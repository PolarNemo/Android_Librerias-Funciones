package com.polarnemo.nuevoproyecto.adapters;

import android.app.Activity;
import android.content.Context;
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
        Log.i(TAG, "onCreateViewHolder: called");
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_cursos_adapter, parent, false);
        ViewHolder holder = new ViewHolder(view) ;
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position){
        Log.i(TAG, "onBindViewHolder: called");

        holder.lblNameCurso.setText(arrayCurso.get(position).getNombreCurso());
        holder.lblPromedioCurso.setText(arrayCurso.get(position).getPromedioFinal()+"");
        holder.lblProfesorCurso.setText(arrayCurso.get(position).getIdProfesor());
        holder.chkAprobadoCurso.setChecked(arrayCurso.get(position).getAprobado());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context,"Funciono perra",Toast.LENGTH_LONG).show();

                Log.i(TAG, "onClick: Nombre curso"+arrayCurso.get(position).getNombreCurso());
                Log.i(TAG, "onClick: Promedio curso"+arrayCurso.get(position).getPromedioFinal());
                Log.i(TAG, "onClick: Profesor curso"+arrayCurso.get(position).getIdProfesor());
                Log.i(TAG, "onClick: Aprobado curso"+arrayCurso.get(position).getAprobado());

            }
        });

    }

    @Override
    public int getItemCount(){
        return arrayCurso.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView lblNameCurso, lblPromedioCurso, lblProfesorCurso;
        CheckBox chkAprobadoCurso;
        LinearLayout parentLayout;

        public ViewHolder(View itemView)
        {
            super(itemView);
            lblNameCurso= itemView.findViewById(R.id.lblNameCurso_CursoListView);
            lblPromedioCurso=itemView.findViewById(R.id.lblPromedioCurso_CursoListView);
            lblProfesorCurso= itemView.findViewById(R.id.lblProfesorCurso_CursoListView);
            chkAprobadoCurso=itemView.findViewById(R.id.chkAprobadoCurso_CursoListView);
            parentLayout=itemView.findViewById(R.id.parentLayout_CursoRecyclerViewAdapter);

        }




    }



}
