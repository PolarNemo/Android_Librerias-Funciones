package com.polarnemo.nuevoproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.bumptech.glide.load.engine.Resource;

import org.w3c.dom.Text;

public class CursoActivity extends AppCompatActivity {

    private static final String TAG = "CursoActivity |NP";

    TextView lblPromedio, lblEstado, lblNota1, lblNota2, lblNota3, lblNota4, lblNotaFinal, lblPromedioFinal, lblPorcentajeInasistencias;
    SeekBar skbPorcentajeInasistencias;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curso);

        //Asignando las variables a los widgets
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

        lblPromedio.setText("Promedio : "+promedioFinal);
        if(aprobado){
            lblEstado.setText(" Aprobado");
            lblEstado.setTextColor(getResources().getColor(R.color.green));
        }else{
            lblEstado.setText(" Desaprobado");
            lblEstado.setTextColor(getResources().getColor(R.color.red));
        }

        setearColorDeAprobados(lblNota1,nota1);
        setearColorDeAprobados(lblNota2,nota2);
        setearColorDeAprobados(lblNota3,nota3);
        setearColorDeAprobados(lblNota4,nota4);
        setearColorDeAprobados(lblNotaFinal,notaFinal);
        setearColorDeAprobados(lblPromedioFinal, Integer.parseInt(promedioFinal+""));

        lblPorcentajeInasistencias.setText("Porcentaje de Inasistencias: "+promedioInasistencias+"%");
        skbPorcentajeInasistencias.setProgress(Integer.parseInt(promedioInasistencias+""));

        setTitle("Curso : "+nombreCurso);

    }

    private void setearColorDeAprobados(TextView lblNota, int nota)
    {
        if(nota==21) {
            lblNota.setText(R.string.onMaintenance);
        }else if (nota>13 && nota<=20){
            lblNota.setText(nota);
            lblNota.setTextColor(getResources().getColor(R.color.green));
        }else{
            lblNota.setText(nota);
            lblNota.setTextColor(getResources().getColor(R.color.red));
        }
    }



}
