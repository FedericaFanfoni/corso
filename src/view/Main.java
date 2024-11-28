package view;

import model.Corso;
import model.Discente;
import model.Docente;
import service.CorsoService;
import service.DiscenteService;
import service.DocenteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli in quale menù andare.");
        System.out.println("1. Docente");
        System.out.println("2. Discente");
        System.out.println("Corso");

        int scelta = scanner.nextInt();

        if(scelta == 1) {
            int choice;

            do {
                System.out.println("Classe docente");

                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo docente");
                System.out.println("2. Aggiorna un docente");
                System.out.println("3. Visualizza la lista di docenti");
                System.out.println("4. Elimina un docente");
                System.out.println("5. Exit");
                System.out.print("inserisci la tua scelta: ");

                // Read user input
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        create();
                        break;
                    case 2:
                        update();
                        break;
                    case 3:
                        read();
                        break;
                    case 4:
                        delete();
                        break;
                    case 5:
                        System.out.println("exiting");
                        break;
                    default:
                        System.out.println("scelta errata. scegliere un numero da 1 a 5");
                }

            } while (choice != 5);
            scanner.close();

        }else if(scelta == 2){
            int choice;

            do {
                System.out.println("Classe Discente");

                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo discente");
                System.out.println("2. Aggiorna un discente");
                System.out.println("3. Visualizza la lista di discenti");
                System.out.println("4. Elimina un discente");
                System.out.println("5. Exit");
                System.out.print("inserisci la tua scelta: ");

                // Read user input
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        createDiscente();
                        break;
                    case 2:
                        updateDiscente();
                        break;
                    case 3:
                        readDiscenti();
                        break;
                    case 4:
                        deleteDiscente();
                        break;
                    case 5:
                        System.out.println("exiting");
                        break;
                    default:
                        System.out.println("scelta errata. scegliere un numero da 1 a 5");
                }

            } while (choice != 5);
            scanner.close();
        }else{
            int choice;

            do {
                System.out.println("Classe corso");

                System.out.println("***Menu***");
                System.out.println("1. Crea un nuovo corso");
                System.out.println("2. Visualizza lista corsi");
                System.out.println("5. Exit");
                System.out.print("inserisci la tua scelta: ");

                // Read user input
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        createCorso();
                        break;
                    case 2:
                        readCorsi();
                    case 5:
                        System.out.println("exiting");
                        break;
                    default:
                        System.out.println("Scelta errata. scegliere un numero da 1 a 5");
                }

            } while (choice != 5);
            scanner.close();

        }
    }

        private static void read() {
        System.out.println("ecco la lista dei docenti: ");
        DocenteService oDocenteService = new DocenteService();
        List<Docente> listaDocenti= oDocenteService.readDocente();
        int i = 0;
        while(i<listaDocenti.size()){
            System.out.println(listaDocenti.get(i).getid()+" "+listaDocenti.get(i).getCognome()+" "+listaDocenti.get(i).getNome());
            i++;}

        }

        private static void create () {
            System.out.println("inserisci nome: ");
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.next();
            System.out.println("inserisci cognome: ");
            String cognome = scanner.next();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.create(nome, cognome);

        }

        private static void delete () {
            System.out.println("Elimina il docente con id: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.delete(id);

        }

        private static void update () {
            Scanner scanner = new Scanner(System.in);
            System.out.println("inserisci l'id del docente da modificare:");
            int id = scanner.nextInt();
            System.out.println("inserisci il nuovo nome:");
            String nome = scanner.next();
            System.out.println("inserisci il nuovo cognome:");
            String cognome = scanner.next();
            DocenteService oDocenteService = new DocenteService();
            oDocenteService.update(id, nome, cognome);

        }

        private static void createDiscente() {
            System.out.println("inserisci nome: ");
            Scanner scanner = new Scanner(System.in);
            String nome = scanner.next();
            System.out.println("inserisci cognome: ");
            String cognome = scanner.next();
            scanner.nextLine();
            System.out.println("inserisci anno di nascita: ");
            int anno = scanner.nextInt();
            System.out.println("inserisci mese: ");
            int mese = scanner.nextInt();
            System.out.println("inserisci giorno: ");
            int giorno = scanner.nextInt();
            scanner.nextLine();
            LocalDate dataNascita = LocalDate.of(anno, mese, giorno);

            System.out.println("inserisci matricola: ");
            String matricola = scanner.next();

            DiscenteService discenteService = new DiscenteService();
            discenteService.createDiscente(nome, cognome, dataNascita , matricola);
        }

        private static void readDiscenti() {
            System.out.println("ecco la lista dei discenti: ");
            DiscenteService discenteService = new DiscenteService();
            List<Discente> listaDiscenti = discenteService.readDiscente();

            for (Discente discente : listaDiscenti) {
                System.out.println(discente.getid() + " " + discente.getCognome() + " " + discente.getNome());
            }

        }

        private static void deleteDiscente() {
            System.out.println("Elimina il discente con id: ");
            Scanner scanner = new Scanner(System.in);
            int id = scanner.nextInt();
            DiscenteService discenteService = new DiscenteService();
            discenteService.deleteDiscente(id);
        }

        private static void updateDiscente() {
            Scanner scanner = new Scanner(System.in);

            System.out.println("inserisci il nuovo nome:");
            String nome = scanner.next();
            System.out.println("inserisci il nuovo cognome:");
            String cognome = scanner.next();
            System.out.println("inserisci il nuovo anno di nascita: ");
            scanner.nextLine();
            int anno = scanner.nextInt();
            System.out.println("inserisci il nuovo mese: ");
            int mese = scanner.nextInt();
            System.out.println("inserisci il nuovo giorno: ");
            int giorno = scanner.nextInt();
            System.out.println("inserisci la nuova matricola:");
            scanner.nextLine();
            LocalDate dataNascita = LocalDate.of(anno, mese, giorno);
            String matricola = scanner.next();
            System.out.println("inserisci l'id del discente da modificare:");
            int id = scanner.nextInt();

            DiscenteService discenteService = new DiscenteService();
            discenteService.updateDiscente(nome, cognome, dataNascita, matricola, id);

        }

        private static void createCorso(){
            System.out.println("Inserisci il nome del corso: ");
            Scanner scanner = new Scanner(System.in);
            String nomeCorso = scanner.next();

            System.out.println("Inserisci la data di inizio");
            String dataInizioString = scanner.next();
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate dataInizio = LocalDate.parse(dataInizioString, dateFormatter);

            System.out.println("inserisci durata: ");
            int durata = scanner.nextInt();

            System.out.println("Inserisci id del docente: ");
            int idDocente = scanner.nextInt();
            DocenteService docenteService = new DocenteService();
            List<Docente> listaDocenti= docenteService.readDocente();

            boolean trovato = false;

            for(Docente docente : listaDocenti){
                if(docente.getid() == idDocente){
                    trovato = true;
                }
            }

            if(!trovato){
                System.out.println("Nessun docente trovato con questo id");
                return;
            }

            CorsoService corsoService = new CorsoService();
            corsoService.createCorso(nomeCorso, dataInizio, durata, idDocente);

        }

        private static void readCorsi(){
            System.out.println("Lista corsi: ");
            CorsoService corsoService = new CorsoService();
            ArrayList<Corso> listaCorsi = corsoService.readCorsi();

            DocenteService oDocenteService = new DocenteService();
            List<Docente> listaDocenti= oDocenteService.readDocente();
            Docente docenteCorso = new Docente();


            for (Corso corso : listaCorsi) {

                for(int i = 0; i<listaDocenti.size(); i++){

                    if(corso.getIdDocente() == listaDocenti.get(i).getid()){
                        docenteCorso.setNome(listaDocenti.get(i).getNome());
                        docenteCorso.setCognome(listaDocenti.get(i).getCognome());
                        docenteCorso.setid(listaDocenti.get(i).getid());
                    }
                }

                System.out.println(corso.getId() + " " + corso.getNomeCorso() + " , Docente: " + docenteCorso.getNome() + " " + docenteCorso.getCognome());
            }
        }
}
