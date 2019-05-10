package com.polarnemo.nuevoproyecto.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.polarnemo.nuevoproyecto.R;
import com.polarnemo.nuevoproyecto.be.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursosAdapter extends ArrayAdapter {

    private Activity context;
    ArrayList<Curso> listCursos;
    private int resources;

    public CursosAdapter(@NonNull Activity context, @LayoutRes int resource, ArrayList listCursos) {
        super(context, resource,listCursos);
        this.context=context;
        this.listCursos=listCursos;
        this.resources=resource;

    }

    @Override
    public Object getItem(int position) {
        return listCursos.get(position);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(context!=null)
        {
            view = context.getLayoutInflater().inflate(resources,null);
            TextView lblName=view.findViewById(R.id.lblNameCurso_CursoListView);
            TextView lblPromedio=view.findViewById(R.id.lblPromedioCurso_CursoListView);
            TextView lblProfesor=view.findViewById(R.id.lblProfesorCurso_CursoListView);
            CheckBox chkAprobado=view.findViewById(R.id.chkAprobadoCurso_CursoListView);

            Curso objCurso=new Curso();
            objCurso.setNombreCurso(lblName.getText().toString());
            objCurso.setPromedioFinal(Integer.parseInt(lblPromedio.getText().toString()));
            objCurso.setIdProfesor(lblProfesor.getText().toString());
            objCurso.setAprobado(chkAprobado.isChecked());



            listCursos.set(i,objCurso);



        }
        return view;
    }


}
