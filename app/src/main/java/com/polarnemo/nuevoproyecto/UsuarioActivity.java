package com.polarnemo.nuevoproyecto;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.polarnemo.nuevoproyecto.be.Usuario;
import com.squareup.picasso.Picasso;

public class UsuarioActivity extends AppCompatActivity {

    private static final String TAG = "UsuarioActivity";

    TextView lblDni,lblDireccion,lblEdad,lblCarrera;
    ImageView imgUsuario;

    String nombreUsuario, carreraUsuario, distritoUsuario, strGDNIUsuario, uriUsuario;
    int DNIUsuario, edadUsuario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario);
        Log.i(TAG, "onCreate: Iniciando el UsuarioActivity");

        Log.i(TAG, "onCreate: Enlazando los Widgets");
        lblDireccion=findViewById(R.id.lblDireccionUser_Det);
        lblDni=findViewById(R.id.lblDniUser_Det);
        lblEdad=findViewById(R.id.lblEdadUser_Det);
        lblCarrera=findViewById(R.id.lblCarreraUser_Det);
        imgUsuario=findViewById(R.id.imgUsuarioUser_Det);

        Log.i(TAG, "onCreate: Obteniendo los getExtras");
        Intent usuarioIntent=getIntent();
        nombreUsuario= usuarioIntent.getStringExtra("Menu_to_User_Nombre");
        carreraUsuario= usuarioIntent.getStringExtra("Menu_to_User_Carrera");
        distritoUsuario= usuarioIntent.getStringExtra("Menu_to_User_Distrito");
        DNIUsuario= usuarioIntent.getIntExtra("Menu_to_User_DNI",0);
        edadUsuario= usuarioIntent.getIntExtra("Menu_to_User_Edad",0);

        Log.i(TAG, "onCreate: nombreUsuario:"+nombreUsuario);
        Log.i(TAG, "onCreate: carreraUsuario:"+carreraUsuario);
        Log.i(TAG, "onCreate: distritoUsuario:"+distritoUsuario);
        Log.i(TAG, "onCreate: DNIUsuario:"+DNIUsuario);
        Log.i(TAG, "onCreate: edadUsuario:"+edadUsuario);

        Log.i(TAG, "onCreate: Insertando el text en los widgets");
        setTitle(nombreUsuario);
        Log.d(TAG, "onCreate: DNIUsuario :"+DNIUsuario);
        String strDNIUsuario="";
        int countstrDNIUsuario=0;
        while(Double.toString(DNIUsuario).charAt(countstrDNIUsuario)!='.')
        {
            strDNIUsuario+=Double.toString(DNIUsuario).charAt(countstrDNIUsuario);
            Log.i(TAG, "onCreate: count("+countstrDNIUsuario+") strDNIUsuario:"+strDNIUsuario);
            countstrDNIUsuario++;
        }
        Log.d(TAG, "onCreate: strDNIUsuario :"+strDNIUsuario);
        strGDNIUsuario=strDNIUsuario;
        Usuario objUsuario=new Usuario();
        uriUsuario= objUsuario.getUriPerfil();
        Log.i(TAG, "onCreate: Insertando los datos en los TextView");
        insertarDatos();

        Log.i(TAG, "onCreate: Terminando el UsuarioActivity");
    }

    private void insertarDatos(){
        Log.i(TAG, "insertarDatos: Iniciando el insertar los datos");

        lblDni.setText(strGDNIUsuario);
        lblDireccion.setText(distritoUsuario);
        String strAge=Double.toString(edadUsuario);
        Log.d(TAG, "onCreate: strEdad :"+strAge);
        lblEdad.setText(strAge);
        lblCarrera.setText(carreraUsuario);

        Picasso.with(this).load(Uri.parse("https://www.elbrinner.com/img/files/banner/xamarin_android_1.jpg")).into(imgUsuario);

        Log.i(TAG, "insertarDatos:uriUsuario "+uriUsuario);

        Log.i(TAG, "insertarDatos: Finalizando los insertar los datos");
    }


}
