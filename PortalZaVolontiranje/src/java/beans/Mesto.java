/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

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
public class Mesto {
    private int id;
    private String nazivMesta;

    public Mesto(int id, String nazivMesta) {
        this.id = id;
        this.nazivMesta = nazivMesta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivMesta() {
        return nazivMesta;
    }

    public void setNazivMesta(String nazivMesta) {
        this.nazivMesta = nazivMesta;
    }
    
    public static List<Mesto> ucitajSvaMesta(){
        List<Mesto> rezultat = new LinkedList<>();
        try{
            Connection conn = DriverManager.getConnection(db.DB.connectionString,db.DB.user,db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select id,naziv_mesta from tblgrad");
            while(rs.next()){
                Mesto mesto = new Mesto(rs.getInt("id"),rs.getString("naziv_mesta"));
                rezultat.add(mesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Mesto.class.getName()).log(Level.SEVERE, null, ex);
        }
    return rezultat;
}
    
}
