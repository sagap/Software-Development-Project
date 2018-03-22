package home;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;


public class HouseHelper implements Serializable{
    Session session = null;
    
    public HouseHelper(){
    
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    }
    
public int delete_type(SellRent sr)
{
     this.session.beginTransaction();
     session.delete(sr);
      session.getTransaction().commit();
     return 1;
}

public int update_House(Houses h)
{
  this.session.beginTransaction();

  session.merge(h);
   session.getTransaction().commit();
  return 1;
}    

public int update_type(SellRent sr)
{
  this.session.beginTransaction();
  //session.saveOrUpdate(sr);
  session.merge(sr);
   session.getTransaction().commit();
  return 1;
}   
public int delete_photo(Photos a)
{
   this.session.beginTransaction();
   session.delete(a);
   session.getTransaction().commit();
   return 1;
}
public void delete_message(Messages m)
{
   this.session.beginTransaction();
   session.delete(m);
   session.beginTransaction().commit();


}
    public int new_type(SellRent sr)
    {
      this.session.beginTransaction();
      session.save(sr);
      session.getTransaction().commit();
      return 1;
    
    }
 public int createHouse(Houses house,SellRent[] sr)
    {
          this.session.beginTransaction();
       //user.getRoles().add(role);
       
       try{
       session.save(house);
       int i =0;
       for(i=0;i<sr.length;i++)
       session.save(sr[i]);
       }
       catch(ConstraintViolationException e)
       {
          
         System.out.println(e.getErrorCode());
         if(!e.toString().contains("@"))
             System.out.println("skatares");
        
         if(e.getErrorCode() == 1062)
            return 0;
         else
            return 1;
       }
       
       session.getTransaction().commit();
       return 1;
    }
 
    public int upload_photos(Photos photo)
    {
      this.session.beginTransaction();
       
      try{
        session.save(photo);
       }
       catch(ConstraintViolationException e)
       {
          
         System.out.println(e.getErrorCode());
       }       
       session.getTransaction().commit();
      
       return 1;
    }
    public int upload_message(Messages message)
    {
        this.session.beginTransaction();
        session.save(message);
        session.getTransaction().commit();
        return 1;
    }
    public Houses getHouse(String a)
    {
      this.session.beginTransaction();
      
      //Query query=  session.createQuery("from User where username=:uname");
        String query = "from Houses where odos= ? ";
        List<Houses> h;
        h = (List<Houses>) session.createQuery(query).setParameter(0, a).list();
        session.getTransaction().commit();   
        return h.get(0);
   }
    
      public List<String> House_regions()
      {
          this.session.beginTransaction();
         String query = "select distinct region from Houses";
         List<String> r;
         r = (List<String>) session.createSQLQuery(query).addScalar("region",Hibernate.STRING).list();
         session.getTransaction().commit();
         for(int i = 0;i<r.size();i++)
             System.out.println("panagia tsouliiiii "+r.get(i));
         return r;
      }
      public double House_MR()
      {
         this.session.beginTransaction();
         String query = "select a.payment from SellRent a where type = 'Rent'  order by payment desc";
         List<Double> m ;
         m = (List<Double>)session.createQuery(query).list();
         session.getTransaction().commit();
         if(!m.isEmpty())
            return m.get(0);
         return 0.0;     
      }
      public double House_MS()
      {
         this.session.beginTransaction();
         String query = "select a.payment from SellRent a where type = 'Sale'  order by payment desc";
         List<Double> m ;
         m = (List<Double>)session.createQuery(query).list();
         session.getTransaction().commit();
         if(!m.isEmpty())
         {
            System.out.println("eeeeeeeeeee "+m.get(0));
            return m.get(0);
         }
         return 0.0;
      
      }
      
        public double House_Square_MR()
      {
         this.session.beginTransaction();
         String query = "select a.tetragwnika from Houses a order by tetragwnika desc";
         List<Double> m = null;
         m = (List<Double>)session.createQuery(query).list();
         if(!m.isEmpty())
           return m.get(0);
         return 0.0;
      }
      
