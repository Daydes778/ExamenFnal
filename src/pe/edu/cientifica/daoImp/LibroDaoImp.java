/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.cientifica.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import pe.edu.cientifica.config.Conexion;
import pe.edu.cientifica.dao.Operaciones;
import pe.edu.cientifica.model.Libro;

/**
 *
 * @author Alumno
 */
public class LibroDaoImp implements Operaciones<Libro> {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Libro t) {
        String SQL = "INSERT INTO libro (titulo, npaginas, edicion,fecha_publicacion,ididioma,ideditorial,idautor) VALUES(?,?,?,?,?,?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps  = cx.prepareStatement(SQL);
            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getNpaginas());
            ps.setString(3, t.getEdicion());
            ps.setString(4, t.getFecha_publicacion());
            ps.setInt(5, t.getIdidioma());
            ps.setInt(6, t.getIdeditorial());
            ps.setInt(7, t.getIdautor());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Libro t) {
        String SQL = "UPDATE libro SET titulo=?, npaginas=?, edicion=?, fecha_publicacion=?, ididioma=?, ideditorial=?, idautor=? WHERE idlibro=?";
        int x = 0;
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getTitulo());
            ps.setString(2, t.getNpaginas());
            ps.setString(3, t.getEdicion());
            ps.setString(4, t.getFecha_publicacion());
            ps.setInt(5, t.getIdidioma());
            ps.setInt(6, t.getIdeditorial());
            ps.setInt(7, t.getIdautor());
            ps.setInt(8, t.getIdlibro());
            x= ps.executeUpdate();
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Libro read(int id) {
        String SQL = "SELECT *FROM libro WHERE idlibro=?";
        Libro c =  new Libro();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){ 
                c.setIdlibro(rs.getInt("idlibro"));
                c.setTitulo(rs.getString("titulo"));
                c.setNpaginas(rs.getString("npaginas"));
                c.setEdicion(rs.getString("edicion"));
                c.setFecha_publicacion(rs.getString("fecha_publicacion"));
                c.setIdidioma(rs.getInt("ididioma"));
                c.setIdeditorial(rs.getInt("ideditorial"));
                c.setIdautor(rs.getInt("idautor"));
                
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return c;
    }

    @Override
    public List<Libro> readAll() {
        String SQL = "SELECT *FROM libro";
        List<Libro> lista = new ArrayList<>();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs= ps.executeQuery();
            while(rs.next()){
                Libro c =  new Libro();
                c.setIdlibro(rs.getInt("idlibro"));
                c.setTitulo(rs.getString("titulo"));
                c.setNpaginas(rs.getString("npaginas"));
                c.setEdicion(rs.getString("edicion"));
                c.setFecha_publicacion(rs.getString("fecha_publicacion")); 
                c.setIdidioma(rs.getInt("ididioma"));   
                c.setIdeditorial(rs.getInt("ideditorial"));   
                lista.add(c);
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }   
        return lista;
    }

    @Override
    public List<Map<String, Object>> readAll2() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
