package Service;

import Entity.Libro;
import Repository.LibroRepository;

import java.util.ArrayList;

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
