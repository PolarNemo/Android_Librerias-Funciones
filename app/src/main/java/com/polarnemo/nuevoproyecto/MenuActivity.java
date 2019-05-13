package com.polarnemo.nuevoproyecto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.polarnemo.nuevoproyecto.adapters.CursosAdapter;
import com.polarnemo.nuevoproyecto.be.Curso;
import com.polarnemo.nuevoproyecto.be.Usuario;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MenuActivity  extends AppCompatActivity {

    private static final String TAG = "MenuActivity";

    ArrayList<Curso> listCursos=new ArrayList<>();

    TextView lblUserName, lblUserDni;

    Usuario objUsuario;
    Curso objCurso;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(TAG);
        setContentView(R.layout.activity_menu);
        Log.i(TAG, "onCreate: Iniciando el menu");

        lblUserName=findViewById(R.id.lblUserName);
        lblUserDni=findViewById(R.id.lblUserDni);

        //Adquiriendo los extras
        Intent intent=getIntent();
        String nombreUsuario= intent.getStringExtra("Login_to_Menu_Nombre");
        String carreraUsuario= intent.getStringExtra("Login_to_Menu_Carrera");
        int DNIUsuario= intent.getIntExtra("Login_to_Menu_DNI",0);
        int edadUsuario= intent.getIntExtra("Login_to_Menu_Edad",0);

        Log.i(TAG, "onCreate: nombreUsuario:"+nombreUsuario);
        Log.i(TAG, "onCreate: carreraUsuario:"+carreraUsuario);
        Log.i(TAG, "onCreate: DNIUsuario:"+DNIUsuario);
        Log.i(TAG, "onCreate: edadUsuario:"+edadUsuario);

        cargandoDatos();

        //Pintando los datos del usuario
        lblUserName.setText(nombreUsuario);
        lblUserDni.setText(": "+DNIUsuario);

        Log.i(TAG, "onCreate: Terminando el menu");
    }

    private void cargandoDatos()
    {
        Log.i(TAG, "cargandoDatos: Empezando a cargar datos");

        llenandoData();

        Log.i(TAG, "cargandoDatos: Cargando el Curso Adapter");

        cargandoAdapter();

        Log.i(TAG, "cargandoDatos: Terminando de cargar datos");
    }

    private void cargandoAdapter()
    {
        Log.i(TAG, "cargandoAdapter: Iniciando el Adapter");
        RecyclerView recyclerView=findViewById(R.id.cursos_RecyclerView);
        CursosAdapter adapter=new CursosAdapter(this, listCursos);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Log.i(TAG, "cargandoAdapter: Terminando el Adapter");
    }

    private void llenandoData()
    {
        objCurso=new Curso();
        objCurso.setNombreCurso("Antropologia");
        objCurso.setNota1(13);
        objCurso.setNota2(17);
        objCurso.setNota3(19);
        objCurso.setNota4(20);
        objCurso.setNotaFinal(18);
        objCurso.setInasistencias(0);
        objCurso.setIdProfesor("ANT007");

        listCursos.add(objCurso);

        objCurso=new Curso();
        objCurso.setNombreCurso("Biologia");
        objCurso.setNota1(10);
        objCurso.setNota2(14);
        objCurso.setNota3(18);
        objCurso.setNota4(20);
        objCurso.setNotaFinal(17);
        objCurso.setInasistencias(1);
        objCurso.setIdProfesor("BIO666");

        listCursos.add(objCurso);

        objCurso=new Curso();
        objCurso.setNombreCurso("Ciencias Sociales");
        objCurso.setNota1(5);
        objCurso.setNota2(12);
        objCurso.setNota3(11);
        objCurso.setNota4(13);
        objCurso.setNotaFinal(14);
        objCurso.setInasistencias(3);
        objCurso.setCantClasesTotales(10);
        objCurso.setIdProfesor("CSO777");

        listCursos.add(objCurso);

        objCurso=new Curso();
        objCurso.setNombreCurso("Dopamina y sus regulaciones");
        objCurso.setNota1(0);
        objCurso.setNota2(0);
        objCurso.setNota3(0);
        objCurso.setNota4(0);
        objCurso.setNotaFinal(20);
        objCurso.setInasistencias(15);
        objCurso.setCantClasesTotales(16);
        objCurso.setIdProfesor("DOR142");

        listCursos.add(objCurso);

        objCurso=new Curso();
        objCurso.setNombreCurso("Estadistica para Dummies");
        objCurso.setNota1(20);
        objCurso.setNota2(20);
        objCurso.setNota3(20);
        objCurso.setNota4(20);
        objCurso.setNotaFinal(0);
        objCurso.setInasistencias(1);
        objCurso.setCantClasesTotales(16);
        objCurso.setIdProfesor("ESD854");

        listCursos.add(objCurso);

        objCurso=new Curso();
        objCurso.setNombreCurso("Forence, Introduccion");
        objCurso.setNota1(15);
        objCurso.setNota2(16);
        objCurso.setNota3(19);
        objCurso.setNota4(18);
        objCurso.setNotaFinal(15);
        objCurso.setInasistencias(0);
        objCurso.setCantClasesTotales(17);
        objCurso.setIdProfesor("FOI211");

        listCursos.add(objCurso);

        objCurso=new Curso();
        objCurso.setNombreCurso("Gerundios y sus aplicaciones");
        objCurso.setNota1(15);
        objCurso.setNota2(13);
        objCurso.setNota3(14);
        objCurso.setNota4(13);
        objCurso.setNotaFinal(5);
        objCurso.setInasistencias(0);
        objCurso.setCantClasesTotales(17);
        objCurso.setIdProfesor("GYA152");

        listCursos.add(objCurso);
    }


}
