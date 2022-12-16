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
import pe.edu.cientifica.model.Autor;
/**
 *
 * @author Alumno
 */
public class AutorDaoImp implements Operaciones<Autor>{
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;

    @Override
    public int create(Autor t) {
        String SQL = "INSERT INTO autor (nombres, apellidos) VALUES(?,?)";
        int x = 0;
        try {
            cx = Conexion.getConexion();
            ps  = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int update(Autor t) {
        String SQL = "UPDATE autor SET nombres=?, apellidos=? WHERE idautor=?";
        int x = 0;
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, t.getNombres());
            ps.setString(2, t.getApellidos());
            ps.setInt(3, t.getIdautor());
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
    public Autor read(int id) {
        String SQL = "SELECT *FROM autor WHERE idautor=?";
        Autor c =  new Autor();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1,id);
            rs=ps.executeQuery();
            while(rs.next()){ 
                c.setIdautor(rs.getInt("idautor"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));
            }
        }catch(SQLException e){
            System.out.println("Error: "+e);
        }
        return c;
    }

    @Override
    public List<Autor> readAll() {
                String SQL = "SELECT *FROM autor";
        List<Autor> lista = new ArrayList<>();
        try{
            cx = Conexion.getConexion();
            ps = cx.prepareStatement(SQL);
            rs= ps.executeQuery();
            while(rs.next()){
                Autor c =  new Autor();
                c.setIdautor(rs.getInt("idautor"));
                c.setNombres(rs.getString("nombres"));
                c.setApellidos(rs.getString("apellidos"));                
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
