/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pe.edu.cientifica.test;

import com.google.gson.Gson;
import pe.edu.cientifica.config.Conexion;
import pe.edu.cientifica.daoImp.AutorDaoImp;
import pe.edu.cientifica.daoImp.EditorialDaoImp;
import pe.edu.cientifica.daoImp.IdiomaDaoImp;
import pe.edu.cientifica.daoImp.LibroDaoImp;
import pe.edu.cientifica.model.Autor;
import pe.edu.cientifica.model.Editorial;
import pe.edu.cientifica.model.Idioma;
import pe.edu.cientifica.model.Libro;

/**
 *
 * @author Alumno
 */
public class Test {
private Gson gson = new Gson();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         if(Conexion.getConexion()!=null){
            System.out.println("SI");
        }else{
            System.out.println("NO");
        }
        EditorialDaoImp cdi =  new EditorialDaoImp();
        System.out.println(cdi.update(new Editorial(1,"e","e","e"))); 
    }
    
}
