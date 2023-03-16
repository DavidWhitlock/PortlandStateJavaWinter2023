package edu.pdx.cs410J.whitlock;

import static edu.pdx.cs410J.whitlock.CalculatorActivity.SUM_VALUE;

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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int GET_SUM = 42;
    private ArrayAdapter<Integer> sums;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listOfSums = findViewById(R.id.sums);
        sums = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<>());
        listOfSums.setAdapter(sums);
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
                    }
                }
            }
        }
    }
}