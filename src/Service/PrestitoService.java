package Service;

import Entity.Libro;
import Entity.Prestito;
import Entity.Utente;
import Repository.PrestitoRepository;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



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

    public Set<Libro> libriPrestati(Utente utente){
        PrestitoRepository prestitoRepository = new PrestitoRepository();
        ArrayList<Prestito> prestiti=prestitoRepository.readPrestito();
        Set<Libro> libri=prestiti.stream().filter(p->p.getUtente().getIdu()== utente.getIdu()).map(Prestito::getLibro).collect(Collectors.toSet());
        return libri;
    }

    public List<Prestito> libriNonRientrati(){
        PrestitoRepository prestitoRepository = new PrestitoRepository();
        ArrayList<Prestito> prestiti=prestitoRepository.readPrestito();
        List<Prestito> lista=prestiti.stream().filter(p->p.getData_fine()==null).collect(Collectors.toList());
        return lista;
    }

    public List<Prestito> storicoLibriUtente(Utente utente){
        PrestitoRepository prestitoRepository = new PrestitoRepository();
        ArrayList<Prestito> prestiti=prestitoRepository.readPrestito();
        List<Prestito> lista=prestiti.stream().filter(p->p.getUtente().getIdu()==utente.getIdu()).collect(Collectors.toList());
        return lista;
    }

    public List<Prestito> prestitiP15g(){
        PrestitoRepository prestitoRepository = new PrestitoRepository();
        ArrayList<Prestito> prestiti=prestitoRepository.readPrestito();
        List<Prestito> lista=prestiti.stream().filter(p->{LocalDate fine=p.getData_fine()!=null?p.getData_fine():LocalDate.now();
            long durata=ChronoUnit.DAYS.between(p.getData_inizio(),fine);
            return durata>15;}).collect(Collectors.toList());
        return lista;
    }
}
