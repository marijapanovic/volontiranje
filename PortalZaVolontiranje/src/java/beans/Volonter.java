/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Date;

/**
 *
 * @author Korisnik
 */
public class Volonter {
    private int idVolonter;
    private String imePrezime;
    private Date datumRodjenja;
    private char pol;
    private Drzavljanstvo drzavljanstvo;
    private String telefon;
    private String ulica_broj;
    private int mestoId;
    private String slika;
    private String cv;
    private String email;
    private String lozinka;
    private Status status;

    public int getIdVolonter() {
        return idVolonter;
    }

    public void setIdVolonter(int idVolonter) {
        this.idVolonter = idVolonter;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public char getPol() {
        return pol;
    }

    public void setPol(char pol) {
        this.pol = pol;
    }

    public Drzavljanstvo getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(Drzavljanstvo drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getUlica_broj() {
        return ulica_broj;
    }

    public void setUlica_broj(String ulica_broj) {
        this.ulica_broj = ulica_broj;
    }

    public int getMestoId() {
        return mestoId;
    }

    public void setMestoId(int mestoId) {
        this.mestoId = mestoId;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
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
}
