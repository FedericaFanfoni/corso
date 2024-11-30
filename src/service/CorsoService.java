package service;

import model.Corso;
import model.Docente;
import repository.CorsoRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class CorsoService {
    CorsoRepository corsoRepository = new CorsoRepository();

    public void createCorso(String nomeCorso, LocalDate dataInizio, int durata, Docente docente) {
        Corso corso = new Corso(nomeCorso, dataInizio, durata, docente);
        corsoRepository.createCorso(corso);
    }

   public ArrayList<Corso> readCorsi() {
       return corsoRepository.readCorsi();
   }

   public ArrayList<Corso> readCorsiOfDiscente(int idDiscente){
        return corsoRepository.readCorsiOfDiscente(idDiscente);
   }

   public void updateCorso(String nomeCorso, LocalDate dataInizio, int durata, Docente docente, int id) {
       Corso corso = new Corso(nomeCorso, dataInizio, durata, docente, id);
       corsoRepository.updateCorso(corso);
   }

   public void deleteCorso(int id){
       corsoRepository.deleteCorso(id);
   }


}
