/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import model.Documento;
import util.UtilDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos arriaga
 */
public class DocumentoDAOImp implements DocumentoDAO{
   
    public Connection connection;
    
    public DocumentoDAOImp(){
        connection =UtilDB.getConnection();
    }
    
     @Override
    public void agregarDocumento(Documento documento) {
         String sql = "INSERT INTO documentos "
                 + " (nombre, descripcion, activo, universidad, carrera) "
                 + "VALUES(?, ?, ?, ?, ?)";
         
         try{
             PreparedStatement ps =
                     connection.prepareStatement(sql);
             ps.setString(1, documento.getNombre());
             ps.setString(2, documento.getDescripcion());
             ps.setString(3, documento.getActivo());
             ps.setString(4, documento.getUniversidad());
             ps.setString(5, documento.getCarrera());
             ps.executeUpdate();  
         } catch (SQLException e){
             e.printStackTrace();
         }
    }   
    @Override
    public void borrarDocumento(int idDocumento) {
       String sql="DELETE FROM documentos WHERE id_documento=?";
       try{
           PreparedStatement ps=connection.prepareStatement(sql);
           ps.setInt(1, idDocumento);
           ps.executeUpdate();
          }catch(SQLException e){
              e.printStackTrace();
          }
    }
    
     @Override
    public void cambiarDocumento(Documento documento) {
       String sql = "UPDATE documentos SET "
                 + " nombre=?, descripcion=?, activo=?, universidad=?, carrera=? "
                    + "WHERE id_documento=?";
         
         try{
             PreparedStatement ps =
                     connection.prepareStatement(sql);
        
            ps.setString(1, documento.getNombre());
            ps.setString(2, documento.getDescripcion());
            ps.setString(3, documento.getActivo());
            ps.setString(4, documento.getUniversidad());
            ps.setString(5, documento.getCarrera());
            ps.setInt(6, documento.getIdDocumento());
            ps.executeUpdate();  
         } catch (SQLException e){
             e.printStackTrace();
         }
    }
     @Override
    public List<Documento> desplegarDocumentos() {
        List<Documento> documentos = new ArrayList<Documento>();
        try{
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(
                "SELECT * FROM documentos");
            while (rs.next()){
                Documento documento = new Documento(
                        rs.getInt("id_documento"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("activo"),
                        rs.getString("universidad"),
                        rs.getString("carrera"));
                documentos.add(documento);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
            
       return documentos;
       
    }
    @Override
    public Documento elegirDocumento(int idDocumento) {
        Documento documento = null;
        try{
           PreparedStatement ps = connection.prepareStatement(
                                  "SELECT * FROM documentos "
                                + "WHERE id_documento=?");
           ps.setInt(1, idDocumento);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
               documento = new Documento(
                        rs.getInt("id_documento"),
                        rs.getString("nombre"),
                        rs.getString("descripcion"),
                        rs.getString("activo"),
                        rs.getString("universidad"),
                        rs.getString("carrera"));
               
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
            
       return documento;
    }
}//final clase
