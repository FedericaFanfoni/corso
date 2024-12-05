package repository;

import config.DbConnection;
import model.Discente;

import java.sql.*;
import java.util.ArrayList;

public class DiscenteRepository {

    // Creazione del discente;
    public void createDiscente(Discente newDiscente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO discenti VALUES('" + newDiscente.getNome() + "','" + newDiscente.getCognome() + "','"+ newDiscente.getDataNascita() +"','"+ newDiscente.getMatricola() +"')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    // Lettura di tutta la lista dei discenti;
    public ArrayList<Discente> readDiscenti() {
        ArrayList<Discente> listaDiscenti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM discenti ORDER BY id asc");
            CorsoRepository corsoRepository = new CorsoRepository();
            while (rs.next()) {
                Discente discente = new Discente();
                discente.setNome(rs.getString("nome"));
                discente.setCognome(rs.getString("cognome"));
                discente.setMatricola(rs.getString("matricola"));
                discente.setListaCorsi(corsoRepository.readCorsiOfDiscente(rs.getInt("id")));
                discente.setid(rs.getInt("id"));
                listaDiscenti.add(discente);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDiscenti;
    }

    public ArrayList<Discente> readDiscentiOfCorso(int idCorso){
        ArrayList<Discente> listaDiscenti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT d.nome, d.cognome, d.data_nascita, d.matricola, d.id FROM discenti d\n" +
                    "JOIN corsiDiscenti cd ON cd.id_discente = d.id\n" +
                    "JOIN corsi c ON c.id = cd.id_corso\n" +
                    "WHERE c.id= " + idCorso
            );
            while (rs.next()) {
                Discente discente = new Discente();
                discente.setNome(rs.getString("nome"));
                discente.setCognome(rs.getString("cognome"));
                discente.setDataNascita(rs.getDate("data_nascita").toLocalDate());
                discente.setid(rs.getInt("id"));
                listaDiscenti.add(discente);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDiscenti;
    }

    // Cancellazione di un discente;
    public void deleteDiscente(Discente discente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM discenti WHERE id = '" + discente.getid() + "'");
            System.out.println("model.dao.Discente eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    // Modifica di un discente;
    public void updateDiscente(Discente discente) {

        try {
            Connection c = DbConnection.openConnection();
            System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE discenti SET nome='"+discente.getNome()+"', cognome='"+discente.getCognome()+"', data_nascita ='"+discente.getDataNascita()+"', matricola ='"+discente.getMatricola()+"' WHERE id ="  + discente.getid());
            System.out.println("model.dao.Discente aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }


}
