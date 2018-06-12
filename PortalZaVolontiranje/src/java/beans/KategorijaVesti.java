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
public class KategorijaVesti {
    private Integer idKategorijaVesti;
    private String kategorija;

    public Integer getIdKategorijaVesti() {
        return idKategorijaVesti;
    }

    public void setIdKategorijaVesti(Integer idKategorijaVesti) {
        this.idKategorijaVesti = idKategorijaVesti;
    }

   

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public KategorijaVesti() {
    }

    public KategorijaVesti(Integer idKategorijaVesti, String kategorija) {
        this.idKategorijaVesti = idKategorijaVesti;
        this.kategorija = kategorija;
    }
    
    public static List<KategorijaVesti> ucitajSveVesti() {
        List<KategorijaVesti> rezultat = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select idkategorija_vesti, kategorija from kategorija_vesti");
            while (rs.next()) {
                KategorijaVesti kategorijaVesti = new KategorijaVesti(rs.getInt("idkategorija_vesti"), rs.getString("kategorija"));
                rezultat.add(kategorijaVesti);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }
}
