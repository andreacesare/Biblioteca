package Service;
import java.util.*;
import Entity.Libro;
import Entity.Prestito;
import Entity.Utente;
import Repository.LibroRepository;
import Repository.PrestitoRepository;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class LibroService {


    public void createLibro(String idl,String titolo,String autore){
        LibroRepository libroRepository = new LibroRepository();
        Libro libro = new Libro();
        libro.setIdl(idl);
        libro.setTitolo(titolo);
        libro.setAutore(autore);
        libroRepository.createLibro(libro);


    }

    public ArrayList<Libro> readLibro(){
        LibroRepository libroRepository = new LibroRepository();
        return libroRepository.readLibro();
    }

    public void deleteLibro(String id){
        LibroRepository libroRepository = new LibroRepository();
        Libro libro=new Libro();
        libro.setIdl(id);
        libroRepository.deleteLibro(libro);
    }

    public void updateLibro(String id,String titolo,String autore){
        LibroRepository libroRepository = new LibroRepository();
        Libro libro=new Libro();
        libro.setIdl(id);
        libro.setTitolo(titolo);
        libro.setAutore(autore);
        libroRepository.updateLibro(libro);
    }


}
