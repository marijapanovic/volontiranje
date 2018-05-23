/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Volonter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
public class OdobravanjeVolontera {
    private Volonter selektovaniVolonter;

    public Volonter getSelektovaniVolonter() {
        return selektovaniVolonter;
    }

    public void setSelektovaniVolonter(Volonter selektovaniVolonter) {
        this.selektovaniVolonter = selektovaniVolonter;
    }
    
    private List<Volonter> volonteriZaOdobravanje;

    public List<Volonter> getVolonteriZaOdobravanje() {
        return volonteriZaOdobravanje;
    }

    public void setVolonteriZaOdobravanje(List<Volonter> volonteriZaOdobravanje) {
        this.volonteriZaOdobravanje = volonteriZaOdobravanje;
    }
    
    public String dohvatiZahteveZaOdobravanjeVolontera(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from volonter where JPstatus=0");
            volonteriZaOdobravanje = new ArrayList<Volonter>();
            while(rs.next()){
                Volonter volonter = new Volonter();
                volonter.setIdVolonter(rs.getInt("idvolonter"));
                volonter.setImePrezime(rs.getString("ime_prezime"));
                volonter.setEmail(rs.getString("email"));
                volonter.setUlica_broj(rs.getString("ulica_broj"));
         //       volonter.setDrzavljanstvo(rs.getDrzavlajnstvo("drzavljanstvo"));
            //    volonter.setPol(rs.getString("pol"));

                volonteriZaOdobravanje.add(volonter);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OdobravanjeVolontera.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void odobriZahtevVolontera(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            stm.executeUpdate("update volonter set JPstatus=1 where idvolonter="+ selektovaniVolonter.getIdVolonter());
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(OdobravanjeVolontera.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
    }
    
    
}
