package com.example.jatuncar.myapppizza.Models;

import com.example.jatuncar.myapppizza.Repositories.ComplementosCompra;

import java.util.Calendar;

public class Compra {
    private Integer id;
    private TipoPizza tipoPizza;
    private ComplementosCompra complementos;
    private TipoMasa tipo_masa;

    public TipoMasa getTipo_masa() {
        return tipo_masa;
    }

    public void setTipo_masa(TipoMasa tipo_masa) {
        this.tipo_masa = tipo_masa;
    }

    public ComplementosCompra getComplementos() {
        return complementos;
    }

    public void setComplementos(ComplementosCompra complementos) {
        this.complementos = complementos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoPizza getTipoPizza() {
        return tipoPizza;
    }

    public void setTipoPizza(TipoPizza tipoPizza) {
        this.tipoPizza = tipoPizza;
    }

    public double CalculaPrecio(){
        double precio_final = 0.0;
        double precio_complemento = complementos.obtener_precio_total_complemento();

        precio_final = tipoPizza.getPrecio() + precio_complemento;
        if (Calendar.DAY_OF_WEEK == 2) {
            precio_final = tipoPizza.getPrecio() + precio_complemento - (tipoPizza.getPrecio() + precio_complemento)*0.3;
        }
        return precio_final;
    }
    public String MsgdeConfirmacionCompra(){
        String strMsg = "Su pedido de "+ tipoPizza.getTipopizza()+" con "+ this.tipo_masa.getDescripcionTipoMasa() +" a S/."+ String.valueOf(this.CalculaPrecio())+" + IGV está en proceso de envío";
        return  strMsg;
    }

    public Compra(Integer id, TipoPizza tipoPizza, ComplementosCompra complementos, TipoMasa tipo_masa) {
        this.id = id;
        this.tipoPizza = tipoPizza;
        this.complementos = complementos;
        this.tipo_masa = tipo_masa;
    }
}
