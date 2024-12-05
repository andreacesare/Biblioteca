package Entity;

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

}
