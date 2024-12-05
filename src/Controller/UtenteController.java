package Controller;

import Entity.Utente;
import Service.UtenteService;

import java.util.ArrayList;
import java.util.Scanner;

public class UtenteController {
    Scanner scanner = new Scanner(System.in);

    public void createUtente(){
        UtenteService utenteService = new UtenteService();
        System.out.println("Inserisci nome");
        String nome = scanner.nextLine();
        System.out.println("Inserisci cognome");
        String cognome = scanner.nextLine();
        utenteService.createUtente(nome, cognome);

    }

    public void readUtente(){
        UtenteService utenteService = new UtenteService();
        ArrayList<Utente> utenti= utenteService.readUtenti();
        System.out.println("Ecco la lista degli utenti");
        for(Utente utente : utenti){
            System.out.println(utente);
        }

    }

    public void deleteUtente(){
        UtenteService utenteService = new UtenteService();
        readUtente();;
        System.out.println("Inserisci l'id dell'utente da eliminare");
        int id = scanner.nextInt();
        scanner.nextLine();
        utenteService.deleteUtente(id);

    }

    public void updateUtente(){
        UtenteService utenteService = new UtenteService();
        readUtente();
        System.out.println("Inserisci id dell'utente da modificare");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Inserisci nuvo cognome");
        String cognome = scanner.nextLine();
        System.out.println("Inserisci nuovo nome");
        String nome = scanner.nextLine();
        utenteService.updateUtente(id, cognome, nome);
    }
}
