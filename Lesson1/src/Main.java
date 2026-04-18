import com.n11.oop.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        //ClassIsmi nesneAdi = new ClassIsmi();
        Insan i = new Insan();
        i.ad =  "İbrahim";
        i.soyad = "Gökyar";
        i.yas = 47;
        i.maas = 3.14;
        i.cinsiyet = true;
        i.uyu();

        Anne a = new Anne();
        a.ad = "Fahriye";
        a.soyad = "Gökyar";
        a.ekranaYaz(a.ad, a.soyad);
        a.dinle(a.ad);
        a.oku(a.ad);
        a.yaz(a.ad);

        Baba b = new Baba();
        b.ad = "Kasım";
        b.soyad = "Gökyar";
        b.dinle(b.ad);
        b.ekranaYaz(b.ad, b.soyad);

        Cocuk c = new Cocuk();
        c.ad = "ibrahim";
        c.soyad = "Gökyar";
        c.ekranaYaz(c.ad, c.soyad);

        AkilliCocuk ak = new AkilliCocuk();
        ak.ad = "Hakan";
        ak.soyad = "Yılmaz";
        ak.sifat = "Akıllıdır";
        ak.adSoyadSifatYaz(ak.ad, ak.soyad, ak.sifat);

        UsluCocuk us = new  UsluCocuk();
        us.adSoyadSifatYaz("Mehmet", "Yıldız", "Usludur");

    }
}