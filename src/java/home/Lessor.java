package home;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Lessor {


    private UserHelper helper;
    User user;
    List<Houses> house;    
    
    public Lessor() {
    }
    
       public List<Houses> getHouse(){
        return house;
    }
    
    public String user_houses(String username)
    {
      
      user = new User();
      user.setUsername(username);
      helper = new UserHelper();
      house = helper.User_Houses(user);
      return "/secured/seller?faces-redirect=true";
    }  
}
