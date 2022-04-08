package com.example.ejerlab03vf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MONEDA extends AppCompatActivity {
    private EditText text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moneda);
        text = (EditText) findViewById(R.id.editText);
    }
    public void miClicManejador(View view) {
        switch (view.getId()) {
            case R.id.btnConvertir:

                RadioButton solesButton = (RadioButton)
                        findViewById(R.id.radio1);
                RadioButton eurosButton = (RadioButton)
                        findViewById(R.id.radio2);
                RadioButton librasButton = (RadioButton)
                        findViewById(R.id.radio3);
                RadioButton YuanesButton = (RadioButton)
                        findViewById(R.id.radio4);
                if (text.getText().length() == 0) {
                    Toast.makeText(this, "Ingresa un número válido",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                float inputValue = Float.parseFloat(text.getText().toString());
                if (eurosButton.isChecked()){
                    text.setText(String
                            .valueOf(convierteSolesAEuros(inputValue)));
                    solesButton.setChecked(false);
                    eurosButton.setChecked(true);
                }
                if (librasButton.isChecked()){
                    text.setText(String
                            .valueOf(convierteSolesALibras(inputValue)));
                    solesButton.setChecked(false);
                    librasButton.setChecked(true);
                }
                if (YuanesButton.isChecked()){
                    text.setText(String
                            .valueOf(convierteSolesALibras(inputValue)));
                    solesButton.setChecked(false);
                    YuanesButton.setChecked(true);
                }
                break;
        }
    }
    // Convierte a dólares
    private double convierteSolesADolares(float soles) {
        return (soles/3.8);
    }
    // Convierte a soles
    private double convierteDolaresASoles(float dolares) {
        return (dolares*3.8);
    }
    // Convierte a Euros
    private double convierteSolesAEuros(float soles) {
        return (soles*4.13);
    }
    // Convierte a Libra
    private double convierteSolesALibras(float soles) {
        return (soles*0.20);
    }
    // Convierte a Yuanes
    private double convierteSolesAYuanes(float soles) {
        return (soles*1.70);
    }
}