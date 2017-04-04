package br.com.recuperacao.projetotcc1;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import br.com.recuperacao.projetotcc1.controller.CadastroController;
import br.com.recuperacao.projetotcc1.modelo.Cadastro;
import br.com.recuperacao.projetotcc1.util.DataBase;

public class EntrarActivity extends AppCompatActivity {
    private DataBase db;
    private SQLiteDatabase instanciaDb;

    EditText usuarioLog;
    EditText senhaLog;
    Button entrarLog;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);
        final Cadastro cadastro = new Cadastro();
        usuarioLog = (EditText) findViewById(R.id.usuarioLog);
        senhaLog = (EditText) findViewById(R.id.senhaLog);
        entrarLog = (Button) findViewById(R.id.entrarLog);


        entrarLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!validaCampos()) {
                    return;
                } else
                if (senhaLog.getText().toString().length() == 0 && usuarioLog.getText().toString().length() == 0) {
                    Toast.makeText(EntrarActivity.this, "Os campos são obrigatórios!", Toast.LENGTH_LONG).show();
                }
                CadastroController crud = new CadastroController(getBaseContext());
                int teste = crud.VerificaLogin("username = '"+ usuarioLog.getText()+"' and senha = '"+senhaLog.getText().toString()+"'");

                if (teste > 0) {
                    Toast.makeText(getApplicationContext(), "Redirecionando...", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(EntrarActivity.this, MapsActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(EntrarActivity.this, "Usuário ou senha incorretos.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


    public void VoltarTelaInicial (View view) {
        Intent intent = new Intent(this, MainInicial.class);
        startActivity(intent);
    }
    public boolean validaCampos() {
        return validaCamposVazio(usuarioLog) && validaCamposVazio(senhaLog);
    }
    private boolean validaCamposVazio(EditText edit) {
        String valor = edit.getText().toString().trim();

        if (!TextUtils.isEmpty(valor)) {
            return true;
        }
        edit.requestFocus();
        edit.setError("Campo obrigatório");
        return false;
    }

}
