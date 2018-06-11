package controlers;


import beans.Mesto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import beans.Drzavljanstvo;
import beans.OblastDelovanja;
import beans.Skola;
import beans.Status;
import beans.TipNaloga;
import beans.Vestine;
import beans.Volonter;

import controlers.greske.GreskaPriRegistraciji;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import java.sql.PreparedStatement;
import javax.faces.bean.ViewScoped;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.commons.io.IOUtils;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class RegistracijaVolonter {

    private String imePrezime;
    private Boolean jpIme;
    private Date datumRodjenja;
    private Boolean jpDatumRodjenja;
    private String pol;
    private Boolean jpPol;
    private Integer drzavljanstvo;
    private Boolean jpDrzavljanstvo;
    private String telefon;
    private Boolean jpTelefon;
    private String ulica_broj;
    private Boolean jpAdresa;
    private Integer mesto;
    private Boolean jpMesto;
    private String mail;
    private String lozinka;
    
    private Boolean jpSlika;
    private String cv;
    private Boolean jpCv;
    private Integer status;
    private Boolean jpStatus;
    private String kompanija;
    private String sedisteKompanije;
    private String pozicijaUKompaniji;
    
    
    private Integer[] odgovarajuciDani;
    private Boolean jpOdovarajuciDani;

    private String zdravstveneNapomene;
    private Boolean jpZdravstveneNapomene;
    private Integer skolaid;
    private String nivoStudija;
    private String godinaUpisa;
    
    private Integer idvestinesif;
    private Boolean jpVestine;
    private String vestineIskustva;
    private String vestineDiploma;
    
    private Integer idoblasti;
    private Boolean jpOblast_delovanja;

    
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

    private List<SelectItem> svaMesta = new LinkedList<>();

    public List<SelectItem> getSvaMesta() {
        return svaMesta;
    }

    private List<SelectItem> svaDrzavljanstva = new LinkedList<>();

    public List<SelectItem> getSvaDrzavljanstva() {
        return svaDrzavljanstva;
    }
    private List<SelectItem> sveSkole = new LinkedList<>();

    public List<SelectItem> getSveSkole() {
        return sveSkole;
    }
    
    public List<SelectItem> sveVestine = new LinkedList<>();

    public List<SelectItem> getSveVestine() {
        return sveVestine;
    }

    public void setSveVestine(List<SelectItem> sveVestine) {
        this.sveVestine = sveVestine;
    }
    
    private List<SelectItem> sveOblasti = new LinkedList<>();

    public List<SelectItem> getSveOblasti() {
        return sveOblasti;
    }
    
    @PostConstruct
    public void init() {
        List<Drzavljanstvo> svaDrzavljanstvaBinovi = Drzavljanstvo.ucitajSvaDrzavljanstva();

        for (Drzavljanstvo drzavljanstvo : svaDrzavljanstvaBinovi) {
            svaDrzavljanstva.add(new SelectItem(drzavljanstvo.getIddrz(), drzavljanstvo.getDrzavljanstvo()));
        }
        List<Mesto> svaMestaBinovi = Mesto.ucitajSvaMesta();
        for (Mesto mesto : svaMestaBinovi) {
            svaMesta.add(new SelectItem(mesto.getId(), mesto.getNazivMesta()));
        }
        
        List<Skola> sveSkoleBinovi = Skola.ucitajSveSkole();
        for(Skola skola: sveSkoleBinovi){
            sveSkole.add(new SelectItem(skola.getIdskolaSif(), skola.getNazivSkole()));
        }
        
        List<Vestine> sveVestineBinovi = Vestine.ucitajSveVestine();
        for(Vestine vestine: sveVestineBinovi){
            sveVestine.add(new SelectItem(vestine.getIdvestinesif(),vestine.getNaziv()));
        }
        
        List<OblastDelovanja> sveOblastiBinovi = OblastDelovanja.ucitajSveOblasti();
        for (OblastDelovanja oblastDelovanja : sveOblastiBinovi) {
            sveOblasti.add(new SelectItem(oblastDelovanja.getIdoblasti(), oblastDelovanja.getNaziv_oblasti()));
        }
    }

  

    public String getPol() {
        return pol;
    }

    public void setPol(String pol) {
        this.pol = pol;
    }

    private static Map<String, String> polovi;

    static {
        polovi = new LinkedHashMap<>();
        polovi.put("Zensko", "Z");
        polovi.put("Musko", "M");

    }

    public Map<String, String> getPolovi() {
        return polovi;
    }

    public void setPolovi(Map<String, String> polovi) {
        RegistracijaVolonter.polovi = polovi;
    }

    public Integer getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(Integer drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdresa() {
        return ulica_broj;
    }

    public void setAdresa(String adresa) {
        this.ulica_broj = adresa;
    }

    public String getUlicaibroj() {
        return ulica_broj;
    }

    public void setUlicaibroj(String ulicaibroj) {
        this.ulica_broj = ulicaibroj;
    }

    public Integer getMesto() {
        return mesto;
    }

    public void setMesto(Integer mesto) {
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

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Integer getStatus() {
        return status;
    }
    
    public List<SelectItem> getStatusi() {
        List<SelectItem> statusi = new LinkedList<>();
        for (Map.Entry<Integer, String> statusEntry : Status.statusi.entrySet()) {
            statusi.add(new SelectItem(statusEntry.getKey(), statusEntry.getValue()));
        }
        return statusi;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUlica_broj() {
        return ulica_broj;
    }

    public void setUlica_broj(String ulica_broj) {
        this.ulica_broj = ulica_broj;
    }

    public String getKompanija() {
        return kompanija;
    }

    public void setKompanija(String kompanija) {
        this.kompanija = kompanija;
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



    public String getNivoStudija() {
        return nivoStudija;
    }

    public void setNivoStudija(String nivoStudija) {
        this.nivoStudija = nivoStudija;
    }

    public String getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(String godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public static class Dan {

        private int brDana;

        public Dan(int broj) {
            this.brDana = broj;
        }

        public int getBrDana() {
            return brDana;
        }

        public String getImeDana() {
            DateFormatSymbols dfs = new DateFormatSymbols();
            String[] dani = dfs.getWeekdays();
            return dani[brDana];
        }
    }

    private static Dan[] daniUNedelji;

    static {
        daniUNedelji = new Dan[7];
        for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
            daniUNedelji[i - Calendar.SUNDAY] = new Dan(i);
        }
    }

    public Dan[] getDaniUNedelji() {
        return daniUNedelji;
    }

    public void setDaniUNedelji(Dan[] daniUNedelji) {
        RegistracijaVolonter.daniUNedelji = daniUNedelji;
    }

    public Integer[] getOdgovarajuciDani() {
        return odgovarajuciDani;
    }

    public void setOdgovarajuciDani(Integer[] odgovarajuciDani) {
        this.odgovarajuciDani = odgovarajuciDani;
    }

    public String getVestineDiploma() {
        return vestineDiploma;
    }

    public void setVestineDiploma(String vestineDiploma) {
        this.vestineDiploma = vestineDiploma;
    }

    public String getVestineIskustva() {
        return vestineIskustva;
    }

    public void setVestineIskustva(String vestineIskustva) {
        this.vestineIskustva = vestineIskustva;
    }


    public String getZdravstveneNapomene() {
        return zdravstveneNapomene;
    }

    public void setZdravstveneNapomene(String zdravstveneNapomene) {
        this.zdravstveneNapomene = zdravstveneNapomene;
    }
    

    public Boolean getJpIme() {
        return jpIme;
    }

    public void setJpIme(Boolean jpIme) {
        this.jpIme = jpIme;
    }

    public Boolean getJpDatumRodjenja() {
        return jpDatumRodjenja;
    }

    public void setJpDatumRodjenja(Boolean jpDatumRodjenja) {
        this.jpDatumRodjenja = jpDatumRodjenja;
    }

    public Boolean getJpPol() {
        return jpPol;
    }

    public void setJpPol(Boolean jpPol) {
        this.jpPol = jpPol;
    }

    public Boolean getJpDrzavljanstvo() {
        return jpDrzavljanstvo;
    }

    public void setJpDrzavljanstvo(Boolean jpDrzavljanstvo) {
        this.jpDrzavljanstvo = jpDrzavljanstvo;
    }

    public Boolean getJpTelefon() {
        return jpTelefon;
    }

    public void setJpTelefon(Boolean jpTelefon) {
        this.jpTelefon = jpTelefon;
    }

    public Boolean getJpAdresa() {
        return jpAdresa;
    }

    public void setJpAdresa(Boolean jpAdresa) {
        this.jpAdresa = jpAdresa;
    }

    public Boolean getJpMesto() {
        return jpMesto;
    }

    public void setJpMesto(Boolean jpMesto) {
        this.jpMesto = jpMesto;
    }

    public Boolean getJpSlika() {
        return jpSlika;
    }

    public void setJpSlika(Boolean jpSlika) {
        this.jpSlika = jpSlika;
    }

    public Boolean getJpCv() {
        return jpCv;
    }

    public void setJpCv(Boolean jpCv) {
        this.jpCv = jpCv;
    }

    public Boolean getJpStatus() {
        return jpStatus;
    }

    public void setJpStatus(Boolean jpStatus) {
        this.jpStatus = jpStatus;
    }

    public Boolean getJpOdovarajuciDani() {
        return jpOdovarajuciDani;
    }

    public void setJpOdovarajuciDani(Boolean jpOdovarajuciDani) {
        this.jpOdovarajuciDani = jpOdovarajuciDani;
    }

    public Boolean getJpVestine() {
        return jpVestine;
    }

    public void setJpVestine(Boolean jpVestine) {
        this.jpVestine = jpVestine;
    }

    public Boolean getJpZdravstveneNapomene() {
        return jpZdravstveneNapomene;
    }

    public void setJpZdravstveneNapomene(Boolean jpZdravstveneNapomene) {
        this.jpZdravstveneNapomene = jpZdravstveneNapomene;
    }

    public Integer getSkolaid() {
        return skolaid;
    }

    public void setSkolaid(Integer skolaid) {
        this.skolaid = skolaid;
    }

    public Integer getIdvestinesif() {
        return idvestinesif;
    }

    public void setIdvestinesif(Integer idvestinesif) {
        this.idvestinesif = idvestinesif;
    }

    public Integer getIdoblasti() {
        return idoblasti;
    }

    public void setIdoblasti(Integer idoblasti) {
        this.idoblasti = idoblasti;
    }

    public Boolean getJpOblast_delovanja() {
        return jpOblast_delovanja;
    }

    public void setJpOblast_delovanja(Boolean jpOblast_delovanja) {
        this.jpOblast_delovanja = jpOblast_delovanja;
    }
    
    private UploadedFile fileSlika;
 
    public UploadedFile getFileSlika() {
        return fileSlika;
    }
 
    public void setFileSlika(UploadedFile file) {
        this.fileSlika = file;
    }
     
    public String uploadSlika() {
        if(fileSlika != null) {
            
            try {
                String filename = fileSlika.getFileName();
                InputStream input = fileSlika.getInputstream();
                String fileNameSlika;
                fileNameSlika = mail + "_" + filename;
                OutputStream output = new FileOutputStream(new File(Volonter.UPLOAD_DIRECTORY, fileNameSlika));
                
                try {
                    IOUtils.copy(input, output);
                } finally {
                    input.close();
                    output.close();
                }
                
                FacesMessage message1 = new FacesMessage("Succesful", fileSlika.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message1);
                
            return fileNameSlika;
            } catch (IOException ex) {
                Logger.getLogger(RegistracijaVolonter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return fileSlika.getFileName();
    }
    
    private UploadedFile fileCv;

    public UploadedFile getFileCv() {
        return fileCv;
    }

    public void setFileCv(UploadedFile fileCv) {
        this.fileCv = fileCv;
    }
 
    
     
    public String uploadCv() {
        if(fileCv != null) {
            
            try {
                String filename = fileCv.getFileName();
                InputStream input = fileCv.getInputstream();
                String fileNameCv;
                fileNameCv = mail + "_" + filename;
                OutputStream output = new FileOutputStream(new File(Volonter.UPLOAD_DIRECTORY, fileNameCv));

                try {
                    IOUtils.copy(input, output);
                } finally {
                    input.close();
                    output.close();
                }
                
                FacesMessage message2 = new FacesMessage("Succesful", fileCv.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message2);
                
               return fileNameCv; 
            } catch (IOException ex) {
                Logger.getLogger(RegistracijaVolonter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    public String registrujVolontera() throws GreskaPriRegistraciji, SQLException {
        Connection conn;
        try {
            String slikaFileName = uploadSlika();
            String cvFileName = uploadCv();
            conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            PreparedStatement preparedstatement = conn.prepareStatement("select count(*) as br_naloga from volonter "
                    + "where email = ?");
            preparedstatement.setString(1, mail);
            ResultSet resultset = preparedstatement.executeQuery();
            resultset.next();
            if (resultset.getInt("br_naloga") > 0) {
                return "Email vec postoji u bazi";
            } else {
                preparedstatement = conn.prepareStatement("insert into volonter(ime_prezime, datum_rodjenja, pol, drzavljanstvo_id,"
                        + " telefon, ulica_broj, mesto_id, slika, cv, status, email, lozinka,  JPime, JPdatum_rodjenja, JPpol,"
                        + " JPdrzavljanstvo, JPtelefon, JPulica_broj, JPmesto, JPslika, JPcv, JPstatus, tip, Zdravstveni_problemi, "
                        + " vestineid, oblastiid,JPzdravstveniproblemi, JPoblasti, JPvestine, JPdan) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                preparedstatement.setString(1, imePrezime);
          
                java.sql.Date sqlDatumRodjenja = new java.sql.Date(datumRodjenja.getTime());
                preparedstatement.setDate(2,sqlDatumRodjenja);
                preparedstatement.setString(3, pol);
                preparedstatement.setInt(4, drzavljanstvo);
                preparedstatement.setString(5, telefon);
                preparedstatement.setString(6, ulica_broj);
                preparedstatement.setInt(7, mesto);
                preparedstatement.setString(8, slikaFileName );
                preparedstatement.setString(9, cvFileName);
                preparedstatement.setInt(10,status);
                preparedstatement.setString(11, mail);
                preparedstatement.setString(12, lozinka);
                preparedstatement.setBoolean(13, jpIme);
                preparedstatement.setBoolean(14, jpDatumRodjenja);
                preparedstatement.setBoolean(15, jpPol);
                preparedstatement.setBoolean(16,jpDrzavljanstvo);
                preparedstatement.setBoolean(17, jpTelefon);
                preparedstatement.setBoolean(18, jpAdresa);
                preparedstatement.setBoolean(19, jpMesto);
                preparedstatement.setBoolean(20, jpSlika);
                preparedstatement.setBoolean(21, jpCv);
                preparedstatement.setBoolean(22, jpStatus);
                preparedstatement.setInt(23, TipNaloga.VOLONTER);
                preparedstatement.setString(24, zdravstveneNapomene);
//                preparedstatement.setInt(25, skolaid);
//                preparedstatement.setString(26, kompanija);
                preparedstatement.setInt(25, idvestinesif);
                preparedstatement.setInt(26,idoblasti );
                preparedstatement.setBoolean(27, jpZdravstveneNapomene);
                preparedstatement.setBoolean(28, jpOblast_delovanja);
                preparedstatement.setBoolean(29, jpVestine);
                preparedstatement.setBoolean(30, jpOdovarajuciDani);
//                preparedstatement.setString(33, sedisteKompanije);
//                preparedstatement.setString(34, pozicijaUKompaniji);
//                preparedstatement.setString(35, godinaUpisa);
//                preparedstatement.setString(36, nivoStudija);

                preparedstatement.executeUpdate();
          
                
                preparedstatement = conn.prepareStatement("select idvolonter from volonter where email = ?");
                preparedstatement.setString(1, mail);
                resultset = preparedstatement.executeQuery();
                resultset.next();
                int idVolontera = resultset.getInt("idvolonter");
                preparedstatement = conn.prepareStatement("insert into raspolozivost (idvolontera, iddana) values (?, ?)");                
                for (Integer dan : odgovarajuciDani) {
                    preparedstatement.setInt(1, idVolontera);
                    preparedstatement.setInt(2, dan);
                    preparedstatement.executeUpdate();
                }
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistracijaVolonter.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Uspesno ste se registrovali."));
        return registrovaniVolonterStatus();
    }
    
    public String registrovaniVolonterStatus() throws GreskaPriRegistraciji, SQLException{
        
        Connection con;
        try {
            con = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            PreparedStatement preparedstatement;
            
            if (status == 1){
               preparedstatement = con.prepareStatement("update volonter set zaposlenjeid = ?, sediste_firme = ?, pozicijaufirmi = ? "
                       + "where email = ?");
               preparedstatement.setString(4, mail);
            
               preparedstatement.setString(1,kompanija);
               preparedstatement.setString(2, sedisteKompanije);
               preparedstatement.setString(3,pozicijaUKompaniji);
                
               preparedstatement.executeUpdate();
                
               return "ulogovani_volonter.xhtml";
            }
            else if (status == 3){
                preparedstatement = con.prepareStatement("update volonter set skola_id = ?, godinaupisa = ?, nivo_skole = ? "
                        + "where email = ?");
                
                preparedstatement.setInt(1, skolaid);
                preparedstatement.setString(2, godinaUpisa);
                preparedstatement.setString(3, nivoStudija);
                preparedstatement.setString(4, mail);
                preparedstatement.executeUpdate();
            }
            
          
        }   catch (SQLException ex) {
            Logger.getLogger(RegistracijaVolonter.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }
        return "ulogovani_volonter.xhtml";

    }
    

    
    
    
}
