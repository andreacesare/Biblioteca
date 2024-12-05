package Service;

import Entity.Utente;
import Repository.UtenteRepository;

import java.util.ArrayList;

public class UtenteService {

    public void createUtente(String nome,String cognome) {
        UtenteRepository utenteRepository = new UtenteRepository();
        Utente utente=new Utente();
        utente.setNome(nome);
        utente.setCognome(cognome);
        utenteRepository.createUtente(utente);
    }

    public ArrayList<Utente> readUtenti() {
        UtenteRepository utenteRepository = new UtenteRepository();
        ArrayList<Utente> utenti = utenteRepository.readUtenti();
        return utenti;
    }

    public void deleteUtente(int id) {
        UtenteRepository utenteRepository = new UtenteRepository();
        Utente utente=new Utente();
        utente.setIdu(id);
        utenteRepository.deleteUtente(utente);
    }

    public void updateUtente(int id,String nome,String cognome) {
        UtenteRepository utenteRepository = new UtenteRepository();
        Utente utente=new Utente();
        utente.setIdu(id);
        utente.setNome(nome);
        utente.setCognome(cognome);
        utenteRepository.updateUtente(utente);
    }
}
