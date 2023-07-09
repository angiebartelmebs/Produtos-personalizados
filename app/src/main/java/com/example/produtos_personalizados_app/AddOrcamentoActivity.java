package com.example.produtos_personalizados_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddOrcamentoActivity extends AppCompatActivity {

    EditText cliente;
    EditText telefone;
    EditText produto;
    EditText preco;
    Button incluir;

    private ConexãoBD ConexãoDB;
    private SQLiteDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_orcamento);

        ConexãoBD ConexãoDB = new ConexãoBD(this);
        database = ConexãoDB.getWritableDatabase();

       cliente = findViewById(R.id.addTextCliente);
       telefone = findViewById(R.id.addTextTel);
       produto = findViewById(R.id.addTextProdutos);
       preco = findViewById(R.id.addTextPreco);
        incluir = findViewById(R.id.btincluir);
        // Ilógica para inserir o produto
        incluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Cliente = cliente.getText().toString();
                String Telefone = telefone.getText().toString();
                String Produto = produto.getText().toString();
                double Preco = Double.parseDouble(preco.getText().toString());
                //inserir os produtos no linear layout na activity de produto
                Intent intent = new Intent(AddOrcamentoActivity.this, Orcamento.class);
                intent.putExtra("Cliente", Cliente);
                intent.putExtra("Telefone", Telefone);
                intent.putExtra("Produto", Produto);
                intent.putExtra("Preco", Preco);
                startActivity(intent);

                Toast.makeText(AddOrcamentoActivity.this, "Orçamento Salvo", Toast.LENGTH_SHORT).show();
            }
        });
    }
}