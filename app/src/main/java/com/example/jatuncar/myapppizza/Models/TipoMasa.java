package com.example.jatuncar.myapppizza.Models;

public class TipoMasa {
    private Integer id;
    private String descripcionTipoMasa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcionTipoMasa() {
        return descripcionTipoMasa;
    }

    public void setDescripcionTipoMasa(String descripcionTipoMasa) {
        this.descripcionTipoMasa = descripcionTipoMasa;
    }

    public TipoMasa(Integer id, String descripcionTipoMasa) {
        this.id = id;
        this.descripcionTipoMasa = descripcionTipoMasa;
    }

    @Override
    public String toString() {
        return "TipoMasa{" +
                "id='" + id + '\'' +
                ", descripcionTipoMasa='" + descripcionTipoMasa + '\'' +
                '}';
    }
}
