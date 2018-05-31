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

    private int admin_id;
    private String email;
    private String lozinka;
    private String imePrezime;
    private String errorEmail;
    private String errorPassword;

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
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

    public Admin logAdmin;

    public Admin getLogAdmin() {
        return logAdmin;
    }

    public void setLogAdmin(Admin logAdmin) {
        this.logAdmin = logAdmin;
    }

    public String loginAdminNew() {

        try {
            errorEmail = "";
            errorPassword = "";
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm1 = conn.createStatement();
            ResultSet rsa = stm1.executeQuery("select * from volonteri.admin where email='" + email + "'");
            if (!rsa.next()) {
                errorEmail = "Ne postoji korisnicko ime";
                return errorEmail;
            } else {
                if (rsa.getString("lozinka").equals(lozinka)) {
                    HttpSession sesija1 = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                    logAdmin = new Admin();
                    logAdmin.setEmail(rsa.getString("email"));
                    logAdmin.setLozinka(rsa.getString("lozinka"));
                    logAdmin.setImePrezime(rsa.getString("imePrezime"));
                    logAdmin.setAdmin_id(rsa.getInt("admin_id"));
                    sesija1.setAttribute("admin", logAdmin);
                    return "admin_ulogovan?faces-redirect=true";
                } else {
                    errorPassword = "Pogresna lozinka";
                    return errorPassword;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
