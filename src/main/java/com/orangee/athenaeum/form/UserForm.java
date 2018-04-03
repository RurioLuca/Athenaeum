package com.orangee.athenaeum.form;

/**
 * Created by Luca on 30/03/2018.
 */
public class UserForm {

    private long user_id;
    private String name;
    private String surname;
    private String registrationNumber;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public long getUser_id() { return user_id;  }

    public void setUser_id(long user_id) { this.user_id = user_id;}
}
