package br.com.recuperacao.projetotcc1.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Matheus on 02/03/2017.
 */

public class DataBase extends SQLiteOpenHelper {
    private static final String BD_NOME = "Bus_Map";
    private static final int BD_VERSION = 1;


    public DataBase(Context contexto){
        super(contexto, BD_NOME, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        final String createTableUsuario = "CREATE TABLE USUARIO ( " +
                "_id integer primary key autoincrement, "+
                "nome text not null, "+
                "sobrenome text not null, "+
                "data_nascimento text not null,"+
                "email text  not null, "+
                "username text not null, "+
                "senha text  not null, " +
                "confirmar_senha text not null)";
        db.execSQL(createTableUsuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String alterTableUsuario = "DROP TABLE IF EXISTS USUARIO";
        db.execSQL(alterTableUsuario);
        this.onCreate(db);
    }

}
