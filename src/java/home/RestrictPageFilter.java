
package home;

import java.io.IOException;
import java.util.Collection;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.Filter;


public class RestrictPageFilter implements Filter {
    
    FilterConfig fc;
    
    public void init(FilterConfig filterConfig) throws ServletException{
      fc = filterConfig;
     
    }
    
    public void doFilter(ServletRequest request,ServletResponse response,FilterChain chain)
    throws IOException,ServletException
    {
       HttpServletRequest req = (HttpServletRequest) request;
       HttpServletResponse resp = (HttpServletResponse) response;
       Login session = (Login) req.getSession().getAttribute("login");
       String url = req.getRequestURI();
       
      if(session == null || session.isIsLogged() == false)
       {
           System.out.println("eeeeeeeeeeeeeeeeeeeeeeeeeeeee ");
          
               resp.sendRedirect(req.getServletContext().getContextPath()+"/index.xhtml");
          //resp.sendRedirect("index.xhtml");
               System.out.println(req.getServletContext().getContextPath()+"/index.xhtml");
       
       }
       else
      {
          if(session.isAdminLogged())
           chain.doFilter(request, response);
          else
              if(url.indexOf("choose_admin.xhtml")>= 0 || url.indexOf("admin.xhtml")>= 0)
                  resp.sendRedirect(req.getServletContext().getContextPath()+"/secured/role.xhtml");
              else
                  chain.doFilter(request, response);
      }
    }
    public void destroy()
    {}

   
    
}
