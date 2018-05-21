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
    private String errorPassword="";
    private String errorEmail="";

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
        errorEmail="";
        errorPassword="";
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from volonter where email='" + email + "'");
            rs.next();
            if (rs.getString("lozinka").equals(lozinka)) {
                HttpSession sesija = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                sesija.setAttribute("email", email);
                logInVolonter = new Volonter();
                logInVolonter.setIdVolonter(rs.getInt("idvolonter"));
                logInVolonter.setEmail(rs.getString("email"));
                logInVolonter.setImePrezime(rs.getString("ime_prezime"));
                logInVolonter.setLozinka(rs.getString("lozinka"));
                
                return "index?faces-redirect=true";
            }else{
              errorPassword="Pogresna lozinka";
              return errorPassword;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        errorEmail="Ne postoji korisnicko ime";
        return errorEmail;
    }

}
