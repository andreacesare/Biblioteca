package Entity;

import java.util.Objects;

public class Libro {
    private String idl;
    private String titolo;
    private String autore;

    public String getIdl() {return idl;}
    public void setIdl(String idl) {this.idl = idl;}
    public String getTitolo() {return titolo;}
    public void setTitolo(String titolo) {this.titolo = titolo;}
    public String getAutore() {return autore;}
    public void setAutore(String autore) {this.autore = autore;}
    public String toString(){
        return idl+" "+titolo+" "+autore;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true; // Se sono lo stesso oggetto, sono uguali
        if (obj == null || getClass() != obj.getClass()) return false; // Se sono di tipo diverso, non sono uguali
        Libro libro = (Libro) obj; // Cast dell'oggetto
        return idl.equals(libro.idl)&&titolo.equals(libro.titolo) && autore.equals(libro.autore); // Confronta i campi principali
    }

    public int hashCode() {
        return Objects.hash(idl,titolo, autore); // Restituisce un codice hash combinato per titolo e autore
    }
}
