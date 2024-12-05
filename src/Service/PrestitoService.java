package Service;

import Entity.Libro;
import Entity.Prestito;
import Entity.Utente;
import Repository.PrestitoRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public class PrestitoService {

    public void createPrestito(LocalDate inizio, Libro libro, Utente utente){
        PrestitoRepository prestitoRepository = new PrestitoRepository();
        Prestito prestito = new Prestito();
        prestito.setLibro(libro);
        prestito.setUtente(utente);
        prestito.setData_inizio(inizio);
        prestitoRepository.createPrestito(prestito);
    }

    public ArrayList<Prestito> readPrestito(){
        PrestitoRepository prestitoRepository = new PrestitoRepository();
        ArrayList<Prestito> prestiti= prestitoRepository.readPrestito();
        return prestiti;
    }

    public void deletePrestito(int idp){
        PrestitoRepository prestitoRepository = new PrestitoRepository();
        Prestito prestito=new Prestito();
        prestito.setIdp(idp);
        prestitoRepository.deletePrestito(prestito);

    }

    public void updatePrestito(int idp,LocalDate inizio, LocalDate fine,Libro libro, Utente utente){
        PrestitoRepository prestitoRepository = new PrestitoRepository();
        Prestito prestito=new Prestito();
        prestito.setLibro(libro);
        prestito.setUtente(utente);
        prestito.setData_inizio(inizio);
        prestito.setData_fine(fine);
        prestito.setIdp(idp);
        prestitoRepository.updatePrestito(prestito);
    }
}
