/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlers;

import beans.Vesti;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Korisnik
 */

@ManagedBean    
@SessionScoped
public class DohvatiVesti {
    
    private Vesti sveVesti;

    public Vesti getSveVesti() {
        return sveVesti;
    }

    public void setSveVesti(Vesti sveVesti) {
        this.sveVesti = sveVesti;
    }
    
    
    
}
