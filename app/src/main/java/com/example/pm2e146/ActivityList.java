package com.example.pm2e146;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.pm2e146.configuracion.SQLiteConexion;
import com.example.pm2e146.transacciones.Contactos;
import com.example.pm2e146.transacciones.Transacciones;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity {

    //Variables Globales
    SQLiteConexion conexion;
    ListView listView;
    ArrayList<Contactos> listacontactos;
    ArrayList<String> Arreglocontactos;

    Button btnCompartir;
    Button btnEliminar;
    Button btnVer;
    Button btnActualizar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        btnCompartir = (Button) findViewById(R.id.btnCompartir);

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int contacto = listView.getCheckedItemPosition();
                String nombre = listacontactos.get(contacto).getNombre();
                CompartirContactos(nombre);
            }
        });

        conexion = new SQLiteConexion(this, Transacciones.NameDatabase, null, 1);
        listView = (ListView) findViewById(R.id.listView);

        ObtenerListaContactos();

        ArrayAdapter adp = new ArrayAdapter(this, android.R.layout.simple_list_item_1, Arreglocontactos);
        listView.setAdapter(adp);
    }

     private void CompartirContactos(String contactos){

         Intent intent = new Intent(Intent.ACTION_SEND);
         intent.setType("text/plain");
         intent.putExtra(Intent.EXTRA_TEXT,  contactos);
         startActivity(Intent.createChooser(intent, "Compartir contacto"));
     }


    private void ObtenerListaContactos()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Contactos contact = null;
        listacontactos = new ArrayList<Contactos>();

        //Cursor
        Cursor cursor = db.rawQuery("SELECT * FROM contactos", null);

        while (cursor.moveToNext())
        {
            contact = new Contactos();
            contact.setId(cursor.getInt(0));
            contact.setNombre(cursor.getString(1));
            contact.setPais(cursor.getString(2));
            contact.setTelefono(cursor.getString(3));
            contact.setNota(cursor.getString(4));

            listacontactos.add(contact);
        }
        cursor.close();
        FillList();
    }

    private void FillList(){
        Arreglocontactos = new ArrayList<String>();
        for(int i =0; i<listacontactos.size(); i++)
        {
            Arreglocontactos.add(listacontactos.get(i).getId()+ " | "+
                    listacontactos.get(i).getNombre()+ " | "+
                    listacontactos.get(i).getPais()+ " | "+
                    listacontactos.get(i).getTelefono()+ " | "+
                    listacontactos.get(i).getNota()+ " | ");
        }
    }
}