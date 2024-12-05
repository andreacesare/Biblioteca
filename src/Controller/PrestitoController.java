package Controller;

import Entity.Libro;
import Entity.Prestito;
import Entity.Utente;
import Service.LibroService;
import Service.PrestitoService;
import Service.UtenteService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrestitoController {
    Scanner scanner=new Scanner(System.in);
    private static final Logger logger=Logger.getLogger(PrestitoController.class.getName());

    public void createPrestito(){
        PrestitoService prestitoService = new PrestitoService();
        LibroController libroController = new LibroController();
        UtenteController utenteController = new UtenteController();
        LibroService libroService = new LibroService();
        UtenteService utenteService = new UtenteService();
        ArrayList<Libro> libri=libroService.readLibro();
        ArrayList<Utente> utenti=utenteService.readUtenti();
        Libro libro=new Libro();
        Utente utente=new Utente();
        utenteController.readUtente();
        System.out.println("Inserisci id dell'utente che vuole fare il prestito");
        int idu= scanner.nextInt();
        scanner.nextLine();
        libroController.readLibro();
        System.out.println("Inserisci l'id del libro da prendere in prestito");
        String idl= scanner.nextLine();
        for(int i=0;i<utenti.size();i++){
            if(utenti.get(i).getIdu()==idu){
                utente=utenti.get(i);
                break;
            }
        }
        for(int i=0;i<libri.size();i++){
            if(libri.get(i).getIdl().equalsIgnoreCase(idl)){
                libro=libri.get(i);
                break;
            }
        }
        LocalDate inizio=null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean dataValida=false;
        while(!dataValida){
            try{
                System.out.println("Inserisci l'inizio del prestito");
                inizio=LocalDate.parse(scanner.nextLine(),formatter);
                dataValida=true;
            }catch(DateTimeParseException e){
                System.out.println("Formato non valido, riprova");
            }
        }
        prestitoService.createPrestito(inizio,libro,utente);

    }

    public void readPrestito(){
        PrestitoService prestitoService = new PrestitoService();
        ArrayList<Prestito> prestiti =prestitoService.readPrestito();
        System.out.println("Ecco la lista dei prestiti");
        for(Prestito p:prestiti){
            System.out.println(p);
        }


    }

    public void deletePrestito(){
        PrestitoService prestitoService = new PrestitoService();
        readPrestito();
        System.out.println("Inserisci l'id del prestito da eliminare");
        int id= scanner.nextInt();
        scanner.nextLine();
        prestitoService.deletePrestito(id);
    }

    public void updatePrestito(){
        readPrestito();
        System.out.println("Inserisci l'id del prestito da modificare");
        int id= scanner.nextInt();
        scanner.nextLine();
        PrestitoService prestitoService = new PrestitoService();
        LibroController libroController = new LibroController();
        UtenteController utenteController = new UtenteController();
        LibroService libroService = new LibroService();
        UtenteService utenteService = new UtenteService();
        ArrayList<Libro> libri=libroService.readLibro();
        ArrayList<Utente> utenti=utenteService.readUtenti();
        Libro libro=new Libro();
        Utente utente=new Utente();
        utenteController.readUtente();
        System.out.println("Inserisci id dell'utente che vuoi modificare");
        int idu= scanner.nextInt();
        scanner.nextLine();
        libroController.readLibro();
        System.out.println("Inserisci l'id del libro che vuoi modificare");
        String idl= scanner.nextLine();
        for(int i=0;i<utenti.size();i++){
            if(utenti.get(i).getIdu()==idu){
                utente=utenti.get(i);
                break;
            }
        }
        for(int i=0;i<libri.size();i++){
            if(libri.get(i).getIdl().equalsIgnoreCase(idl)){
                libro=libri.get(i);
                break;
            }
        }
        LocalDate inizio=null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean dataValida=false;
        while(!dataValida){
            try{
                System.out.println("Inserisci l'inizio del prestito");
                inizio=LocalDate.parse(scanner.nextLine(),formatter);
                dataValida=true;
            }catch(DateTimeParseException e){
                System.out.println("Formato non valido, riprova");
            }
        }
        LocalDate fine=null;
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean dataValida2=false;
        while(!dataValida2){
            try{
                System.out.println("Inserisci la fine del prestito");
                fine=LocalDate.parse(scanner.nextLine(),formatter);
                dataValida2=true;
            }catch(DateTimeParseException e){
                System.out.println("Formato non valido, riprova");
            }
        }
        prestitoService.updatePrestito(id,inizio,fine,libro,utente);


    }


}