      public List<SellRent> sell_rent(String a)
      {
        this.session.beginTransaction();
      
      //Query query=  session.createQuery("from User where username=:uname");
        String query = "from SellRent where houses_odos= ? ";
        List<SellRent> h;
        h = (List<SellRent>) session.createQuery(query).setParameter(0, a).list();
        session.getTransaction().commit();
        return h;    
      
      
      }        
      public List<SellRent> House_searchR(String[] regions,String value1,String value2,String kataskevi1,Double t1,Double t2,String thermansi,String single,String username)
      {
         List<SellRent> h = null;
         h = new ArrayList<SellRent>();
         int l=0;
         this.session.beginTransaction();
         String date1 = kataskevi1+"-01-01";
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         
         Date date2 = null;
         try {
             date2 = df.parse(date1);
         } catch (ParseException ex) {
             Logger.getLogger(HouseHelper.class.getName()).log(Level.SEVERE, null, ex);
         }
          
         for(int i=0;i < regions.length;i++)
         {
             
      
      //Query query=  session.createQuery("from User where username=:uname");
            String query ="from SellRent where type='Rent' and (payment between ? and ?)  "; //"from Houses where (region = ?) and (xronos_kataskevis >= ?) and (tetragwnika between ? and ?) and odos in (select Houses.odos from SellRent where type = 'Sale'  and payment between ? and ?)  )";
            List<Houses> h1;
        //h1 = (List<Houses>) session.createQuery(query).list();//.setParameter(0, regions[i]).setParameter(1, date1).setParameter(2,t1).setParameter(3, t2).setParameter(4, value1).setParameter(5, value2).list();
        List<SellRent> h2;
        h2 = (List<SellRent>) session.createQuery(query).setParameter(0, value1).setParameter(1,value2).list();
        
        if(h2!= null)
          for(int k =0;k< h2.size();k++)
        {
           System.out.println("ela mou "+(h2.get(k).getHouses().getOdos()));
           if(h2.get(k).getHouses().getRegion().compareTo(regions[i]) == 0)
               if(h2.get(k).getHouses().getXronosKataskevis().after(date2))
                   if(((t1) <= h2.get(k).getHouses().getTetragwnika()) && (h2.get(k).getHouses().getTetragwnika() <= (t2)) )
                   if(h2.get(k).getHouses().getUser().getUsername().compareTo(username) != 0)
                   {
                       h.add(l, h2.get(k));
                       l++;
                   }
          
        }   
         }
         session.getTransaction().commit();
         if(h.isEmpty())
             return null;
         else
             return h;  
      
      }
            public List<SellRent> House_search(String[] regions,String value1,String value2,String kataskevi1,Double t1,Double t2,String thermansi,String single,String username)
      {
         List<SellRent> h = null;
         h = new ArrayList<SellRent>();
         int l=0;
         this.session.beginTransaction();
         String date1 = kataskevi1+"-01-01";
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         
         Date date2 = null;
        try {
            date2 = df.parse(date1);
        } catch (ParseException ex) {
            Logger.getLogger(HouseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
         for(int i=0;i < regions.length;i++)
         {
             
      
      //Query query=  session.createQuery("from User where username=:uname");
        String query ="from SellRent where type='Sale' and (payment between ? and ?)   "; //"from Houses where (region = ?) and (xronos_kataskevis >= ?) and (tetragwnika between ? and ?) and odos in (select Houses.odos from SellRent where type = 'Sale'  and payment between ? and ?)  )";
        List<Houses> h1;
        //h1 = (List<Houses>) session.createQuery(query).list();//.setParameter(0, regions[i]).setParameter(1, date1).setParameter(2,t1).setParameter(3, t2).setParameter(4, value1).setParameter(5, value2).list();
        List<SellRent> h2;
        h2 = (List<SellRent>) session.createQuery(query).setParameter(0, value1).setParameter(1,value2).list();
        
        if(h2!= null)
          for(int k =0;k< h2.size();k++)
        {
           System.out.println("ela mou "+(h2.get(k).getHouses().getOdos()));
           if(h2.get(k).getHouses().getRegion().compareTo(regions[i]) == 0)
               if(h2.get(k).getHouses().getXronosKataskevis().after(date2))
                   if(((t1) <= h2.get(k).getHouses().getTetragwnika()) && (h2.get(k).getHouses().getTetragwnika() <= (t2)) )
                   if(h2.get(k).getHouses().getUser().getUsername().compareTo(username) != 0)
                   {
                       h.add(l, h2.get(k));
                       l++;
                   }
          
        }   
         }
         session.getTransaction().commit();
         if(h.isEmpty())
             return null;
         else
             return h;  
      
      }
      
      public List<SellRent> House_search1(String[] regions,String value1,String value2,String kataskevi1,String kataskevi2,Double t1,Double t2,String thermansi,String single,String username)
      {
         List<SellRent> h = null;
         h = new ArrayList<SellRent>();
         int l=0;
         this.session.beginTransaction();
         String date1 = kataskevi1+"-01-01";
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         
         Date date2 = null;
        try {
            date2 = df.parse(date1);
        } catch (ParseException ex) {
            Logger.getLogger(HouseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
         String date3 = kataskevi2+"-01-01";
         SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
         
         Date date4 = null;
        try {
            date4 = df.parse(date3);
        } catch (ParseException ex) {
            Logger.getLogger(HouseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         for(int i=0;i < regions.length;i++)
         {
             
      
      //Query query=  session.createQuery("from User where username=:uname");
        String query ="from SellRent where type='Sale' and (payment between ? and ?)  "; //"from Houses where (region = ?) and (xronos_kataskevis >= ?) and (tetragwnika between ? and ?) and odos in (select Houses.odos from SellRent where type = 'Sale'  and payment between ? and ?)  )";
        List<Houses> h1;
        //h1 = (List<Houses>) session.createQuery(query).list();//.setParameter(0, regions[i]).setParameter(1, date1).setParameter(2,t1).setParameter(3, t2).setParameter(4, value1).setParameter(5, value2).list();
        List<SellRent> h2;
        h2 = (List<SellRent>) session.createQuery(query).setParameter(0, value1).setParameter(1,value2).list();
        
        if(h2!= null)
          for(int k =0;k< h2.size();k++)
        {
           System.out.println("ela mou "+(h2.get(k).getHouses().getOdos()));
           if(h2.get(k).getHouses().getRegion().compareTo(regions[i]) == 0)
               if(h2.get(k).getHouses().getXronosKataskevis().after(date2))
                 if(((t1) <= h2.get(k).getHouses().getTetragwnika()) && (h2.get(k).getHouses().getTetragwnika() <= (t2)) )
                   if(h2.get(k).getHouses().getAnakainhsh().after(date4))
                   if(h2.get(k).getHouses().getUser().getUsername().compareTo(username) != 0)
                   {
                       
                       h.add(l, h2.get(k));
                       l++;
                   }
          
        }   
         }
         session.getTransaction().commit();
         if(h.isEmpty())
             return null;
         else
             return h;  
      
      }
      public List<SellRent> House_searchR1(String[] regions,String value1,String value2,String kataskevi1,String kataskevi2,Double t1,Double t2,String thermansi,String single,String username)
      {
         List<SellRent> h = null;
         h = new ArrayList<SellRent>();
         int l=0;
         this.session.beginTransaction();
         String date1 = kataskevi1+"-01-01";
         SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
         
         Date date2 = null;
        try {
            date2 = df.parse(date1);
        } catch (ParseException ex) {
            Logger.getLogger(HouseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
         String date3 = kataskevi2+"-01-01";
         SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
         
         Date date4 = null;
        try {
            date4 = df.parse(date3);
        } catch (ParseException ex) {
            Logger.getLogger(HouseHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
         for(int i=0;i < regions.length;i++)
         {
             
      
      //Query query=  session.createQuery("from User where username=:uname");
        String query ="from SellRent where type='Rent' and (payment between ? and ?)  "; //"from Houses where (region = ?) and (xronos_kataskevis >= ?) and (tetragwnika between ? and ?) and odos in (select Houses.odos from SellRent where type = 'Sale'  and payment between ? and ?)  )";
        List<Houses> h1;
        //h1 = (List<Houses>) session.createQuery(query).list();//.setParameter(0, regions[i]).setParameter(1, date1).setParameter(2,t1).setParameter(3, t2).setParameter(4, value1).setParameter(5, value2).list();
        List<SellRent> h2;
        h2 = (List<SellRent>) session.createQuery(query).setParameter(0, value1).setParameter(1,value2).list();
        
        if(h2!= null)
          for(int k =0;k< h2.size();k++)
        {
           System.out.println("ela mou "+(h2.get(k).getHouses().getOdos()));
           if(h2.get(k).getHouses().getRegion().compareTo(regions[i]) == 0)
               if(h2.get(k).getHouses().getXronosKataskevis().after(date2))
                 if(((t1) <= h2.get(k).getHouses().getTetragwnika()) && (h2.get(k).getHouses().getTetragwnika() <= (t2)) )
                   if(h2.get(k).getHouses().getAnakainhsh().after(date4))
                   if(h2.get(k).getHouses().getUser().getUsername().compareTo(username) != 0)
                   {
                       
                       h.add(l, h2.get(k));
                       l++;
                   }
          
        }   
         }
         session.getTransaction().commit();
         if(h.isEmpty())
             return null;
         else
             return h;  
      
      }
      
      public List<Photos> Houses_Photos(String a){
      this.session.beginTransaction();
      String query = "from Photos where houses_odos = ?";
      
      List<Photos> photos;
      photos = (List<Photos>) session.createQuery(query).setParameter(0, a).list();
      session.getTransaction().commit();
      if(photos.isEmpty())
          return null;
      else
          return photos;
   
   }
   public List<Messages> Houses_messages(String a)
   {
      this.session.beginTransaction();
      String query = "from Messages where houses_odos = ?";
      List<Messages> m;
      m = (List<Messages>) session.createQuery(query).setParameter(0, a).list();
      session.getTransaction().commit();
      if(m.isEmpty())
          return null;
      else
          return m;
   
   }
}
