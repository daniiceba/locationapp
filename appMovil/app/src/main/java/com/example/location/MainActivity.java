package com.example.location;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, LocationListener {
    TextView tvTexto, tvLongitud;
    Button btnBoton;
    Double latitud, longitud;
    Boolean enviarInfo = false;

    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar();
        pedirLocalizacion();
    }


    private void inicializar() {
        btnBoton = findViewById(R.id.btnBoton);
        tvTexto = findViewById(R.id.tvTexto);
        tvLongitud = findViewById(R.id.tvLongitud);
        btnBoton.setOnClickListener(this);

    }

    private void pedirLocalizacion() {
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, (LocationListener) this);
        } catch (Exception exc) {
            System.out.println(exc);
        }
    }

    @Override
    public void onLocationChanged(Location location) {
        tvLongitud.setText("Latitude:" + location.getLatitude() + "\nLongitude:" + location.getLongitude());
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnBoton) {
            if (!enviarInfo) {
                enviarInfo = true;
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION,}, 1000);
                } else {
                }
                //pedirLocalizacion();

                btnBoton.setText("Apagar");
                tvTexto.setText("Encendido");
            } else {
                enviarInfo = false;

                btnBoton.setText("Encender");
                tvTexto.setText("Apagado");
            }

        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (enviarInfo) {
        }
    }


}