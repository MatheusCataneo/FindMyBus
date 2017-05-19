package br.com.recuperacao.projetotcc1;

import android.content.Intent;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.facebook.FacebookSdk;

public class MainInicial extends AppCompatActivity {

    Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.setApplicationId("1921069258109618");
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        btnEntrar = (Button) findViewById(R.id.btnEntrar);
        String provider = Settings.Secure.getString(getContentResolver(),
                Settings.Secure.LOCATION_PROVIDERS_ALLOWED);
//Se vier null ou length == 0   é por que o GPS esta desabilitado.
//Para abrir a tela do menu pode fazer assim:
        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
        startActivityForResult(intent, 1);

    }


    public void abrirCadastro(View view) {
        Intent intent = new Intent(this, CadastroActivity.class);
        startActivity(intent);
    }




    public void abrirEntrar(View view) {
        Intent intent = new Intent(MainInicial.this, EntrarActivity.class);

        startActivity(intent);

    }

}
