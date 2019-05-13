package com.polarnemo.nuevoproyecto;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.polarnemo.nuevoproyecto.be.Usuario;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity | PN";

    TextView lblUser, lblPwd,lblVacio;
    EditText txtUser, txtPwd;
    Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Login");
        setContentView(R.layout.activity_main);

        lblUser=findViewById(R.id.lblUser);
        lblPwd=findViewById(R.id.lblPwd);

        txtUser=findViewById(R.id.txtUser);
        txtPwd=findViewById(R.id.txtPwd);

        btnGo=findViewById(R.id.btnGo);

        lblVacio=findViewById(R.id.lblVacio);

        formateandoTexto();

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: Iniciando el logeo");
                String strUser = txtUser.getText().toString();
                String strPwd = txtPwd.getText().toString();

                if(strUser.equals("admin") && strPwd.equals("123"))
                {
                    Log.i(TAG, "onClick: Logeo Correcto");
                    Usuario objUsuario=new Usuario();
                    Intent intentMenu = new Intent( MainActivity.this,MenuActivity.class);
                    Log.i(TAG, "onClick: Ingresando los putExtras");
                    intentMenu.putExtra("Login_to_Menu_Nombre",objUsuario.getNombre());
                    intentMenu.putExtra("Login_to_Menu_Carrera",objUsuario.getCarrera());
                    intentMenu.putExtra("Login_to_Menu_DNI",objUsuario.getDni());
                    intentMenu.putExtra("Login_to_Menu_Edad",objUsuario.getEdad());
                    startActivity(intentMenu);
                }
                else if(strUser.equals("") && strPwd.equals("")){
                    Log.i(TAG, "onClick: Entro vacio");
                    lblVacio.setTextColor(getResources().getColor(R.color.indigo));
                    lblVacio.setText("Tienes que colocar algun dato :)");
                    new Handler().postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            Log.i(TAG, "run: Handler started");
                            lblVacio.setText("");
                            Log.i(TAG, "run: End of the Handler");
                        }
                    }, 2000);
                }else
                {
                    Log.i(TAG, "onClick: Logeo Incorrecto");
                    lblVacio.setTextColor(getResources().getColor(R.color.red));
                    lblVacio.setText("Logeo incorrecto :(");
                    new Handler().postDelayed(new Runnable(){
                        @Override
                        public void run() {
                            Log.i(TAG, "run: Handler started");
                            lblVacio.setText("");
                            Log.i(TAG, "run: End of the Handler");
                        }
                    }, 2000);

                }

                Log.i(TAG, "onClick: Terminando el logeo");
            }
        });

    }

    private void formateandoTexto()
    {
        //Putting texts on elements
        Log.i(TAG, "formateandoTexto: Iniciando llenado de data");
        lblUser.setText(R.string.user);
        lblPwd.setText(R.string.pwd);

        txtUser.setHint("Ingrese aqui su usuario");
        txtPwd.setHint("Ingrese aqui su contraseña");
        Log.i(TAG, "formateandoTexto: Terminando llenada de data");
    }


}
