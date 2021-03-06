package home;
// Generated Sep 3, 2014 1:26:11 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Houses generated by hbm2java
 */
public class Houses  implements java.io.Serializable {


     private String odos;
     private User user;
     private double tetragwnika;
     private boolean kentriki;
     private String sxolia;
     private boolean monokatoikia;
     private Date xronosKataskevis;
     private Date anakainhsh;
     private Double koinoxrhsta;
     private boolean aytonomh;
     private String region;
     private Set<Photos> photoses = new HashSet<Photos>(0);
     private Set<SellRent> sellRents = new HashSet<SellRent>(0);
     private Set<Messages> messageses = new HashSet<Messages>(0);

    public Houses() {
    }

	
    public Houses(String odos, User user, double tetragwnika, boolean kentriki, boolean monokatoikia, Date xronosKataskevis, boolean aytonomh, String region) {
        this.odos = odos;
        this.user = user;
        this.tetragwnika = tetragwnika;
        this.kentriki = kentriki;
        this.monokatoikia = monokatoikia;
        this.xronosKataskevis = xronosKataskevis;
        this.aytonomh = aytonomh;
        this.region = region;
    }
    public Houses(String odos, User user, double tetragwnika, boolean kentriki, String sxolia, boolean monokatoikia, Date xronosKataskevis, Date anakainhsh, Double koinoxrhsta, boolean aytonomh, String region, Set<Photos> photoses, Set<SellRent> sellRents, Set<Messages> messageses) {
       this.odos = odos;
       this.user = user;
       this.tetragwnika = tetragwnika;
       this.kentriki = kentriki;
       this.sxolia = sxolia;
       this.monokatoikia = monokatoikia;
       this.xronosKataskevis = xronosKataskevis;
       this.anakainhsh = anakainhsh;
       this.koinoxrhsta = koinoxrhsta;
       this.aytonomh = aytonomh;
       this.region = region;
       this.photoses = photoses;
       this.sellRents = sellRents;
       this.messageses = messageses;
    }
   
    public String getOdos() {
        return this.odos;
    }
    
    public void setOdos(String odos) {
        this.odos = odos;
    }
    public User getUser() {
        return this.user;
    }
    
    public void setUser(User user) {
        this.user = user;
    }
    public double getTetragwnika() {
        return this.tetragwnika;
    }
    
    public void setTetragwnika(double tetragwnika) {
        this.tetragwnika = tetragwnika;
    }
    public boolean isKentriki() {
        return this.kentriki;
    }
    
    public void setKentriki(boolean kentriki) {
        this.kentriki = kentriki;
    }
    public String getSxolia() {
        return this.sxolia;
    }
    
    public void setSxolia(String sxolia) {
        this.sxolia = sxolia;
    }
    public boolean isMonokatoikia() {
        return this.monokatoikia;
    }
    
    public void setMonokatoikia(boolean monokatoikia) {
        this.monokatoikia = monokatoikia;
    }
    public Date getXronosKataskevis() {
        return this.xronosKataskevis;
    }
    
    public void setXronosKataskevis(Date xronosKataskevis) {
        this.xronosKataskevis = xronosKataskevis;
    }
    public Date getAnakainhsh() {
        return this.anakainhsh;
    }
    
    public void setAnakainhsh(Date anakainhsh) {
        this.anakainhsh = anakainhsh;
    }
    public Double getKoinoxrhsta() {
        return this.koinoxrhsta;
    }
    
    public void setKoinoxrhsta(Double koinoxrhsta) {
        this.koinoxrhsta = koinoxrhsta;
    }
    public boolean isAytonomh() {
        return this.aytonomh;
    }
    
    public void setAytonomh(boolean aytonomh) {
        this.aytonomh = aytonomh;
    }
    public String getRegion() {
        return this.region;
    }
    
    public void setRegion(String region) {
        this.region = region;
    }
    public Set<Photos> getPhotoses() {
        return this.photoses;
    }
    
    public void setPhotoses(Set<Photos> photoses) {
        this.photoses = photoses;
    }
    public Set<SellRent> getSellRents() {
        return this.sellRents;
    }
    
    public void setSellRents(Set<SellRent> sellRents) {
        this.sellRents = sellRents;
    }
    public Set<Messages> getMessageses() {
        return this.messageses;
    }
    
    public void setMessageses(Set<Messages> messageses) {
        this.messageses = messageses;
    }




}


