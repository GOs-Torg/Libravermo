package com.sitebooks.librovermo.models.plugs;

import jakarta.persistence.*;

public class Purchasedgoods {
    private long id_Purchasedgoods;
    private long Purchasedgoods_Product;
    private long Purchasedgoods_Client;

    public  Purchasedgoods(){}
    public Purchasedgoods(long id_Purchasedgoods, long purchasedgoods_Product, long purchasedgoods_Client) {
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

    public long getPurchasedgoods_Product() {
        return Purchasedgoods_Product;
    }

    public void setPurchasedgoods_Product(long purchasedgoods_Product) {
        Purchasedgoods_Product = purchasedgoods_Product;
    }

    public long getPurchasedgoods_Client() {
        return Purchasedgoods_Client;
    }

    public void setPurchasedgoods_Client(long purchasedgoods_Client) {
        Purchasedgoods_Client = purchasedgoods_Client;
    }
}
