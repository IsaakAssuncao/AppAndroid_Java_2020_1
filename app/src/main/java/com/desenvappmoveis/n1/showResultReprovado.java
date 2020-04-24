package com.desenvappmoveis.n1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class showResultReprovado extends AppCompatActivity {



    private EditText nome;
    private EditText mediafinal;
    private EditText status;
    private TextView TValuno;
    private TextView TVmedia;
    private TextView TVstatus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_result_rep);

        final Bundle bunble = getIntent().getExtras();

        mediafinal = findViewById(R.id.formulario_media);
        status = findViewById(R.id.formulario_status);
        nome = findViewById(R.id.formulario_nome);
        TValuno = findViewById(R.id.textViewAluno);
        TVmedia = findViewById(R.id.textViewMedia);
        TVstatus = findViewById(R.id.textViewStatus);

        String mf = Double.toString(bunble.getDouble("media"));

        nome.setText(bunble.getString("name"));
        mediafinal.setText(mf);
        status.setText("Reprovado");
        TValuno.setText("Aluno");
        TVmedia.setText("Média final");
        TVstatus.setText("Status");

        Button addAluno = findViewById(R.id.formulario_voltar);
        addAluno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                String varNome = bunble.getString("name");


                Intent intent = new Intent(showResultReprovado.this, MainActivity.class);
                intent.putExtra("name",varNome);
                intent.putExtra("id",1);
                startActivity(intent);

            }
        });
    }
}

