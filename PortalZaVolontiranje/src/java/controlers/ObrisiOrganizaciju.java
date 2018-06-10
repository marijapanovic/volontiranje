/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Organizacija;
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
 * @author Nikola
 */
@ManagedBean
@SessionScoped
public class ObrisiOrganizaciju {
    private Organizacija selektovanaOrganizacija;

    public Organizacija getSelektovanaOrganizacija() {
        return selektovanaOrganizacija;
    }

    public void setSelektovanaOrganizacija(Organizacija selektovanaOrganizacija) {
        this.selektovanaOrganizacija = selektovanaOrganizacija;
    }
    
    public void obrisiOrganizaciju(){
        try {
            Connection con = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
             Statement stm = con.createStatement();
              stm.executeUpdate("delete from organizacija where idorganizacija="+selektovanaOrganizacija.getIdOrganizacija());
        } catch (SQLException ex) {
            Logger.getLogger(ObrisiOrganizaciju.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
