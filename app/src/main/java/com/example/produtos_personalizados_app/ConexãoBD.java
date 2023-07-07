package com.example.produtos_personalizados_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ConexãoBD extends SQLiteOpenHelper {

            private static final String DATABASE_NAME = "products.db";
        private static final int DATABASE_VERSION = 1;

        public ConexãoBD(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(@NonNull SQLiteDatabase db) {
            // Crie a tabela para armazenar os produtos
            String createTableQuery = "CREATE TABLE produto (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, descricao TEXT, tamanho TEXT, cor TEXT, valor REAL)";
            db.execSQL(createTableQuery);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // Se você precisar atualizar a estrutura do banco de dados, defina a lógica aqui
        }
}

