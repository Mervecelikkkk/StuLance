package com.example.stulance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class GirisActivity extends AppCompatActivity {

    Button btnOgr;
    Button btnIsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris);
        onClickOgr();
        onClickIsv();
    }

    public void onClickOgr(){
        btnOgr = findViewById(R.id.bGirisOgr);
        btnOgr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GirisActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onClickIsv(){
        btnIsv  = findViewById(R.id.bGirisIsv);
        btnIsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GirisActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
