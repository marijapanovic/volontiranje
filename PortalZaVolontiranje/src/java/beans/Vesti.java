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
    private int idvesti;
    private int kategorija;
    private String autor;
    private Date vreme;
    private String tekst;
    private int tipAutora;
    private int vidljivost;

    public int getIdvesti() {
        return idvesti;
    }

    public void setIdvesti(int idvesti) {
        this.idvesti = idvesti;
    }

    public int getKategorija() {
        return kategorija;
    }

    public void setKategorija(int kategorija) {
        this.kategorija = kategorija;
    }

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

    public int getVidljivost() {
        return vidljivost;
    }

    public void setVidljivost(int vidljivost) {
        this.vidljivost = vidljivost;
    }
    
    
}

