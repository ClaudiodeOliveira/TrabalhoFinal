package com.claudio.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button juSim = (Button) findViewById(R.id.juSim);
        juSim.setOnClickListener(clickJuSim);
        Button juComp = (Button) findViewById(R.id.juCom);
        juComp.setOnClickListener(clickJuCom);
        Button deSim = (Button) findViewById(R.id.deSim);
        deSim.setOnClickListener(clickDeSim);
    }
    private View.OnClickListener clickDeSim = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent DeSim = new Intent(MainActivity.this, DescontoSimples.class);
            startActivity(DeSim);
            finish();
        }

    };


    private View.OnClickListener clickJuSim = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent JuSim = new Intent(MainActivity.this, JurosSimples.class);
            startActivity(JuSim);
            finish();
        }

    };

    private View.OnClickListener clickJuCom = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent JuCom = new Intent(MainActivity.this, JurosCompostos.class);
            startActivity(JuCom);
            finish();
        }

    };
}