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
 * @author dprokic
 */
public class Drzavljanstvo {
    private Integer iddrz;

    public Drzavljanstvo(Integer iddrz, String drzavljanstvo) {
        this.iddrz = iddrz;
        this.drzavljanstvo = drzavljanstvo;
    }
    private String drzavljanstvo;

    public Integer getIddrz() {
        return iddrz;
    }

    public void setIddrz(Integer iddrz) {
        this.iddrz = iddrz;
    }

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }
    
    public static List<Drzavljanstvo> ucitajSvaDrzavljanstva() {
        List<Drzavljanstvo> rezultat = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select iddrz, drzavljanstvo from drzavljanstvo");
            while (rs.next()) {
                Drzavljanstvo drzavljanstvo = new Drzavljanstvo(rs.getInt("iddrz"), rs.getString("drzavljanstvo"));
                rezultat.add(drzavljanstvo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }
}
