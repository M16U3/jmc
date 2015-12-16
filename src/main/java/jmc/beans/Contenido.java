/*
 * 
 * 
 * 
 */
package jmc.beans;

/**
 *
 * @author miguel
 */
import java.io.Serializable;

public class Contenido implements Serializable {
        
    private String titulo;
    private String contenido;
    private String autor;
    private String fecha;
    private Enlace enlace;

    public Contenido() {
    }

    public String getAutor() {
        return autor;
    }

    public String getContenido() {
        return contenido;
    }

    public Enlace getEnlace() {
        return enlace;
    }

    public String getFecha() {
        return fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setEnlace(Enlace enlace) {
        this.enlace = enlace;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
}
