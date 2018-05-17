package com.example.myworldofsoftware.turkcekontrolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    Button btnKontrol;
    EditText textKelime;
    String kelime;
    TextView textRapor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnKontrol = findViewById(R.id.btnKontrol);
        textKelime = findViewById(R.id.editTextKelime);
        textRapor = findViewById(R.id.textRapor);

        btnKontrol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                kelime = textKelime.getText().toString();

                Kontrol kontrol = new Kontrol();
                String metinRapor  = kontrol.MetinKontrolEt(harflendir(kelime));

                textRapor.setText(metinRapor);
            }
        });
    }
    public String[] harflendir(String kelime) {

        String harfDizi[] = new String[kelime.length()]; //Kelime uzunluğu kadar dizi tanımlıyoruz.

        for(int i = 0; i < kelime.length(); i++){ //Kelimenin her harfini diziye atıyoruz.
            String harf = kelime.substring(i, i+1);
            harfDizi[i] = harf;
        }

        return harfDizi;
    }
}
