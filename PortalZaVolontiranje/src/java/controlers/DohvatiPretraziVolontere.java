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
import java.util.Date;

/**
 *
 * @author Korisnik
 */
@ManagedBean
@SessionScoped
public class DohvatiPretraziVolontere {
    
    private List<Volonter> sviVolonteri;

    public List<Volonter> getSviVolonteri() {
        return sviVolonteri;
    }

    public void setSviVolonteri(List<Volonter> sviVolonteri) {
        this.sviVolonteri = sviVolonteri;
    }
    
    public String dohvatiSveVolontere(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from volonter");
            sviVolonteri = new ArrayList<Volonter>();
            while(rs.next()){
                Volonter volonter = new Volonter();
                volonter.setIdVolonter(rs.getInt("idvolonter"));
                volonter.setImePrezime(rs.getString("ime_prezime"));
                volonter.setEmail(rs.getString("email"));
          //      volonter.setDatumRodjenja(rs.getTime("datum_rodjenja"));
                volonter.setUlica_broj(rs.getString("ulica_broj"));
             //   volonter.setCv(rs.getString("cv"));
            //    volonter.setSlika(rs.getString("slika"));
            //    volonter.setLozinka(rs.getString("lozinka"));
                
                
                sviVolonteri.add(volonter);
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(DohvatiPretraziVolontere.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
}
