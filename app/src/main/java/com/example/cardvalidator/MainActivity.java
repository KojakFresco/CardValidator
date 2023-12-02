package com.example.cardvalidator;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText enter;
    private Button but;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enter = findViewById(R.id.card);
        text = findViewById(R.id.textView);
        but = findViewById(R.id.button);
    }

    public void CheckCard(View v) {
        String num = enter.getText().toString();
        int sum = 0;
        for (int i = 0; i < 16; i++) {
            int n = parseInt(String.valueOf(num.charAt(i)));
            if (i % 2  == 0) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }
            sum += n;
        }
        if (sum % 10 == 0) text.setText("Card is valid");
        else text.setText("Card is not valid");
    }
}