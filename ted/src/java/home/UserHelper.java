package home;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;


public class UserHelper implements Serializable{
    Session session = null;
    
    public UserHelper(){
    
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    }
    
    public User login(User user)
    {
      this.session.beginTransaction();
      
      //Query query=  session.createQuery("from User where username=:uname");
        String query = "from User where username= ? and password = ?";
        List<User> user1;
        user1 = (List<User>) session.createQuery(query).setParameter(0, user.getUsername()).setString(1,user.getPassword()).list();
        if(!user1.isEmpty())
          return user1.get(0);
        else 
          return null;

   }
    public int update_User(User u)
   {
      this.session.beginTransaction();

      session.merge(u);
      session.getTransaction().commit();
      return 1;
}
    public User rUser(String username)
    {
         this.session.beginTransaction();
         String Query = "from User where username = ?";
         List<User> user1;
         user1 = (List<User>) session.createQuery(Query).setParameter(0, username).list();
         return user1.get(0);
    }
   public List<RoleId> User_Role (User user)
   {
        this.session.beginTransaction();
        String query = "from Role where user_username = ?";
        
        List<RoleId> role;
        role = (List<RoleId>) session.createQuery(query).setParameter(0, user.getUsername()).list();
        //int megethos = role.size();
      //  String[] roles = new String[megethos];
    //    int i;
  //      for(i=0;i<role.size();i++)
//            roles[i] = role[i]; 
        return role; 
   
   }
   public List<Houses> User_Houses(User user){
      this.session.beginTransaction();
      String query = "from Houses where user_username = ?";
      
      List<Houses> house;
      house = (List<Houses>) session.createQuery(query).setParameter(0, user.getUsername()).list();
      return house;
   
   }
   public int seeIfExists(String username)
   {
      this.session.beginTransaction();
      String query = "from User where username =?";
      List<User> u = null;
      u = (List<User>)session.createQuery(query).setParameter(0, username).list();
      if(u.isEmpty())
      { 
          System.out.println("U is empty");
          return 0;
      
      }
        else
          return 1;
      
   
   
   }        
    public int createUser(User user,Role[] role)
    {
       
       this.session.beginTransaction();
       int a=1;
       //user.getRoles().add(role);
       
       try{
       session.save(user);
       int i =0;
       for(i=0;i<role.length;i++)
       session.save(role[i]);
       }    
      catch (Exception e) {
   // Throwable t = e.getCause();
    //while ((t != null) && !(t instanceof ConstraintViolationException)) {
      //  t = t.getCause();
    //}
 //   if (t instanceof ConstraintViolationException) {
        // Here you're sure you have a ConstraintViolationException, you can handle it
               return 0;
    }
    
       session.getTransaction().commit();     
           return 1;
}
}
