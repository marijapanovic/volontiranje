/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;


import beans.KategorijaVesti;
import beans.Organizacija;
import beans.Vesti;
import beans.Volonter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Korisnik
 */
@ManagedBean
@SessionScoped
public class DohvatiVesti {

    private int vidljivostVol;
    private int vidljivostOrg;
    private int tip_autora;
    private Integer idkategorija_vesti;

    public int getVidljivostOrg() {
        return vidljivostOrg;
    }

    public void setVidljivostOrg(int vidljivostOrg) {
        this.vidljivostOrg = vidljivostOrg;
    }

    public int getVidljivostVol() {
        return vidljivostVol;
    }

    public void setVidljivostVol(int vidljivostVol) {
        this.vidljivostVol = vidljivostVol;
    }

    public int getTip_autora() {
        return tip_autora;
    }

    public void setTip_autora(int tip_autora) {
        this.tip_autora = tip_autora;
    }

    public void volonter(Volonter volonter) {
        vidljivostVol = volonter.getTip();
    }

    public void organizacija(Organizacija organizacija) {
        vidljivostOrg = organizacija.getTip();
    }

    private List<Vesti> sveVesti;

    public List<Vesti> getSveVesti() {
        return sveVesti;
    }

    public void setSveVesti(List<Vesti> sveVesti) {
        this.sveVesti = sveVesti;
    }

    private List<Vesti> sveMojeVesti;

    public List<Vesti> getSveMojeVesti() {
        return sveMojeVesti;
    }

    public void setSveMojeVesti(List<Vesti> sveMojeVesti) {
        this.sveMojeVesti = sveMojeVesti;
    }

    public Integer getIdkategorija_vesti() {
        return idkategorija_vesti;
    }

    public void setIdkategorija_vesti(Integer idkategorija_vesti) {
        this.idkategorija_vesti = idkategorija_vesti;
    }
    
    
     private List<SelectItem> sveKategorijeVesti = new LinkedList<>();

    public List<SelectItem> getSveKategorijeVesti() {
        return sveKategorijeVesti;
    }

       
    @PostConstruct
    public void init() {
        List<KategorijaVesti> sveKategorijeVestiBinovi = KategorijaVesti.ucitajSveVesti();

        for (KategorijaVesti kategorijeVesti : sveKategorijeVestiBinovi) {
            sveKategorijeVesti.add(new SelectItem(kategorijeVesti.getIdKategorijaVesti(),kategorijeVesti.getKategorija()));
        }
    }
    public String uzmiVesti() throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(db.DB.connectionString, db.DB.user, db.DB.pass);
            Statement stm = conn.createStatement();
            HttpSession sesija = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            Volonter volonter = (Volonter) sesija.getAttribute("volonter");
            ResultSet rs1 = stm.executeQuery("select * kategorija_vesti.kategorija from vesti, kategorija_vesti where autor='" + volonter.getEmail() + "'");
            sveMojeVesti = new ArrayList<Vesti>();
            while (rs1.next()) {
                Vesti mojeVesti = new Vesti();
                mojeVesti.setIdkategorija_vesti(rs1.getInt("idkategorija"));
                mojeVesti.setAutor(rs1.getString("autor"));
                mojeVesti.setTekst(rs1.getString("tekstVesti"));
                mojeVesti.setVreme(rs1.getDate("vreme"));
                mojeVesti.setTipAutora(rs1.getInt("tip_autora"));
                mojeVesti.setKategorija_naziv(rs1.getString("kategorija"));
                sveMojeVesti.add(mojeVesti);
            }
            if (volonter.getTip() == 1) {
                ResultSet rs = stm.executeQuery("select * kategorija_vesti.kategorija from vesti, kategorija_vesti where vidljivost=" + 1);
                sveVesti = new ArrayList<Vesti>();
                while (rs.next()) {
                    Vesti vesti = new Vesti();

                    vesti.setIdkategorija_vesti(rs.getInt("idkategorija"));
                    vesti.setAutor(rs.getString("autor"));
                    vesti.setTekst(rs.getString("tekstVesti"));
                    vesti.setVreme(rs.getDate("vreme"));
                    vesti.setTipAutora(rs.getInt("tip_autora"));
                    vesti.setKategorija_naziv(rs.getString("kategorija"));
                    sveVesti.add(vesti);
                }

            }

        } catch (SQLException ex) {
            Logger.getLogger(DohvatiVesti.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
