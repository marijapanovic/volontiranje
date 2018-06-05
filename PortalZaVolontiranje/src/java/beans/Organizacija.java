
package beans;

/**
 *
 * @author Korisnik
 */
public class Organizacija {
    private String naziv;
    private Mesto mestoId;
    private int mesto;
    private int pib;
    private String email;
    private String text;
    private String ulica_broj;
    private OblastDelovanja oblastDelovanja;
    private String lozinka;
    private int idOrganizacija;
    private String webAdresa;
    private String telefon;
    private int Tip;
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

    public int getIdOrganizacija() {
        return idOrganizacija;
    }

    public void setIdOrganizacija(int idOrganizacija) {
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

    public int getTip() {
        return Tip;
    }

    public void setTip(int Tip) {
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
