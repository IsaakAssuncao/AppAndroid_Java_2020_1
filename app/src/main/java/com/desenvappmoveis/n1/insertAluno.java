package com.desenvappmoveis.n1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class insertAluno extends AppCompatActivity {


    private EditText nome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_aluno);



        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.formulario_nome);

        String[] nomes = getResources().getStringArray(R.array.nomes_array);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nomes);
        textView.setAdapter(adapter);



        nome = findViewById(R.id.formulario_nome);

        Button addAluno = findViewById(R.id.formulario_salvar_aluno);
        addAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String nomeValue = nome.getText().toString();

                Intent intent = new Intent(insertAluno.this, editNota1.class);

                intent.putExtra("name", nomeValue);

                startActivity(intent);

            }


        });

    }
    private boolean validaNome(){

        String nomeimput  =  nome.getEditableText().toString().trim();

        if (nomeimput.isEmpty()){
            nome.setError("Campo deve ser preenchido!");
            return  false;
        }else {
            nome.setError(null);
            return  true;
        }
    }

    public void validaCampos(View view) {

        if (!validaNome()){
            return;
        }
    }


}