package com.sitebooks.librovermo.models.plugs;

import jakarta.persistence.*;


public class Review {
    private long id_Review;
    private String review_Title;
    private String review_Text;
    private String review_Rate;
    private String review_Status;
    private String review_Data;
    private long review_Client;
    private long review_Employee;
    private long review_Product;

    public Review(){}
    public Review(long id_Review, String review_Title, String review_Text, String review_Rate, String review_Status, String review_Data, long review_Client, long review_Employee, long review_Product) {
        this.id_Review = id_Review;
        this.review_Title = review_Title;
        this.review_Text = review_Text;
        this.review_Rate = review_Rate;
        this.review_Status = review_Status;
        this.review_Data = review_Data;
        this.review_Client = review_Client;
        this.review_Employee = review_Employee;
        this.review_Product = review_Product;
    }

    public long getId_Review() {
        return id_Review;
    }

    public void setId_Review(long id_Review) {
        this.id_Review = id_Review;
    }

    public String getReview_Title() {
        return review_Title;
    }

    public void setReview_Title(String review_Title) {
        this.review_Title = review_Title;
    }

    public String getReview_Text() {
        return review_Text;
    }

    public void setReview_Text(String review_Text) {
        this.review_Text = review_Text;
    }

    public String getReview_Rate() {
        return review_Rate;
    }

    public void setReview_Rate(String review_Rate) {
        this.review_Rate = review_Rate;
    }

    public String getReview_Status() {
        return review_Status;
    }

    public void setReview_Status(String review_Status) {
        this.review_Status = review_Status;
    }

    public String getReview_Data() {
        return review_Data;
    }

    public void setReview_Data(String review_Data) {
        this.review_Data = review_Data;
    }

    public long getReview_Client() {
        return review_Client;
    }

    public void setReview_Client(long review_Client) {
        this.review_Client = review_Client;
    }

    public long getReview_Employee() {
        return review_Employee;
    }

    public void setReview_Employee(long review_Employee) {
        this.review_Employee = review_Employee;
    }

    public long getReview_Product() {
        return review_Product;
    }

    public void setReview_Product(long review_Product) {
        this.review_Product = review_Product;
    }
}
