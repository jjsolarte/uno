package co.jjsolarte.uno;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import co.jjsolarte.uno.models.Artista;

public class ListaActivity extends AppCompatActivity {

    List<Artista> artistaList;
    List<String> listaNombreArtistas;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        inicializer();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, listaNombreArtistas);

        listView.setAdapter(adapter);

    }

    private void inicializer() {
        artistaList = new ArrayList<>();
        listaNombreArtistas = new ArrayList<>();
        listView = findViewById(R.id.regList);
        llenarLista();
    }

    private void llenarLista() {
        artistaList.add(new Artista(1061651,"Michael"
                ,"Jackson","mj@gmail.com",312111));
        artistaList.add(new Artista(3215564,"Grupo"
                ,"Niche","gniche@gmail.com",34564));
        artistaList.add(new Artista(3584635,"Mana"
                ,"Mexico","manamana@gmail.com",3654646));

        for (int i = 0 ; i<artistaList.size(); i++){
            listaNombreArtistas.add(artistaList.get(i).getNombre());
        }
    }
}
