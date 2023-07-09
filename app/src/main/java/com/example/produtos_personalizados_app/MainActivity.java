package com.example.produtos_personalizados_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       View v = findViewById(R.id.btProduto);
       v.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               /* Codigo para navegacaoo para a tela de produto ao clicar no botão de produto */
               Intent nav = new Intent(view.getContext(),Produto.class);
               startActivity(nav);
           }
       });

        View o = findViewById(R.id.btOrcamento);
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* Codigo para navegacaoo para a tela de produto ao clicar no botão de produto */
                Intent nav = new Intent(view.getContext(),Orcamento.class);
                startActivity(nav);
            }
        });
    }
}


