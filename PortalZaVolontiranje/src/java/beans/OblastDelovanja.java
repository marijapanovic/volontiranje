/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import controlers.Login;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class OblastDelovanja {
    private Integer idoblasti;
    private String naziv_oblasti;

    public OblastDelovanja(Integer idoblasti, String naziv_oblasti) {
        this.idoblasti = idoblasti;
        this.naziv_oblasti = naziv_oblasti;
    }

    public Integer getIdoblasti() {
        return idoblasti;
    }

    public void setIdoblasti(Integer idoblasti) {
        this.idoblasti = idoblasti;
    }

    public String getNaziv_oblasti() {
        return naziv_oblasti;
    }

    public void setNaziv_oblasti(String naziv_oblasti) {
        this.naziv_oblasti = naziv_oblasti;
    }
    
     public static List<OblastDelovanja> ucitajSveOblasti() {
        List<OblastDelovanja> rezultat = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select idoblasti, naziv_oblasti from oblasti");
            while (rs.next()) {
                OblastDelovanja oblastdelovanja = new OblastDelovanja(rs.getInt("idoblasti"), rs.getString("naziv_oblasti"));
                rezultat.add(oblastdelovanja);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }
}
