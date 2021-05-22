package com.example.practicasemana14;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class taskView extends AppCompatActivity {

    private ListView listView;
    private EditText textNtarea;
    private EditText textDescripcion;
    private Button btnAgregar;
    private FirebaseDatabase db;
    private TaskAdapter adapter;
    Task task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_view);

        listView = findViewById(R.id.listView);
        textNtarea = findViewById(R.id.textNtarea);
        textDescripcion = findViewById(R.id.textDescripcion);
        btnAgregar = findViewById(R.id.btnAgregar);

        adapter = new TaskAdapter();
        listView.setAdapter(adapter);
        db = FirebaseDatabase.getInstance();

        cargarTask();

        btnAgregar.setOnClickListener(
                v -> {
                    String nTarea = textNtarea.getText().toString();
                    String descriTarea = textDescripcion.getText().toString();

                    db.getReference().child("");

                    textNtarea.setText("");
                    textDescripcion.setText("");
                }
        );
    }

    private void cargarTask() {
        db.getReference().child("info").addValueEventListener(
                new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        adapter.clear();
                        for (DataSnapshot child: dataSnapshot.getChildren()){
                            Task tarea = child.getValue(Task.class);
                            adapter.addTask(tarea);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                }
        );
    }
}