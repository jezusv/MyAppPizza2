package com.example.jatuncar.myapppizza.Repositories;

import com.example.jatuncar.myapppizza.Models.Complementos;

import java.util.ArrayList;
import java.util.List;

public class ComplementosCompra {
    public  List<Complementos> complementos = new ArrayList<>();

    public ComplementosCompra() {
    }

    public void ComplementosAdd(Integer Id_Complemento)
    {
        complementos.add(ComplementosRepository.DevuelveComplementos(Id_Complemento));
    }
    public double obtener_precio_total_complemento()
    {
        double precio_total = 0.0;
        for(Complementos comple : complementos)
        {
            precio_total = precio_total + comple.getPrecio();
        }
        return precio_total;
    }
}
