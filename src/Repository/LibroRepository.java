package Repository;

import Config.DbConnection;
import Entity.Libro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroRepository {
    private static final Logger logger=Logger.getLogger(LibroRepository.class.getName());

    public void createLibro(Libro libro){
        String sql="insert into libri values(?,?,?)";
        try{
            Connection c= DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,libro.getIdl());
            ps.setString(2, libro.getTitolo());
            ps.setString(3, libro.getAutore());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Libro inserido com sucesso");
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

    public ArrayList<Libro> readLibro(){
        String sql="select * from libri";
        ArrayList<Libro> libri=new ArrayList<>();
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Libro libro=new Libro();
                libro.setIdl(rs.getString(1));
                libro.setTitolo(rs.getString(2));
                libro.setAutore(rs.getString(3));
                libri.add(libro);
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
        return libri;
    }

    public void deleteLibro(Libro libro){
        String sql="delete from libri where idl=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,libro.getIdl());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Libro eliminato com sucesso");
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }

    public void updateLibro(Libro libro){
        String sql="update libri set titolo=?,autore=? where idl=?";
        try{
            Connection c=DbConnection.openConnection();
            PreparedStatement ps=c.prepareStatement(sql);
            ps.setString(1,libro.getTitolo());
            ps.setString(2,libro.getAutore());
            ps.setString(3,libro.getIdl());
            int result=ps.executeUpdate();
            if(result>0){
                System.out.println("Libro modificato com sucesso");
            }
        }catch(ClassNotFoundException | SQLException e){
            logger.log(Level.SEVERE,"Errore"+e.getMessage(),e);
        }
    }
}
