/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Dan;
import beans.Drzavljanstvo;
import beans.Mesto;
import beans.OblastDelovanja;
import beans.Skola;
import beans.Status;
import beans.Vestine;
import beans.Volonter;
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
import javax.annotation.PostConstruct;
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
    private Integer mestoAzuriranje;
    private String nazivMesta;
    private Boolean jpMesto;
    private String mail;
    private String lozinka;
    private String slika;
    private Boolean jpSlika;
    private String cv;
    private Boolean jpCv;
    private int status;
    private Boolean jpStatus;
    private String kompanija;
    private String sedisteKompanije;
    private String pozicijaUKompaniji;
    private Integer nazivSkole;
    private String sedisteSkole;
    private String nivoStudija;
    private String godinaUpisa;
    //private Integer[] odgovarajuciDani;
    private Boolean jpOdovarajuciDani;

   private String vestine;
    private Boolean jpVestine;
    private String vestineNaziv;
    private String vestineZvanje;
    private String vestineOstalo;
    private String vestineIskustva;
    private String zdravstveneNapomene;
    private Boolean jpZdravstveneNapomene;
    
    private Integer idzaposlenja;
    private Integer idVestine;
    private String diplome;
    private String iskustva;
    private Integer idOblasti;
    private boolean oblastiDelovanja;

    public boolean isOblastiDelovanja() {
        return oblastiDelovanja;
    }

    public void setOblastiDelovanja(boolean oblastiDelovanja) {
        this.oblastiDelovanja = oblastiDelovanja;
    }
    
    
    
    public Integer getIdOblasti() {
        return idOblasti;
    }

    public void setIdOblasti(Integer idOblasti) {
        this.idOblasti = idOblasti;
    }
    
    
    
    public String getIskustva() {
        return iskustva;
    }

    public void setIskustva(String iskustva) {
        this.iskustva = iskustva;
    }
    
    
    
    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }
    

    public Integer getIdVestine() {
        return idVestine;
    }

    public void setIdVestine(Integer idVestine) {
        this.idVestine = idVestine;
    }
    

    public Integer getIdzaposlenja() {
        return idzaposlenja;
    }

    public void setIdzaposlenja(Integer idzaposlenja) {
        this.idzaposlenja = idzaposlenja;
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

    public Integer getMestoAzuriranje() {
        return mestoAzuriranje;
    }

    public void setMestoAzuriranje(Integer mestoAzuriranje) {
        this.mestoAzuriranje = mestoAzuriranje;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public Integer getNazivSkole() {
        return nazivSkole;
    }

    public void setNazivSkole(Integer nazivSkole) {
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

//    
//    public List<Mesto> dohvatiMesta(){
//        try {
//            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery("select * from tblgrad");
//            svaMesta2 = new ArrayList<Mesto>();
//            while(rs.next()){
//                Mesto mesto2 = new Mesto();
//                mesto2.setId(rs.getInt("id"));
//                mesto2.setNazivMesta(rs.getString("naziv_mesta"));
//                mesto2.setPostanski_broj(rs.getInt("postanski_broj"));
//                mesto2.setOkrug(rs.getString("okrug"));
//                mesto2.setOpstina(rs.getString("opstina"));
//                
//                svaMesta2.add(mesto2);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return svaMesta2;
//    }
//     public List<Drzavljanstvo> dohvatiDrzavljanstva(){
//        try {
//            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
//            Statement stm = conn.createStatement();
//            ResultSet rs = stm.executeQuery("select * from drzavljanstvo");
//            svaDrzavljanstva2 = new ArrayList<Drzavljanstvo>();
//            while(rs.next()){
//                Drzavljanstvo drzavljanstvo2 = new Drzavljanstvo();
//                drzavljanstvo2.setIddrz(rs.getInt("iddrz"));
//                drzavljanstvo2.setDrzavljanstvo(rs.getString("drzavljanstvo"));
//                svaDrzavljanstva2.add(drzavljanstvo2);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return svaDrzavljanstva2;
//    }
//    public static class Dan {
//
//        private int brDana;
//
//        public Dan(int broj) {
//            this.brDana = broj;
//        }
//
//        public int getBrDana() {
//            return brDana;
//        }
//
//        public String getImeDana() {
//            DateFormatSymbols dfs = new DateFormatSymbols();
//            String[] dani = dfs.getWeekdays();
//            return dani[brDana];
//        }
//    }
//
//    private static Dan[] daniUNedelji;
//
//    static {
//        daniUNedelji = new Dan[7];
//        for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY; i++) {
//            daniUNedelji[i - Calendar.SUNDAY] = new Dan(i);
//        }
//    }
//
//    public Dan[] getDaniUNedelji() {
//        return daniUNedelji;
//    }
//
//    public void setDaniUNedelji(Dan[] daniUNedelji) {
//        AzuriranjeProfilaVolonter.daniUNedelji = daniUNedelji;
//    }
//
//    public Integer[] getOdgovarajuciDani() {
//        return odgovarajuciDani;
//    }
//
//    public void setOdgovarajuciDani(Integer[] odgovarajuciDani) {
//        this.odgovarajuciDani = odgovarajuciDani;
//    }
//
//    public List<SelectItem> dohvatiStatuse() {
//        List<SelectItem> statusi = new LinkedList<>();
//        for (Map.Entry<Integer, String> statusEntry : Status.statusi.entrySet()) {
//            statusi.add(new SelectItem(statusEntry.getKey(), statusEntry.getValue()));
//        }
//        return statusi;
//    }
    
    
//     
    
       public void azurirajProfilcic(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from volonter where email = '" + AzuriranjeProfilaVolonter.volonterZaAzuriranje.getEmail() + "'");
            rs.next();
            stm.executeUpdate("update volonter set telefon = 11111111111" );

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
  
    private static Volonter volonterZaAzuriranje;

    public Volonter getVolonterZaAzuriranje() {
        return volonterZaAzuriranje;
    }

    public void setVolonterZaAzuriranje(Volonter volonterZaAzuriranje) {
        this.volonterZaAzuriranje = volonterZaAzuriranje;
    }

    public List<Drzavljanstvo> getSvaDrzavljanstva() {
        return Drzavljanstvo.ucitajSvaDrzavljanstva();
    }


   
    
   
    public List<SelectItem> getStatusi() {
        List<SelectItem> statusi = new LinkedList<>();
        for (Map.Entry<Integer, String> statusEntry : Status.statusi.entrySet()) {
            statusi.add(new SelectItem(statusEntry.getKey(), statusEntry.getValue()));
        }
        return statusi;
    }
    public Volonter dohvatiPodatkeOVolonteru() {
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select v.*, d.*, r.*, sf.*, ve.*, tg.*, da.*, sts.*, vsif.*, obl.* from Volonter v "
                    + " left join drzavljanstvo d on v.drzavljanstvo_id = d.iddrz "
                    + " left join raspolozivost r on v.idvolonter = r.idvolontera "
                    + " left join dani da on r.iddana = da.iddani "
                   
                    + " left join skolasif sf on v.skola_id = sf.idskolasif "
                    + " left join statussif sts on v.status = sts.idstatussif "
                    + " left join vestine ve on v.idvolonter = ve.idvolont "
                    + " left join vestinesif vsif on ve.idvestine = vsif.idvestinesif "
                    + " left join oblasti obl on v.oblastiid = obl.idoblasti "
                    + " left join tblgrad tg on v.mesto_id = tg.id  where email = 'srki@bla.com'");
            rs.next();
            volonterZaAzuriranje = new Volonter();
            volonterZaAzuriranje.setIdVolonter(rs.getInt("idvolonter"));
            volonterZaAzuriranje.setImePrezime(rs.getString("ime_prezime"));
            volonterZaAzuriranje.setDatumRodjenja(rs.getDate("datum_rodjenja"));
            volonterZaAzuriranje.setPol(rs.getString("pol").charAt(0));
            volonterZaAzuriranje.setDrzavljanstvo(rs.getString("drzavljanstvo"));
            volonterZaAzuriranje.setTelefon(rs.getString("telefon"));
            volonterZaAzuriranje.setUlica_broj(rs.getString("ulica_broj"));
            volonterZaAzuriranje.setMestoAzuriranje(rs.getString("naziv_mesta"));
            volonterZaAzuriranje.setSlika(rs.getString("slika"));
            volonterZaAzuriranje.setCv(rs.getString("cv"));
            volonterZaAzuriranje.setEmail(rs.getString("email"));
            volonterZaAzuriranje.setLozinka(rs.getString("lozinka"));
            volonterZaAzuriranje.setStatus(rs.getString("sts.status"));
            volonterZaAzuriranje.setJPime(rs.getBoolean("jpime"));
            volonterZaAzuriranje.setImeKompanije(rs.getString("zaposlenjeid"));
            //volonterZaAzuriranje.setJPdani(rs.getBoolean("jpdani"));
            volonterZaAzuriranje.setSedisteKompanije(rs.getString("sediste_firme"));
            volonterZaAzuriranje.setPozicijaUKompaniji(rs.getString("pozicijaufirmi"));
            volonterZaAzuriranje.setNazivSkole(rs.getString("nazivSkole"));
            volonterZaAzuriranje.setNazivVestine(rs.getString("vsif.naziv"));
            volonterZaAzuriranje.setIskustva(rs.getString("iskustva"));
            volonterZaAzuriranje.setDiplome(rs.getString("diplome"));
            volonterZaAzuriranje.setNazivOblasti(rs.getString("naziv_oblasti"));
            //kompanijaAzuriranje = new Zaposlen();
            //kompanijaAzuriranje.setKompanija(rs.getString("kompanija"));
            // volonterZaAzuriranje.setIdDana(rs.getInt("iddana"));
            //volonterZaAzuriranje.setIdDana(rs.getInt("iddana"));

            //  volonterZaAzuriranje.setSlobodniDani(rs.getString("iddana"));
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
        dohvatiD();
        dohvatiListuSvihDana();
        dohvatiSvaMestaAzuriranje();
        dohvatiSveVestine();
        dohvatiOblastiDelovanja();
        return volonterZaAzuriranje;

    }
    
    

    private List<Dan> listaDanaVolontera;

    public List<Dan> getListaDanaVolontera() {
        return listaDanaVolontera;
    }

    public void setListaDanaVolontera(List<Dan> listaDanaVolontera) {
        this.listaDanaVolontera = listaDanaVolontera;
    }

    public String dohvatiD() {
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery("select  d.dan, r.iddana, v.idvolonter from raspolozivost r, volonter v, dani d where "
                    + "r.idvolontera=v.idvolonter and r.iddana=d.iddani and  idvolonter=1");
            listaDanaVolontera = new ArrayList<>();

            while (rs.next()) {
                Dan dan = new Dan();
                dan.setIdDana(rs.getInt("iddana"));
                dan.setImeDana(rs.getString("dan"));
                listaDanaVolontera.add(dan);

            }

        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    private List<Dan> listaSvihDana;

    public List<Dan> getListaSvihDana() {
        return listaSvihDana;
    }

    public void setListaSvihDana(List<Dan> listaSvihDana) {
        this.listaSvihDana = listaSvihDana;
    }

    public String dohvatiListuSvihDana() {
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from dani");
            listaSvihDana = new ArrayList<>();
            while (rs.next()) {
                Dan dan = new Dan();
                dan.setIdDana(rs.getInt("iddani"));
                dan.setImeDana(rs.getString("dan"));
                listaSvihDana.add(dan);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private List<Dan> odgovarajuciDaniVolontera;

    public List<Dan> getOdgovarajuciDaniVolontera() {
        return odgovarajuciDaniVolontera;
    }

    public void setOdgovarajuciDaniVolontera(List<Dan> odgovarajuciDaniVolontera) {
        this.odgovarajuciDaniVolontera = odgovarajuciDaniVolontera;
    }
    
//    private List<SelectItem> svaMesta = new LinkedList<>();
//
//    public List<SelectItem> getSvaMesta() {
//        return svaMesta;
//    }
//    
//    @PostConstruct
//    public void init() {
//       
//        List<Mesto> svaMestaBinovi = Mesto.ucitajSvaMesta();
//        for (Mesto mesto : svaMestaBinovi) {
//            svaMesta.add(new SelectItem(mesto.getId(), mesto.getNazivMesta()));
//        }
//    }

    
    private List<Mesto> svaMestaAzuriranje;

    public List<Mesto> getSvaMestaAzuriranje() {
        return svaMestaAzuriranje;
    }

    public void setSvaMestaAzuriranje(List<Mesto> svaMestaAzuriranje) {
        this.svaMestaAzuriranje = svaMestaAzuriranje;
    }
     
    public List<Mesto> dohvatiSvaMestaAzuriranje(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
              ResultSet rs = stm.executeQuery("select id, naziv_mesta from tblgrad");
              svaMestaAzuriranje = new ArrayList<>();
              while(rs.next()){
                 Mesto mesto = new Mesto();
                  mesto.setId(rs.getInt("id"));
                  mesto.setNazivMesta(rs.getString("naziv_mesta"));
                  svaMestaAzuriranje.add(mesto);
                          
              }
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
         return svaMestaAzuriranje;
    }

    public String getNazivMesta() {
        return nazivMesta;
    }

    public void setNazivMesta(String nazivMesta) {
        this.nazivMesta = nazivMesta;
    }
    
      public void azurirajProfil() {
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from volonter where email = '" + AzuriranjeProfilaVolonter.volonterZaAzuriranje.getEmail() + "'");
            rs.next();
             stm.executeUpdate("update volonter set telefon'" + telefon + "'" );
           // stm.executeUpdate("update volonter set telefon= '"+ telefon +"'");
//            stm.executeUpdate("update volonter, raspolozivost, skola, zaposlenje, vestine set "
//                    + "volonter.jpime=" + jpIme + ", volonter.jpdatum_rodjenja=" + jpDatumRodjenja + ", volonter.jppol=" + jpPol
//                    + ", volonter.jpdrzavljanstvo=" + jpDrzavljanstvo + ", volonter.telefon='" + telefon + "', volonter.jptelefon="
//                    + jpTelefon + ", volonter.ulica_broj='" + ulica_broj + "' , volonter.jpulica_broj=" + jpAdresa + ", volonter.jpmesto=" + jpMesto + ", volonter.lozinka='"
//                    + lozinka + "', volonter.slika='" + slika + "', volonter.jpslika=" + jpSlika + ", volonter.cv='" + cv + "', volonter.jpcv=" + jpCv +
//                    ", volonter.status="+ status + ", volonter.jpstatus=" + jpStatus + ", volonter.zdravstveni_problemi='" + zdravstveneNapomene +"', "
//                    + "', volonter.mesto_id= " + selektovanoMesto.getId() + ", volonter.drzavljanstvo_id= " + selektovanoDrzavljanstvo.getIddrz() + ", raspolozivost.iddana=" + odgovarajuciDani + ", skola.naziv='"+nazivSkole 
//                    +"', skola.mesto='" + sedisteSkole + "', skola.nivo='" + nivoStudija + "', skola.godina_upisa='" + godinaUpisa +"', zaposlenje.kompanija='" + kompanija +"',"
//                    + " zaposlenje.sediste='" + sedisteKompanije + "', zaposlenje.pozicija='" + pozicijaUKompaniji + "', vestine.naziv='" + vestineNaziv + "', vestine.struka= '" + vestineZvanje + "', vestine.iskustva='"
//                    + vestineIskustva + "' where volonter.email='" + mail + "' and volonter.idvolonter = raspolozivost.idvolontera and volonter.idvolonter=raspolozivost.idvolontera and "
//                            + "volonter.idvolonter=skola.idvolont and volonter.idvolonter = zaposlenje.idvolonter and volonter.idvolonter = vestine.idvolonter" );

//            stm.executeUpdate("update volonter set jpime="+ jpIme+ ", jpdatum_rodjenja="+ jpDatumRodjenja + ", jppol="+ jpPol + ", drzavljanstvo_id="+
//                    drzavljanstvo + ", jpdrzavljanstvo="+ jpDrzavljanstvo+", telefon='"+ telefon + "', jptelefon="+ jpTelefon + ", ulica_broj='" + 
//                    ulica_broj + "', jpulica_broj="+ jpAdresa+ ", mesto_id="+ mesto + ", jpmesto="+ jpMesto+ ", email='"+ mail + "', lozinka='"+
//                    lozinka + ", slika='"+ slika + "', jpslika="+ jpSlika + ", cv="+ cv + "', jpcv="+ jpCv+ ", status="+ status + ", jpstatus="+
//                    jpStatus + ", kompanija='"+ kompanija + "', sediste='"+ sedisteKompanije + "', pozicija='"+ pozicijaUKompaniji + "', naziv='"+ 
//                    nazivSkole + "', mesto='"+ sedisteSkole + "', nivo='"+ nivoStudija + "', godina_upisa='"+ godinaUpisa + "', " );


//            stm.executeUpdate("update volonter, raspolozivost, skola, zaposlenje, vestine, skolasif set " +
//                    " volonter.jpime="+jpIme+" , volonter.jpdatum_rodjenja="+jpDatumRodjenja+" , volonter.jppol="+jpPol+
//                    ", volonter.jpdrzavljanstvo="+jpDrzavljanstvo+", volonter.telefon='"+telefon+"', volonter.jptelefon="+jpTelefon+
//                    " volonter.ulica_broj='"+ulica_broj+"' , volonter.jpulica_broj="+ jpAdresa+" , volonter.jpmesto="+jpMesto+", volonter.lozinka='" +lozinka+
//                    "' , volonter.slika='"+slika+"', volonter.jpslika="+jpSlika+", volonter.cv='"+cv+"', volonter.jpcv="+jpCv+
//                    ", volonter.status="+status+", volonter.jpstatus="+jpStatus+", volonter.zdravstveni_problemi='"+zdravstveneNapomene+
//                    "', volonter.mesto_id="+mesto+", volonter.drzavljanstvo_id="+drzavljanstvo+", raspolozivost.iddana='"+odgovarajuciDaniVolontera+"', skola.idskolasif="+nazivSkole+
//                    ", skola.nivo='"+nivoStudija+"', skola.godina_upisa='" +godinaUpisa + 
//                    "', zaposlenje.idzaposlenje=" + idzaposlenja+
//                    " zaposlenje.sediste='"+sedisteKompanije+"', zaposlenje.pozicija='" +pozicijaUKompaniji+
//                    "', vestine.idvestine="+idVestine+", vestine.diplome='"+diplome+"' , vestine.iskustva='" +vestineIskustva+
//                    " where volonter.email='srki@bla.com' and volonter.idvolonter = raspolozivost.idvolontera and \n" +
//                    "volonter.idvolonter=skola.idvolont and volonter.idvolonter = zaposlenje.idvolonter and volonter.idvolonter = vestine.idvolont\n" +
//                    "and skola.idskolasif=skolasif.idskolaSif");

//            stm.executeUpdate("update volonter, raspolozivost, vestine set " + 
//            " volonter.jpime="+jpIme+", volonter.jpdatum_rodjenja="+jpDatumRodjenja+", volonter.jppol=" +jpPol+
//            ", volonter.jpdrzavljanstvo="+jpDrzavljanstvo+", volonter.telefon='"+telefon+"', volonter.jptelefon=" + jpTelefon+
//            ", volonter.ulica_broj='"+ulica_broj+"', volonter.jpulica_broj="+jpAdresa+", volonter.jpmesto="+jpMesto+", volonter.lozinka='" +lozinka+
//            "', volonter.slika='"+slika+"', volonter.jpslika="+jpSlika+", volonter.cv='"+cv+"', volonter.jpcv=" +jpCv + 
//            ", volonter.status="+status+", volonter.jpstatus="+jpStatus+", volonter.zdravstveni_problemi='"+zdravstveneNapomene+"', volonter.jpzdravstveniproblemi=" +jpZdravstveneNapomene+
//            ", volonter.mesto_id="+mesto+", volonter.drzavljanstvo_id="+selektovanoDrzavljanstvo.getIddrz()+" , raspolozivost.iddana=2, volonter.skola_id=6\n" +
//", volonter.nivo_skole='4dddad', volonter.godinaupisa='1222', volonter.zaposlenjeid='Samsung',\n" +
//"volonter.sediste_firme='Finska', volonter.pozicijaufirmi='kurir', vestine.idvestine=1, vestine.diplome='bez strukfdsfdfda' , vestine.iskustva='iskusan sveps'\n" +
//"where volonter.email='srki@bla.com' and volonter.idvolonter=raspolozivost.idvolontera\n" +
//"	  and volonter.idvolonter = vestine.idvolont");

          



//            
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    private List<Vestine> listaVestina;

    public List<Vestine> getListaVestina() {
        return listaVestina;
    }

    public void setListaVestina(List<Vestine> listaVestina) {
        this.listaVestina = listaVestina;
    }
      
      
      
       public  List<Vestine> dohvatiSveVestine() {
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from vestinesif");
            listaVestina = new ArrayList<>();
            while (rs.next()) {
                Vestine vestina = new Vestine();
                vestina.setIdvestinesif(rs.getInt("idvestinesif"));
                vestina.setNaziv(rs.getString("naziv"));
                listaVestina.add(vestina);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaVestina;
    }
       
       private List<OblastDelovanja> listaOblastiDelovanja;

    public List<OblastDelovanja> getListaOblastiDelovanja() {
        return listaOblastiDelovanja;
    }

    public void setListaOblastidelovanja(List<OblastDelovanja> listaOblastidelovanja) {
        this.listaOblastiDelovanja = listaOblastidelovanja;
    }
       
    public List<OblastDelovanja> dohvatiOblastiDelovanja(){
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from oblasti");
            listaOblastiDelovanja = new ArrayList<>();
            while(rs.next()){
                OblastDelovanja oblast = new OblastDelovanja();
                oblast.setIdoblasti(rs.getInt("idoblasti"));
                oblast.setNaziv_oblasti(rs.getString("naziv_oblasti"));
                listaOblastiDelovanja.add(oblast);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AzuriranjeProfilaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaOblastiDelovanja;
    }
}



