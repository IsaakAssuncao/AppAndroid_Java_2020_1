package com.desenvappmoveis.n1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class editNota2 extends AppCompatActivity {

    private EditText tXN2;
    private  double media ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nota2);

        final Bundle bulble = getIntent().getExtras();

        tXN2 = findViewById(R.id.formulario_nota2);






        Button addAluno = findViewById(R.id.formulario_salvar_n2);
        addAluno.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {

    double n2Var = Double.parseDouble(tXN2.getText().toString());

    double n1Var = bulble.getDouble("n1");

    String nmVar = bulble.getString("name");

    media = ((n2Var + n1Var)/2);



    if (media>=6){
        Intent intentVaiProFormulario = new Intent(editNota2.this, showResultAprovado.class);
        intentVaiProFormulario.putExtra("media",media);
         intentVaiProFormulario.putExtra("name",nmVar);
        startActivity(intentVaiProFormulario);
    }else {

        Intent intentVaiProFormulario = new Intent(editNota2.this, showResultReprovado.class);
        intentVaiProFormulario.putExtra("media", media);
        intentVaiProFormulario.putExtra("name", nmVar);
        startActivity(intentVaiProFormulario);
    }

        }
        });
        }
        }