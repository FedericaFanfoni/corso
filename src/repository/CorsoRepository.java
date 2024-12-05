package repository;

import config.DbConnection;
import model.Corso;
import model.Discente;
import model.Docente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CorsoRepository {

    public void createCorso(Corso corso) {

        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO corsi VALUES('" + corso.getNomeCorso() + "','" + corso.getDataInizio() + "', '" + corso.getDurata() + "','" + corso.getDocente().getid() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Corso> readCorsi(){

        ArrayList<Corso> listaCorsi = new ArrayList<>();

        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM corsi JOIN DocenteTest dt ON dt.id = corsi.id_docente");
            DiscenteRepository discenteRepository = new DiscenteRepository();
            while (rs.next()) {

                Docente docente = new Docente();
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));
                docente.setid(rs.getInt("id_docente"));

                ArrayList<Discente> listaDiscenti;
                System.out.println("Creazione dell'oggetto corso...");
                Corso corso = new Corso(
                        rs.getString("nome_corso"),
                        rs.getDate("data_inizio").toLocalDate(),
                        rs.getInt("durata"),
                        docente,
                        listaDiscenti = discenteRepository.readDiscentiOfCorso(rs.getInt("id")),
                        rs.getInt("id")
                );

                //System.out.println(listaDiscenti.size());
                listaCorsi.add(corso);
            }
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaCorsi;
    }

    public ArrayList<Corso> readCorsiOfDiscente(int idDiscente){

        ArrayList<Corso> listaCorsi = new ArrayList<>();

        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(
                       "SELECT c.nome_corso, c.data_inizio, c.durata, c.id_docente, c.id, dt.nome, dt.cognome FROM corsi c\n" +
                            "JOIN corsiDiscenti cd ON cd.id_corso = c.id\n" +
                            "JOIN DocenteTest dt ON dt.id = c.id_docente\n" +
                            "JOIN discenti d ON d.id = cd.id_discente\n" +
                            "WHERE d.id =" + idDiscente
            );
            DiscenteRepository discenteRepository = new DiscenteRepository();
            while (rs.next()) {

                Docente docente = new Docente();
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));
                docente.setid(rs.getInt("id_docente"));

                ArrayList<Discente> listaDiscenti;

                Corso corso = new Corso(
                        rs.getString("nome_corso"),
                        rs.getDate("data_inizio").toLocalDate(),
                        rs.getInt("durata"),
                        docente,
                        listaDiscenti = discenteRepository.readDiscentiOfCorso(rs.getInt("id")),
                        rs.getInt("id")
                );

                //System.out.println(listaDiscenti.size());
                listaCorsi.add(corso);
            }
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaCorsi;
    }

    public ArrayList<Corso> readCorsiOfDocenti(int idDocente){
        ArrayList<Corso> listaCorsi = new ArrayList<>();
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM corsi JOIN DocenteTest dt ON dt.id = corsi.id_docente WHERE corsi.id_docente=" + idDocente
            );
            DiscenteRepository discenteRepository = new DiscenteRepository();
            while (rs.next()) {

                Docente docente = new Docente();
                docente.setNome(rs.getString("nome"));
                docente.setCognome(rs.getString("cognome"));
                docente.setid(rs.getInt("id_docente"));

                ArrayList<Discente> listaDiscenti;

                Corso corso = new Corso(
                        rs.getString("nome_corso"),
                        rs.getDate("data_inizio").toLocalDate(),
                        rs.getInt("durata"),
                        docente,
                        listaDiscenti = discenteRepository.readDiscentiOfCorso(rs.getInt("id")),
                        rs.getInt("id")
                );
                //System.out.println(listaDiscenti.size());
                listaCorsi.add(corso);
            }
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaCorsi;
    }

    public void updateCorso(Corso corso){
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE corsi SET nome_corso='"+corso.getNomeCorso()+"', data_inizio='"+corso.getDataInizio()+"', durata= '"+corso.getDurata()+"', id_docente= '"+corso.getDocente().getid()+"' WHERE id ="  + corso.getId());
            System.out.println("model.dao.Corso aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void deleteCorso(int idCorso){
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM corsi WHERE id = '" + idCorso + "'");
            System.out.println("model.dao.Corso eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

}
