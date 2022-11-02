package com.android.belajar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    private EditText etNama, etNomor;
    private CheckBox cbIG, cbFB, cbWEB;
    private Button btnDaftar;
    String info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = findViewById(R.id.et_nama);
        etNomor = findViewById(R.id.et_nomor);
        cbIG = findViewById(R.id.cb_ig);
        cbFB = findViewById(R.id.cb_fb);
        cbWEB = findViewById(R.id.cb_web);
        btnDaftar = findViewById(R.id.btn_daftar);


        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama, nomor, ig, fb, web;
                nama = etNama.getText().toString();
                nomor = etNomor.getText().toString();
                ig = cbIG.getText().toString();
                fb = cbFB.getText().toString();
                web = cbWEB.getText().toString();
                
                HashSet<String> hsInfo = new HashSet<String>();

                if (nama.trim().equals("")){
                    etNama.setError("Nama belum diisi");
                } if (nomor.trim().equals("")){
                    etNomor.setError("Nomor Pendaftaran Belum Diisi");
                } if (cbFB.isChecked()){
                    hsInfo.add(fb);
                } if (cbIG.isChecked()){
                    hsInfo.add(ig);
                } if (cbWEB.isChecked()){
                    hsInfo.add(web);
                } if (!(cbFB.isChecked() || cbIG.isChecked() || cbWEB.isChecked())) {
                    Toast.makeText(MainActivity.this, "Silahkan pilih salah satu informasi pendaftaran", Toast.LENGTH_SHORT).show();
                }
                 if (!(nama.trim().equals("")) && !(nomor.trim().equals("")) && (cbFB.isChecked() || cbWEB.isChecked() || cbIG.isChecked())){
                    info = String.join(", ", hsInfo);

                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("fooNama", nama);
                    intent.putExtra("fooNomor", nomor);
                    intent.putExtra("fooInfo", "Informasi Pendaftaran Dari :\n" + info);
                    startActivity(intent);
                }
            }
        });
    }
}