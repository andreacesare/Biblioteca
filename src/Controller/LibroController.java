package Controller;

import Entity.Libro;
import Service.LibroService;

import java.util.ArrayList;
import java.util.Scanner;

public class LibroController {
    Scanner scanner = new Scanner(System.in);

    public void createLibro(){
        LibroService libroService = new LibroService();
        System.out.print("Inserisci id Libro ");
        String id = scanner.nextLine();
        System.out.println("Inserisci Titolo");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci Autore");
        String autore = scanner.nextLine();
        libroService.createLibro(id,titolo, autore);



    }

    public void readLibro(){
        LibroService libroService = new LibroService();
        ArrayList<Libro> libri= libroService.readLibro();
        System.out.println("Ecco la lista dei libri");
        for(Libro libro:libri){
            System.out.println(libro);
        }

    }

    public void deleteLibro(){
        LibroService libroService = new LibroService();
        readLibro();
        System.out.println("Inserisci l'id del libro da eliminare");
        String id = scanner.nextLine();
        libroService.deleteLibro(id);

    }

    public void updateLibro(){
        LibroService libroService = new LibroService();
        readLibro();
        System.out.println("Inserisci l'id del libro da modificare");
        String id = scanner.nextLine();
        System.out.println("Inserisci nuovo titolo");
        String titolo = scanner.nextLine();
        System.out.println("Inserisci nuovo autore");
        String autore = scanner.nextLine();
        libroService.updateLibro(id, titolo, autore);
    }
}
