package service;

import model.Corso;
import repository.CorsoRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class CorsoService {
    CorsoRepository corsoRepository = new CorsoRepository();

    public void createCorso(String nomeCorso, LocalDate dataInizio, int durata, int idDocente) {
        Corso corso = new Corso(nomeCorso, dataInizio, durata, idDocente);
        corsoRepository.createCorso(corso);
    }

    public ArrayList<Corso> readCorsi(){
        return corsoRepository.readCorsi();
    }

}
