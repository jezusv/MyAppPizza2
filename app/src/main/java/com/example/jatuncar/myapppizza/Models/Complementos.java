package com.example.jatuncar.myapppizza.Models;

public class Complementos {
    private Integer id_complemento;
    private String descripcion;
    private double  precio;

    public Complementos(Integer id_complemento, String descripcion, double precio) {
        this.id_complemento = id_complemento;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Complementos{" + "id_complemento=" + id_complemento + ", descripcion='" + descripcion + '\'' + ", precio=" + precio + '}';
    }

    public Integer getId_complemento() {
        return id_complemento;
    }

    public void setId_complemento(Integer id_complemento) {
        this.id_complemento = id_complemento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
