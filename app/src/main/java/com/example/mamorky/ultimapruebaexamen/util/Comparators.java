package com.example.mamorky.ultimapruebaexamen.util;

import com.example.mamorky.ultimapruebaexamen.data.pojo.Articulo;

import java.util.Comparator;

/**
 * Created by mamorky on 13/12/17.
 */

public class Comparators {
    public static class CompareById implements Comparator<Articulo>{
        @Override
        public int compare(Articulo o1, Articulo o2) {
            if(o1.getId() > o2.getId())
                return 1;
            else if(o1.getId() < o2.getId())
                return -1;
            else
                return 0;
        }
    }
    public static class CompareByCoste implements Comparator<Articulo>{
        @Override
        public int compare(Articulo o1, Articulo o2) {
            if(o1.getCoste() > o2.getCoste())
                return 1;
            else if(o1.getCoste() < o2.getCoste())
                return -1;
            else
                return 0;
        }
    }
}
