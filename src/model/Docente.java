package model;

import java.util.ArrayList;

public class Docente {

    private String nome;
    private String cognome;
    private ArrayList<Corso> corsi;
    private int id;


    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getNome() {

        return nome;
    }

    public void setCognome(String cognome) {

        this.cognome = cognome;
    }

    public String getCognome() {

        return cognome;
    }

    public void setCorsi(ArrayList<Corso> corsi){
        this.corsi = corsi;
    }

    public ArrayList<Corso> getCorsi(){
        return this.corsi;
    }

    public void setid(int id) {

        this.id = id;
    }

    public int getid() {

        return id;
    }


}
