package home;

import java.util.ArrayList;
import java.util.List;


public class Saw {
    
       private List<Houses> h1;
  public Saw(){}
    
  public List<Houses> callSaw(int rows1,int columns1,List<SellRent> h,double[] w,String[] protimhseis)
  {
       int rows = rows1;
       int columns = columns1;
       double[][] x = new double[rows][columns];
       double[] Apot = new double[rows];
       double year;
       String[] year1;
       double[] weighted = new double[w.length];
       h1 = new ArrayList<Houses>();
       for(int l=0;l<rows;l++)
       {
          x[l][0] = h.get(l).getPayment();
          x[l][1] = h.get(l).getHouses().getTetragwnika();
          year1 = h.get(l).getHouses().getXronosKataskevis().toString().split("-");
          year = Double.parseDouble(year1[0]);
          x[l][2] = year;
          if(protimhseis[0].compareTo("Central Heating")==0)
          {    
              if(h.get(l).getHouses().isKentriki())
                x[l][3] = 10;
              else
                x[l][3] = 1;
          }
          else if(protimhseis[0].compareTo("Autonomous Heating")==0)
          {    
              if(h.get(l).getHouses().isKentriki())
                x[l][3] = 1;
              else
                x[l][3] = 10;
          }
          else
          {    
                x[l][3] = 5;
          }

          if(protimhseis[1].compareTo("Single House")==0)
          {    
              if(h.get(l).getHouses().isMonokatoikia())
                x[l][4] = 10;
              else
                x[l][4] = 1;
          }
          else if(protimhseis[1].compareTo("Apartment")==0)
          {    
              if(h.get(l).getHouses().isMonokatoikia())
                x[l][4] = 1;
              else
                x[l][4] = 10;
          }
          else
          {    
                x[l][4] = 5;
          }         
       
       }
       int [] theseis = new int [rows];
       
       for(int u=0;u<rows;u++)
           theseis[u] = u;
       for(int k=0;k<rows;k++)
       { 
         Apot[k] = 0;
         for(int j=0;j<5;j++)
         {
           if(j==0)
             Apot[k] -= x[k][j]*w[j];
           else
             Apot[k] += x[k][j]*w[j];
         }
                //System.out.println("EDWWWWW "+Apot[k]);
        }
       double swap;
       int swap2;
      for (int c = 0; c < ( rows - 1 ); c++) {
       for (int d = 0; d < rows - c - 1; d++) {
        if (Apot[d] < Apot[d+1]) /* For descending order use < */
        {
          swap  = Apot[d];
          Apot[d]   = Apot[d+1];
          Apot[d+1] = swap;
          swap2 = theseis[d];
          theseis[d] = theseis[d+1];
          theseis[d+1] = swap2;
        }
      }
    }
    for(int d=0;d<h.size();d++)
    {    
         h1.add(d, h.get(theseis[d]).getHouses());
         System.out.println("HEREEEE "+h1.get(d).getOdos()+"APottt: "+Apot[d]);
    }
    return h1;
  }        

}