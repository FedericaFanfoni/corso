package repository;

import config.DbConnection;

import model.Corso;
import model.Docente;

import java.sql.*;
import java.util.ArrayList;

public class DocenteRepository {

    public void createDocente(Docente docente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO DocenteTest VALUES('" + docente.getNome() + "','" + docente.getCognome() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Docente> readDocente () {
            ArrayList<Docente> listaDocenti = new ArrayList<>();
            try {
                Connection c = DbConnection.openConnection();
                Statement stmt = c.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM DocenteTest ORDER BY id asc");
                CorsoRepository corsoRepository = new CorsoRepository();
                while (rs.next()) {
                    Docente docente = new Docente();
                    docente.setNome(rs.getString("nome"));
                    docente.setCognome(rs.getString("cognome"));
                    ArrayList<Corso> listaCorsi = corsoRepository.readCorsiOfDocenti(rs.getInt("id"));
                    docente.setid(rs.getInt("id"));
                    listaDocenti.add(docente);
                }
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println(e.getMessage());
                System.exit(0);
            }

            return listaDocenti;
    }

    public Docente getDocenteByID(int idDocente){
        Docente docente = new Docente();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM DocenteTest WHERE id =" + idDocente);

            if(rs.next()){
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));
                docente.setid(rs.getInt("id"));
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return docente;
    }

    public void deleteDocente(Docente docente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM DocenteTest WHERE id = '" + docente.getid() + "'");
            System.out.println("model.dao.Docente eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateDocente(Docente docente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE DocenteTest SET nome='"+docente.getNome()+"', cognome='"+docente.getCognome()+"' WHERE id ="  + docente.getid());
            System.out.println("model.dao.Docente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }








}




