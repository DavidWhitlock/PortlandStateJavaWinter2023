package edu.pdx.cs410J.whitlock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayMessage(View view) {
        Flight flight = new Flight();
        Toast.makeText(this, flight.toString(), Toast.LENGTH_LONG).show();
    }
}