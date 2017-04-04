package br.com.recuperacao.projetotcc1;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity implements Runnable {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        Handler handler = new Handler();
        handler.postDelayed(this,3000);
    }
    //abrir uma activity
    @Override
    public void run() {
        Intent intent = new Intent(this, MainInicial.class);
        startActivity(intent);
        finish();
    }
}
