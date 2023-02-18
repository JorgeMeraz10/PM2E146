package com.example.pm2e146.transacciones;

public class Transacciones {

    //Nombre de la base de datos

    public static final String NameDatabase = "PM01DB";

    //Tablas de la base de datos
    public  static final String tablacontactos = "contactos";

    /* Transacciones de la base de datos PM01DB; */

    public static final String CreateTBContactos =
            "CREATE TABLE contactos (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT,"+
                    "pais TEXT , telefono TEXT, nota TEXT, imagen TEXT)";

    public static final String DropTableContactos = "DROP TABLE IF EXISTS contactos";

    //Helpers
    public static final String Empty = "";


}
