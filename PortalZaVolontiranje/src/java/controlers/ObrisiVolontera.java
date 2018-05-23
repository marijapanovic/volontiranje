/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Volonter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Korisnik
 */
@ManagedBean
@SessionScoped
public class ObrisiVolontera {
    private Volonter selektovaniVolonter;

    public Volonter getSelektovaniVolonter() {
        return selektovaniVolonter;
    }

    public void setSelektovaniVolonter(Volonter selektovaniVolonter) {
        this.selektovaniVolonter = selektovaniVolonter;
    }
    
    
     public String obrisiVolontera(){
        try {
            Connection con = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = con.createStatement();
            stm.executeUpdate("delete from volonter where idvolonter="+selektovaniVolonter.getIdVolonter());
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Volonter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
}
