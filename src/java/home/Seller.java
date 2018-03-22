package home;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;


@ManagedBean(name = "seller")
@SessionScoped
public class Seller {

    private UserHelper helper;
    private User user;
    private List<Houses> house;    
    private List<String> regions;
    private List<SelectItem> li;
    double maxM;
    double maxS;
    private String noAvailable = "";
    
    public Seller() {
    }
    
       public List<Houses> getHouse(){
        return house;
    }

    public double getMaxS() {
        return maxS;
    }

    public void setMaxS(double maxS) {
        this.maxS = maxS;
    }
     
    public double getMaxM() {
        return maxM;
    }

    public void setMaxM(double maxM) {
        this.maxM = maxM;
    }
    
    public List<String> getRegions() {
        return regions;
    }

    public List<SelectItem> getLi() {
        return li;
    }

    public void setLi(List<SelectItem> li) {
        this.li = li;
    }

    public String getNoAvailable() {
        return noAvailable;
    }

    
    public void setRegions(List<String> regions) {
        this.regions = regions;
    }
    
    public String user_houses(String value,String name)
    {
      
       if(value.compareTo("Seller")==0 || value.compareTo("Lessor") == 0)
       {
      user = new User();
      user.setUsername(name);
      helper = new UserHelper();
      house = helper.User_Houses(user);
      

      return "/secured/seller?faces-redirect=true";
       }
       else if(value.compareTo("Buyer") == 0)
       {
          regions = (new HouseHelper()).House_regions();
                maxM = (new HouseHelper()).House_MS();
          maxS = (new HouseHelper()).House_Square_MR();
          if( maxM == 0.0 || maxS == 0.0)
              this.noAvailable = "There aren't any available houses at the time. "
                      + "Sorry for the incovenience";
          else
              this.noAvailable = "";
          return "/secured/buyer?faces-redirect=true";
       }
       else if(value.compareTo("Renter") == 0)
       {
          regions = (new HouseHelper()).House_regions();
          maxM = (new HouseHelper()).House_MR();
          maxS = (new HouseHelper()).House_Square_MR();
          if( maxM == 0.0 || maxS == 0.0)
              this.noAvailable = "There aren't any available houses at the time. "
                      + "Sorry for the incovenience";
          else
              this.noAvailable = "";
          li = new ArrayList<SelectItem>();
          int k = regions.size();
          for(int i =0;i<k;i++)
          {
             li.add(new SelectItem(regions.get(i),regions.get(i)));
          }
          return "/secured/renter?faces-redirect=true";
       }
       else 
           return "";
    }

    public String epistrofh(String username)
    {
      user = new User();
      user.setUsername(username);
      helper = new UserHelper();
      house = helper.User_Houses(user);
      return "/secured/seller?faces-redirect=true";
    }

}
