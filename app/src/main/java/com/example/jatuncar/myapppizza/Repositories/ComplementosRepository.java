package com.example.jatuncar.myapppizza.Repositories;

import com.example.jatuncar.myapppizza.Models.Complementos;

import java.util.ArrayList;
import java.util.List;

public class ComplementosRepository {
    public static List<Complementos> complementos = new ArrayList<>();
    static {
        complementos.add(new Complementos(1,"Americana",4.00));
        complementos.add(new Complementos(2,"Pepperoni",8.00));
    }
    public static Complementos DevuelveComplementos(Integer id)
    {
        for (Complementos tipo: complementos)
        {
            if (tipo.getId_complemento() == id)
            {
                return tipo;
            }
        }
        return  null;
    }
}
