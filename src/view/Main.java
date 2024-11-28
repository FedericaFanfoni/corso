package view;

import model.Discente;
import model.Docente;
import service.DiscenteService;
import service.DocenteService;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli in quale menù andare.");
        System.out.println("1. Docente");
        System.out.println("2. Discente");

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
            int choice2;

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
                choice2 = scanner.nextInt();
                switch (choice2) {
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

            } while (choice2 != 5);
            scanner.close();
        }else{
            System.out.println("Scelta sbagliata");
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
}
