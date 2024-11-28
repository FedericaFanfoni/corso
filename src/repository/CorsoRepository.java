package repository;

import config.DbConnection;
import model.Corso;
import model.Docente;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class CorsoRepository {

    public void createCorso(Corso corso) {

        // Creazione di un nuovo corso;
        try {
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO corsi VALUES('" + corso.getNomeCorso() + "','" + corso.getDataInizio() + "', '" + corso.getDurata() + "','" + corso.getIdDocente() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public ArrayList<Corso> readCorsi(){

        // Lettura di tutti i corsi presenti nella tabella;
        ArrayList<Corso> listaCorsi = new ArrayList<>();
        try{
            Connection c = DbConnection.openConnection();
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM corsi");

            // Per ogni corso trovato crea un oggetto corso da mattere nell'arraylist
            while (rs.next()) {
                Corso corso = new Corso(
                        rs.getString("nome_corso"),
                        rs.getDate("data_inizio").toLocalDate(),
                        rs.getInt("durata"),
                        rs.getInt("id_docente"),
                        rs.getInt("id")
                );
                listaCorsi.add(corso);
            }
        } catch(ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaCorsi;
    }

}
