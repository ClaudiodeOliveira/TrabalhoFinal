package com.claudio.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class JurosCompostos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juros_compostos);

        Button voltar = (Button) findViewById(R.id.voltarJC);
        voltar.setOnClickListener(clickVoltar);
        Button calcular = (Button) findViewById(R.id.calcularJC);
        calcular.setOnClickListener(clickCalcular);
    }
    private View.OnClickListener clickVoltar = new View.OnClickListener() {

        @java.lang.Override
        public void onClick(View v) {
            Intent mainIntent = new Intent(JurosCompostos.this, MainActivity.class);
            startActivity(mainIntent);
            finish();
        }
    };
    private View.OnClickListener clickCalcular = new View.OnClickListener() {

        @SuppressLint("SetTextI18n")
        @java.lang.Override
        public void onClick(View v) {

            DecimalFormat rs = new DecimalFormat("#0.00");

            try {
                EditText Capital = (EditText) findViewById(R.id.txtCapitalJC);
                double C = Double.parseDouble(Capital.getText().toString());

                EditText TaxaJ = (EditText) findViewById(R.id.txtTaxaJC);
                double i = Double.parseDouble(TaxaJ.getText().toString());

                EditText Mes = (EditText) findViewById(R.id.txtmesJC);
                int t = Integer.parseInt(Mes.getText().toString());


                TextView calculo = (TextView) findViewById(R.id.resultadoJC);
                TextView CalJuCo = (TextView) findViewById(R.id.valorJuC);

                double JuCo = C * Math.pow((1+(0.01*i)),t);
                Double CJC = JuCo - C;
                calculo.setText("Valor Total = " + String.valueOf(rs.format(JuCo)) + " R$");
                CalJuCo.setText("Total dos Juros = " + String.valueOf(rs.format(CJC)) + " R$");
            }

            catch (Exception ex) {
                TextView calculo = (TextView) findViewById(R.id.resultadoJC);
                TextView CalJuCo = (TextView) findViewById(R.id.valorJuC);
                calculo.setText("Campos Vazios");
                CalJuCo.setText("");

            }
        }
    };
}