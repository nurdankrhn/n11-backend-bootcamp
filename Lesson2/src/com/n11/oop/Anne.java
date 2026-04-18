package com.n11.oop;


import com.n11.oop.interfaces.IDinle;
import com.n11.oop.interfaces.IOku;
import com.n11.oop.interfaces.IYaz;

public class Anne extends Insan implements IOku, IYaz, IDinle {

    @Override
    public void oku(String adi) {
        System.out.print(adi + " okuyor");
    }

    @Override
    public void yaz(String adi) {
        System.out.println(adi + " yazıyor");
    }


    @Override
    public void dinle(String adi) {
        System.out.print(adi + " dinliyor");
    }
}
