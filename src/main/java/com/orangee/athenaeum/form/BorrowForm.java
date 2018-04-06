package com.orangee.athenaeum.form;

/**
 * Created by Luca on 03/04/2018.
 */
public class BorrowForm {

    private long borrow_id;
    private String nomeUtente;
    private String nomeCliente;
    private String nomeLibro;
    private int durataPrestito;
    private String stato_prestito;//data scadenza < data di oggi = "EXPIRED" altrimenti stato corrente.
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

    public String getStato_prestito() {
        return stato_prestito;
    }

    public void setStato_prestito(String stato_prestito) {
        this.stato_prestito = stato_prestito;
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

    public long getBorrow_id() {
        return borrow_id;
    }

    public void setBorrow_id(long borrow_id) {
        this.borrow_id = borrow_id;
    }
}
