package com.polarnemo.nuevoproyecto;

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

        cargandoDatos();

        Log.i(TAG, "onCreate: Terminando el menu");
    }

    private void cargandoDatos()
    {
        Log.i(TAG, "cargandoDatos: Empezando a cargar datos");

        objCurso=new Curso();
        objCurso.setNombreCurso("Antropologia");
        objCurso.setPromedioFinal(19);
        objCurso.setIdProfesor("ANT007");
        objCurso.setAprobado(true);

        listCursos.add(objCurso);

        objCurso=new Curso();
        objCurso.setNombreCurso("Biologia");
        objCurso.setPromedioFinal(10);
        objCurso.setIdProfesor("BIO666");
        objCurso.setAprobado(false);

        listCursos.add(objCurso);

        objCurso=new Curso();
        objCurso.setNombreCurso("Ciencias Sociales");
        objCurso.setPromedioFinal(16);
        objCurso.setIdProfesor("CSO777");
        objCurso.setAprobado(true);

        listCursos.add(objCurso);


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


}
