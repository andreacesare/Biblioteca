package Entity;

import java.time.LocalDate;

public class Prestito {
    private int idp;
    private LocalDate data_inizio;
    private LocalDate data_fine;
    private Libro libro;
    private Utente utente;

    public int getIdp(){return idp;}
    public void setIdp(int idp){this.idp = idp;}
    public LocalDate getData_inizio(){return data_inizio;}
    public void setData_inizio(LocalDate data_inizio){this.data_inizio = data_inizio;}
    public LocalDate getData_fine(){return data_fine;}
    public void setData_fine(LocalDate data_fine){this.data_fine = data_fine;}
    public Libro getLibro(){return libro;}
    public void setLibro(Libro libro){this.libro = libro;}
    public Utente getUtente(){return utente;}
    public void setUtente(Utente utente){this.utente = utente;}
    public String toString(){
        return idp+"\t Libro:"+getLibro().getTitolo()+"\t"+getLibro().getAutore()+"\t Utente:"+getUtente().getNome()+"\t"+getUtente().getCognome()+"\t Inizio:"+getData_inizio()+"\t Fine:"+getData_fine();
    }

    }


