package com.danielcirilo.contactosfragments;

import java.io.Serializable;

public class Contacto implements Serializable {
    private int id;
    private String name;
    private String surname1;
    private String surname2;
    private String fecha;
    private String company;
    private String email;
    private String phone1;
    private String phone2;
    private String address;


    public Contacto(int id, String name, String surname1, String surname2, String fecha, String company, String email, String phone1, String phone2, String address) {
        this.id = id;
        this.name = name;
        this.surname1 = surname1;
        this.surname2 = surname2;
        this.fecha = fecha;
        this.company = company;
        this.email = email;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;

    }


    public String getName() {
        return name;
    }

    public String getSurname1() {
        return surname1;
    }

    public String getSurname2() {
        return surname2;
    }

    public String getFecha() {
        return fecha;
    }

    public String getCompany() {
        return company;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getAddress() {
        return address;
    }
    public int getId(){
        return id;
    }
}