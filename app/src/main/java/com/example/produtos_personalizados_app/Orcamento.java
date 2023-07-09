package com.example.produtos_personalizados_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Orcamento extends AppCompatActivity {

    LinearLayout llOrcamento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orcamento);

        View i = findViewById(R.id.btaddor);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /* Codigo para navegacao */
                Intent nav = new Intent(view.getContext(),AddOrcamentoActivity.class);
                startActivity(nav);
            }
        });

        // logica para após  ser salvo redirecionar e apresentar no linear layout
        llOrcamento = findViewById(R.id.llOrcamento);

        Intent intent = getIntent();
        String Cliente = intent.getStringExtra("cliente");
        String Telefone = intent.getStringExtra("telefone");
        String Produtos = intent.getStringExtra("produtos");
        double Preco = intent.getDoubleExtra("preco", 0.0);

        TextView clienteTextView = new TextView(this);
        clienteTextView.setText("cliente: " + Cliente);

        TextView telefoneTextView = new TextView(this);
        telefoneTextView.setText("telefone: " + Telefone);

        TextView produtosTextView = new TextView(this);
        produtosTextView.setText("produtos: " + Produtos);

        TextView precoTextView = new TextView(this);
        precoTextView.setText("preco: " + Preco);

        llOrcamento.addView(clienteTextView);
        llOrcamento.addView(telefoneTextView);
        llOrcamento.addView(produtosTextView);
        llOrcamento.addView(precoTextView);


    }
}