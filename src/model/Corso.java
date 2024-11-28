package model;

import java.time.LocalDate;

public class Corso {

    private String nomeCorso;
    private LocalDate dataInizio;
    private int durata;
    private int idDocente;
    private int id;

    public Corso(String nomeCorso, LocalDate dataInizio, int durata, int idDocente){
        this.nomeCorso = nomeCorso;
        this.dataInizio = dataInizio;
        this.durata = durata;
        this.idDocente = idDocente;
    }

    public Corso(String nomeCorso, LocalDate dataInizio, int durata, int idDocente, int id){
        this.nomeCorso = nomeCorso;
        this.dataInizio = dataInizio;
        this.durata = durata;
        this.idDocente = idDocente;
        this.id = id;
    }

    public String getNomeCorso(){
        return this.nomeCorso;
    }

    public LocalDate getDataInizio(){
        return this.dataInizio;
    }

    public int getDurata(){
        return this.durata;
    }

    public int getIdDocente(){
        return this.idDocente;
    }

    public int getId(){
        return this.id;
    }

    public void setNomeCorso(String nomeCorso){
        this.nomeCorso = nomeCorso;
    }

    public void setDataInizio(LocalDate dataInizio){
        this.dataInizio = dataInizio;
    }

    public void setDurata(int durata){
        this.durata = durata;
    }

    public void setIdDocente(int idDocente){
        this.idDocente = idDocente;
    }

    public void setId(int id){
        this.id = id;
    }
}
