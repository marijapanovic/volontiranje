/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Organizacija;
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
 * @author Nikola
 */
@ManagedBean
@SessionScoped
public class OdobravanjeOrganizacija {
    private Organizacija selektovanaOrganizacija;

    public Organizacija getSelektovanaOrganizacija() {
        return selektovanaOrganizacija;
    }

    public void setSelektovanaOrganizacija(Organizacija selektovanaOrganizacija) {
        this.selektovanaOrganizacija = selektovanaOrganizacija;
    }
    
    private List<Organizacija> organizacijeZaOdobravanje;

    public List<Organizacija> getOrganizacijeZaOdobravanje() {
        return organizacijeZaOdobravanje;
    }

    public void setOrganizacijeZaOdobravanje(List<Organizacija> organizacijeZaOdobravanje) {
        this.organizacijeZaOdobravanje = organizacijeZaOdobravanje;
    }
    
    public String dohvatiZahteveZaOdobravanjeOrganizacija(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
             Statement stm = conn.createStatement();
               ResultSet rs = stm.executeQuery("select * from organizacija where Aktivan=0");
               organizacijeZaOdobravanje = new ArrayList<>();
               while(rs.next()){
                   Organizacija organizacija = new Organizacija();
                   organizacija.setIdOrganizacija(rs.getInt("idorganizacija"));
                   organizacija.setNaziv(rs.getString("naziv"));
                   organizacija.setEmail(rs.getString("email"));
                   organizacija.setUlica_broj(rs.getString("ulica_broj"));
                   organizacija.setWebAdresa(rs.getString("web_adresa"));
                   organizacijeZaOdobravanje.add(organizacija);
               }
        } catch (SQLException ex) {
            Logger.getLogger(OdobravanjeOrganizacija.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void odobriZahtevOrganizacije(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
             Statement stm = conn.createStatement();
              stm.executeUpdate("update organizacija set Aktivan=1 where idorganizacija="+ selektovanaOrganizacija.getIdOrganizacija());
        } catch (SQLException ex) {
            Logger.getLogger(OdobravanjeOrganizacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void odbijZahtevOrganizacije(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
             Statement stm = conn.createStatement();
              stm.executeUpdate("delete from organizacija where idorganizacija="+ selektovanaOrganizacija.getIdOrganizacija());
        } catch (SQLException ex) {
            Logger.getLogger(OdobravanjeOrganizacija.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
