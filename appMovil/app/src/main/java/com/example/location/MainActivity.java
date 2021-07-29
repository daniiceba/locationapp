package com.example.location;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tvTexto;
    Button btnBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
    }

    private void inicializar() {
        btnBoton = findViewById(R.id.btnBoton);
        tvTexto = findViewById(R.id.tvTexto);


        btnBoton.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnBoton) {
            if (tvTexto.getText().equals("Apagado")) {
                btnBoton.setText("Apagar");
                tvTexto.setText("Encendido");
            } else {
                btnBoton.setText("Encender");
                tvTexto.setText("Apagado");
            }

        }
    }
}