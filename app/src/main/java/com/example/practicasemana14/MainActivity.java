package com.example.practicasemana14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    //private ListView taskLists;
    private EditText userInput;
    private Button btnIngresar;
    private FirebaseDatabase db;
    private boolean verificar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //taskLists = findViewById(R.id.taskLists);
        userInput = findViewById(R.id.userInput);
        btnIngresar = findViewById(R.id.btnIngresar);
//        db = FirebaseDatabase.getInstance();

        btnIngresar.setOnClickListener(
                (v) -> {
                    String userName = userInput.getText().toString();

                    //Verificacion para saber si está vacio el input o no
                    verificar = userName.isEmpty();
                    if(verificar){
                        Toast.makeText(this, "Por favor ingrese un usuario", Toast.LENGTH_SHORT).show();
                    }else {
                        Intent i = new Intent(this, taskView.class);
                        startActivity(i);
                    }
                }
        );

    }
}