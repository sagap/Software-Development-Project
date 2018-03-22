
package home;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@ManagedBean
@SessionScoped
public class RegisterHouse {

     HouseHelper helper;
     Houses h;
     private String odos;
     private String tetragwnika;
     private boolean kentriki = false;
     private String sxolia = null;
     private boolean monokatoikia = false;
     private String xronosKataskevis;
     private String anakainhsh = null;
     private String type1 = null;
     private String type2 = null;
     private User user;
     private boolean t1 =false;
     private boolean t2=false;
     private String region;
     private Photos photo;
     private String koinoxrhsta;
     private String p1;
     private String p2;
     private boolean aytonomh =false;
     SellRentId[] sellRi;
     SellRent[] sellR;
     private Part file1=null;
     private UploadedFile file;
     private String userN;
     
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     

    public Part getFile1() {
        return file1;
    }

    public void setFile1(Part file1) {
        this.file1 = file1;
    }

     public String getRegion() {
        return region;
    }

    public boolean isT1() {
        return t1;
    }

    public void setT1(boolean t1) {
        this.t1 = t1;
    }

    public boolean isT2() {
        return t2;
    }

    public void setT2(boolean t2) {
        this.t2 = t2;
    }
     

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }
    
       

    public void setRegion(String region) {
        this.region = region;
    }

    public String getKoinoxrhsta() {
        return koinoxrhsta;
    }

    public void setKoinoxrhsta(String koinoxrhsta) {
        this.koinoxrhsta = koinoxrhsta;
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

    public boolean isAytonomh() {
        return aytonomh;
    }

    public void setAytonomh(boolean aytonomh) {
        this.aytonomh = aytonomh;
    }
     
    
    public RegisterHouse() {
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
    
    public String register_house(String username) throws IOException
    {
      helper = new HouseHelper();
      user = new User();
      user.setUsername(username);
      this.userN = username;
           try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date a =df.parse(this.xronosKataskevis);
            h = new Houses(this.odos,this.user , Double.parseDouble(this.tetragwnika),this.kentriki,this.monokatoikia, a,this.aytonomh,this.region);
             if(!(this.anakainhsh.isEmpty()))
                 h.setAnakainhsh(df.parse(this.anakainhsh));
        } catch (ParseException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
       if(sxolia !=null)
       h.setSxolia(this.sxolia);
       if(t1)
           type1 = "Sale";
       if(t2)
           type2 = "Rent";
       

       if(type1!= null && type2!=null)
       {    
         sellR = new SellRent[2];
         sellRi = new SellRentId[2];
         sellRi[0] = new SellRentId(type1,this.odos);
         sellR[0] =  new SellRent(this.sellRi[0],this.h,Double.parseDouble(p1));
         sellRi[1] = new SellRentId(type2,this.odos);
         sellR[1] =  new SellRent(this.sellRi[1],this.h,Double.parseDouble(p2));
       }
       else if(type1==null && type2!=null)
       {
         sellR = new SellRent[1];
         sellRi = new SellRentId[1];       
         sellRi[0] = new SellRentId(type2,this.odos);
         sellR[0] =  new SellRent(this.sellRi[0],this.h,Double.parseDouble(p2));         
       }
       else
       {
         sellR = new SellRent[1];
         sellRi = new SellRentId[1];       
         sellRi[0] = new SellRentId(type1,this.odos);
         sellR[0] =  new SellRent(this.sellRi[0],this.h,Double.parseDouble(p1));       
       }


               

       (new HouseHelper()).createHouse(h, sellR);
       
       String catalogue;
       catalogue = "C:\\Users\\Christos\\Documents\\NetBeansProjects\\ted\\web\\images\\"+username+"\\"+this.odos;
       Path xPath = Paths.get(catalogue);       
            
       Files.createDirectory(xPath);
             
            
            
       return "/secured/uploading?faces-redirect=true" ;
    
      }

    public String proceed()
    {
      return "/secured/houseedit2?faces-redirect=true";
        
    }
    
   
    /*private static String getFilename(Part part)
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
    }*/
    public String uploadPh() throws IOException
    {
        String path,path1;
        path = "C:\\Users\\Christos\\Documents\\NetBeansProjects\\ted\\web\\images\\"+this.userN+"\\"+this.odos+"\\";
        path1 = "images/"+this.userN+"/"+this.odos+"/"+this.file.getFileName();
  
        String filename = file.getFileName();
        InputStream input;
        input= file.getInputstream();
        OutputStream output = new FileOutputStream(new File(path, filename));

        try {
        IOUtils.copy(input, output);
         } finally {
        IOUtils.closeQuietly(input);
        
        }
        //file1.write(path);
        helper = new HouseHelper();
        photo = new Photos(this.h,path1);
        helper.upload_photos(photo);
        return "ok";
    }
    public void fileUploadListener(FileUploadEvent e){
        // Get uploaded file from the FileUploadEvent
        this.file = e.getFile();
        
        // Print out the information of the file
        System.out.println("Uploaded File Name Is :: "+file.getFileName()+" :: Uploaded File Size :: "+file.getSize());
         try {
             this.uploadPh();
         } catch (IOException ex) {
             Logger.getLogger(RegisterHouse.class.getName()).log(Level.SEVERE, null, ex);
         }
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage("File Uploaded Successfully"));
    }


}
