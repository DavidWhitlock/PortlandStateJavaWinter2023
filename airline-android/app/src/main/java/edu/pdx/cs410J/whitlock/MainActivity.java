package edu.pdx.cs410J.whitlock;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

    public void computeSum(View view) {
        EditText leftOperandEditText = findViewById(R.id.leftOperand);
        EditText rightOperandEditText = findViewById(R.id.rightOperand);

        String leftOperandString = leftOperandEditText.getText().toString();
        String rightOperandString = rightOperandEditText.getText().toString();

        int leftOperand = Integer.parseInt(leftOperandString);
        int rightOperand = Integer.parseInt(rightOperandString);

        int sum = leftOperand + rightOperand;

        EditText sumEditText = findViewById(R.id.sum);
        sumEditText.setText(String.valueOf(sum), TextView.BufferType.EDITABLE);

    }
}