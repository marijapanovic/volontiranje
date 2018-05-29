/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Drzavljanstvo;
import beans.Mesto;
import beans.Status;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author Korisnik
 */
@ManagedBean
@SessionScoped
public class AzuriranjeProfilaVolonter {
    //  private String imePrezime;

    private Boolean jpIme;
    //  private Date datumRodjenja;
    private Boolean jpDatumRodjenja;
    //  private String pol;
    private Boolean jpPol;
    private SelectItem drzavljanstvo;
    private Boolean jpDrzavljanstvo;
    private String drzavljanstvoDrugo;
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
    private String status;
    private Boolean jpStatus;
    private String kompanija;
    private String sedisteKompanije;
    private String pozicijaUKompaniji;
    private String nazivSkole;
    private String sedisteSkole;
    private String nivoStudija;
    private String godinaUpisa;
    private Integer[] odgovarajuciDani;
    private Boolean jpOdovarajuciDani;

    private String vestine;
    private Boolean jpVestine;
    private String vestineNaziv;
    private String vestineZvanje;
    private String vestineOstalo;
    private String vestineIskustva;
    private String zdravstveneNapomene;
    private Boolean jpZdravstveneNapomene;
    
  
    
    
    
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

    public SelectItem getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(SelectItem drzavljanstvo) {
        this.drzavljanstvo = drzavljanstvo;
    }

    public Boolean getJpDrzavljanstvo() {
        return jpDrzavljanstvo;
    }

    public void setJpDrzavljanstvo(Boolean jpDrzavljanstvo) {
        this.jpDrzavljanstvo = jpDrzavljanstvo;
    }

    public String getDrzavljanstvoDrugo() {
        return drzavljanstvoDrugo;
    }

