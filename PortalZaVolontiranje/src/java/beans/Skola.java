
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


public class Skola {
    private Integer idskolaSif;
    private String nazivSkole;

    public Skola(Integer idskolaSif, String nazivSkole) {
        this.idskolaSif = idskolaSif;
        this.nazivSkole = nazivSkole;
    }

    public Skola() {
    }
    

    public Integer getIdskolaSif() {
        return idskolaSif;
    }

    public void setIdskolaSif(Integer idskolaSif) {
        this.idskolaSif = idskolaSif;
    }

    public String getNazivSkole() {
        return nazivSkole;
    }

    public void setNazivSkole(String nazivSkole) {
        this.nazivSkole = nazivSkole;
    }
    
    public static List<Skola> ucitajSveSkole() {
        List<Skola> rezultat = new LinkedList<>();
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select idskolaSif, nazivSkole from skolasif");
            while (rs.next()) {
                Skola skola = new Skola(rs.getInt("idskolaSif"), rs.getString("nazivSkole"));
                rezultat.add(skola);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rezultat;
    }
}
