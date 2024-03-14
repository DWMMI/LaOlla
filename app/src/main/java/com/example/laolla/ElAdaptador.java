package com.example.laolla;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ElAdaptador extends RecyclerView.Adapter<ElAdaptador.ElViewHolder> implements View.OnClickListener {

    private ArrayList<ItemLista> datos;
    private View.OnClickListener listener;

    public static class ElViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagen;
        private TextView nombrereceta;
        public ElViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imageView);
            nombrereceta = itemView.findViewById(R.id.textView);
        }

        public void bindItemLista(ItemLista r){
            imagen.setImageResource(r.getImg());
            nombrereceta.setText(r.getTextoup());
        }
    }

    public ElAdaptador(ArrayList<ItemLista> datos){
        this.datos = datos;
    }

    public ElAdaptador.ElViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lay_1, parent, false);
        v.setOnClickListener(this);
        ElViewHolder evh = new ElViewHolder(v);
        return evh;
    }

    public void onBindViewHolder(ElViewHolder holder, int pos){
        holder.bindItemLista(datos.get(pos));
    }
    @Override
    public int getItemCount() {
        return datos.size();
    }
    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }
    @Override
    public void onClick(View view) {
        if(listener != null)
            listener.onClick(view);
    }
}
