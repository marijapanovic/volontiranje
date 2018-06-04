/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Mesto;
import beans.OblastDelovanja;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Korisnik
 */
@ManagedBean
@ViewScoped
public class RegistracijaOrganizacija {
   private String naziv;
    private Mesto mestoId;
    private String email;
    private String ulica_broj;
    private OblastDelovanja oblastDelovanja;
    private String lozinka;

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Mesto getMestoId() {
        return mestoId;
    }

    public void setMestoId(Mesto mestoId) {
        this.mestoId = mestoId;
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

    public OblastDelovanja getOblastDelovanja() {
        return oblastDelovanja;
    }

    public void setOblastDelovanja(OblastDelovanja oblastDelovanja) {
        this.oblastDelovanja = oblastDelovanja;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
}
