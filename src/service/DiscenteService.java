package service;

import model.Discente;
import repository.DiscenteRepository;

import java.time.LocalDate;
import java.util.List;

public class DiscenteService {
    DiscenteRepository discenteRepository = new DiscenteRepository();

    public void createDiscente(String nome, String cognome, LocalDate dataNascita, String matricola) {
        Discente discente = new Discente();
        discente.setNome(nome);
        discente.setCognome(cognome);
        discente.setDataNascita(dataNascita);
        discente.setMatricola(matricola);
        discenteRepository.createDiscente(discente);
    }

    public List<Discente> readDiscente(){
        return discenteRepository.readDiscenti();
    }

    public void deleteDiscente(int id) {
        Discente discente = new Discente();
        discente.setid(id);
        discenteRepository.deleteDiscente(discente);
    }

    public void updateDiscente(String nome, String cognome, LocalDate dataNascita, String matricola, int id) {
        Discente discente = new Discente();
        discente.setNome(nome);
        discente.setCognome(cognome);
        discente.setDataNascita(dataNascita);
        discente.setMatricola(matricola);
        discente.setid(id);
        discenteRepository.updateDiscente(discente);
    }
}
