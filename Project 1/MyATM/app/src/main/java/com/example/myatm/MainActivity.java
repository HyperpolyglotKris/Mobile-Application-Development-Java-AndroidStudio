package com.example.myatm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView tvHandValue;
    TextView tvAccountValue;
    Button btnWithdraw;
    Button btnDeposit;
    Spinner spinnerAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeAllViews();


    }

    private void initializeAllViews(){
        tvHandValue = findViewById(R.id.hand_value);
        tvAccountValue = findViewById(R.id.account_value);
        btnWithdraw = findViewById(R.id.withdraw);
        btnDeposit = findViewById(R.id.deposit);
        spinnerAmount = findViewById(R.id.select_amount);

        ArrayAdapter<CharSequence> dataAdapter = ArrayAdapter.createFromResource(this, R.array.select_amount, android.R.layout.simple_spinner_item);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAmount.setAdapter(dataAdapter);

        spinnerAmount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int addAmount = Integer.parseInt(spinnerAmount.getSelectedItem().toString());

                btnDeposit.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        if (Integer.parseInt(tvHandValue.getText().toString()) >= addAmount){
                            tvAccountValue.setText(String.valueOf(Integer.parseInt(tvAccountValue.getText().toString()) + addAmount));
                            tvHandValue.setText(String.valueOf(Integer.parseInt(tvHandValue.getText().toString()) - addAmount));
                        }
                    }
                });

                btnWithdraw.setOnClickListener(new View.OnClickListener(){
                    public void onClick(View v) {
                        if (Integer.parseInt(tvAccountValue.getText().toString()) >= addAmount) {
                            tvAccountValue.setText(String.valueOf(Integer.parseInt(tvAccountValue.getText().toString()) - addAmount));
                            tvHandValue.setText(String.valueOf((Integer.parseInt(tvHandValue.getText().toString()) + addAmount)));
                        }
                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }
}