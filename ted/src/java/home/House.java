
package home;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class House {
     private Houses h;
    private List<Photos> p;
    private List<Messages> m;
    private HouseHelper helper;
    private String odos;
     private String tetragwnika;
     private boolean kentriki = false;
     private String sxolia = null;
     private boolean monokatoikia = false;
     private String xronosKataskevis;
     private String anakainhsh = null;
     private String koinoxrhsta;
     private boolean aytonomh=false;
     private String p1=null;
     private String p2=null;
     private String message = null;  
     private String[] type;
     private String region;
     private List<SellRent> sr;
     private List<Photos> ph;
     private List<String> phot;
     private boolean alf=false;
     private boolean alfa=false;
     private boolean alf1 = false;
     private boolean alfa1 = false;
     private User user;
     private List<SellRent> s;
     private Messages me;
     private User u;
    private Photos photo;

   
    public House() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public Houses getH() {
        return h;
    }

    public void setH(Houses h) {
        this.h = h;
    }

    public List<Photos> getP() {
        return p;
    }

    public void setP(List<Photos> p) {
        this.p = p;
    }

    public List<Messages> getM() {
        return m;
    }

    public void setM(List<Messages> m) {
        this.m = m;
    }

    public HouseHelper getHelper() {
        return helper;
    }

    public void setHelper(HouseHelper helper) {
        this.helper = helper;
    }

    public String getOdos() {
        return odos;
    }

    public void setOdos(String odos) {
        this.odos = odos;
    }

    public String getTetragwnika() {
        return tetragwnika;
    }

    public void setTetragwnika(String tetragwnika) {
        this.tetragwnika = tetragwnika;
    }

    public boolean isKentriki() {
        return kentriki;
    }

    public void setKentriki(boolean kentriki) {
        this.kentriki = kentriki;
    }

    public String getSxolia() {
        return sxolia;
    }

    public void setSxolia(String sxolia) {
        this.sxolia = sxolia;
    }

    public boolean isMonokatoikia() {
        return monokatoikia;
    }

    public void setMonokatoikia(boolean monokatoikia) {
        this.monokatoikia = monokatoikia;
    }

    public String getXronosKataskevis() {
        return xronosKataskevis;
    }

    public void setXronosKataskevis(String xronosKataskevis) {
        this.xronosKataskevis = xronosKataskevis;
    }

    public String getAnakainhsh() {
        return anakainhsh;
    }

    public void setAnakainhsh(String anakainhsh) {
        this.anakainhsh = anakainhsh;
    }

    public String getKoinoxrhsta() {
        return koinoxrhsta;
    }

    public void setKoinoxrhsta(String koinoxrhsta) {
        this.koinoxrhsta = koinoxrhsta;
    }

    public boolean isAytonomh() {
        return aytonomh;
    }

    public void setAytonomh(boolean aytonomh) {
        this.aytonomh = aytonomh;
    }

    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public List<SellRent> getSr() {
        return sr;
    }

    public void setSr(List<SellRent> sr) {
        this.sr = sr;
    }

    public List<Photos> getPh() {
        return ph;
    }

    public void setPh(List<Photos> ph) {
        this.ph = ph;
    }

    public List<String> getPhot() {
        return phot;
    }

    public void setPhot(List<String> phot) {
        this.phot = phot;
    }

    public boolean isAlf() {
        return alf;
    }

    public void setAlf(boolean alf) {
        this.alf = alf;
    }

    public boolean isAlfa() {
        return alfa;
    }

    public void setAlfa(boolean alfa) {
        this.alfa = alfa;
    }

    public boolean isAlf1() {
        return alf1;
    }

    public void setAlf1(boolean alf1) {
        this.alf1 = alf1;
    }

    public boolean isAlfa1() {
        return alfa1;
    }

    public void setAlfa1(boolean alfa1) {
        this.alfa1 = alfa1;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

   

    public Photos getPhoto() {
        return photo;
    }

    public void setPhoto(Photos photo) {
        this.photo = photo;
    }
           // fortwnontai ta stoixeia tou spitiou    
    public String change(String a)
    {
        helper = new HouseHelper();
        this.h = helper.getHouse(a);
        helper = new HouseHelper();
        this.ph = helper.Houses_Photos(a);
        
        int i;
        this.phot = new ArrayList<String>();
        if(ph!=null)
        for(i = 0; i < ph.size(); i++)
        {
           this.phot.add(i, ph.get(i).getPhotos());
           
        }
        System.out.println("edwwwwwwwwwww"+phot);
        if(h.getAnakainhsh() != null)
                this.anakainhsh = h.getAnakainhsh().toString();
        this.kentriki = h.isKentriki();
        this.xronosKataskevis = h.getXronosKataskevis().toString();
        this.monokatoikia = h.isMonokatoikia();
        this.odos = h.getOdos();
        this.region = h.getRegion();
        if(h.getSxolia()!=null)
        this.sxolia = h.getSxolia();
        this.tetragwnika = Double.toString(h.getTetragwnika());
        this.sr = (new HouseHelper()).sell_rent(a); 
        int l = this.sr.size();
        this.aytonomh=h.isAytonomh();
        
        p1=null;
        p2=null;
        for(i=0;i<l;i++)
        {
            
          if(this.sr.get(i).getId().getType().compareTo("Sale")==0)
          {  alf1 = alf =true;
             p1=Double.toString(sr.get(i).getPayment());
          }
          else
          {
              alfa1 = alfa=true;
              p2=Double.toString(sr.get(i).getPayment());

          }
          
          
        }
        
        return "/secured/House?faces-redirect=true";
    }
    
      // afhnei mhnuma
    public String  StoreMessage(String a)
    {
        
        u = new User();
        u.setUsername(a);
        
        me = new Messages(this.h,u,this.message);
        (new HouseHelper()).upload_message(me);
        this.message = " ";
        
        return "/secured/House?faces-redirect=true";
    }
    
}
