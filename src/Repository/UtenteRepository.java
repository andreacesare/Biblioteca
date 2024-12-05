package Repository;

import Config.DbConnection;
import Entity.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtenteRepository {
    private static final Logger logger=Logger.getLogger(UtenteRepository.class.getName());

    public void createUtente(Utente utente) {
        String sql="insert into utenti(cognome,nome) values(?,?)";
        try{
            Connection c= DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(2, utente.getNome());
            ps.setString(1, utente.getCognome());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Utente creato");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

    public ArrayList<Utente> readUtenti() {
        ArrayList<Utente> utenti=new ArrayList<>();
        String sql="select * from utenti";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Utente utente=new Utente();
                utente.setIdu(rs.getInt("idu"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                utenti.add(utente);

            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
        return utenti;
    }

    public void deleteUtente(Utente utente) {
        String sql="delete from utenti where idu=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setInt(1, utente.getIdu());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Utente eliminato");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

    public void updateUtente(Utente utente){
        String sql="update utenti set nome=?, cognome=? where idu=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1, utente.getNome());
            ps.setString(2, utente.getCognome());
            ps.setInt(3, utente.getIdu());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Utente modificato");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }
}
