package com.example.laolla;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView miRecyclerView;
    private LinearLayoutManager miLayoutManager;
    private ElAdaptador miAdapter;
    private ArrayList<ItemLista> datos;

    ActivityResultLauncher<Intent> stfrores = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK){

            }
        }
    });

    public void abrirReceta(View view){
        Intent intent = new Intent(this, Receta.class);
        intent.putExtra("1", 0);
        stfrores.launch(intent);

    }
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
                abrirReceta(v);
                String msg = "Seleccionada la opción " + miRecyclerView.getChildAdapterPosition(v);
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
        miRecyclerView.setAdapter(miAdapter);
    }
}