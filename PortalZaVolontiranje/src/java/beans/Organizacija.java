
package beans;

import java.io.Serializable;

/**
 *
 * @author Korisnik
 */
public class Organizacija implements Serializable{
    private Integer idOrganizacija;
    private String naziv;
    private Integer mestoId;
    private int pib;
    private String email;
    private String text;
    private String ulica_broj;
    private Integer idoblasti;
    private String lozinka;
    private String webAdresa;
    private String telefon;
    private Integer Tip;
    private Boolean jpNaziv;
    private Boolean jpMestoId;
    private Boolean jpPib;
    private Boolean jpText;
    private Boolean jpUlica_broj;
    private Boolean jpOblast_delovanja;
    private Boolean jpWebAdresa;
    private Boolean jpTelefon;
    private String mestoAzuriranje;

    public String getMestoAzuriranje() {
        return mestoAzuriranje;
    }

    public void setMestoAzuriranje(String mestoAzuriranje) {
        this.mestoAzuriranje = mestoAzuriranje;
    }
    
    
    public Organizacija(Integer idOrganizacija, String naziv, Integer mestoId, int pib, String email, String text, String ulica_broj, Integer idoblasti, String lozinka, String webAdresa, String telefon, Integer Tip, Boolean jpNaziv, Boolean jpMestoId, Boolean jpPib, Boolean jpText, Boolean jpUlica_broj, Boolean jpOblast_delovanja, Boolean jpWebAdresa, Boolean jpTelefon) {
        this.idOrganizacija = idOrganizacija;
        this.naziv = naziv;
        this.mestoId = mestoId;
        this.pib = pib;
        this.email = email;
        this.text = text;
        this.ulica_broj = ulica_broj;
        this.idoblasti = idoblasti;
        this.lozinka = lozinka;
        this.webAdresa = webAdresa;
        this.telefon = telefon;
        this.Tip = Tip;
        this.jpNaziv = jpNaziv;
        this.jpMestoId = jpMestoId;
        this.jpPib = jpPib;
        this.jpText = jpText;
        this.jpUlica_broj = jpUlica_broj;
        this.jpOblast_delovanja = jpOblast_delovanja;
        this.jpWebAdresa = jpWebAdresa;
        this.jpTelefon = jpTelefon;
    }

    public Organizacija() {
    }

    public String getNaziv() {
        return naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
     public Integer getMesto() {
        return mestoId;  
    }
    public void setMesto(Integer mesto) {
        this.mestoId = mesto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPib() {
        return pib;
    }

    public void setPib(int pib) {
        this.pib = pib;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Integer getIdOrganizacija() {
        return idOrganizacija;
    }

    public void setIdOrganizacija(Integer idOrganizacija) {
        this.idOrganizacija = idOrganizacija;
    }

    public String getWebAdresa() {
        return webAdresa;
    }

    public void setWebAdresa(String webAdresa) {
        this.webAdresa = webAdresa;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Integer getTip() {
        return Tip;
    }

    public void setTip(Integer Tip) {
        this.Tip = Tip;
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


      
}
