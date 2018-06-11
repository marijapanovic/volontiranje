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


public class Vestine {
    
    private Integer idvestinesif;
    private String naziv;

    public Vestine(Integer idvestinesif, String naziv) {
        this.idvestinesif = idvestinesif;
        this.naziv = naziv;
    }

    public Vestine() {
    }

    public Integer getIdvestinesif() {
        return idvestinesif;
    }

    public void setIdvestinesif(Integer idvestinesif) {
        this.idvestinesif = idvestinesif;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
    
        public static List<Vestine> ucitajSveVestine() {
        List<Vestine> rezultat = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select idvestinesif, naziv from vestinesif");
            while (rs.next()) {
                Vestine vestine = new Vestine(rs.getInt("idvestinesif"), rs.getString("naziv"));
                rezultat.add(vestine);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }
}
