package Repository;

import Config.DbConnection;
import Entity.Libro;
import Entity.Prestito;
import Entity.Utente;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PrestitoRepository {
    private static final Logger logger=Logger.getLogger(PrestitoRepository.class.getName());

    public void createPrestito(Prestito prestito){
        String query="select count(*) from prestiti where idl=? and fine is null";
        String sql = "insert into prestiti(idl,idu,inizio) values(?,?,?)";
        try{
            Connection c= DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(query);
            ps.setString(1,prestito.getLibro().getIdl());
            ResultSet rs=ps.executeQuery();
            if(rs.next()&&rs.getInt(1)==0){
                PreparedStatement ps1=c.prepareStatement(sql);
                ps1.setString(1,prestito.getLibro().getIdl());
                ps1.setInt(2,prestito.getUtente().getIdu());
                ps1.setDate(3, Date.valueOf(prestito.getData_inizio()));
                int result=ps1.executeUpdate();
                if(result>0){
                    System.out.println("Prestito creato con successo");
                }
            }else{System.out.println("Libro non disponibile");}
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);

        }

    }

    public ArrayList<Prestito> readPrestito(){
        String query="select u.idu,u.nome,u.cognome,l.idl,l.titolo,l.autore,p.idp,p.inizio,p.fine  from utenti u full join prestiti p on u.idu=p.idu full join libri l on l.idl=p.idl where idp is not null ";
        ArrayList<Prestito> prestiti=new ArrayList<>();
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Prestito prestito=new Prestito();
                Libro libro=new Libro();
                Utente utente=new Utente();
                prestito.setIdp(rs.getInt("idp"));
                Date inizio=rs.getDate("inizio");
                prestito.setData_inizio(inizio.toLocalDate());
                Date fine=rs.getDate("fine");
                prestito.setData_fine(fine!=null ? fine.toLocalDate():null);
                utente.setIdu(rs.getInt("idu"));
                utente.setNome(rs.getString("nome"));
                utente.setCognome(rs.getString("cognome"));
                libro.setIdl(rs.getString("idl"));
                libro.setTitolo(rs.getString("titolo"));
                libro.setAutore(rs.getString("autore"));
                prestito.setLibro(libro);
                prestito.setUtente(utente);
                prestiti.add(prestito);
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
        return prestiti;
    }

    public void deletePrestito(Prestito prestito){
        String query="delete from prestiti where idp=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(query);
            ps.setInt(1,prestito.getIdp());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Prestito eliminato");
            }

        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

    public void updatePrestito(Prestito prestito){
        String sql="update prestiti set idl=?,idu=?,inizio=?,fine=? where idp=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,prestito.getLibro().getIdl());
            ps.setInt(2,prestito.getUtente().getIdu());
            ps.setDate(3,Date.valueOf(prestito.getData_inizio()));
            ps.setDate(4,Date.valueOf(prestito.getData_fine()));
            ps.setInt(5,prestito.getIdp());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Prestito modificato");
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }
}
