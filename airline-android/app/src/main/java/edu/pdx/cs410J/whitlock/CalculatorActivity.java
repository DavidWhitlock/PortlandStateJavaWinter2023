package edu.pdx.cs410J.whitlock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity {

    static final String SUM_VALUE = "SUM";
    private Integer sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    public void computeSum(View view) {
        EditText leftOperandEditText = findViewById(R.id.leftOperand);
        EditText rightOperandEditText = findViewById(R.id.rightOperand);

        String leftOperandString = leftOperandEditText.getText().toString();
        String rightOperandString = rightOperandEditText.getText().toString();

        int leftOperand;
        try {
            leftOperand = Integer.parseInt(leftOperandString);

        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Invalid number: " + leftOperandString, Toast.LENGTH_SHORT).show();
            return;
        }

        int rightOperand;
        try {
            rightOperand = Integer.parseInt(rightOperandString);

        } catch (NumberFormatException ex) {
            Toast.makeText(this, "Invalid number: " + rightOperandString, Toast.LENGTH_SHORT).show();
            return;
        }

        sum = leftOperand + rightOperand;

        TextView sumEditText = findViewById(R.id.sum);
        sumEditText.setText(String.valueOf(sum));

    }

    public void returnToMain(View view) {
        Intent data = new Intent();
        data.putExtra(SUM_VALUE, this.sum);
        setResult(RESULT_OK, data);

        finish();
    }
}