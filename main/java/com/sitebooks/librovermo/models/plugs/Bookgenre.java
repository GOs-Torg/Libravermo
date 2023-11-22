package com.sitebooks.librovermo.models.plugs;


public class Bookgenre {
    private long id_Bookgenre;
    private long Bookgenre_Product;
    private long Bookgenre_Genre;

    public Bookgenre(){}

    public Bookgenre(long id_Bookgenre, long bookgenre_Product, long bookgenre_Genre) {
        this.id_Bookgenre = id_Bookgenre;
        Bookgenre_Product = bookgenre_Product;
        Bookgenre_Genre = bookgenre_Genre;
    }

    public long getId_Bookgenre() {
        return id_Bookgenre;
    }

    public void setId_Bookgenre(long id_Bookgenre) {
        this.id_Bookgenre = id_Bookgenre;
    }

    public long getBookgenre_Product() {
        return Bookgenre_Product;
    }

    public void setBookgenre_Product(long bookgenre_Product) {
        Bookgenre_Product = bookgenre_Product;
    }

    public long getBookgenre_Genre() {
        return Bookgenre_Genre;
    }

    public void setBookgenre_Genre(long bookgenre_Genre) {
        Bookgenre_Genre = bookgenre_Genre;
    }
}
