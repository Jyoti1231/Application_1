package com.example.wifiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button ebtn,dbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ebtn=findViewById(R.id.button);
        dbtn=findViewById(R.id.button2);

        ebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wm=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
                wm.setWifiEnabled(true);
            }
        });
        dbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiManager wm=(WifiManager)getApplicationContext().getSystemService(WIFI_SERVICE);
                wm.setWifiEnabled(false);
            }
        });
    }
}