package br.com.recuperacao.projetotcc1.controller;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import br.com.recuperacao.projetotcc1.CadastroActivity;
import br.com.recuperacao.projetotcc1.modelo.Cadastro;
import br.com.recuperacao.projetotcc1.util.DataBase;


public class CadastroController {
    private SQLiteDatabase instanciaDb;
    private DataBase db;

    public CadastroController (Context context) { db = new DataBase(context);}
    public long create (Cadastro cadastro) {
        ContentValues dados = new ContentValues();
        long resultado = 1;

        instanciaDb = db.getWritableDatabase();
        dados.put("nome", cadastro.getNome());
        dados.put("sobrenome", cadastro.getSobrenome());
        dados.put("data_nascimento", cadastro.getData_nascimento());
        dados.put("email", cadastro.getEmail());
        dados.put("username", cadastro.getNome_usuario());
        dados.put("senha", cadastro.getSenha_usuario());
        dados.put("confirmar_senha", cadastro.getRepetir_senha_usuario());
        resultado = instanciaDb.insert("USUARIO", null, dados);


        instanciaDb.close();

        return resultado;

    }

    public Cadastro getbyid (int id){
        String[] campos = {"_id", "nome", "sobrenome", "data_nascimento", "email", "username", "senha", "confirmar_senha"};
        String where = "_id = " + id;
        instanciaDb = db.getReadableDatabase();

        Cursor cursor = instanciaDb.query("cadastro", campos,null,null,null,null,null);

        if (cursor == null) {
            return null;
        }

        cursor.moveToFirst();
        instanciaDb.close();

        Cadastro cadastro = new Cadastro();
        cadastro.setId(cursor.getInt(cursor.getColumnIndexOrThrow("_id")));
        cadastro.setNome(cursor.getString(cursor.getColumnIndexOrThrow("nome")));
        cadastro.setSobrenome(cursor.getString(cursor.getColumnIndexOrThrow("sobrenome")));
        cadastro.setData_nascimento(cursor.getString(cursor.getColumnIndexOrThrow("data_nascimento")));
        cadastro.setEmail(cursor.getString(cursor.getColumnIndexOrThrow("email")));
        cadastro.setNome_usuario(cursor.getString(cursor.getColumnIndexOrThrow("username")));
        cadastro.setSenha_usuario(cursor.getString(cursor.getColumnIndexOrThrow("senha")));
        cadastro.setRepetir_senha_usuario(cursor.getString(cursor.getColumnIndexOrThrow("confirmar_senha")));
        return cadastro;

    }
    public long update(final Cadastro cadastro){
        ContentValues dados = new ContentValues();
        long resultado;
        instanciaDb = db.getWritableDatabase();
        dados.put("nome", cadastro.getNome());
        dados.put("sobrenome", cadastro.getSobrenome());
        dados.put("data_nascimento", cadastro.getData_nascimento());
        dados.put("email", cadastro.getEmail());
        dados.put("username", cadastro.getNome_usuario());
        dados.put("senha", cadastro.getSenha_usuario());
        dados.put("confirmar_senha", cadastro.getRepetir_senha_usuario());



        String where = "_id =" + cadastro.getId();

        resultado = instanciaDb.update("cadastro", dados, where, null);
        instanciaDb.close();
        return resultado;
    }

    public int VerificaLogin(String where){
        String[] campos = {"nome"};
        instanciaDb = db.getReadableDatabase();

        Cursor cursor = instanciaDb.query("USUARIO", campos, where, null, null, null, null);
        if (cursor != null){
            cursor.moveToFirst();
        }

        instanciaDb.close();
        return cursor.getCount();
    }



}