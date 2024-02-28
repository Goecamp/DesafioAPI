package sv.edu.udb.model;

import java.math.BigDecimal;

public class disco {
    private int id_disco;
    private String nombre_disco;
    private int id_artista;
    private int numero_canciones;
    private BigDecimal precio;

    // Constructor, getters y setters

    // Constructor por defecto
    public disco() {
    }

    // Constructor con todos los atributos
    public disco(int id_disco, String nombre_disco, int id_artista, int numero_canciones, BigDecimal precio) {
        this.id_disco = id_disco;
        this.nombre_disco = nombre_disco;
        this.id_artista = id_artista;
        this.numero_canciones = numero_canciones;
        this.precio = precio;
    }

    // Getters y setters

    public int getId_disco() {
        return id_disco;
    }

    public void setId_disco(int id_disco) {
        this.id_disco = id_disco;
    }

    public String getNombre_disco() {
        return nombre_disco;
    }

    public void setNombre_disco(String nombre_disco) {
        this.nombre_disco = nombre_disco;
    }

    public int getId_artista() {
        return id_artista;
    }

    public void setId_artista(int id_artista) {
        this.id_artista = id_artista;
    }

    public int getNumero_canciones() {
        return numero_canciones;
    }

    public void setNumero_canciones(int numero_canciones) {
        this.numero_canciones = numero_canciones;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}


