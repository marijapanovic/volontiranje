
package beans;

/**
 *
 * @author Korisnik
 */
public class Organizacija {
    private Integer idOrganizacija;
    private String naziv;
    private Mesto mestoId;
    private Integer mesto;
    private Integer pib;
    private String email;
    private String text;
    private String ulica_broj;
    private OblastDelovanja naziv_oblasti;
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
    
    public String getNaziv() {
        return naziv;
    }
    
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }
     public Integer getMesto() {
        return mesto;  
    }
    public void setMesto(Integer mesto) {
        this.mesto = mesto;
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

    public Integer getPib() {
        return pib;
    }

    public void setPib(Integer pib) {
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

    public OblastDelovanja getNaziv_oblasti() {
        return naziv_oblasti;
    }

    public void setNaziv_oblasti(OblastDelovanja naziv_oblasti) {
        this.naziv_oblasti = naziv_oblasti;
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
