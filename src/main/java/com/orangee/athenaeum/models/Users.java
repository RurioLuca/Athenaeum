package com.orangee.athenaeum.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Luca on 23/03/2018.
 */
@Entity
@Table(name = "utente")
public class Users implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long utente_id;
    @Column
    private String nome;
    @Column
    private String cognome;
    @Column
    private String matricola;


    public long getUtente_id() {
        return utente_id;
    }

    public void setUtente_id(long utente_id) {
        this.utente_id = utente_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }
}
