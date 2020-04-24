package com.desenvappmoveis.n1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class editNota1 extends AppCompatActivity {

    private EditText sN1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_nota1);



        final Bundle bulble = getIntent().getExtras();

        sN1 = findViewById(R.id.formulario_nota1);







        Button addAluno = findViewById(R.id.formulario_salvar_n1);
        addAluno.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                double n1Var = Double.parseDouble(sN1.getText().toString());
                String nmVar = bulble.getString("name");

                Intent intentVaiProFormulario = new Intent(editNota1.this, editNota2.class);
                intentVaiProFormulario.putExtra("name",nmVar);
                intentVaiProFormulario.putExtra("n1",n1Var);


                startActivity(intentVaiProFormulario);

            }
        });
    }
}