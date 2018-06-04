
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
    

   
    
    
    
    
}
