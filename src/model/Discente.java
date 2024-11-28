package model;

import java.time.LocalDate;

public class Discente {

    private String nome;
    private String cognome;
    private LocalDate dataNascita;
    private String matricola;
    private int id;

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public LocalDate getDataNascita(){
        return this.dataNascita;
    }

    public String getMatricola(){
        return this.matricola;
    }

    public int getid() {
        return id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public void setMatricola(String matricola){
        this.matricola = matricola;
    }

    public void setid(int id) {
        this.id = id;
    }
}
