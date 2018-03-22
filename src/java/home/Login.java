package home;

import javax.faces.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.primefaces.context.RequestContext;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


@ManagedBean
@SessionScoped

public class Login implements Serializable{
    
    private  String username;
    private  String password;

    private String name;
    private String surname;
    private String email;
    private String number;
    private User user;
    private UserHelper helper;
    private User temp,temp1;
    private List<RoleId> role;
    private Role role1 = null;
    private Role role2 = null;
    private int a;
    private int admin;
    private Admin adm;
    private boolean isLogged = false;
    private boolean adminLogged =false;
    private MapModel simpleModel;
private List<Photos> p = null;
private List<String> phot;
 @PostConstruct
 public void init()
 {
   
     simpleModel = new DefaultMapModel();
  //Shared coordinates 
 LatLng coord1 = new LatLng(37.949888, 23.750301);
 LatLng coord2 = new LatLng(37.960912,23.731806);
 LatLng coord3 = new LatLng(40.652261,22.949289);
 LatLng coord4 = new LatLng(36.420554,25.431446);
  LatLng coord5 = new LatLng(31.834401,-98.736510);
 LatLng coord6 = new LatLng(27.735809,-81.641784);
 LatLng coord7 = new LatLng(23.735334,-110.282902);
 LatLng coord8 = new LatLng(34.023644,-118.782016);
  LatLng coord9 = new LatLng(16.879466, 20.667648);
 LatLng coord10 = new LatLng(16.883707, 20.689216);
 LatLng coord11 = new LatLng(16.879703, 20.706707);
 LatLng coord12 = new LatLng(16.885233, 20.702323);
  LatLng coord13 = new LatLng(25.879466, 10.667649);
 LatLng coord14 = new LatLng(25.883707, 10.689219);
 LatLng coord15 = new LatLng(25.879703, 20.706709);
 LatLng coord16 = new LatLng(25.885233, 20.702329);
 //Basic marker
 simpleModel.addOverlay(new Marker(coord1));
 simpleModel.addOverlay(new Marker(coord2));
 simpleModel.addOverlay(new Marker(coord3));
 simpleModel.addOverlay(new Marker(coord4));
  simpleModel.addOverlay(new Marker(coord5));
 simpleModel.addOverlay(new Marker(coord6));
 simpleModel.addOverlay(new Marker(coord7));
 simpleModel.addOverlay(new Marker(coord8));
  simpleModel.addOverlay(new Marker(coord9));
 simpleModel.addOverlay(new Marker(coord10));
 simpleModel.addOverlay(new Marker(coord11));
 simpleModel.addOverlay(new Marker(coord12));
  simpleModel.addOverlay(new Marker(coord13));
 simpleModel.addOverlay(new Marker(coord14));
 simpleModel.addOverlay(new Marker(coord15));
 simpleModel.addOverlay(new Marker(coord16));
 
 phot = new ArrayList<String>();
 phot.add("images/10-modern-houses-with-integrated-pools-1.jpg");
 phot.add("images/Beautiful-Houses-Week32_E4-House-by-DADA-Partners_02.jpg");
 phot.add("images/images.jpg");
 phot.add("images/index.jpg");
 
 }
 public MapModel getSimpleModel()
 {
     return simpleModel;
 }

    public List<Photos> getP() {
        return p;
    }

    public void setP(List<Photos> p) {
        this.p = p;
    }

    public List<String> getPhot() {
        return phot;
    }
 


    public boolean isAdminLogged() {
        return adminLogged;
    }

    public void setAdminLogged(boolean adminLogged) {
        this.adminLogged = adminLogged;
    }

    
    public boolean isIsLogged() {
        return isLogged;
    }

    public void setIsLogged(boolean isLogged) {
        this.isLogged = isLogged;
    }
    
    
    public Admin getAdm() {
        return adm;
    }

    public void setAdm(Admin adm) {
        this.adm = adm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    
     public List<RoleId> getRole() {
        return role;
    }

    public User getTemp() {
        return temp;
    }

    public void setTemp(User temp) {
        this.temp = temp;
    }
    
    public void setRole(List<RoleId> role) {
        this.role = role;
    }
    Role role3 = null;
    Role role4 = null;
    

    public Login() {
    }
    public String user_change(){
            

       temp1 = new User(this.username,this.password,this.name,this.surname,this.email,this.number,temp.isPending());
       (new UserHelper()).update_User(temp1);
       return "/secured/role?faces-redirect=true";
    }
  
    public void user_login()
    {
      
        FacesMessage message = null;
        boolean loggedIn = false;
      user = new User(this.username,this.password);
      
      helper = new UserHelper();
      temp =  helper.login(user);
      //if(temp!=null)
    /* if(temp.getUsername().compareTo("admin")==0 && temp.getPassword().compareTo("123456")==0)
      {
   //     adm = new Admin();
     //   return adm.Admin_login();
            //this.username = this.temp.getUsername();
            //this.password = this.temp.getPassword();
            this.username1 = this.temp.getUsername();
            this.password1 = this.temp.getPassword();
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
          
         
           
      }*/
      
      
      if(temp == null)
      {
        username = null;
        password = null;
        loggedIn = false;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        FacesContext.getCurrentInstance().addMessage(null, message);
        a = 1;
      }
      else
      {  
        if(temp.isPending())
        {
          loggedIn = false;
        message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Confirmation pending");
        FacesContext.getCurrentInstance().addMessage(null, message);  
        a =1 ;
        }
        else
        {
          // Memory.getInstance().setUsername(this.temp.getUsername());
          // Memory.getInstance().setPassword(this.temp.getPassword());
           
            
         
           this.name = this.temp.getName();
           this.surname = this.temp.getSurname();
           this.email = this.temp.getEmail();
           this.number = this.temp.getNumber();
            loggedIn = true;
            this.isLogged = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            FacesContext.getCurrentInstance().addMessage(null, message);
            a = 0;
         if(this.username.compareTo("admin") != 0)
         {
            role = helper.User_Role(user);
            admin = 0;
         }
         else
         {
             admin = 1;
             this.adminLogged = true;   
         }
        }
      }
      
       
        //if(temp == null)
         // context.addCallbackParam("loggedIn", loggedIn);
        //else if (temp.getUsername().compareTo("admin") == 0)
        //{
         //   return "choose_admin?faces-redirect=true";
       // }
       // else
        //  return "House?faces-redirect=true";
   // return "index?faces-redirect=true";
    }
    public String givePage()
    {
       if(admin == 1)
           return "/secured/choose_admin?faces-redirect=true";
       if(a == 0)
           return "/secured/role?faces-redirect=true";
       else
           return "";
     
    }
    public String userLogout()
    {
        System.out.println("edw "+this.username);
       ((HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
       return "/index?faces-redirect=true";
      
    }
    

} 
