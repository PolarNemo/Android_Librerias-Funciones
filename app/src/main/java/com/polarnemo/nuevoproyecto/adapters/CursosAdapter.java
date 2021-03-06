package com.polarnemo.nuevoproyecto.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.polarnemo.nuevoproyecto.CursoActivity;
import com.polarnemo.nuevoproyecto.R;
import com.polarnemo.nuevoproyecto.be.Curso;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CursosAdapter extends RecyclerView.Adapter<CursosAdapter.ViewHolder> {

    private static final String TAG = "CursosAdapter |Nemo";

    private ArrayList<Curso> arrayCurso=new ArrayList<>();
    private Context context;

    public CursosAdapter(Context context, ArrayList<Curso> arrayCurso) {
        this.arrayCurso = arrayCurso;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        Log.i(TAG, "TAG: "+TAG);
        Log.i(TAG, "----------------------------");
        Log.i(TAG, "onCreateViewHolder: called");
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cursos_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        Log.i(TAG, "onBindViewHolder: called");

        Log.i(TAG, "onBindViewHolder: Colocando texto");
        holder.lblNameCurso.setText(arrayCurso.get(position).getNombreCurso());
        holder.lblPromedioCurso.setText(arrayCurso.get(position).getPromedioFinal()+"");
        holder.lblProfesorCurso.setText(arrayCurso.get(position).getIdProfesor());
        holder.chkAprobadoCurso.setChecked(arrayCurso.get(position).getAprobado());
        if(arrayCurso.get(position).getAprobado()) {
            int verde = context.getResources().getColor(R.color.greenTras);
            holder.parentLayout.setBackgroundColor(verde);
        }else{
            int rojo = context.getResources().getColor(R.color.redTras);
            holder.parentLayout.setBackgroundColor(rojo);
        }

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i(TAG, "onClick: Nombre curso"+arrayCurso.get(position).getNombreCurso());
                Log.i(TAG, "onClick: Promedio curso"+arrayCurso.get(position).getPromedioFinal());
                Log.i(TAG, "onClick: Profesor curso"+arrayCurso.get(position).getIdProfesor());
                Log.i(TAG, "onClick: Aprobado curso"+arrayCurso.get(position).getAprobado());

                //Llamando la activity
                Log.i(TAG, "onClick: Creando los activity.putExtra");
                Intent intentCurso=new Intent(context, CursoActivity.class);
                intentCurso.putExtra("Menu_to_Curso_Nombre",arrayCurso.get(position).getNombreCurso());
                intentCurso.putExtra("Menu_to_Curso_PromedioFinal",arrayCurso.get(position).getPromedioFinal());
                intentCurso.putExtra("Menu_to_Curso_Aprobado",arrayCurso.get(position).getAprobado());
                intentCurso.putExtra("Menu_to_Curso_Nota1",arrayCurso.get(position).getNota1());
                intentCurso.putExtra("Menu_to_Curso_Nota2",arrayCurso.get(position).getNota2());
                intentCurso.putExtra("Menu_to_Curso_Nota3",arrayCurso.get(position).getNota3());
                intentCurso.putExtra("Menu_to_Curso_Nota4",arrayCurso.get(position).getNota4());
                intentCurso.putExtra("Menu_to_Curso_NotaFinal",arrayCurso.get(position).getNotaFinal());
                intentCurso.putExtra("Menu_to_Curso_PromedioInasistencias",arrayCurso.get(position).getPromedioInasistencias());
                Log.i(TAG, "onClick: Termiandno de crear los activity.putExtra");
                Log.i(TAG, "onClick: Llamando el CursoActivity");
                context.startActivity(intentCurso);
            }
        });

    }

    @Override
    public int getItemCount(){
        return arrayCurso.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "ViewHolder";

        TextView lblNameCurso, lblPromedioCurso, lblProfesorCurso;
        CheckBox chkAprobadoCurso;
        LinearLayout parentLayout;

        public ViewHolder(View itemView)
        {
            super(itemView);
            Log.i(TAG, "ViewHolder: Iniando ViewHolder");
            Log.i(TAG, "ViewHolder: Asisgnando las variables al xml partner del adapter");
            lblNameCurso= itemView.findViewById(R.id.lblNameCurso_CursoListView);
            lblPromedioCurso=itemView.findViewById(R.id.lblPromedioCurso_CursoListView);
            lblProfesorCurso= itemView.findViewById(R.id.lblProfesorCurso_CursoListView);
            chkAprobadoCurso=itemView.findViewById(R.id.chkAprobadoCurso_CursoListView);
            parentLayout=itemView.findViewById(R.id.parentLayout_CursoRecyclerViewAdapter);
            Log.i(TAG, "ViewHolder: Terminando ViewHolder");

        }




    }



}
