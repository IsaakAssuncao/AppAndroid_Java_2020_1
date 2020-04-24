package com.desenvappmoveis.n1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class editNotas extends AppCompatActivity {


    private EditText nome;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout. activity_edit_notas);



        nome = findViewById(R.id.formulario_nome_edit);

        final Bundle bulble = getIntent().getExtras();
        nome.setText(bulble.getString("name"));



        nome = findViewById(R.id.formulario_nome_edit);

        Button addAluno = findViewById(R.id.formulario_salvar_aluno);
        addAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nomeValue = nome.getText().toString();

                Intent intent = new Intent(editNotas.this, editNota1.class);

                intent.putExtra("name", nomeValue);

                startActivity(intent);


            }


        });

    }

            private boolean validaNome() {

                String nomeimput = nome.getEditableText().toString().trim();

                if (nomeimput.isEmpty()) {
                    nome.setError("Campo deve ser preenchido!");
                    return false;
                } else {
                    nome.setError(null);
                    return true;
                }
            }

            public void validaCampos(View view) {

                if (!validaNome()) {
                    return;
                }



        }}