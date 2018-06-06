/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Mesto;
import beans.OblastDelovanja;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import beans.TipNaloga;
import controlers.greske.GreskaPriRegistraciji;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@ManagedBean
@ViewScoped
public class RegistracijaOrganizacija {

    private String naziv;
    private int mesto;
    private String email;
    private String ulica_broj;
    private Integer idoblasti;
    private String lozinka;
    private Integer pib;
    private String telefon;
    private String text;
    private String webAdresa;
    private Boolean jpNaziv;
    private Boolean jpMestoId;
    private Boolean jpPib;
    private Boolean jpText;
    private Boolean jpUlica_broj;
    private Boolean jpOblast_delovanja;
    private Boolean jpWebAdresa;
    private Boolean jpTelefon;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

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

    public String getUlica_broj() {
        return ulica_broj;
    }

    public void setUlica_broj(String ulica_broj) {
        this.ulica_broj = ulica_broj;
    }

    public Integer getIdoblasti() {
        return idoblasti;
    }

    public void setIdoblasti(Integer idoblasti) {
        this.idoblasti = idoblasti;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Integer getPib() {
        return pib;
    }

    public void setPib(Integer pib) {
        this.pib = pib;
    }

    public Boolean getJpNaziv() {
        return jpNaziv;
    }

    public void setJpNaziv(Boolean jpNaziv) {
        this.jpNaziv = jpNaziv;
    }

    public Boolean getJpMestoId() {
        return jpMestoId;
    }

    public void setJpMestoId(Boolean jpMestoId) {
        this.jpMestoId = jpMestoId;
    }

    public Boolean getJpPib() {
        return jpPib;
    }

    public void setJpPib(Boolean jpPib) {
        this.jpPib = jpPib;
    }

    public Boolean getJpText() {
        return jpText;
    }

    public void setJpText(Boolean jpText) {
        this.jpText = jpText;
    }

    public Boolean getJpUlica_broj() {
        return jpUlica_broj;
    }

    public void setJpUlica_broj(Boolean jpUlica_broj) {
        this.jpUlica_broj = jpUlica_broj;
    }

    public Boolean getJpOblast_delovanja() {
        return jpOblast_delovanja;
    }

    public void setJpOblast_delovanja(Boolean jpOblast_delovanja) {
        this.jpOblast_delovanja = jpOblast_delovanja;
    }

    public Boolean getJpWebAdresa() {
        return jpWebAdresa;
    }

    public void setJpWebAdresa(Boolean jpWebAdresa) {
        this.jpWebAdresa = jpWebAdresa;
    }

    public Boolean getJpTelefon() {
        return jpTelefon;
    }

    public void setJpTelefon(Boolean jpTelefon) {
        this.jpTelefon = jpTelefon;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWebAdresa() {
        return webAdresa;
    }

    public void setWebAdresa(String webAdresa) {
        this.webAdresa = webAdresa;
    }

    private List<SelectItem> svaMesta = new LinkedList<>();

    public List<SelectItem> getSvaMesta() {
        return svaMesta;
    }
    private List<SelectItem> sveOblasti = new LinkedList<>();

    public List<SelectItem> getSveOblasti() {
        return sveOblasti;
    }
    
    @PostConstruct
    public void init() {
        List<Mesto> svaMestaBinovi = Mesto.ucitajSvaMesta();
        for (Mesto mesto : svaMestaBinovi) {
            svaMesta.add(new SelectItem(mesto.getId(), mesto.getNazivMesta()));
        }

        List<OblastDelovanja> sveOblastiBinovi = OblastDelovanja.ucitajSveOblasti();
        for (OblastDelovanja oblastDelovanja : sveOblastiBinovi) {
            sveOblasti.add(new SelectItem(oblastDelovanja.getIdoblasti(), oblastDelovanja.getNaziv_oblasti()));
        }
    }

    public String registrujOrganizaciju() throws GreskaPriRegistraciji, SQLException {
        Connection conn;
        try {
            conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            PreparedStatement preparedstatement = conn.prepareStatement("select count(*) as br_naloga from organizacija "
                    + "where email = ?");
            preparedstatement.setString(1, email);
            ResultSet resultset = preparedstatement.executeQuery();
            resultset.next();
            if (resultset.getInt("br_naloga") > 0) {
                return "Email vec postoji u bazi";
            } else {
                preparedstatement = conn.prepareStatement("insert into organizacija(naziv, mesto_id, pib, email, tekst, oblast_id"
                        + "web_adresa, lozinka, tip, ulica_broj, kontakt_tel,"
                        + " JPnaziv, JPmesto_id, JPpib, JPtext, JPoblast_id, JPweb_adresa, JPulica_broj, JPkontakt_tel) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                preparedstatement.setString(1, naziv);
                preparedstatement.setInt(2, mesto);
                preparedstatement.setInt(3, pib);
                preparedstatement.setString(4, email);
                preparedstatement.setString(5, text);
                preparedstatement.setInt(6, idoblasti);
                preparedstatement.setString(7, webAdresa);
                preparedstatement.setString(8, lozinka);
                preparedstatement.setInt(9, TipNaloga.ORGANIZACIJA);
                preparedstatement.setString(10, ulica_broj);
                preparedstatement.setString(11, telefon);
                preparedstatement.setBoolean(12, jpNaziv);
                preparedstatement.setBoolean(13, jpMestoId);
                preparedstatement.setBoolean(14, jpPib);
                preparedstatement.setBoolean(15, jpText);
                preparedstatement.setBoolean(16, jpOblast_delovanja);
                preparedstatement.setBoolean(17, jpWebAdresa);
                preparedstatement.setBoolean(18, jpUlica_broj);
                preparedstatement.setBoolean(19, jpTelefon);
                preparedstatement.executeUpdate();

            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistracijaOrganizacija.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Uspesno ste se registrovali."));
        return "ulogovana_organizacija";
    }
}
