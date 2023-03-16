package edu.pdx.cs410J.whitlock;

import static edu.pdx.cs410J.whitlock.CalculatorActivity.SUM_VALUE;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.AndroidException;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int GET_SUM = 42;
    private ArrayAdapter<Integer> sums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listOfSums = findViewById(R.id.sums);
        List<Integer> sumsFromFile = null;
        try {
            sumsFromFile = readSumsFromFile();
        } catch (IOException e) {
            Toast.makeText(this, "While reading file: " + e, Toast.LENGTH_LONG).show();
        }

        sums = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, sumsFromFile);
        listOfSums.setAdapter(sums);
    }

    @NonNull
    private List<Integer> readSumsFromFile() throws IOException {
        List<Integer> sums = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(getSumsFile()))) {
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                sums.add(Integer.parseInt(line));
            }
        }

        return sums;
    }

    public void launchCalculator(View view) {
        startActivityForResult(new Intent(this, CalculatorActivity.class), GET_SUM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == GET_SUM) {
                if (data != null) {
                    Integer sum = data.getSerializableExtra(SUM_VALUE, Integer.class);
                    if (sum != null) {
                        this.sums.add(sum);
                        try {
                            writeSumsToInternalStorage();
                        } catch (IOException e) {
                            Toast.makeText(this, "While writing file: " + e, Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }
        }
    }

    private void writeSumsToInternalStorage() throws IOException {
        File sumsFile = getSumsFile();

        try (PrintWriter pw = new PrintWriter(new FileWriter(sumsFile))) {
            for (int i = 0 ; i < this.sums.getCount() ; i++) {
                Integer sum = this.sums.getItem(i);
                pw.println(sum);
            }
        }
    }

    @NonNull
    private File getSumsFile() {
        File dataDir = this.getDataDir();
        return new File(dataDir, "sums.txt");
    }
}