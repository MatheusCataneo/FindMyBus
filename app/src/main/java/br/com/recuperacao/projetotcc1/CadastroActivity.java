package br.com.recuperacao.projetotcc1;

import android.content.Intent;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import br.com.recuperacao.projetotcc1.controller.CadastroController;
import br.com.recuperacao.projetotcc1.modelo.Cadastro;

import static br.com.recuperacao.projetotcc1.R.drawable.teste;

public class CadastroActivity extends AppCompatActivity {
    EditText nome_cad, sobrenome_cad, dt_nasc_cad, email_cad, user_cad, senha_cad, rep_senha_cad;
    Cadastro cadastro;
    String id_cadastro;

    Button cadastrar, voltar;

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        nome_cad = (EditText) findViewById(R.id.nome_cad);
        sobrenome_cad = (EditText) findViewById(R.id.sobrenome_cad);
        dt_nasc_cad = (EditText) findViewById(R.id.dt_nasc_cad);
        email_cad = (EditText) findViewById(R.id.email_cad);
        user_cad = (EditText) findViewById(R.id.user_cad);
        senha_cad = (EditText) findViewById(R.id.senha_cad);
        rep_senha_cad = (EditText) findViewById(R.id.rep_senha_cad);

        cadastrar = (Button) findViewById(R.id.cadastrar);
        voltar = (Button) findViewById(R.id.voltar);

        id_cadastro = this.getIntent().getStringExtra("id");

        if (!TextUtils.isEmpty(id_cadastro)){
            CadastroController crud = new CadastroController(getBaseContext());
                cadastro = crud.getbyid(Integer.parseInt(id_cadastro));

        }
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();

    }

    public void Salvar (View view) {
        if (!validaCampos()) {
            return;
        } else if (!senha_cad.getText().toString().equals(rep_senha_cad.getText().toString())) {
            Toast.makeText(getApplicationContext(), "As senhas não coincidem.", Toast.LENGTH_LONG).show();
        } else {

            //Toast.makeText(getApplicationContext(),"erroooowww", Toast.LENGTH_LONG).show();
            Cadastro cadastro = new Cadastro();
            cadastro.setNome(nome_cad.getText().toString());
            cadastro.setSobrenome(sobrenome_cad.getText().toString());
            cadastro.setData_nascimento(dt_nasc_cad.getText().toString());
            cadastro.setEmail(email_cad.getText().toString());
            cadastro.setNome_usuario(user_cad.getText().toString());
            cadastro.setSenha_usuario(senha_cad.getText().toString());
            cadastro.setRepetir_senha_usuario(rep_senha_cad.getText().toString());


            CadastroController crud = new CadastroController(getBaseContext());
            long retorno;

            if (!TextUtils.isEmpty(id_cadastro)) {
                cadastro.setId(Integer.parseInt(id_cadastro));
                retorno = crud.update(cadastro);
            } else {
                retorno = crud.create(cadastro);
            }

            if (retorno == -1) {
                Toast.makeText(getBaseContext(), "Erro ao Cadastrar!", Toast.LENGTH_LONG).show();
            }
            if (teste > 0) {
                Toast.makeText(getApplicationContext(), "Redirecionando...", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CadastroActivity.this, EntrarActivity.class);
                startActivity(intent);
            }else {
                Toast.makeText(getBaseContext(), cadastro.getNome() + " Salvo com sucesso!", Toast.LENGTH_LONG).show();

            }
        }
    }

    public boolean validaCampos() {
        return validaCamposVazio(nome_cad) && validaCamposVazio(senha_cad);
    }
    private boolean validaCamposVazio(EditText edit){
        String valor = edit.getText().toString().trim();

        if (!TextUtils.isEmpty(valor)){
            return true;
        }
        edit.requestFocus();
        edit.setError("Campo obrigatório");
        return false;

    }

    public void VoltarTelaInicial (View view) {
        Intent intent = new Intent(this, MainInicial.class);
        startActivity(intent);

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Cadastro Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
