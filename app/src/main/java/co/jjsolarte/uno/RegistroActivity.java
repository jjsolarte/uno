package co.jjsolarte.uno;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import co.jjsolarte.uno.models.Artista;

public class RegistroActivity extends AppCompatActivity {

    Button btnRegistrar;
    EditText edtNombre, edtApellido, edtContaseña, edtCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        showToolbar("Shasena",false);

        inicializer();

    }

    public void onRegistro(View view){
        Artista artista = new Artista(36413,edtNombre.getText().toString()
                ,edtApellido.getText().toString(),
                edtCorreo.getText().toString(),
                Integer.parseInt(edtContaseña.getText().toString()));

        Toast.makeText(this, "Bienvenido "+edtNombre.getText().toString(), Toast.LENGTH_SHORT).show();

        Intent i = new Intent(this,ListaActivity.class);
        startActivity(i);
    }

    private void inicializer() {
        btnRegistrar = findViewById(R.id.regBtnRegistrar);
        edtNombre = findViewById(R.id.regEdtNombre);
        edtApellido = findViewById(R.id.regEdtApellido);
        edtCorreo = findViewById(R.id.regEdtCorreo);
        edtContaseña = findViewById(R.id.regEdtConstraseña);
    }

    public void showToolbar(String title,boolean upButton){
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

}
