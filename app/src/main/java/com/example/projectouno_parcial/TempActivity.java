package com.example.projectouno_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TempActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnCelsius;
    private Button btnFahrenheit;
    private Button btnKelvin;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        SharedPreferences spGet = getSharedPreferences("Aplicacion", MODE_PRIVATE);
        String name = spGet.getString("Nombre","NA");
        TextView txtTituloConNombre = findViewById(R.id.lblTemp);
        txtTituloConNombre.setText(name + ", convierte temperaturas.");
    }
    private void setContentViewEvents() {
        btnCelsius.setOnClickListener(this);
        btnFahrenheit.setOnClickListener(this);
        btnKelvin.setOnClickListener(this);
    }
    public void setContentViewAttribute(){
        btnCelsius = findViewById(R.id.btnCel);
        btnFahrenheit = findViewById(R.id.btnFar);
        btnKelvin = findViewById(R.id.btnKel);
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnCel:
                calcTempCel();
                break;
            case R.id.btnFar:
                calcTempFar();
                break;
            case R.id.btnKel:
                calcTempKel();
                break;
        }
    }
    private void calcTempCel(){
        EditText txtTemp = findViewById(R.id.txtTempInput);
        String tempInput = txtTemp.getText().toString();
        float tempCelcius     =  Float.parseFloat(tempInput);
        float tempFahrenheit = tempCelcius * Float.parseFloat("1.8") + Float.parseFloat("32");
        float tempKelvin = tempCelcius + Float.parseFloat("273.15");

        TextView resultTemps = findViewById(R.id.txtTempResults);
        resultTemps.setText(tempCelcius + " grados Celsius es " + tempFahrenheit + " en grados Fahrenheit y " +tempKelvin+" en grados Kelvin.");
    }
    private void calcTempFar(){
        EditText txtTemp = findViewById(R.id.txtTempInput);
        String tempInput = txtTemp.getText().toString();
        float tempFahrenheit     =  Float.parseFloat(tempInput);
        float tempCelsius = (tempFahrenheit - Float.parseFloat("32")) / Float.parseFloat("1.8");
        float tempKelvin = Float.parseFloat("5")/Float.parseFloat("9") * (tempFahrenheit - Float.parseFloat("32")) + Float.parseFloat("273.15");

        TextView resultTemps = findViewById(R.id.txtTempResults);
        resultTemps.setText(tempFahrenheit + " grados Fahrenheit es "+tempCelsius+" en grados Celsius y "+tempKelvin+" en grados Kelvin.");
    }
    private void calcTempKel(){
        EditText txtTemp = findViewById(R.id.txtTempInput);
        String tempInput = txtTemp.getText().toString();
        float tempKelvin = Float.parseFloat(tempInput);
        float tempCelsius = tempKelvin - Float.parseFloat("273.15");
        float tempFahrenheit = Float.parseFloat("1.8") * (tempKelvin - Float.parseFloat("273.15")) + Float.parseFloat("32");

        TextView resultTemps = findViewById(R.id.txtTempResults);
        resultTemps.setText(tempKelvin + " grados Kelvin es "+tempCelsius+" en grados Celsius y "+tempFahrenheit+" en grados Fahrenheit.");
    }

}