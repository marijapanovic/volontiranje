
package volontiranje;


import javax.faces.bean.SessionScoped;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 


@ManagedBean
@SessionScoped
public class RegistracijaVolonter {
    private String imeiprezime;
    private Date date;

    public String getImeiprezime() {
        return imeiprezime;
    }

    public void setImeiprezime(String imeiprezime) {
        this.imeiprezime = imeiprezime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
   private boolean active;
   private boolean inactive;

   

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }
   
   
   @PostConstruct
   public void prepareMrBean() {
      this.active = true;
   }

   public void onActiveStatusChange() {
      if (active) inactive = false;
   }

   public void onInactiveStatusChange() {
      if (inactive) active = false;
   }
    
    public void RegistracijaVolontera(){
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Uspesno ste se registrovali." ));
    }
}
