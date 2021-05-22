package com.example.practicasemana14;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends BaseAdapter {

    //Arreglo a representar graficamente
    ArrayList<Task> tasks;

    public TaskAdapter(){
        tasks = new ArrayList<>();
        //meter la otra img en escritorio
    }

    //Metodo para agregar una task al arreglo
    public void addTask(Task task){
        tasks.add(task);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View item = inflater.inflate(R.layout.taskpreview, null);

        //Referenciar los items
        TextView textTitulo = item.findViewById(R.id.textTitulo);
        TextView textFecha = item.findViewById(R.id.textFecha);
        TextView textTask = item.findViewById(R.id.textTask);

        //Darle la informacion a los text segun el array
        textTitulo.setText(tasks.get(position).getTittle());
        textFecha.setText(tasks.get(position).getDateStr());
        textTask.setText(tasks.get(position).getDescription());


        return item;
    }

    public void clear() {
        tasks.clear();
        notifyDataSetChanged();
    }
    //agregar btns
}
