package com.cursoandroid.teste.combustvel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText texteditAlcool;
    private TextInputEditText texteditGasolina;
    private TextView texteditResulted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texteditAlcool = findViewById(R.id.textAlcool);
        texteditGasolina = findViewById(R.id.textGasoline);
        texteditResulted = findViewById (R.id.textResulted);
    }
    public void calculatePrice (View view){

        //recuperar valores digitados
        String priceAlcool = texteditAlcool.getText().toString();
        String priceGasoline = texteditGasolina.getText().toString();

        //validar campos digitados

        Boolean fieldsValidated = validateFields(priceAlcool,priceGasoline);
        if (fieldsValidated){

            //Convertendo string para números
            Double valueAlcool = Double.parseDouble(priceAlcool);
            Double valueGasoline = Double.parseDouble(priceGasoline);

            /* Fazer cálculo de menor preço
            Se (valorAlcool / valorGasolina) >= 0.7 é melhor utilizar gasolina
            senão é melhor utilizar álcool
             */
            Double resulted = valueAlcool / valueGasoline;
            if (resulted >= 0.7){
                texteditResulted.setText("Melhor utilizar gasolina");
            }else{
                texteditResulted.setText("Melhor utilizar álcool");
            }

        }else{
            texteditResulted.setText("Preencha os preços primeiro");
        }



    }

    public boolean validateFields ( String pAlcool, String pGasoline ){

        Boolean fieldsValidated = true;

        if (pAlcool == null || pAlcool.equals("")){
            fieldsValidated = false;

        }else if (pGasoline == null || pGasoline.equals("")){
            fieldsValidated = false;

        }return fieldsValidated;

    }

}
