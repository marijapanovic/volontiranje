/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Korisnik
 */
public class Vestine {
    private String nazivVestine;
    private String strucnoZvanje;
    private String ostaleVestineIMetode;
    private String prethodnaIskustva;

    public Vestine(String nazivVestine, String strucnoZvanje, String ostaleVestineIMetode, String prethodnaIskustva) {
        this.nazivVestine = nazivVestine;
        this.strucnoZvanje = strucnoZvanje;
        this.ostaleVestineIMetode = ostaleVestineIMetode;
        this.prethodnaIskustva = prethodnaIskustva;
    }

    public String getNazivVestine() {
        return nazivVestine;
    }

    public void setNazivVestine(String nazivVestine) {
        this.nazivVestine = nazivVestine;
    }

    public String getStrucnoZvanje() {
        return strucnoZvanje;
    }

    public void setStrucnoZvanje(String strucnoZvanje) {
        this.strucnoZvanje = strucnoZvanje;
    }

    public String getOstaleVestineIMetode() {
        return ostaleVestineIMetode;
    }

    public void setOstaleVestineIMetode(String ostaleVestineIMetode) {
        this.ostaleVestineIMetode = ostaleVestineIMetode;
    }

    public String getPrethodnaIskustva() {
        return prethodnaIskustva;
    }

    public void setPrethodnaIskustva(String prethodnaIskustva) {
        this.prethodnaIskustva = prethodnaIskustva;
    }

    
    
}
