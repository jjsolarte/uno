package co.jjsolarte.uno;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.jjsolarte.uno.models.Artista;
import io.realm.Realm;
import io.realm.RealmResults;

public class RegistroActivity extends AppCompatActivity {

    EditText edtNombre, edtCorreo, edtApellido, edtContraseña;
    Button btnRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        showToolbar("Shasena",true);

        inicializer();

    }

    public void onRegistrar(View view){

    }

    private void inicializer() {
        edtNombre = findViewById(R.id.regEdtNombre);
        edtApellido = findViewById(R.id.regEdtApellido);
        edtCorreo = findViewById(R.id.regEdtCorreo);
        edtContraseña = findViewById(R.id.regEdtConstraseña);
        btnRegistro = findViewById(R.id.regBtnRegistrar);

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNombre.getText().toString().trim()!=""
                        && edtContraseña.getText().toString().trim()!=""){
                    Artista artista = new Artista();
                    artista.setNombre(edtNombre.getText().toString());
                    artista.setApellido(edtApellido.getText().toString());
                    artista.setCorreo(edtCorreo.getText().toString());
                    artista.setIdentificacion(Integer.parseInt(edtContraseña.getText().toString()));

                    //Espacio Reservado para el Shared Preferences
                    SharedPreferences prefs =
                            getSharedPreferences("MisPreferencias",RegistroActivity.MODE_PRIVATE);

                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("nombre", ""+edtNombre.getText().toString());
                    editor.putString("contraseña", ""+edtContraseña.getText().toString());
                    editor.putBoolean("sesion",true);
                    editor.commit();

                    Realm realm = Realm.getDefaultInstance();

                    /*
                    realm.beginTransaction();
                    Artista artista1 = realm.createObject(Artista.class);
                    artista1.setNombre(edtNombre.getText().toString());
                    artista1.setIdentificacion(Integer.parseInt(edtContraseña.getText().toString()));
                    realm.commitTransaction();
                    */

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Artista artista1 = realm.createObject(Artista.class);
                            artista1.setNombre(edtNombre.getText().toString());
                            artista1.setIdentificacion(Integer.parseInt(edtContraseña.getText().toString()));
                        }
                    });

                    RealmResults<Artista> results = realm.where(Artista.class).findAll();
                    for (Artista artista2 : results){
                        Toast.makeText(RegistroActivity.this,
                                ""+artista2.getNombre(),
                                Toast.LENGTH_SHORT).show();
                    }

                    Intent intent = new Intent(
                            RegistroActivity.this,ListaActivity.class);
                    intent.putExtra("nombre",edtNombre.getText().toString());
                    startActivity(intent);

                    /*Toast.makeText(RegistroActivity.this,
                            "Bienvenido "+edtNombre.getText().toString(),
                            Toast.LENGTH_SHORT).show();*/

                }else {
                    Toast.makeText(RegistroActivity.this,
                            "Por favor llenar los campos solicitados",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void showToolbar(String title,boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }


}
