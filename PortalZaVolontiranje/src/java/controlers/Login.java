/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Volonter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Korisnik
 */
@ManagedBean
@SessionScoped
public class Login {

    private String email;
    private String lozinka;
    private String errorNeaktivan;
    private int idVolonter;
    private int aktivan;

    private String errorPassword = "";
    private String errorEmail = "";

    public String getErrorNeaktivan() {
        return errorNeaktivan;
    }

    public void setErrorNeaktivan(String errorNeaktivan) {
        this.errorNeaktivan = errorNeaktivan;
    }

    public int getIdVolonter() {
        return idVolonter;
    }

    public void setIdVolonter(int idVolonter) {
        this.idVolonter = idVolonter;
    }

    public int getAktivan() {
        return aktivan;
    }

    public void setAktivan(int aktivan) {
        this.aktivan = aktivan;
    }
    
    

    public String getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(String errorPassword) {
        this.errorPassword = errorPassword;
    }

    public String getErrorEmail() {
        return errorEmail;
    }

    public void setErrorEmail(String errorEmail) {
        this.errorEmail = errorEmail;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Volonter logInVolonter;

    public Volonter getLogInVolonter() {
        return logInVolonter;
    }

    public void setLogInVolonter(Volonter logInVolonter) {
        this.logInVolonter = logInVolonter;
    }

    public String login() {
        errorEmail = "";
        errorPassword = "";
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from volonter where email='" + email + "'");
            rs.next();
            aktivan=rs.getInt("Aktivan");
            if (aktivan == 0) {
               errorNeaktivan="Vas nalog jos nije aktiviran";
               return errorNeaktivan;
            } else {
                if (rs.getString("lozinka").equals(lozinka)) {
                    HttpSession sesija = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    logInVolonter = new Volonter();
                    logInVolonter.setIdVolonter(rs.getInt("idvolonter"));
                    logInVolonter.setEmail(rs.getString("email"));
                    logInVolonter.setImePrezime(rs.getString("ime_prezime"));
                    logInVolonter.setLozinka(rs.getString("lozinka"));
                    logInVolonter.setDatumRodjenja(rs.getDate("datum_rodjenja"));
                    logInVolonter.setDrzavljanstvoID(rs.getInt("drzavljanstvo"));
                    logInVolonter.setTelefon(rs.getString("telefon"));
                    logInVolonter.setUlica_broj(rs.getString("ulica_broj"));
                    logInVolonter.setMesto(rs.getInt("mesto"));
                    logInVolonter.setSlika(rs.getString("slika"));
                    logInVolonter.setCv(rs.getString("cv"));
                    logInVolonter.setStatusID(rs.getInt("zaposlen"));
                    logInVolonter.setJPime(rs.getBoolean("JPime"));
                    logInVolonter.setJPdatum_rodjenja(rs.getBoolean("JPdatum_rodjenja"));
                    logInVolonter.setJPpol(rs.getBoolean("JPpol"));
                    logInVolonter.setJPdrzavljanstvo(rs.getBoolean("JPdrzavljanstvo"));
                    logInVolonter.setJPtelefon(rs.getBoolean("JPtelefon"));
                    logInVolonter.setJPulica_broj(rs.getBoolean("JPulica_broj"));
                    logInVolonter.setJPmesto(rs.getBoolean("JPmesto"));
                    logInVolonter.setJPslika(rs.getBoolean("JPslika"));
                    logInVolonter.setJPcv(rs.getBoolean("JPcv"));
                    logInVolonter.setJPstatus(rs.getBoolean("JPstatus"));
                    logInVolonter.setAktivan(rs.getInt("Aktivan"));
                    logInVolonter.setTip(rs.getInt("Tip"));
                    logInVolonter.setZdravstveni_problemi(rs.getString("zdravstveni_problemi"));
                    sesija.setAttribute("volonter", logInVolonter);

                    return "index?faces-redirect=true";
                } else {
                    errorPassword = "Pogresna lozinka";
                    return errorPassword;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        //errorEmail = "Ne postoji korisnicko ime";
        //return errorEmail;
        return null; 
    }

}
