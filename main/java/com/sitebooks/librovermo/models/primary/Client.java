package com.sitebooks.librovermo.models.primary;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "Client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_Client;
    @Column(name = "Client_Surname", nullable = false)
    private String client_Surname;
    @Column(name = "Client_Name", nullable = false)
    private String client_Name;
    @Column(name = "Client_Description", nullable = false)
    private String client_Description;
    @Column(name = "Client_Login", nullable = false, unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]{8,24}$")
    private String client_Login;
    @Column(name = "Client_Password", nullable = false, unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]{6,32}$", message = "Must be at least 6 symbols and contains at least 1 number")
    private String client_Password;
    @Column(name = "Client_Phone_Number", nullable = false, unique = true)
    private String client_Phone_Number;
    @Column(name = "Client_Email", nullable = false, unique = true)
    @Email(message = "Email must be valid")
    private String client_Email;
    @Column(name = "Client_Nickname", nullable = false, unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]{4,24}$")
    private String client_Nickname;

    public Client() {
    }
    public Client(long id_Client, String client_Surname, String client_Name, String client_Description, String client_Login, String client_Password, String client_Phone_Number, String client_Email, String client_Nickname) {
        this.id_Client = id_Client;
        this.client_Surname = client_Surname;
        this.client_Name = client_Name;
        this.client_Description = client_Description;
        this.client_Login = client_Login;
        this.client_Password = client_Password;
        this.client_Phone_Number = client_Phone_Number;
        this.client_Email = client_Email;
        this.client_Nickname = client_Nickname;
    }

    public long getId_Client() {
        return id_Client;
    }

    public void setId_Client(long id_Client) {
        this.id_Client = id_Client;
    }

    public String getClient_Surname() {
        return client_Surname;
    }

    public void setClient_Surname(String client_Surname) {
        this.client_Surname = client_Surname;
    }

    public String getClient_Name() {
        return client_Name;
    }

    public void setClient_Name(String client_Name) {
        this.client_Name = client_Name;
    }

    public String getClient_Description() {
        return client_Description;
    }

    public void setClient_Description(String client_Description) {
        this.client_Description = client_Description;
    }

    public String getClient_Login() {
        return client_Login;
    }

    public void setClient_Login(String client_Login) {
        this.client_Login = client_Login;
    }

    public String getClient_Password() {
        return client_Password;
    }

    public void setClient_Password(String client_Password) {
        this.client_Password = client_Password;
    }

    public String getClient_Phone_Number() {
        return client_Phone_Number;
    }

    public void setClient_Phone_Number(String client_Phone_Number) {
        this.client_Phone_Number = client_Phone_Number;
    }

    public String getClient_Email() {
        return client_Email;
    }

    public void setClient_Email(String client_Email) {
        this.client_Email = client_Email;
    }

    public String getClient_Nickname() {
        return client_Nickname;
    }

    public void setClient_Nickname(String client_Nickname) {
        this.client_Nickname = client_Nickname;
    }
}
