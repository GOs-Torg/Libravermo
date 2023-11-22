package com.sitebooks.librovermo.models.primary;

import jakarta.persistence.*;

@Entity
@Table(name = "Favourite")
public class Favourite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_Favourite;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Product",nullable = false)
    private Product favourite_Product;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Client",nullable = false)
    private Client favourite_Client;

    public Favourite(){}
    public Favourite(long id_Favourite, Product favourite_Product, Client favourite_Client) {
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

    public Product getFavourite_Product() {
        return favourite_Product;
    }

    public void setFavourite_Product(Product favourite_Product) {
        this.favourite_Product = favourite_Product;
    }

    public Client getFavourite_Client() {
        return favourite_Client;
    }

    public void setFavourite_Client(Client favourite_Client) {
        this.favourite_Client = favourite_Client;
    }
}
