package co.jjsolarte.uno.models;

import io.realm.RealmObject;

public class Artista extends RealmObject {

    private int identificacion;
    private String nombre;
    private String apellido;
    private String correo;
    private int telefono;

    public Artista() {
    }

    public Artista(int identificacion, String nombre, String apellido, String correo, int telefono) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
