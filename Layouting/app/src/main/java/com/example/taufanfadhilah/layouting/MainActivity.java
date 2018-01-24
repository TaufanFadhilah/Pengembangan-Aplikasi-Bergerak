package com.example.taufanfadhilah.layouting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int scoreA = 0, scoreB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView tvScoreA = (TextView)findViewById(R.id.tvScoreA);
        final TextView tvScoreB = (TextView)findViewById(R.id.tvScoreB);
        Button btnA = (Button)findViewById(R.id.btnA);
        Button btnB = (Button)findViewById(R.id.btnB);
        tvScoreA.setText(String.valueOf(scoreA));
        tvScoreB.setText(String.valueOf(scoreB));
        btnA.setText("FRI");
        btnB.setText("FIK");

        btnA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "One point to FRI", Toast.LENGTH_SHORT).show();
                tvScoreA.setText(String.valueOf(++scoreA));
            }
        });

        btnB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "One point to FIK", Toast.LENGTH_SHORT).show();
                tvScoreB.setText(String.valueOf(++scoreB));
            }
        });
    }
}
