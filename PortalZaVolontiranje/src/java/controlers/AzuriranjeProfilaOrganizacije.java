/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Mesto;
import beans.Organizacija;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Korisnik
 */
@ManagedBean
@SessionScoped
public class AzuriranjeProfilaOrganizacije {
    
    private int mesto;
    private String email;
    private String tekst;
    private int oblasti;
    private String webAdresa;
    private String lozinka;
    private String ulicaIBroj;
    private String telefon;
    private boolean jpNaziv;
    private boolean jpMesto;
    private boolean jpPib;
    private boolean jpTekst;
    private boolean jpOblast;
    private boolean jpWebAdresa;
    private boolean jpUlicaIBroj;
    private boolean jpTelefon;

    public int getMesto() {
        return mesto;
    }

    public void setMesto(int mesto) {
        this.mesto = mesto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getOblasti() {
        return oblasti;
    }

    public void setOblasti(int oblasti) {
        this.oblasti = oblasti;
    }

    public String getWebAdresa() {
        return webAdresa;
    }

    public void setWebAdresa(String webAdresa) {
        this.webAdresa = webAdresa;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public String getUlicaIBroj() {
        return ulicaIBroj;
    }

    public void setUlicaIBroj(String ulicaIBroj) {
        this.ulicaIBroj = ulicaIBroj;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public boolean isJpNaziv() {
        return jpNaziv;
    }

    public void setJpNaziv(boolean jpNaziv) {
        this.jpNaziv = jpNaziv;
    }

    public boolean isJpMesto() {
        return jpMesto;
    }

    public void setJpMesto(boolean jpMesto) {
        this.jpMesto = jpMesto;
    }

    public boolean isJpPib() {
        return jpPib;
    }

    public void setJpPib(boolean jpPib) {
        this.jpPib = jpPib;
    }

    public boolean isJpTekst() {
        return jpTekst;
    }

    public void setJpTekst(boolean jpTekst) {
        this.jpTekst = jpTekst;
    }

    public boolean isJpOblast() {
        return jpOblast;
    }

    public void setJpOblast(boolean jpOblast) {
        this.jpOblast = jpOblast;
    }

    public boolean isJpWebAdresa() {
        return jpWebAdresa;
    }

    public void setJpWebAdresa(boolean jpWebAdresa) {
        this.jpWebAdresa = jpWebAdresa;
    }

    public boolean isJpUlicaIBroj() {
        return jpUlicaIBroj;
    }

    public void setJpUlicaIBroj(boolean jpUlicaIBroj) {
        this.jpUlicaIBroj = jpUlicaIBroj;
    }

    public boolean isJpTelefon() {
        return jpTelefon;
    }

    public void setJpTelefon(boolean jpTelefon) {
        this.jpTelefon = jpTelefon;
    }
    
    
    private static Organizacija organizacijaZaAzuriranje;

    public Organizacija getOrganizacijaZaAzuriranje() {
        return organizacijaZaAzuriranje;
    }

    public void setOrganizacijaZaAzuriranje(Organizacija organizacijaZaAzuriranje) {
        this.organizacijaZaAzuriranje = organizacijaZaAzuriranje;
    }

   
    
    
    
    public Organizacija dohvatiPodatkeOOrganizaciji(){
        try {
           Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select o.*, tg.*, obl.* from Organizacija o\n" +
"      left join oblasti obl on o.oblast_id = obl.idoblasti\n" +
"      left join tblgrad tg on o.mesto_id = tg.id \n" +
"       where email = 'novi@mail.com'");
            rs.next();
            organizacijaZaAzuriranje = new Organizacija();
            organizacijaZaAzuriranje.setEmail(rs.getString("email"));
            organizacijaZaAzuriranje.setLozinka(rs.getString("lozinka"));
            organizacijaZaAzuriranje.setIdOrganizacija(rs.getInt("idorganizacija"));
            organizacijaZaAzuriranje.setIdoblasti(rs.getInt("oblast_id"));
            organizacijaZaAzuriranje.setJpMestoId(rs.getBoolean("jpmesto_id"));
            organizacijaZaAzuriranje.setWebAdresa(rs.getString("web_adresa"));
            organizacijaZaAzuriranje.setUlica_broj(rs.getString("ulica_broj"));
            organizacijaZaAzuriranje.setTekst(rs.getString("tekst"));
            organizacijaZaAzuriranje.setPib(rs.getInt("pib"));
            organizacijaZaAzuriranje.setTelefon(rs.getString("kontakt_tel"));
            organizacijaZaAzuriranje.setNaziv(rs.getString("naziv"));
            organizacijaZaAzuriranje.setJpNaziv(rs.getBoolean("jpnaziv"));
            organizacijaZaAzuriranje.setJpPib(rs.getBoolean("jppib"));
            organizacijaZaAzuriranje.setJpTelefon(rs.getBoolean("jpkontakt_tel"));
            organizacijaZaAzuriranje.setJpOblast_delovanja(rs.getBoolean("jpoblast_id"));
            organizacijaZaAzuriranje.setJpTekst(rs.getBoolean("jptekst"));
            organizacijaZaAzuriranje.setJpWebAdresa(rs.getBoolean("jpweb_adresa"));
            organizacijaZaAzuriranje.setJpUlica_broj(rs.getBoolean("jpulica_broj"));
            organizacijaZaAzuriranje.setMestoAzuriranje(rs.getString("naziv_mesta"));
    //        organizacijaZaAzuriranje.setOblast(rs.getString("naziv_oblasti"));
            
            
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaOrganizacije.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return organizacijaZaAzuriranje; 
        
    }
    private List<Mesto> svaMestaZaAzuriranjeOrg;

    public List<Mesto> getSvaMestaZaAzuriranjeOrg() {
        return svaMestaZaAzuriranjeOrg;
    }

    public void setSvaMestaZaAzuriranjeOrg(List<Mesto> svaMestaZaAzuriranjeOrg) {
        this.svaMestaZaAzuriranjeOrg = svaMestaZaAzuriranjeOrg;
    }
    
    public List<Mesto> dohvatiSvaMestaZaAzuriranjeOrg(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select id, naziv_mesta from tblgrad ");
            svaMestaZaAzuriranjeOrg = new ArrayList<>();
            while(rs.next()){
                Mesto mesto = new Mesto();
                mesto.setId(rs.getInt("id"));
                mesto.setNazivMesta(rs.getString("naziv_mesta"));
                svaMestaZaAzuriranjeOrg.add(mesto);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaOrganizacije.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return svaMestaZaAzuriranjeOrg;
    }
    
    public void azurirajProfilOrganizacije(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from organizacija where email='"+AzuriranjeProfilaOrganizacije.organizacijaZaAzuriranje.getEmail()+"'");     //potrebno je dodati static kod organizacijazaazuriranje
            rs.next();
            
            stm.executeUpdate("update organizacija set mesto_id= "+mesto+", email= ' "+email+" ' , tekst= ' "+tekst+
                    " ' , web_adresa= ' "+webAdresa+" ' , lozinka= ' "+lozinka+" ' , ulica_broj= ' "+ ulicaIBroj+ " ' ,  kontakt_tel= ' "+
                    telefon+" ' , jpnaziv= "+jpNaziv+" , jpmesto_id= "+jpMesto+" , jptekst= "+jpTekst+" , jppib= "+jpPib+
                    " , jpoblast_id= "+jpOblast+" , jpweb_adresa= "+jpWebAdresa+" , jpulica_broj= "+jpUlicaIBroj+
                    " , jpkontakt_tel= "+jpTelefon);
            
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaOrganizacije.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
