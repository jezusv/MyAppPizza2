package com.example.jatuncar.myapppizza.Models;

public class TipoPizza {
    private Integer id;
    private String tipopizza;
    private double precio;

    public Integer getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipopizza() {
        return tipopizza;
    }

    public void setTipopizza(String tipopizza) {
        this.tipopizza = tipopizza;
    }

    public TipoPizza(Integer id, String tipopizza,double precio) {
        this.id = id;
        this.tipopizza = tipopizza;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return tipopizza;
    }
}
