package com.example.jatuncar.myapppizza.Repositories;

import com.example.jatuncar.myapppizza.Models.TipoMasa;

import java.util.ArrayList;
import java.util.List;

public class TipoMasaRepository {
    private static List<TipoMasa> tipomasa = new ArrayList<>();
    static{
        tipomasa.add(new TipoMasa(1,"Masa Gruesa"));
        tipomasa.add(new TipoMasa(2,"Masa delgada"));
        tipomasa.add(new TipoMasa(2,"Masa artesanal"));
    }
    public static TipoMasa DevuelveTipoMasa(Integer id)
    {
        for (TipoMasa tipo: tipomasa)
        {
            if (tipo.getId() == id)
            {
                return tipo;
            }
        }
        return  null;
    }
}

