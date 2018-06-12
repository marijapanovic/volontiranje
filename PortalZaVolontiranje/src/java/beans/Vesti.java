/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author Korisnik
 */

public class Vesti {
//    private int idvesti;
    private Integer idkategorija_vesti;
    private String kategorija;
    private String autor;
    private Date vreme;
    private String tekst;
    private int tipAutora;
    private String vidljivost;
//    private int vidljivost;
    private String kategorija_naziv;

    public String getKategorija_naziv() {
        return kategorija_naziv;
    }

    public void setKategorija_naziv(String kategorija_naziv) {
        this.kategorija_naziv = kategorija_naziv;
    }

    public Integer getIdkategorija_vesti() {
        return idkategorija_vesti;
    }

    public void setIdkategorija_vesti(Integer idkategorija_vesti) {
        this.idkategorija_vesti = idkategorija_vesti;
    }
    
    
    

//    public int getIdvesti() {
//        return idvesti;
//    }
//
//    public void setIdvesti(int idvesti) {
//        this.idvesti = idvesti;
//    }
//
//    public int getKategorija() {
//        return kategorija;
//    }
//
//    public void setKategorija(int kategorija) {
//        this.kategorija = kategorija;
//    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Date getVreme() {
        return vreme;
    }

    public void setVreme(Date vreme) {
        this.vreme = vreme;
    }

    public String getTekst() {
        return tekst;
    }

    public void setTekst(String tekst) {
        this.tekst = tekst;
    }

    public int getTipAutora() {
        return tipAutora;
    }

    public void setTipAutora(int tipAutora) {
        this.tipAutora = tipAutora;
    }
    
//    public int getVidljivost() {
//        return vidljivost;
//    }
//
//    public void setVidljivost(int vidljivost) {
//        this.vidljivost = vidljivost;
//    }

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getVidljivost() {
        return vidljivost;
    }

    public void setVidljivost(String vidljivost) {
        this.vidljivost = vidljivost;
    }
    
    
}

