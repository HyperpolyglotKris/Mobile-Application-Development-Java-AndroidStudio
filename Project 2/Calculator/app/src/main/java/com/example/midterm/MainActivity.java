package com.example.midterm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView sign, left, right, result;
    boolean leftSide = true;
    boolean darkTheme = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sign = findViewById(R.id.sign);
        left = findViewById(R.id.leftOperand);
        right = findViewById(R.id.rightOperand);
        result = findViewById(R.id.result);
    }

    public void onClickedAdd(View v) {
        sign.setText("+");
    }
    public void onClickedSubtract(View view) {
        sign.setText("-");
    }
    public void onClickedMultiply(View view) {
        sign.setText("*");
    }
    public void onClickedDivide(View view) {
        sign.setText("/");
    }

    public void onClickedSwitch(View view) {
        if (leftSide) {
            leftSide = false;
        } else {
            leftSide = true;
        }
    }

    public void onClickedReset(View view) {
        left.setText("Left Operand");
        right.setText("Right Operand");
        result.setText("Result");
    }

    public void onClickedNumber(View view) {
        Button pressed = (Button) view;
        int number = Integer.parseInt(pressed.getText().toString());
        String leftOperand = "Left Operand";
        String rightOperand = "Right Operand";
        System.out.println(number);
        Log.e("Number", "Button was pressed");
        if (leftSide) {
            if (left.getText().toString().equals(leftOperand)) {
                left.setText("" + number);
            } else {
                left.setText((left.getText().toString()) + number);
            }
        } else {
            if (right.getText().toString().equals(rightOperand)) {
                right.setText("" + number);
            } else {
                right.setText((right.getText().toString()) + number);
            }
        }
    }

    public void onClickedResult(View view) {
        try {
            result.setText("" + calculateResult());
        } catch (Exception x) {
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickedTheme(View view) {
        if (darkTheme == false) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            darkTheme = true;
        } else if (darkTheme) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            darkTheme = false;
        }
    }

    public int calculateResult(){
        if (left.getText().toString() == null || right.getText().toString() == null) {
            Toast.makeText(this, "The Operand cannot be empty", Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            int leftCalculation = Integer.parseInt(left.getText().toString());
            int rightCalculation = Integer.parseInt(right.getText().toString());
            String charCalculation = sign.getText().toString();
            int resultCalculation = 0;
            if (charCalculation == "+") {
                resultCalculation = leftCalculation + rightCalculation;
            } else if (charCalculation == "-") {
                resultCalculation = leftCalculation - rightCalculation;
            } else if (charCalculation == "*") {
                resultCalculation = leftCalculation * rightCalculation;
            } else if (charCalculation == "/") {
                resultCalculation = leftCalculation / rightCalculation;
            }
            return resultCalculation;
        }
    }
}