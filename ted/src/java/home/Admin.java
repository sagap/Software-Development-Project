
package home;

import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Admin implements Serializable{

    private List<User> userl;
    private AdminHelper ah;
    private List<User> confirmed;
    private List<User> pending;
    private User preview;
    private List<Houses> h;
    private User us1;
    private User us2;
    
     PropertyFile p;
    Properties prop;
    FileInputStream f = null;
   
   
 
    
    
    
    public Admin() {
    }

    public List<User> getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(List<User> confirmed) {
        this.confirmed = confirmed;
    }

    public User getUs1() {
        return us1;
    }

    public void setUs1(User us1) {
        this.us1 = us1;
    }

    public User getUs2() {
        return us2;
    }

    public void setUs2(User us2) {
        this.us2 = us2;
    }
    
    public List<User> getPending() {
        return pending;
    }

    public void setPending(List<User> pending) {
        this.pending = pending;
    }
  
    public List<User> getUserl() {
        return userl;
    }

    public User getPreview() {
        return preview;
    }

    public void setPreview(User preview) {
        this.preview = preview;
    }

    
    public void setUserl(List<User> userl) {
        this.userl = userl;
    }
       public void topsisAlg()
    {
        
            p = new PropertyFile();

 
            p.Ipt("Topsis");
        
    }
    public void sawAlg(){
      p = new PropertyFile();
      p.Ipt("Saw");
    
    }

    // Fortwnontai oi listes twn user 
    public String Admin_login()
    {
      ah = new AdminHelper();
      userl = ah.Users_Now();
      int i;
      int c1=0;
      int c2=0;
        
        confirmed = new ArrayList<User> ();
        pending = new ArrayList<User> ();
      for(i=0;i<userl.size();i++)
      { 
        if(userl.get(i).isPending())
        {
          pending.add(c1, userl.get(i));
       // System.out.println("KALAAAA"+ userl.get(i).getUsername());          
            c1++;
        }   
        else
        {
          confirmed.add(c2, userl.get(i));
        // System.out.println("CONFIRMED"+ userl.get(i).getUsername());
         c2++;
        }
      }
      return "/secured/admin?faces-redirect=true";
    }
    
    public String User_profile(User a)
    {
        preview = new User();
        preview =a ;
        return "Admin_user";
    }

    public String User_profile1(User a)
    {
        preview = new User();
        preview =a ;      
        return "Admin_user1";
    }
    
    // confirm the user 
    public String Confirm_user(User a)
    {
      ah = new AdminHelper();
      preview = new User();
      preview = a;
      preview.setPending(false);
      ah.Confirm(preview);
      return Admin_login();
    }
    
    public String Delete_user()
    {
      UserHelper hou;
      hou = new UserHelper();
      h = hou.User_Houses(preview);
      int i=0;
      for(i=0;i<h.size();i++)
      {
       // (new UserHelper()).User_Delete_Sell_Rent(h.get(i).getOdos());
        //(new UserHelper()).User_Delete_Photos(h.get(i).getOdos());
        //(new UserHelper()).User_Delete_Messages(h.get(i).getOdos());
        //(new UserHelper()).User_Delete_Houses(h.get(i).getOdos());
      }
        //(new UserHelper()).User_Delete_Roles(preview.getUsername());
        //(new UserHelper()).User_Delete_OwnMessages(preview.getUsername());
        File f = new File("C://Users//Christos//Documents//NetBeansProjects//ted/web//images//"+preview.getUsername());
        f.delete();
        return Admin_login();
    }
}
