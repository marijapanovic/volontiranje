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
public class DohvatiPretraziOrganizacije {
    private List<Organizacija> sveOrganizacije;

    public List<Organizacija> getSveOrganizacije() {
        return sveOrganizacije;
    }

    public void setSveOrganizacije(List<Organizacija> sveOrganizacije) {
        this.sveOrganizacije = sveOrganizacije;
    }
    
    public String dohvatiSveOrganizacije(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
              Statement stm = conn.createStatement();
              ResultSet rs = stm.executeQuery("select * from organizacije where aktivan=1");
              sveOrganizacije = new ArrayList<>();
              while(rs.next()){
                  Organizacija organizacija = new Organizacija();
                  organizacija.setNaziv(rs.getString("naziv"));
                  organizacija.setPib(rs.getInt("pib"));
                  organizacija.setEmail(rs.getString("email"));
                  organizacija.setWebAdresa(rs.getString("web_adresa"));
                  organizacija.setIdOrganizacija(rs.getInt("idorganizacija"));
                  organizacija.setUlica_broj(rs.getString("ulica_broj"));
                  sveOrganizacije.add(organizacija);
              }
        } catch (SQLException ex) {
            Logger.getLogger(DohvatiPretraziOrganizacije.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
