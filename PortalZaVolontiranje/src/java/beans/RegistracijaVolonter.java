
package beans;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;
 


public class RegistracijaVolonter {
    private String imePrezime;
    
    private String imeiprezime;
    private Date datumrodjenja;
    private boolean uslov;
    private String pol;
    private String drzavljanstvo;
    private String telefon;
    private String ulicaibroj;
    private String mesto;
    private String mail;
    private String lozinka;
    private String slika;
    private String cv;

    public String getImeiprezime() {
        return imeiprezime;
    }

    public void setImeiprezime(String imeiprezime) {
        this.imeiprezime = imeiprezime;
    }

    public Date getDatumrodjenja() {
        return datumrodjenja;
    }

    public void setDatumrodjenja(Date datumrodjenja) {
        this.datumrodjenja = datumrodjenja;
    }

    

    public boolean isUslov() {
        return uslov;
    }

    public void setUslov(boolean uslov) {
        this.uslov = uslov;
    }
    private static Map<String, String> polovi;
    static{
        polovi = new LinkedHashMap<String, String>();
        polovi.put("Zensko", "Z");
        polovi.put("Musko", "M");
        
    }
    

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }
    
    

    public Map<String, String> getPolovi() {
        return polovi;
    }

    public void setPolovi(Map<String, String> polovi) {
        RegistracijaVolonter.polovi = polovi;
    }

    public String getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(String drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return ulicaibroj;
    }

    public void setAdresa(String adresa) {
        this.ulicaibroj = adresa;
    }

    public String getUlicaibroj() {
        return ulicaibroj;
    }

    public void setUlicaibroj(String ulicaibroj) {
        this.ulicaibroj = ulicaibroj;
    }

    public String getMesto() {
        return mesto;
    }

    public void setMesto(String mesto) {
        this.mesto = mesto;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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

    public void RegistracijaVolontera(){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Uspesno ste se registrovali." ));
        
    }

}
