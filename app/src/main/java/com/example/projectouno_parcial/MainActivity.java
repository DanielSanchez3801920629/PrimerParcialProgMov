package com.example.projectouno_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.projectouno_parcial.models.PersonModel;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    PersonModel person;
    private Button btnGoToIMC;
    private Button btnGoToTemp;
    private Button btnGoToCalc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentViewAttribute();
        setContentViewEvents();
    }
    private void setContentViewEvents() {
        btnGoToIMC.setOnClickListener(this);
        btnGoToTemp.setOnClickListener(this);
        btnGoToCalc.setOnClickListener(this);
        person = new PersonModel();
    }
    public void setContentViewAttribute(){
        btnGoToIMC = findViewById(R.id.btnMainIMC);
        btnGoToTemp = findViewById(R.id.btnMainConverter);
        btnGoToCalc = findViewById(R.id.btnMainCalc);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnMainIMC:
                goToIMC();
                break;
            case R.id.btnMainConverter:
                goToTemp();
                break;
            case R.id.btnMainCalc:
                goToCalc();
                break;
        }
    }
    private void goToIMC() {
        person = new PersonModel();
        EditText txtNombre = findViewById(R.id.txtPerson);
        person.setNombre(txtNombre.getText().toString());
        SharedPreferences sp = getSharedPreferences("Aplicacion",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Nombre",person.getNombre() );
        editor.commit();

        Intent intent = new Intent(MainActivity.this,IMCActivity.class);
        startActivity(intent);
    }
    private void goToTemp() {
        person = new PersonModel();
        EditText txtNombre = findViewById(R.id.txtPerson);
        person.setNombre(txtNombre.getText().toString());
        SharedPreferences sp = getSharedPreferences("Aplicacion",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Nombre",person.getNombre() );
        editor.commit();

        Intent intent = new Intent(MainActivity.this,TempActivity.class);
        startActivity(intent);
    }
    private void goToCalc() {
        person = new PersonModel();
        EditText txtNombre = findViewById(R.id.txtPerson);
        person.setNombre(txtNombre.getText().toString());
        SharedPreferences sp = getSharedPreferences("Aplicacion",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("Nombre",person.getNombre() );
        editor.commit();

        Intent intent = new Intent(MainActivity.this,CalcActivity.class);
        startActivity(intent);
    }
}