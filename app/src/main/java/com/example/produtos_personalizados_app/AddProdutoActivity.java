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

     EditText nome;
     EditText descricao;
     EditText cor;
     EditText tamanho;
     EditText valor;
     Button salvar;

    private ConexãoBD ConexãoDB;
    private SQLiteDatabase database;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_produto);

        ConexãoDB = new ConexãoBD(this);
        database = ConexãoDB.getWritableDatabase();

        nome = findViewById(R.id.addTextNome);
        descricao = findViewById(R.id.addTextdescricao);
        cor = findViewById(R.id.addTextCor);
        tamanho = findViewById(R.id.addTexTam);
        valor = findViewById(R.id.addTextValor);
        salvar = findViewById(R.id.btsalvar);
         // lógica para salva e inserir
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Nome = nome.getText().toString();
                String Tamanho = tamanho.getText().toString();
                String Descricao = descricao.getText().toString();
                String Cor = cor.getText().toString();
                double Valor = Double.parseDouble(valor.getText().toString());
                //inserir os produtos no linear layout na activity de produto
                Intent intent = new Intent(AddProdutoActivity.this, Produto.class);
                intent.putExtra("nome", Nome);
                intent.putExtra("tamanho", Tamanho);
                intent.putExtra("descricao", Descricao);
                intent.putExtra("cor", Cor);
                intent.putExtra("valor", Valor);
                startActivity(intent);

                Toast.makeText(AddProdutoActivity.this, "Produto Salvo", Toast.LENGTH_SHORT).show();
            }
        });


    }

}


