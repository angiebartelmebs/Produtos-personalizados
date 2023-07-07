package com.example.produtos_personalizados_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class AddProdutoActivity extends AppCompatActivity {

    private EditText nome;
    private EditText descricao;
    private EditText cor;
    private EditText tamanho;
    private EditText valor;

    private ConexãoBD ConexãoDB;
    private SQLiteDatabase database;
    private ContentValues values;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produto);

        ConexãoDB = new ConexãoBD(this);
        database = ConexãoDB.getWritableDatabase();

        Button btsalvar = findViewById(R.id.btsalvar);
        btsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvarProduto();
            }
        });

    }

    private void salvarProduto() {

        String Nome = nome.getText().toString();
        String Tamanho = tamanho.getText().toString();
        String Descricao = descricao.getText().toString();
        String Cor = cor.getText().toString();
        double Valor = Double.parseDouble(valor.getText().toString());

        Intent intent = new Intent(AddProdutoActivity.this, Produto.class);
        intent.putExtra("nome", Nome);
        intent.putExtra("tamanho", Tamanho);
        intent.putExtra("descricao", Descricao);
        intent.putExtra("cor", Cor);
        intent.putExtra("valor", Valor);
        startActivity(intent);

        long idInserido = database.insert("produto", null, values);

        if (idInserido != -1) {
            Toast.makeText(this, "Produto salvo com sucesso", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Falha ao salvar o produto", Toast.LENGTH_SHORT).show();
        }
    }

}


