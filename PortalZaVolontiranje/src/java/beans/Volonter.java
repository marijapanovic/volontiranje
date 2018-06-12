
package beans;



import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;



import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;


public class Volonter implements Serializable {

    public static final String UPLOAD_DIRECTORY = "c:/upload";
     
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
    private Boolean JPzdravstveni_problemi;
    
    private String imeKompanije;
    private String sedisteKompanije;
    private String pozicijaUKompaniji;
    private boolean JPdani;

    private String nazivSkole;
    private int skolaid;
    private String nivoSkolovanja;
    private String godinaUpisa;
    private String mestoSkole;
    
    private int vestineid;
    private int oblastid;
    private String nazivVestine;
    private Boolean JPoblasti;
    private Boolean JPvestine;
    private String iskustva;
    private String diplome;
    private String nazivOblasti;

    public String getNazivOblasti() {
        return nazivOblasti;
    }

    public void setNazivOblasti(String nazivOblasti) {
        this.nazivOblasti = nazivOblasti;
    }
    
    
    
    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getMestoSkole() {
        return mestoSkole;
    }

    public void setMestoSkole(String mestoSkole) {
        this.mestoSkole = mestoSkole;
    }
    
    
    
    public String getIskustva() {
        return iskustva;
    }

    public void setIskustva(String iskustva) {
        this.iskustva = iskustva;
    }

    public String getNazivSkole() {
        return nazivSkole;
    }

    public void setNazivSkole(String nazivSkole) {
        this.nazivSkole = nazivSkole;
    }
    
    
    
    

    public Volonter() {
    }

    public Volonter(int idVolonter, String imePrezime, Date datumRodjenja, char pol, int drzavljanstvoID, String telefon, String ulica_broj, int mesto, String slika, String cv, String email, String lozinka, String status, int statusID, Boolean JPime, Boolean JPdatum_rodjenja, Boolean JPpol, Boolean JPdrzavljanstvo, Boolean JPtelefon, Boolean JPulica_broj, Boolean JPmesto, Boolean JPslika, Boolean JPcv, Boolean JPstatus, int Aktivan, int Tip, String zdravstveni_problemi, String imeKompanije, String sedisteKompanije, String pozicijaUKompaniji, boolean JPdani, int skolaid, int vestineid, int oblastid, Boolean JPzdravstveni_problemi, Boolean JPoblasti, Boolean JPvestine, String nivoSkolovanja, String nazivObrazovneInstitucije, String sedisteSkole, String godinaUpisa) {
        this.idVolonter = idVolonter;
        this.imePrezime = imePrezime;
        this.datumRodjenja = datumRodjenja;
        this.pol = pol;
        this.drzavljanstvoID = drzavljanstvoID;
        this.telefon = telefon;
        this.ulica_broj = ulica_broj;
        this.mesto = mesto;
        this.slika = slika;
        this.cv = cv;
        this.email = email;
        this.lozinka = lozinka;
        this.status = status;
        this.statusID = statusID;
        this.JPime = JPime;
        this.JPdatum_rodjenja = JPdatum_rodjenja;
        this.JPpol = JPpol;
        this.JPdrzavljanstvo = JPdrzavljanstvo;
        this.JPtelefon = JPtelefon;
        this.JPulica_broj = JPulica_broj;
        this.JPmesto = JPmesto;
        this.JPslika = JPslika;
        this.JPcv = JPcv;
        this.JPstatus = JPstatus;
        this.Aktivan = Aktivan;
        this.Tip = Tip;
        this.zdravstveni_problemi = zdravstveni_problemi;
        this.imeKompanije = imeKompanije;
        this.sedisteKompanije = sedisteKompanije;
        this.pozicijaUKompaniji = pozicijaUKompaniji;
        this.JPdani = JPdani;
        this.skolaid = skolaid;
        this.vestineid = vestineid;
        this.oblastid = oblastid;
        this.JPzdravstveni_problemi = JPzdravstveni_problemi;
        this.JPoblasti = JPoblasti;
        this.JPvestine = JPvestine;
        this.nivoSkolovanja = nivoSkolovanja;
        this.godinaUpisa = godinaUpisa;
    }

    
    
    
    public String getNivoSkolovanja() {
        return nivoSkolovanja;
    }

    public void setNivoSkolovanja(String nivoSkolovanja) {
        this.nivoSkolovanja = nivoSkolovanja;
    }


    public String getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(String godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }
    
    

    public String getSedisteKompanije() {
        return sedisteKompanije;
    }

    public void setSedisteKompanije(String sedisteKompanije) {
        this.sedisteKompanije = sedisteKompanije;
    }

    public String getPozicijaUKompaniji() {
        return pozicijaUKompaniji;
    }

    public void setPozicijaUKompaniji(String pozicijaUKompaniji) {
        this.pozicijaUKompaniji = pozicijaUKompaniji;
    }

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

    public int getSkolaid() {
        return skolaid;
    }

    public void setSkolaid(int skolaid) {
        this.skolaid = skolaid;
    }

    public int getVestineid() {
        return vestineid;
    }

    public void setVestineid(int vestineid) {
        this.vestineid = vestineid;
    }

    public int getOblastid() {
        return oblastid;
    }

    public void setOblastid(int oblastid) {
        this.oblastid = oblastid;
    }

    public Boolean getJPzdravstveni_problemi() {
        return JPzdravstveni_problemi;
    }

    public void setJPzdravstveni_problemi(Boolean JPzdravstveni_problemi) {
        this.JPzdravstveni_problemi = JPzdravstveni_problemi;
    }

    public Boolean getJPoblasti() {
        return JPoblasti;
    }

    public void setJPoblasti(Boolean JPoblasti) {
        this.JPoblasti = JPoblasti;
    }

    public Boolean getJPvestine() {
        return JPvestine;
    }

    public void setJPvestine(Boolean JPvestine) {
        this.JPvestine = JPvestine;
    }
    
    public StreamedContent getSlikaSadrzajFajla() {
        if (this.slika != null) {
            FileInputStream slikaStream = null;
            try {
                File slikaFajl = new File(UPLOAD_DIRECTORY, this.slika);
                slikaStream = new FileInputStream(slikaFajl);
                return new DefaultStreamedContent(new ByteArrayInputStream(IOUtils.toByteArray(slikaStream)));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Volonter.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Volonter.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if (slikaStream != null) {
                        slikaStream.close();
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Volonter.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public String getNazivVestine() {
        return nazivVestine;
    }

    public void setNazivVestine(String nazivVestine) {
        this.nazivVestine = nazivVestine;
    }
    
}
