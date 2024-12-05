import Controller.LibroController;
import Controller.PrestitoController;
import Controller.UtenteController;
import Entity.Prestito;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        int choice1;
        int choice2;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("1)Libro \n 2)Utente \n 3) Prestito \n 4)Exit");
            System.out.println("Inserisci la tua scelta");
            choice1 = scanner.nextInt();
            scanner.nextLine();
            if (choice1 == 1) {
                System.out.println("Classe Libro");
                System.out.println("****MENU****");
                System.out.println("1. Crea un nuovo libro");
                System.out.println("2. Aggiorna un libro");
                System.out.println("3. Visualizza la lista dei libri");
                System.out.println("4. Elimina un libro");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                LibroController libroController = new LibroController();
                switch (choice2) {
                    case 1:
                        libroController.createLibro();
                        break;
                    case 2:
                        libroController.updateLibro();
                        break;
                    case 3:
                        libroController.readLibro();
                        break;
                    case 4:
                        libroController.deleteLibro();
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            }
            else if (choice1 == 2) {
                System.out.println("Classe Utente");
                System.out.println("****MENU****");
                System.out.println("1. Crea un nuovo utente");
                System.out.println("2. Aggiorna un utente");
                System.out.println("3. Visualizza la lista degli utenti ");
                System.out.println("4. Elimina un utente");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                UtenteController utenteController= new UtenteController();
                switch (choice2) {
                    case 1:
                        utenteController.createUtente();
                        break;
                    case 2:
                        utenteController.updateUtente();
                        break;
                    case 3:
                        utenteController.readUtente();
                        break;
                    case 4:
                        utenteController.deleteUtente();
                        break;
                    case 5:
                        break;
                    case 6:

                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            }
            else if (choice1 == 3) {
                System.out.println("Classe Prestito");
                System.out.println("****MENU****");
                System.out.println("1. Crea un nuovo prestito");
                System.out.println("2. Aggiorna un prestito");
                System.out.println("3. Visualizza la lista dei prestiti");
                System.out.println("4. Elimina un prestito");
                System.out.println("9. Exit");
                System.out.print("inserisci la tua scelta: ");
                choice2 = scanner.nextInt();
                scanner.nextLine();
                PrestitoController prestitoController=new PrestitoController();
                switch (choice2) {
                    case 1:
                        prestitoController.createPrestito();
                        break;
                    case 2:
                        prestitoController.updatePrestito();
                        break;
                    case 3:
                        prestitoController.readPrestito();
                        break;
                    case 4:
                        prestitoController.deletePrestito();
                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 7:

                        break;
                    case 9:
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Insersci un numero valido");
                }
            }
        }while (choice1 != 4);
    }

    }
