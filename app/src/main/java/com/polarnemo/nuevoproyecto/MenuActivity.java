package com.polarnemo.nuevoproyecto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.polarnemo.nuevoproyecto.adapters.CursosAdapter;
import com.polarnemo.nuevoproyecto.be.Usuario;

import org.w3c.dom.Text;

public class MenuActivity  extends AppCompatActivity {

    private static final String TAG = "MenuActivity";

    TextView lblUserName, lblUserDni;

    Usuario objUsuario;
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        objUsuario=new Usuario();
        objUsuario.setNombre("Nemo");
        objUsuario.setDni(555);

        lblUserName.setText(objUsuario.getNombre());
        lblUserDni.setText(" : " + objUsuario.getDni());

        Log.i(TAG, "cargandoDatos: Cargando el Curso Adapter");

//        CursosAdapter cursosAdapter=new CursosAdapter(this, R.layout.activity_cursos_adapter)

        Log.i(TAG, "cargandoDatos: Terminando de cargar datos");
    }


}