    public void setDrzavljanstvoDrugo(String drzavljanstvoDrugo) {
        this.drzavljanstvoDrugo = drzavljanstvoDrugo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public Boolean getJpTelefon() {
        return jpTelefon;
    }

    public void setJpTelefon(Boolean jpTelefon) {
        this.jpTelefon = jpTelefon;
    }

    public String getUlica_broj() {
        return ulica_broj;
    }

    public void setUlica_broj(String ulica_broj) {
        this.ulica_broj = ulica_broj;
    }

    public Boolean getJpAdresa() {
        return jpAdresa;
    }

    public void setJpAdresa(Boolean jpAdresa) {
        this.jpAdresa = jpAdresa;
    }

    public Integer getMesto() {
        return mesto;
    }

    public void setMesto(Integer mesto) {
        this.mesto = mesto;
    }

    public Boolean getJpMesto() {
        return jpMesto;
    }

    public void setJpMesto(Boolean jpMesto) {
        this.jpMesto = jpMesto;
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

    public Boolean getJpSlika() {
        return jpSlika;
    }

    public void setJpSlika(Boolean jpSlika) {
        this.jpSlika = jpSlika;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Boolean getJpCv() {
        return jpCv;
    }

    public void setJpCv(Boolean jpCv) {
        this.jpCv = jpCv;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getJpStatus() {
        return jpStatus;
    }

    public void setJpStatus(Boolean jpStatus) {
        this.jpStatus = jpStatus;
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

    

    public Boolean getJpOdovarajuciDani() {
        return jpOdovarajuciDani;
    }

    public void setJpOdovarajuciDani(Boolean jpOdovarajuciDani) {
        this.jpOdovarajuciDani = jpOdovarajuciDani;
    }

    public String getVestine() {
        return vestine;
    }

    public void setVestine(String vestine) {
        this.vestine = vestine;
    }

    public Boolean getJpVestine() {
        return jpVestine;
    }

    public void setJpVestine(Boolean jpVestine) {
        this.jpVestine = jpVestine;
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

    public String getZdravstveneNapomene() {
        return zdravstveneNapomene;
    }

    public void setZdravstveneNapomene(String zdravstveneNapomene) {
        this.zdravstveneNapomene = zdravstveneNapomene;
    }

    public Boolean getJpZdravstveneNapomene() {
        return jpZdravstveneNapomene;
    }

    public void setJpZdravstveneNapomene(Boolean jpZdravstveneNapomene) {
        this.jpZdravstveneNapomene = jpZdravstveneNapomene;
    }
    
    private List<Mesto> svaMesta2;

    public List<Mesto> getSvaMesta2() {
        return svaMesta2;
    }

    public void setSvaMesta2(List<Mesto> svaMesta2) {
        this.svaMesta2 = svaMesta2;
    }
   private Mesto selektovanoMesto;

    public Mesto getSelektovanoMesto() {
        return selektovanoMesto;
    }

    public void setSelektovanoMesto(Mesto selektovanoMesto) {
        this.selektovanoMesto = selektovanoMesto;
    }
   
    private List<Drzavljanstvo> svaDrzavljanstva2;

    public List<Drzavljanstvo> getSvaDrzavljanstva2() {
        return svaDrzavljanstva2;
    }

    public void setSvaDrzavljanstva2(List<Drzavljanstvo> svaDrzavljanstva2) {
        this.svaDrzavljanstva2 = svaDrzavljanstva2;
    }
    
    private Drzavljanstvo selektovanoDrzavljanstvo;

    public Drzavljanstvo getSelektovanoDrzavljanstvo() {
        return selektovanoDrzavljanstvo;
    }

    public void setSelektovanoDrzavljanstvo(Drzavljanstvo selektovanoDrzavljanstvo) {
        this.selektovanoDrzavljanstvo = selektovanoDrzavljanstvo;
    }
    
    
    
    public List<Mesto> dohvatiMesta(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from tblgrad");
            svaMesta2 = new ArrayList<Mesto>();
            while(rs.next()){
                Mesto mesto2 = new Mesto();
                mesto2.setId(rs.getInt("id"));
                mesto2.setNazivMesta(rs.getString("naziv_mesta"));
                mesto2.setPostanski_broj(rs.getInt("postanski_broj"));
                mesto2.setOkrug(rs.getString("okrug"));
                mesto2.setOpstina(rs.getString("opstina"));
                
                svaMesta2.add(mesto2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svaMesta2;
    }
    
     public List<Drzavljanstvo> dohvatiDrzavljanstva(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from drzavljanstvo");
            svaDrzavljanstva2 = new ArrayList<Drzavljanstvo>();
            while(rs.next()){
                Drzavljanstvo drzavljanstvo2 = new Drzavljanstvo();
                drzavljanstvo2.setIddrz(rs.getInt("iddrz"));
                drzavljanstvo2.setDrzavljanstvo(rs.getString("drzavljanstvo"));
                svaDrzavljanstva2.add(drzavljanstvo2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return svaDrzavljanstva2;
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
        AzuriranjeProfilaVolonter.daniUNedelji = daniUNedelji;
    }

    public Integer[] getOdgovarajuciDani() {
        return odgovarajuciDani;
    }

    public void setOdgovarajuciDani(Integer[] odgovarajuciDani) {
        this.odgovarajuciDani = odgovarajuciDani;
    }

    public List<SelectItem> dohvatiStatuse() {
        List<SelectItem> statusi = new LinkedList<>();
        for (Map.Entry<Integer, String> statusEntry : Status.statusi.entrySet()) {
            statusi.add(new SelectItem(statusEntry.getKey(), statusEntry.getValue()));
        }
        return statusi;
    }
     
     
    public void azurirajProfil() {
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from volonter where email = '" + mail + "'");
            rs.next();
            stm.executeUpdate("update volonter, raspolozivost, skola, zaposlenje, vestine set "
                    + "volonter.jpime=" + jpIme + ", volonter.jpdatum_rodjenja=" + jpDatumRodjenja + ", volonter.jppol=" + jpPol
                    + ", volonter.jpdrzavljanstvo=" + jpDrzavljanstvo + ", volonter.telefon='" + telefon + "', volonter.jptelefon="
                    + jpTelefon + ", volonter.ulica_broj='" + ulica_broj + "' , volonter.jpulica_broj=" + jpAdresa + ", volonter.jpmesto=" + jpMesto + ", volonter.lozinka='"
                    + lozinka + "', volonter.slika='" + slika + "', volonter.jpslika=" + jpSlika + ", volonter.cv='" + cv + "', volonter.jpcv=" + jpCv +
                    ", volonter.status="+ status + ", volonter.jpstatus=" + jpStatus + ", volonter.zdravstveni_problemi='" + zdravstveneNapomene +"', "
                    + "', volonter.mesto_id= " + selektovanoMesto.getId() + ", volonter.drzavljanstvo_id= " + selektovanoDrzavljanstvo.getIddrz() + ", raspolozivost.iddana=" + odgovarajuciDani + ", skola.naziv='"+nazivSkole 
                    +"', skola.mesto='" + sedisteSkole + "', skola.nivo='" + nivoStudija + "', skola.godina_upisa='" + godinaUpisa +"', zaposlenje.kompanija='" + kompanija +"',"
                    + " zaposlenje.sediste='" + sedisteKompanije + "', zaposlenje.pozicija='" + pozicijaUKompaniji + "', vestine.naziv='" + vestineNaziv + "', vestine.struka= '" + vestineZvanje + "', vestine.iskustva='"
                    + vestineIskustva + "' where volonter.email='" + mail + "' and volonter.idvolonter = raspolozivost.idvolontera and volonter.idvolonter=raspolozivost.idvolontera and "
                            + "volonter.idvolonter=skola.idvolont and volonter.idvolonter = zaposlenje.idvolonter and volonter.idvolonter = vestine.idvolonter" );

//            stm.executeUpdate("update volonter set jpime="+ jpIme+ ", jpdatum_rodjenja="+ jpDatumRodjenja + ", jppol="+ jpPol + ", drzavljanstvo_id="+
//                    drzavljanstvo + ", jpdrzavljanstvo="+ jpDrzavljanstvo+", telefon='"+ telefon + "', jptelefon="+ jpTelefon + ", ulica_broj='" + 
//                    ulica_broj + "', jpulica_broj="+ jpAdresa+ ", mesto_id="+ mesto + ", jpmesto="+ jpMesto+ ", email='"+ mail + "', lozinka='"+
//                    lozinka + ", slika='"+ slika + "', jpslika="+ jpSlika + ", cv="+ cv + "', jpcv="+ jpCv+ ", status="+ status + ", jpstatus="+
//                    jpStatus + ", kompanija='"+ kompanija + "', sediste='"+ sedisteKompanije + "', pozicija='"+ pozicijaUKompaniji + "', naziv='"+ 
//                    nazivSkole + "', mesto='"+ sedisteSkole + "', nivo='"+ nivoStudija + "', godina_upisa='"+ godinaUpisa + "', " );
//            
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
