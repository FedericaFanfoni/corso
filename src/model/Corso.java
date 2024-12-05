package model;

import java.time.LocalDate;
import java.util.ArrayList;

import model.Docente;

public class Corso {

    private String nomeCorso;
    private LocalDate dataInizio;
    private int durata;
    private Docente docente;
    private ArrayList<Discente> listaDiscenti;
    private int id;

    public Corso(String nomeCorso, LocalDate dataInizio, int durata, Docente docente){
        this.nomeCorso = nomeCorso;
        this.dataInizio = dataInizio;
        this.durata = durata;
        this.docente = docente;
    }

    public Corso(String nomeCorso, LocalDate dataInizio, int durata, Docente docente, int id){
        this.nomeCorso = nomeCorso;
        this.dataInizio = dataInizio;
        this.durata = durata;
        this.docente = docente;
        this.id = id;
    }

    public Corso(String nomeCorso, LocalDate dataInizio, int durata, Docente docente, ArrayList<Discente> listaDiscenti, int id){
        this.nomeCorso = nomeCorso;
        this.dataInizio = dataInizio;
        this.durata = durata;
        this.docente = docente;
        this.listaDiscenti = listaDiscenti;
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

    public Docente getDocente(){
        return  this.docente;
    }

    public ArrayList<Discente> getListaDiscenti(){
        return this.listaDiscenti;
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

    public void setDocente(int idDocente) {
        this.docente = docente;
    }

    public void setListaDiscenti(ArrayList<Discente> listaDiscenti){
        this.listaDiscenti = listaDiscenti;
    }

    public void setId(int id){
        this.id = id;
    }
}
