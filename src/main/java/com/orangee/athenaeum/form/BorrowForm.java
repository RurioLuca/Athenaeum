package com.orangee.athenaeum.form;

/**
 * Created by Luca on 03/04/2018.
 */
public class BorrowForm {

    private String nomeUtente;
    private String nomeCliente;
    private String nomeLibro;
    private int durataPrestito;
    private String stato_presito;//data scadenza < data di oggi = "EXIRED" altrimenti stato corrente.
    private String data_prestito;
    private String data_scadenza;// data_prestito + durata_presito.


    public String getNomeUtente() {
        return nomeUtente;
    }

    public void setNomeUtente(String nomeUtente) {
        this.nomeUtente = nomeUtente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeLibro() {
        return nomeLibro;
    }

    public void setNomeLibro(String nomeLibro) {
        this.nomeLibro = nomeLibro;
    }

    public int getDurataPrestito() {
        return durataPrestito;
    }

    public void setDurataPrestito(int durataPrestito) {
        this.durataPrestito = durataPrestito;
    }

    public String getStato_presito() {
        return stato_presito;
    }

    public void setStato_presito(String stato_presito) {
        this.stato_presito = stato_presito;
    }

    public String getData_prestito() {
        return data_prestito;
    }

    public void setData_prestito(String data_prestito) {
        this.data_prestito = data_prestito;
    }

    public String getData_scadenza() {
        return data_scadenza;
    }

    public void setData_scadenza(String data_scadenza) {
        this.data_scadenza = data_scadenza;
    }

}
