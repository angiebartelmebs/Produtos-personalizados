package com.example.produtos_personalizados_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Produto extends AppCompatActivity {

    LinearLayout llProduto;

    private Integer id;
    private String Nome;
    private String Cor;
    private String Tamanho;
    private String Descricao;
    private String Valor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String cor) {
        Cor = cor;
    }

    public String getTamanho() {
        return Tamanho;
    }

    public void setTamanho(String tamanho) {
        Tamanho = tamanho;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        View v = findViewById(R.id.btadd);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Codigo para navegacao para a tela de add produto ao clicar no botão de incerir produto */
                Intent nav = new Intent(view.getContext(),AddProdutoActivity.class);
                startActivity(nav);
            }
        });


        View e = findViewById(R.id.btedit);
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Codigo para navegacao para a tela de editar produto ao clicar no botão de Editar produto */
                Intent nav = new Intent(view.getContext(),EditarProdutoActivity.class);
                startActivity(nav);
            }
        });

        Button editButton = findViewById(R.id.btedit);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarProduto();
            }
        });




        // logica para após o produto ser salvo redirecionar a produtos e apresentar no linear layout
        llProduto = findViewById(R.id.llProduto);

        Intent intent = getIntent();
        String nome = intent.getStringExtra("nome");
        String tamanho = intent.getStringExtra("tamanho");
        String descricao = intent.getStringExtra("descricao");
        String cor = intent.getStringExtra("cor");
        double valor = intent.getDoubleExtra("valor", 0.0);

        TextView nomeTextView = new TextView(this);
        nomeTextView.setText("Nome: " + nome);

        TextView tamanhoTextView = new TextView(this);
        tamanhoTextView.setText("Tamanho: " + tamanho);

        TextView descricaoTextView = new TextView(this);
        descricaoTextView.setText("Descrição: " + descricao);

        TextView corTextView = new TextView(this);
        corTextView.setText("Cor: " + cor);

        TextView valorTextView = new TextView(this);
        valorTextView.setText("Valor: " + valor);

        llProduto.addView(nomeTextView);
        llProduto.addView(tamanhoTextView);
        llProduto.addView(descricaoTextView);
        llProduto.addView(corTextView);
        llProduto.addView(valorTextView);



    }

    private void editarProduto() {
        //  lógica para editar o produto

        Intent intent = new Intent(Produto.this, EditarProdutoActivity.class);
        intent.putExtra("nome", Nome);
        intent.putExtra("tamanho", Tamanho);
        intent.putExtra("descricao", Descricao);
        intent.putExtra("cor", Cor);
        intent.putExtra("valor", Valor);
        startActivity(intent);

    }

}

