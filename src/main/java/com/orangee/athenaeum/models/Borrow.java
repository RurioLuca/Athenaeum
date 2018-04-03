package com.orangee.athenaeum.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Luca on 23/03/2018.
 */
@Entity
@Table(name = "prestito")
public class Borrow implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long prestito_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "libro_id")
    private Book book;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_id")
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utente_id")
    private Users user;

    @Column
    private Date data_prestito;

    @Column
    private int durata_prestito;

    @Column
    private String stato_prestito;

    public long getPrestito_id() {
        return prestito_id;
    }

    public void setPrestito_id(long prestito_id) {
        this.prestito_id = prestito_id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Date getData_prestito() {
        return data_prestito;
    }

    public void setData_prestito(Date data_prestito) {
        this.data_prestito = data_prestito;
    }

    public int getDurata_prestito() {
        return durata_prestito;
    }

    public void setDurata_prestito(int durata_prestito) {
        this.durata_prestito = durata_prestito;
    }

    public String getStato_prestito() {
        return stato_prestito;
    }

    public void setStato_prestito(String stato_prestito) {
        this.stato_prestito = stato_prestito;
    }



}
