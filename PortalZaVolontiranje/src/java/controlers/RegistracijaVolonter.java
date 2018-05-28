package controlers;


import beans.Mesto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;
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
import beans.Status;
import beans.TipNaloga;

import controlers.greske.GreskaPriRegistraciji;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.time.ZoneId;


@ManagedBean
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
    private String slika;
    private Boolean jpSlika;
    private String cv;
    private Boolean jpCv;
    private Integer status;
    private Boolean jpStatus;
    private String kompanija;
    private String sedisteKompanije;
    private String pozicijaUKompaniji;
    private String nazivSkole;
    private String sedisteSkole;
    private String nivoStudija;
    private String godinaUpisa;
    private String[] odgovarajuciDani;
    private Boolean jpOdovarajuciDani;
    
    private String vestine;
    private Boolean jpVestine;
    private String vestineNaziv;
    private String vestineZvanje;
    private String vestineOstalo;
    private String vestineIskustva;
    private String zdravstveneNapomene;
    private Boolean jpZdravstveneNapomene;
    private int idvolonter;
  
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

    public String getNazivSkole() {
        return nazivSkole;
    }

    public void setNazivSkole(String nazivSkole) {
        this.nazivSkole = nazivSkole;
    }

    public String getSedisteSkole() {
        return sedisteSkole;
    }

    public void setSedisteSkole(String sedisteSkole) {
        this.sedisteSkole = sedisteSkole;
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

    public String[] getOdgovarajuciDani() {
        return odgovarajuciDani;
    }

    public void setOdgovarajuciDani(String[] odgovarajuciDani) {
        this.odgovarajuciDani = odgovarajuciDani;
    }

   

    

    public String getVestineNaziv() {
        return vestineNaziv;
    }

    public void setVestineNaziv(String vestineNaziv) {
        this.vestineNaziv = vestineNaziv;
    }

    public String getVestineZvanje() {
        return vestineZvanje;
    }

    public void setVestineZvanje(String vestineZvanje) {
        this.vestineZvanje = vestineZvanje;
    }

    public String getVestineOstalo() {
        return vestineOstalo;
    }

    public void setVestineOstalo(String vestineOstalo) {
        this.vestineOstalo = vestineOstalo;
    }

    public String getVestineIskustva() {
        return vestineIskustva;
    }

    public void setVestineIskustva(String vestineIskustva) {
        this.vestineIskustva = vestineIskustva;
    }

    public String getVestine() {
        return vestine;
    }

    public void setVestine(String vestine) {
        this.vestine = vestine;
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
    
    

    

    public String registrujVolontera() throws GreskaPriRegistraciji, SQLException {
        Connection conn;
        try {
            conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            PreparedStatement preparedstatement = conn.prepareStatement("select count(*) as broj_naloga from volonter where email = ?");
            preparedstatement.setString(1, mail);
            ResultSet resultset = preparedstatement.executeQuery();
            resultset.next();
            if (resultset.getInt("broj_naloga") > 0) {
                return "Email vec postoji u bazi";
            } else {
                preparedstatement = conn.prepareStatement("insert into volonter(ime_prezime, datum_rodjenja, pol, drzavljanstvo_id,"
                        + " telefon, ulica_broj, mesto_id, slika, cv, email, lozinka, status, JPime, JPdatum_rodjenja, JPpol,"
                        + " JPdrzavljanstvo, JPtelefon, JPulica_broj, JPmesto, JPslika, JPcv, JPstatus, Zdravstveni_problemi, tip) "
                        + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                preparedstatement.setString(1, imePrezime);
                preparedstatement.setTimestamp(2, new Timestamp(datumRodjenja.toInstant().atZone(ZoneId.of( "Europe/Belgrade" )).toEpochSecond()));
                preparedstatement.setString(3, pol);
                preparedstatement.setInt(4, drzavljanstvo);
                preparedstatement.setString(5, telefon);
                preparedstatement.setString(6, ulica_broj);
                preparedstatement.setInt(7,mesto);
                preparedstatement.setString(8, slika);
                preparedstatement.setString(9, cv);
                preparedstatement.setString(10, mail);
                preparedstatement.setString(11, lozinka);
                preparedstatement.setInt(12, status);
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
                preparedstatement.setString(23, zdravstveneNapomene);
                preparedstatement.setInt(24, TipNaloga.VOLONTER);
                preparedstatement.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistracijaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Uspesno ste se registrovali."));
        return registrovaniVolonterStatus();
    }
    
    public String registrovaniVolonterStatus() throws GreskaPriRegistraciji, SQLException{
        
        Connection con;
        try {
            con = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            PreparedStatement preparedstatement = con.prepareStatement("select * from volonter where email = ?");
            preparedstatement.setString(1, mail);
            ResultSet resultset = preparedstatement.executeQuery();
            resultset.next();
            int idVolonter;
            
            idVolonter = resultset.getInt(idvolonter);
            if (resultset.getInt(status)== 1){
               preparedstatement = con.prepareStatement("insert into zaposlenje(idvolonter, kompanija, sediste,pozicija) "
                       + "values(?,?,?,?)");
            
               preparedstatement.setInt(1,idVolonter);
               preparedstatement.setString(2,kompanija);
               preparedstatement.setString(3, sedisteKompanije);
               preparedstatement.setString(4,pozicijaUKompaniji);
                
               preparedstatement.executeUpdate();
                
               return "volonter_login.xhtml";
            }
            else if (resultset.getInt(status)== 3){
                preparedstatement = con.prepareStatement("insert into skola(idvolonter, naziv, mesto, nivo, godina_upisa) "
                        + "value(?,?,?,?)");
                preparedstatement.setInt(1, idVolonter);
                preparedstatement.setString(2, nazivSkole);
                preparedstatement.setString(3, sedisteSkole);
                preparedstatement.setString(4, nivoStudija);
                preparedstatement.setString(5, godinaUpisa);
            }
            
          
        }   catch (SQLException ex) {
            Logger.getLogger(RegistracijaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return RegistrovaniVolonterVestine();

    }
    public String RegistrovaniVolonterVestine(){
        Connection con;
        
        try{
            con = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            PreparedStatement preparedstatement = con.prepareStatement("select * from volonter where email = ?");
            preparedstatement.setString(1, mail);
            int idVolonter = 0;
            ResultSet resultset = preparedstatement.executeQuery();
            resultset.next();
            if(resultset.getString(vestine)!= ""){
               preparedstatement = con.prepareStatement("insert into vestine(idvolonter,naziv, struka, iskustva) values(?,?,?,?)");
               preparedstatement.setInt(1,idVolonter);
               preparedstatement.setString(2,vestineNaziv);
               preparedstatement.setString(3, vestineZvanje);
               preparedstatement.setString(4, vestineIskustva);
               
               preparedstatement.executeUpdate();
            }
        
        } catch (SQLException ex) {
            Logger.getLogger(RegistracijaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ulogovani_volonter.xhtml";
    }
    
    
    
}
