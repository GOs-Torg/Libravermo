package com.sitebooks.librovermo.models.plugs;


public class Favourite {
    private long id_Favourite;
    private long favourite_Product;
    private long favourite_Client;

    public Favourite(){}
    public Favourite(long id_Favourite, long favourite_Product, long favourite_Client) {
        this.id_Favourite = id_Favourite;
        this.favourite_Product = favourite_Product;
        this.favourite_Client = favourite_Client;
    }

    public long getId_Favourite() {
        return id_Favourite;
    }

    public void setId_Favourite(long id_Favourite) {
        this.id_Favourite = id_Favourite;
    }

    public long getFavourite_Product() {
        return favourite_Product;
    }

    public void setFavourite_Product(long favourite_Product) {
        this.favourite_Product = favourite_Product;
    }

    public long getFavourite_Client() {
        return favourite_Client;
    }

    public void setFavourite_Client(long favourite_Client) {
        this.favourite_Client = favourite_Client;
    }
}
