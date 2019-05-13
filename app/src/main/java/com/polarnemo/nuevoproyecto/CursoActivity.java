package com.polarnemo.nuevoproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;

import org.w3c.dom.Text;

import javax.security.auth.login.LoginException;

public class CursoActivity extends AppCompatActivity {

    private static final String TAG = "CursoActivity |NP";

    TextView lblPromedio, lblEstado, lblNota1, lblNota2, lblNota3, lblNota4, lblNotaFinal, lblPromedioFinal, lblPorcentajeInasistencias;
    SeekBar skbPorcentajeInasistencias;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        //Asignando las variables a los widgets
        Log.i(TAG, "onCreate: Asignando Variables de Widgets");
        lblPromedio=findViewById(R.id.lblPromedioCursoDet);
        lblEstado=findViewById(R.id.lblEstadoCursoDet);
        lblNota1=findViewById(R.id.lblNota1CursoDet);
        lblNota2=findViewById(R.id.lblNota2CursoDet);
        lblNota3=findViewById(R.id.lblNota3CursoDet);
        lblNota4=findViewById(R.id.lblNota4CursoDet);
        lblNotaFinal=findViewById(R.id.lblNotaFinalCursoDet);
        lblPromedioFinal=findViewById(R.id.lblPromedioFinalCursoDet);
        lblPorcentajeInasistencias=findViewById(R.id.lblPorcentajeInasistenciasCursoDet);
        skbPorcentajeInasistencias=findViewById(R.id.skbPorcentajeInasistenciasCursoDet);

        //Obteniendo los Extras
        Log.i(TAG, "onCreate: Obteniendo Extras");
        Intent intent=getIntent();
        String nombreCurso= intent.getStringExtra("Menu_to_Curso_Nombre");
        double promedioFinal= intent.getDoubleExtra("Menu_to_Curso_PromedioFinal",-1);
        boolean aprobado= intent.getBooleanExtra("Menu_to_Curso_Aprobado",false);
        int nota1= intent.getIntExtra("Menu_to_Curso_Nota1",21);
        int nota2= intent.getIntExtra("Menu_to_Curso_Nota2",21);
        int nota3= intent.getIntExtra("Menu_to_Curso_Nota3",21);
        int nota4= intent.getIntExtra("Menu_to_Curso_Nota4",21);
        int notaFinal= intent.getIntExtra("Menu_to_Curso_NotaFinal",21);
        double promedioInasistencias= intent.getDoubleExtra("Menu_to_Curso_PromedioFinal",-1);

        Log.i(TAG, "onCreate: Seteando el promedio");
        lblPromedio.setText("Promedio : "+promedioFinal);
        if(aprobado){
            lblEstado.setText(" Aprobado");
            lblEstado.setTextColor(getResources().getColor(R.color.green));
        }else{
            lblEstado.setText(" Desaprobado");
            lblEstado.setTextColor(getResources().getColor(R.color.red));
        }

        Log.i(TAG, "onCreate: Seteando nota1");
        setearColorDeAprobados(lblNota1,nota1);
        Log.i(TAG, "onCreate: Seteando nota2");
        setearColorDeAprobados(lblNota2,nota2);
        Log.i(TAG, "onCreate: Seteando nota3");
        setearColorDeAprobados(lblNota3,nota3);
        Log.i(TAG, "onCreate: Seteando nota4");
        setearColorDeAprobados(lblNota4,nota4);
        Log.i(TAG, "onCreate: Seteando notafinal");
        setearColorDeAprobados(lblNotaFinal,notaFinal);
        Log.i(TAG, "onCreate: Seteando promedioFinal");
        setearColorDeAprobados(lblPromedioFinal, Integer.parseInt(promedioFinal+""));

        Log.i(TAG, "onCreate: Seteando lblPorcentajeInasistencias");
        lblPorcentajeInasistencias.setText("Porcentaje de Inasistencias: "+promedioInasistencias+"%");
        Log.i(TAG, "onCreate: Seteando skbPorcentajeInasistencias");
        skbPorcentajeInasistencias.setProgress(Integer.parseInt(promedioInasistencias+""));

        Log.i(TAG, "onCreate: Imprimiendo el titulo");
        setTitle("Curso : "+nombreCurso);

    }

    private void setearColorDeAprobados(TextView lblNota, int nota)
    {
        Log.i(TAG, "setearColorDeAprobados: Iniciando = lblNota:"+lblNota+"| nota:"+nota);
        if(nota==21) {
            Log.i(TAG, "setearColorDeAprobados: ==21");
            lblNota.setText(R.string.onMaintenance);
        }else if (nota>13 && nota<=20){
            Log.i(TAG, "setearColorDeAprobados: >13 <=20");
            lblNota.setText(nota);
            lblNota.setTextColor(getResources().getColor(R.color.green));
        }else{
            Log.i(TAG, "setearColorDeAprobados: else");
            lblNota.setText(nota);
            lblNota.setTextColor(getResources().getColor(R.color.red));
        }
        Log.i(TAG, "setearColorDeAprobados: Terminando = lblNota:"+lblNota+"| nota:"+nota);
    }



}
