package com.example.projectouno_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class IMCActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCalcIMC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcactivity);
        SharedPreferences spGet = getSharedPreferences("Aplicacion", MODE_PRIVATE);
        String nombrePersona = spGet.getString("Nombre","NA");
        TextView txtTituloConNombre = findViewById(R.id.lblIMCTitle);
        txtTituloConNombre.setText(nombrePersona + ", calcula tu IMC.");
    }
    private void setContentViewEvents() {
        btnCalcIMC.setOnClickListener(this);
    }
    public void setContentViewAttribute(){
        btnCalcIMC = findViewById(R.id.btnMainIMC);
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCalcIMC:
                calcIMC();
                break;
        }
    }
    private void calcIMC() {
        //Input Variables
        EditText txtIMCWeight = findViewById(R.id.txtIMCWeight);
        String pesoInput = txtIMCWeight.getText().toString();
        EditText txtIMCHeight = findViewById(R.id.txtIMCHeight);
        String alturaInput = txtIMCHeight.getText().toString();
        TextView resultIMC = findViewById(R.id.lblIMCCalc);
        //Integer conversion
        float peso      =  Float.parseFloat(pesoInput);
        float altura = Float.parseFloat(alturaInput);
        //Process and result
        SharedPreferences spGet = getSharedPreferences("Aplicacion", MODE_PRIVATE);
        String nombrePersonaResult = spGet.getString("Nombre","NA");
        float IMCResult = peso / (float) Math.pow((altura/100), 2);

        if (IMCResult < 18.5){
            resultIMC.setText(nombrePersonaResult+ ", tu IMC es de "+IMCResult+". Presentas bajo peso.");
            resultIMC.setTextColor(Color.RED);
        } else if (IMCResult >= 18.5 && IMCResult <= 29.4) {
            resultIMC.setText(nombrePersonaResult+ ", tu IMC es de "+IMCResult+". Tu peso es normal.");
            resultIMC.setTextColor(Color.GREEN);
        } else if (IMCResult >= 25.0 && IMCResult <= 29.9) {
            resultIMC.setText(nombrePersonaResult+ ", tu IMC es de "+IMCResult+". Presentas sobrepeso.");
            resultIMC.setTextColor(Color.YELLOW);
        } else if (IMCResult >= 30.0 && IMCResult <= 34.9) {
            resultIMC.setText(nombrePersonaResult+ ", tu IMC es de "+IMCResult+". Presentas obesidad grado 1.");
            resultIMC.setTextColor(Color.RED);
        } else if (IMCResult >= 35.0 && IMCResult <= 39.9) {
            resultIMC.setText(nombrePersonaResult+ ", tu IMC es de "+IMCResult+". Presentas obesidad grado 2.");
            resultIMC.setTextColor(Color.RED);
        } else if (IMCResult >= 40) {
            resultIMC.setText(nombrePersonaResult+ ", tu IMC es de "+IMCResult+". Presentas obesidad grado 3.");
            resultIMC.setTextColor(Color.RED);
        }
        }
    }

