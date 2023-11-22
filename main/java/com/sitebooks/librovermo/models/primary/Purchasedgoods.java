package com.sitebooks.librovermo.models.primary;

import jakarta.persistence.*;

@Entity
@Table(name = "Purchasedgoods")
public class Purchasedgoods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_Purchasedgoods;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Product",nullable = false)
    private Product Purchasedgoods_Product;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "ID_Client",nullable = false)
    private Client Purchasedgoods_Client;

    public  Purchasedgoods(){}
    public Purchasedgoods(long id_Purchasedgoods, Product purchasedgoods_Product, Client purchasedgoods_Client) {
        this.id_Purchasedgoods = id_Purchasedgoods;
        Purchasedgoods_Product = purchasedgoods_Product;
        Purchasedgoods_Client = purchasedgoods_Client;
    }

    public long getId_Purchasedgoods() {
        return id_Purchasedgoods;
    }

    public void setId_Purchasedgoods(long id_Purchasedgoods) {
        this.id_Purchasedgoods = id_Purchasedgoods;
    }

    public Product getPurchasedgoods_Product() {
        return Purchasedgoods_Product;
    }

    public void setPurchasedgoods_Product(Product purchasedgoods_Product) {
        Purchasedgoods_Product = purchasedgoods_Product;
    }

    public Client getPurchasedgoods_Client() {
        return Purchasedgoods_Client;
    }

    public void setPurchasedgoods_Client(Client purchasedgoods_Client) {
        Purchasedgoods_Client = purchasedgoods_Client;
    }
}
