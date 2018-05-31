/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SRDJAN
 */
@ManagedBean
@SessionScoped

public class loginAdmin {
    private String email;
    private String lozinka;
    private String errorEmail;
    private String errorPassword;

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

    public String getErrorEmail() {
        return errorEmail;
    }

    public void setErrorEmail(String errorEmail) {
        this.errorEmail = errorEmail;
    }

    public String getErrorPassword() {
        return errorPassword;
    }

    public void setErrorPassword(String errorPassword) {
        this.errorPassword = errorPassword;
    }
    
    public Admin logInAdmin;

    public Admin getLogInAdmin() {
        return logInAdmin;
    }

    public void setLogInAdmin(Admin logInAdmin) {
        this.logInAdmin = logInAdmin;
    }

    

   
    
    public String loginAdmin() {
        
        try {
            errorEmail = "";
            errorPassword = "";
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from admin where email='" + email + "'");
            if (!rs.next()){
                errorEmail = "Ne postoji korisnicko ime";
                return errorEmail;
            }else{
                if (rs.getString("lozinka").equals(lozinka)) {
                    HttpSession sesija = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                   logInAdmin.setAdmin_id(rs.getInt("admin_id"));
                    logInAdmin.setEmail(rs.getString("mail"));
                    logInAdmin.setLozinka(rs.getString("lozinka"));
                    logInAdmin.setImePrezime(rs.getString("imePrezime"));
                    return "admin_ulogovan?faces-redirect=true";
                }else{
                    errorPassword="Pogresna lozinka";
                    return errorPassword;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
           return null; 
 }
    
}
