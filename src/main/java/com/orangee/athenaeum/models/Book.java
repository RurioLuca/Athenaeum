package com.orangee.athenaeum.models;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


/**
 * Created by Luca on 21/03/2018.
 */
@Entity
@Table(name = "libro")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long libro_id;

    @Column
    private String autore;

    @Column
    private String nome;

    @Column
    private int anno;

    @Column
    private Date data_pubblicazione;

    public long getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(long libro_id) {
        this.libro_id = libro_id;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public Date getData_pubblicazione() {
        return data_pubblicazione;
    }

    public void setData_pubblicazione(Date data_pubblicazione) {
        this.data_pubblicazione = data_pubblicazione;
    }
}
