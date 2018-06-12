/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Volonter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SRDJAN
 */

@ManagedBean
@RequestScoped
public class DodajVestVolonter {
    private int idvesti;
    private String kategorija;
    private int idkategorija;
    private String autor;
    private Date vreme;
    private String tekst;
    private int tip_autora;
    private int vidljivost;

    public int getIdvesti() {
        return idvesti;
    }

    public void setIdvesti(int idvesti) {
        this.idvesti = idvesti;
    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getTip_autora() {
        return tip_autora;
    }

    public void setTip_autora(int tip_autora) {
        this.tip_autora = tip_autora;
    }

    public int getVidljivost() {
        return vidljivost;
    }

    public void setVidljivost(int vidljivost) {
        this.vidljivost = vidljivost;
    }

    public int getIdkategorija() {
        return idkategorija;
    }

    public void setIdkategorija(int idkategorija) {
        this.idkategorija = idkategorija;
    }
    
    public String ubaciVest(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm=conn.createStatement();
            HttpSession sesija = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Volonter volonter = (Volonter) sesija.getAttribute("volonter");
            autor=(String) sesija.getAttribute("email");
             ResultSet rs = stm.executeQuery("select * from vesti where idvesti="+idvesti+" and idkategorija="+idkategorija);
            if(rs.next()){
                //update
                stm.executeUpdate("update vesti set tekst='"+tekst+"', vreme="+vreme);
                FacesContext context = FacesContext.getCurrentInstance();
context.addMessage( null, new FacesMessage( "Azurirana vest" )); 
            }
            else{
                //insert
                stm.executeUpdate("insert into vesti (idkategorija,autor,vreme,tekst,tip_autora,vidljivost) values ('"+idkategorija+"','"+autor+"',"+vreme+",'"+tekst+"',"+tip_autora+","+vidljivost+")");
            FacesContext context = FacesContext.getCurrentInstance();
context.addMessage( null, new FacesMessage( "Uspesno" )); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(DodajVestVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return"vestiVolonter";
    }
}
