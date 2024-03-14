package com.example.laolla;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView miRecyclerView;
    private LinearLayoutManager miLayoutManager;
    private ElAdaptador miAdapter;
    private ArrayList<ItemLista> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = new ArrayList<>();
        datos.add(new ItemLista(R.drawable.abejaruco, "Abejaruco"));
        datos.add(new ItemLista(R.drawable.abejaruco, "Abejaruco2"));
        datos.add(new ItemLista(R.drawable.abejaruco, "Abejaruco3"));
        miRecyclerView = findViewById(R.id.recview);
        miRecyclerView.setHasFixedSize(true);
        miLayoutManager = new LinearLayoutManager(this);
        miRecyclerView.setLayoutManager(miLayoutManager);
        miAdapter = new ElAdaptador(datos);
        miAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // implementar el pasar a otra ventana con los datos de la receta
                String msg = "Seleccionada la opción " + miRecyclerView.getChildAdapterPosition(v);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        miRecyclerView.setAdapter(miAdapter);
    }
}