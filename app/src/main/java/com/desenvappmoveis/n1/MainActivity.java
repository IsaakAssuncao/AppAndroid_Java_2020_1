package com.desenvappmoveis.n1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    androidx.appcompat.widget.Toolbar toolbar;




    public static List<String> lista = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Lista de Alunos");
        this.validarretorno();

        listView = (ListView) findViewById(R.id.lista_alunos);


        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent (MainActivity.this, editNotas.class);
                intent.putExtra("name",listView.getItemAtPosition(position).toString());
                startActivity(intent);
            }
        });



        Button addAluno = findViewById(R.id.formulario_add_aluno);
        addAluno.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent (MainActivity.this, insertAluno.class);
            startActivityForResult(intent, 0);

        }
    });
}


    public void editAluno(View view) {

        Intent intent = new Intent (MainActivity.this, insertAluno.class);
        startActivityForResult(intent, 0);


    }

    public void validarretorno() {

        final Bundle bunble = getIntent().getExtras();


        try {

            if (bunble != null){

                int id =bunble.getInt("id");

            if (id == 1) {

                String nome = bunble.getString("name");
                lista.add(nome);
                Toast.makeText(MainActivity.this, "Registro salvo!", Toast.LENGTH_SHORT).show();

            }}
        }catch (Exception e){

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == 1){

            if (data != null){
                String nome = String.valueOf(data.getExtras().getCharSequence("name"));
                lista.add(nome);
            }
            Intent intent = new Intent(MainActivity.this, editNota1.class);

            startActivityForResult(intent,1);
        }
    }
}
