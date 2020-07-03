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

public class DescontoSimples extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desconto_simples);

        Button voltar = (Button) findViewById(R.id.voltarDS);
        voltar.setOnClickListener(clickVoltar);
        Button calcular = (Button) findViewById(R.id.calcularDS);
        calcular.setOnClickListener(clickCalcular);
    }

    private View.OnClickListener clickVoltar = new View.OnClickListener() {

        @java.lang.Override
        public void onClick(View v) {
            Intent mainIntent = new Intent(DescontoSimples.this, MainActivity.class);
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
                EditText Capital = (EditText) findViewById(R.id.txtValorDS);
                double V = Double.parseDouble(Capital.getText().toString());

                EditText TaxaJ = (EditText) findViewById(R.id.txtTaxaDS);
                double t = Double.parseDouble(TaxaJ.getText().toString());

                EditText Mes = (EditText) findViewById(R.id.txtMesDS);
                int m = Integer.parseInt(Mes.getText().toString());

                TextView calculo = (TextView) findViewById(R.id.resultadoDS);
                TextView CalDeSim = (TextView) findViewById(R.id.valorDS);

                double Des = V - (V * t * 0.01 * m);
                Double CDS = V * t * 0.01 * m;

                if (Des > 0) {
                    calculo.setText("Valor Total = " + String.valueOf(rs.format(Des)) + " R$");
                    CalDeSim.setText("Valor Desconto = " + String.valueOf(rs.format(CDS)) + " R$");
                } else {

                    calculo.setText("Valor Total = " + (rs.format(0.00)) + " R$");
                    CalDeSim.setText("Desconto Total");
                }
            } catch (Exception ex) {
                TextView calculo = (TextView) findViewById(R.id.resultadoDS);
                @SuppressLint("CutPasteId") TextView CDS = (TextView) findViewById(R.id.valorDS);

                calculo.setText("Campos Vazios");
                CDS.setText("");
            }
        }
    };
}
