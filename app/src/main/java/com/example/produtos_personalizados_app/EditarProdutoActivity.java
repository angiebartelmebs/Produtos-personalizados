package com.example.produtos_personalizados_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class EditarProdutoActivity extends AppCompatActivity {

    EditText nome;
    EditText descricao;
    EditText cor;
    EditText tamanho;
    EditText valor;
    Button salvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_produto);

        nome = findViewById(R.id.addTextNome);
        descricao = findViewById(R.id.addTextdescricao);
        cor = findViewById(R.id.addTextCor);
        tamanho = findViewById(R.id.addTexTam);
        valor = findViewById(R.id.addTextValor);
        salvar = findViewById(R.id.btedtitado);



    }


}