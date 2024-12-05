package Entity;

public class Utente {
    private int idu;
    private String nome;
    private String cognome;

    public int getIdu() {return idu;}
    public void setIdu(int idu) {this.idu = idu;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
    public String getCognome() {return cognome;}
    public void setCognome(String cognome) {this.cognome = cognome;}
    public String toString() {
        return idu + "\t" + nome + "\t" + cognome;
    }

}
