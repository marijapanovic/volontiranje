/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author dprokic
 */
public class Zaposlen extends Status {
    private String kompanija;
    private String sedisteKompanije;
    private String pozicijaUKompaniji;

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

    public Zaposlen(String kompanija, String sedisteKompanije, String pozicijaUKompaniji) {
        this.kompanija = kompanija;
        this.sedisteKompanije = sedisteKompanije;
        this.pozicijaUKompaniji = pozicijaUKompaniji;
    }
}
