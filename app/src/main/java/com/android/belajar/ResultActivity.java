package com.android.belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView tvNama, tvNomor, tvInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvNama = findViewById(R.id.tv_nama);
        tvNomor = findViewById(R.id.tv_nomor);
        tvInfo = findViewById(R.id.tv_info);

        Intent ambilIntent = getIntent();
        tvNama.setText(ambilIntent.getStringExtra("fooNama"));
        tvNomor.setText(ambilIntent.getStringExtra("fooNomor"));
        tvInfo.setText(ambilIntent.getStringExtra("fooInfo"));
    }
}