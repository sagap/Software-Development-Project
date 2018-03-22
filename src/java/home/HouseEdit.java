
package home;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

/**
 *
 * @author Stelios
 */
@ManagedBean
@SessionScoped
public class HouseEdit {

    private Houses h;
    private List<Photos> p;
    private List<Messages> m;
    HouseHelper helper;
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
     
     private String[] type;
     private String region;
     private List<SellRent> sr;
     private List<Photos> ph;
     private List<Photos> phot;
     private boolean alf=false;
     private boolean alfa=false;
     private boolean alf1 = false;
     private boolean alfa1 = false;
     private User user;
     SellRentId[] sellRi;
     SellRent[] sellR;
     private Photos photo;
     private List<Messages> messa = null;
     private int rows = 10;
     private Messages m1;
     private String mes;
     private User tempUser;
     private String username = null;
    public HouseEdit() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }
    
    public Messages getM1() {
        return m1;
    }

    public void setM1(Messages m1) {
        this.m1 = m1;
    }

    
    

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
    

    public List<Messages> getMessa() {
        return messa;
    }

    public void setMessa(List<Messages> messa) {
        this.messa = messa;
    }

    
    public List<Photos> getPh() {
        return ph;
    }
    
    public List<SellRent> getSr() {
        return sr;
    }

    public void setSr(List<SellRent> sr) {
        this.sr = sr;
    }

    public String getKoinoxrhsta() {
        return koinoxrhsta;
    }

    public List<Photos> getPhot() {
        return phot;
    }

    public void setPhot(List<Photos> phot) {
        this.phot = phot;
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
    
    
    public List<Photos> getP() {
        return p;
    }

    public void setP(List<Photos> p) {
        this.p = p;
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

    public String[] getType() {
        return type;
    }

    public void setType(String[] type) {
        this.type = type;
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
    

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    
    // fotwnontiai  oi metablhtes gia edit
    
    public String change(String a,String b)
    {
        this.username = b;
        alfa = alfa1 = alf = alf1 = false;
        helper = new HouseHelper();
        System.out.println("ela ela ela ela ela "+a);
        this.h = helper.getHouse(a);
        helper = new HouseHelper();
        this.ph = helper.Houses_Photos(a);
        this.messa = new ArrayList<Messages>();
        this.messa = (new HouseHelper()).Houses_messages(a);
        if(this.messa != null)
        for(int i = 0;i<messa.size();i++)
        {
            tempUser = (new UserHelper()).rUser(this.messa.get(i).getUser().getUsername());
            this.messa.get(i).setUser(tempUser);
            
        }
        int i;
        
        
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
        
        return "/secured/houseedit?faces-redirect=true";
    }
    public String Check(String a)
    {
        
       if(a == null)
           return "index?faces-redirect=true";
       else 
           return null;
    }
    
    
    // apothikevontai oi nees times
    public String submit_changes(String username) throws ParseException
    { 
        
      helper = new HouseHelper();
      user = new User();
      user.setUsername(username);
           
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date a;
        try {
            a = df.parse(this.xronosKataskevis);
            h = new Houses(this.odos,this.user , Double.parseDouble(this.tetragwnika),this.kentriki,this.monokatoikia, a,this.aytonomh,h.getRegion());
        } catch (ParseException ex) {
            Logger.getLogger(HouseEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
            
             if(!(this.anakainhsh.isEmpty()))
                h.setAnakainhsh(df.parse(this.anakainhsh));

        
       if(sxolia !=null)
       h.setSxolia(this.sxolia);
       
       
       helper.update_House(h);
       
        sellR = new SellRent[2];
        sellRi = new SellRentId[2];
        if(alf)
        {
            sellRi[0] = new SellRentId("Sale",this.odos);
            sellR[0] =  new SellRent(this.sellRi[0],this.h,Double.parseDouble(this.p1));
            helper = new HouseHelper();
            if(alf1)
            helper.update_type(sellR[0]);
            else
               helper.new_type(sellR[0]);
        }
        else
        {
           sellRi[0] = new SellRentId("Sale",this.odos);
           sellR[0] =  new SellRent(this.sellRi[0],this.h,0.0);
           helper = new HouseHelper();
           helper.delete_type(sellR[0]);
        }

        if(alfa)
        {
            sellRi[1] = new SellRentId("Rent",this.odos);
            sellR[1] =  new SellRent(this.sellRi[1],this.h,Double.parseDouble(this.p2));
            helper = new HouseHelper();
            if(alfa1)
             helper.update_type(sellR[1]);
            else
                helper.new_type(sellR[1]);
        }
        else
        {
           sellRi[1] = new SellRentId("Rent",this.odos);
           sellR[1] =  new SellRent(this.sellRi[1],this.h,0.0);
           helper = new HouseHelper();
           helper.delete_type(sellR[1]);
        }
       
       
       return"/secured/role?faces-redirect=true";       
    }
        private Part file1;

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }
    private static String getFilename(Part part)
    {
      for (String cd : part.getHeader("content-disposition").split(";"))
      {
        if(cd.trim().startsWith("filename"))
        {
          String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"","");
          return filename.substring(filename.indexOf('/')+1).substring(filename.lastIndexOf('\\')+1);
        }
      }
      return null;
    }
    public String upload(String username) throws IOException
    {
        String path,path1;
        path = "C:\\Users\\Christos\\Documents\\NetBeansProjects\\ted\\web\\images\\"+username+"\\"+this.odos+"\\"+getFilename(file1);
        path1 = "images/"+username+"/"+this.odos+"/"+getFilename(file1);
        file1.write(path);
        helper = new HouseHelper();
        photo = new Photos(this.h,path1);
        helper.upload_photos(photo);
        try {
            
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HouseEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
        helper = new HouseHelper();
            this.ph = helper.Houses_Photos(this.odos);
      return "/secured/houseedit?faces-redirect=true";
    }
    public String deletePhoto(String a ,int a1 )
    {
       //kane kati
       
      Photos p1 = new Photos();
      p1.setPhotos(a);
      p1.setHouses(h);
      p1.setId(a1);
      helper = new HouseHelper();
      helper.delete_photo(p1);
      try{
                
    		File file = new File("C://Users//Christos//Documents//NetBeansProjects//ted//web//images//"+a);
               
    		if(file.delete()){
    			System.out.println(file.getName() + " is deleted!");
    		}else{
    			System.out.println("Delete operation is failed.");
    		}
 
      
    }catch(Exception e){
 
    		e.printStackTrace();
 
    }	
      return this.change((this.odos),h.getUser().getUsername());
    }
    public String DeleteMessage(Messages m)
    {
       
       (new HouseHelper()).delete_message(m);
       this.messa = new ArrayList<Messages>();
        this.messa = (new HouseHelper()).Houses_messages(this.odos);
        if(this.messa != null)
        for(int i = 0;i<messa.size();i++)
        {
            tempUser = (new UserHelper()).rUser(this.messa.get(i).getUser().getUsername());
            this.messa.get(i).setUser(tempUser);
            
        }
        return "/secured/houseedit?faces-redirect=true";
    
    }
    
}
