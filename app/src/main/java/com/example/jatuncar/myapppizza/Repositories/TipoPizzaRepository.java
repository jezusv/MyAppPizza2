package com.example.jatuncar.myapppizza.Repositories;

import com.example.jatuncar.myapppizza.Models.TipoPizza;

import java.util.ArrayList;
import java.util.List;

public class TipoPizzaRepository {
    public static List<TipoPizza> tipoPizzas = new ArrayList<>();
    static {
        tipoPizzas.add(new TipoPizza(1,"Americana",38.00));
        tipoPizzas.add(new TipoPizza(2,"Pepperoni",42.00));
        tipoPizzas.add(new TipoPizza(3,"Hawaina",36.00));
        tipoPizzas.add(new TipoPizza(4,"Meat Lover",56.00));
    }

    public static TipoPizza DevuelveTipoPizza(Integer id)
    {
        for (TipoPizza tipo: tipoPizzas)
        {
            if (tipo.getId() == id)
            {
                return tipo;
            }
        }
        return  null;
    }

}
