/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;


//import java.sql.Date;
import java.io.Serializable;



import java.util.Date;


public class Volonter implements Serializable{
    private int idVolonter;
    private String imePrezime;
    private Date datumRodjenja;
    private char pol;
    private String drzavljanstvo;
    private int drzavljanstvoID;
    private String telefon;
    private String ulica_broj;
    private String mestoAzuriranje;
    private int mesto;
    private String slika;
    private String cv;
    private String email;
    private String lozinka;
    private String status;
    private int statusID;
    private Boolean JPime;
    private Boolean JPdatum_rodjenja;
    private Boolean JPpol;
    private Boolean JPdrzavljanstvo;
    private Boolean JPtelefon;
    private Boolean JPulica_broj;
    private Boolean JPmesto;
    private Boolean JPslika;
    private Boolean JPcv;
    private Boolean JPstatus;
    private int Aktivan;
    private int Tip;
    private String zdravstveni_problemi;
    private String imeKompanije;
    private boolean JPdani;

    public String getZdravstveni_problemi() {
        return zdravstveni_problemi;
    }
    public void setZdravstveni_problemi(String zdravstveni_problemi) {
        this.zdravstveni_problemi = zdravstveni_problemi;
    }
    public int getStatusID() {
        return statusID;
    }
    public void setStatusID(int statusID) {
        this.statusID = statusID;
    }
    
    public int getMesto() {
        return mesto;
    }
    public void setMesto(int mesto) {
        this.mesto = mesto;
    }
    public int getDrzavljanstvoID() {
        return drzavljanstvoID;
    }

    public void setDrzavljanstvoID(int drzavljanstvoID) {
        this.drzavljanstvoID = drzavljanstvoID;
    }
    public Boolean getJPime() {
        return JPime;
    }

    public void setJPime(Boolean JPime) {
        this.JPime = JPime;
    }

    public Boolean getJPdatum_rodjenja() {
        return JPdatum_rodjenja;
    }

    public void setJPdatum_rodjenja(Boolean JPdatum_rodjenja) {
        this.JPdatum_rodjenja = JPdatum_rodjenja;
    }

    public Boolean getJPpol() {
        return JPpol;
    }

    public void setJPpol(Boolean JPpol) {
        this.JPpol = JPpol;
    }

    public Boolean getJPdrzavljanstvo() {
        return JPdrzavljanstvo;
    }

    public void setJPdrzavljanstvo(Boolean JPdrzavljanstvo) {
        this.JPdrzavljanstvo = JPdrzavljanstvo;
    }

    public Boolean getJPtelefon() {
        return JPtelefon;
    }

    public void setJPtelefon(Boolean JPtelefon) {
        this.JPtelefon = JPtelefon;
    }

    public Boolean getJPulica_broj() {
        return JPulica_broj;
    }

    public void setJPulica_broj(Boolean JPulica_broj) {
        this.JPulica_broj = JPulica_broj;
    }

    public Boolean getJPmesto() {
        return JPmesto;
    }

    public void setJPmesto(Boolean JPmesto) {
        this.JPmesto = JPmesto;
    }

    public Boolean getJPslika() {
        return JPslika;
    }

    public void setJPslika(Boolean JPslika) {
        this.JPslika = JPslika;
    }

    public Boolean getJPcv() {
        return JPcv;
    }

    public void setJPcv(Boolean JPcv) {
        this.JPcv = JPcv;
    }

    public Boolean getJPstatus() {
        return JPstatus;
    }

    public void setJPstatus(Boolean JPstatus) {
        this.JPstatus = JPstatus;
    }

    public int getAktivan() {
        return Aktivan;
    }

    public void setAktivan(int Aktivan) {
        this.Aktivan = Aktivan;
    }

    public int getTip() {
        return Tip;
    }

    public void setTip(int Tip) {
        this.Tip = Tip;
    }
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

    public String getUlica_broj() {
        return ulica_broj;
    }

    public void setUlica_broj(String ulica_broj) {
        this.ulica_broj = ulica_broj;
    }

    public String getMestoAzuriranje() {
        return mestoAzuriranje;
    }

    public void setMestoAzuriranje(String mestoAzuriranje) {
        this.mestoAzuriranje = mestoAzuriranje;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImeKompanije() {
        return imeKompanije;
    }

    public void setImeKompanije(String imeKompanije) {
        this.imeKompanije = imeKompanije;
    }

    public boolean isJPdani() {
        return JPdani;
    }

    public void setJPdani(boolean JPdani) {
        this.JPdani = JPdani;
    }
    
    
    
}
