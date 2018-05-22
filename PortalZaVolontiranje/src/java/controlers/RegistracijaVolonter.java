package controlers;

import beans.Drzavljanstvo;
import beans.Mesto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import beans.Volonter;
import controlers.greske.GreskaPriRegistraciji;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


@ManagedBean
public class RegistracijaVolonter {

    private String imePrezime;

    private Date datumRodjenja;
    private boolean uslov;
    private String pol;
    private SelectItem drzavljanstvo;
    private String drzavljanstvoDrugo;
    private String telefon;
    private String ulica_broj;
    private SelectItem mesto;
    private String mail;
    private String lozinka;
    private String slika;
    private String cv;
    private String status;
    private String kompanija;
    private String sedisteKompanije;
    private String pozicijaUKompaniji;
    private String nazivSkole;
    private String sedisteSkole;
    private String nivoStudija;
    private String godinaUpisa;
    private String[] odgovarajuciDani;
    private String vestine;
  

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumrodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public boolean isUslov() {
        return uslov;
    }

    public void setUslov(boolean uslov) {
        this.uslov = uslov;
    }

    private List<SelectItem> svaMesta = new LinkedList<>();

    public List<SelectItem> getSvaMesta() {
        return svaMesta;
    }

    private List<SelectItem> svaDrzavljanstva = new LinkedList<>();

    public List<SelectItem> getSvaDrzavljanstva() {
        return svaDrzavljanstva;
    }
    
    private SelectItem izaberiDrzavljanstvo = new SelectItem(-2, "Izaberi drzavljanstvo");

    public SelectItem getIzaberiDrzavljanstvo() {
        return izaberiDrzavljanstvo;
    }

    public void setIzaberiDrzavljanstvo(SelectItem izaberiDrzavljanstvo) {
        this.izaberiDrzavljanstvo = izaberiDrzavljanstvo;
    }

    private SelectItem drugoDrzavljanstvo = new SelectItem(-1, "Drugo");

    public SelectItem getDrugoDrzavljanstvo() {
        return drugoDrzavljanstvo;
    }

    public void setDrugoDrzavljanstvo(SelectItem drugoDrzavljanstvo) {
        this.drugoDrzavljanstvo = drugoDrzavljanstvo;
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

    public String getDrzavljanstvoDrugo() {
        return drzavljanstvoDrugo;
    }

    public void setDrzavljanstvoDrugo(String drzavljanstvoDrugo) {
        this.drzavljanstvoDrugo = drzavljanstvoDrugo;
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

    public SelectItem getDrzavljanstvo() {
        return drzavljanstvo;
    }

    public void setDrzavljanstvo(SelectItem drzavljanstvo) {
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

    public SelectItem getMesto() {
        return mesto;
    }

    public void setMesto(SelectItem mesto) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    public String getVestine() {
        return vestine;
    }

    public void setVestine(String vestine) {
        this.vestine = vestine;
    }

    

    public String RegistrujVolontera() throws GreskaPriRegistraciji {
        Connection conn;
        try {
            conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from volonter where email='" + mail + "'");
            rs.next();
            if (rs.getString("email").equals(mail)) {
                return "Email vec postoji u bazi";
            } else {
                int drzavljanstvoId = 0;
                if ("drugo".equals(drzavljanstvo.getValue())) {

                    // snimiti novo drzaljvanstvo u bazu
                } else if (!"".equals(drzavljanstvo.getValue())) {
                    drzavljanstvoId = (int) drzavljanstvo.getValue();
                } else {
                    throw new GreskaPriRegistraciji("Nije uneto drzavljanstvo");
                }
                //  Volonter volonter = new Volonter();
                stm.executeUpdate("insert into volonter "
                        + "(ime_prezime, datum_rodjenja, pol, drzavljanstvo_id, telefon, "
                        + "ulica_broj, mesto_id, slika, cv, email, lozinka, zaposlen) "
                        + "values ('" + imePrezime + "','" + datumRodjenja + "','" + pol + "','" + drzavljanstvoId + "',)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistracijaVolonter.class.getName()).log(Level.SEVERE, null, ex);
        }

        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Uspesno ste se registrovali."));
        return "index?faces-redirect=true";
    }

}
