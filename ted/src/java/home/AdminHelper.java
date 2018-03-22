/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package home;

import java.io.Serializable;
import java.util.List;
import org.hibernate.Session;


public class AdminHelper implements Serializable{
    Session session = null;
    
    public AdminHelper(){
    
        this.session = HibernateUtil.getSessionFactory().getCurrentSession();
    
    }
    
     public List<User> Users_Now()
     {
       this.session.beginTransaction();
       String query = "from User where username <> ?";
      
      List<User> userl;
      userl = (List<User>) session.createQuery(query).setParameter(0,"admin").list();
       session.getTransaction().commit();     
      if(userl.isEmpty())
          return null;
      else 
          return userl;
     
     }
     
     public int Confirm(User a)
     {
       this.session.beginTransaction();
  //session.saveOrUpdate(h);
  session.update(a);
   session.getTransaction().commit();
  return 1;
     }
    
}
