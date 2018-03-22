/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;



/**
 *
 * @author Christos
 */
@ManagedBean
@SessionScoped
public class Register implements Serializable {
    
     private String username;
     private String password;
     private String name;
     private String surname;
     private String confirmemail;
     private String password2;
     private int a;
     private String ap;
     private String[] selectedGroups;
     private String email;
     private String number;
     private String role1;
     private int answer;
     UserHelper helper;
     User user;
     Role role2;     
     RoleId[] rolei;
     Role[] rolet;
     File dir;
     
    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }
    
     
    public String getConfirmemail() {
        return confirmemail;
    }

    public void setConfirmemail(String confirmemail) {
        this.confirmemail = confirmemail;
    }

     
    public Register() {
        
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String[] getSelectedGroups() {
        return selectedGroups;
    }

    public void setSelectedGroups(String[] selectedGroups) {
        this.selectedGroups = selectedGroups;
    }
   
    public void registerUser() throws IOException{
        FacesContext context =FacesContext.getCurrentInstance();
           
        helper = new UserHelper();
        System.out.println("U000=Name"+username+"password"+password);
        int ab = helper.seeIfExists(this.username);
        if(ab == 0)
        {  
           helper = new UserHelper();
           user = new User(this.username,this.password,this.name,this.surname,this.email,this.number,true);
           int count = this.selectedGroups.length;
           rolet = new Role[count];
           rolei = new RoleId[count];
           int i=0;
           for(i=0;i<this.selectedGroups.length;i++)
          {
              rolei[i] = new RoleId(this.username,this.selectedGroups[i]);
              rolet[i] =  new Role(this.rolei[i],this.user);
          } 
          //role2 = new Role(this.user,this.rolet);
          a = helper.createUser(user, rolet);
          String catalogue;
        
       
          catalogue = "C:\\Users\\Christos\\Documents\\NetBeansProjects\\ted\\web\\images\\"+this.username;
          Path xPath = Paths.get(catalogue);
          if(a == 0)
          {
            
            //= new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Username already exists");
             context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Loggin Error","Username Already exists"));
              answer = 1;
            //return "register";
          }
          else
          {    
             
             //context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Loggin Error","User registered!Waiting for confirmation"));    
            //message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "User registered!Waiting for confirmation");
            Files.createDirectory(xPath);
            answer = 0;
            //return "index?faces-redirect=true";       
         }
        }
        else
        {
           context.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Loggin Error","Username Already exists"));    
           answer = 1;
           //        return "register?faces-redirect=true";
        }
        System.out.println("ACTION L "+answer);
    }
    public String givePage()
    {
       
       if(answer == 0)
           return "index?faces-redirect=true";
       else
           return "";//"register?faces-r1111111111111edirect=true";
    
    }
    
      public String getRole1() {
        return role1;
    }

    public void setRole1(String role1) {
        this.role1 = role1;
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
   
}
