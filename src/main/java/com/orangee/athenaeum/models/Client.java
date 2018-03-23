package com.orangee.athenaeum.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Luca on 23/03/2018.
 */
@Entity
@Table(name="cliente")
public class Client implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long cliente_id;

    @Column
    private String nome;

    @Column
    private String cognome;

    @Column
    private String telefono;

    @Column
    private Date data_registrazione;

    @Column
    private Date data_scadenza;

    @Column
    private String numero_tessera;


    public long getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(long cliente_id) {
        this.cliente_id = cliente_id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getData_registrazione() {
        return data_registrazione;
    }

    public void setData_registrazione(Date data_registrazione) {
        this.data_registrazione = data_registrazione;
    }

    public Date getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(Date data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

    public String getNumero_tessera() {
        return numero_tessera;
    }

    public void setNumero_tessera(String numero_tessera) {
        this.numero_tessera = numero_tessera;
    }

}
