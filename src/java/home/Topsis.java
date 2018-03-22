package home;

import java.util.ArrayList;
import java.util.List;

public class Topsis{
 private List<Houses> h1;
public Topsis(){}
public List<Houses> callTopsis(int rows1,int columns1,List<SellRent> h,double[] w,String[] protimhseis) {//GEN-FIRST:event_runButtonActionPerformed
       //read data into array
       int rows = rows1;
       int columns = columns1;
       int l;
       double sum = 0;
       double year;
       String[] year1;
       double[] weighted = new double[w.length];
       h1 = new ArrayList<Houses>();
       for(l = 0;l<w.length;l++)
       {
          sum += w[l];
       }
       for(l = 0;l<w.length;l++)
       {
          weighted[l] = w[l]/sum;
       }
       double[][] x = new double[rows][columns];
       String [][] y = new String [rows][2];
       for(l = 0;l<rows;l++)
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
       double[] maxCol = new double[columns];
       maxCol = findMax(x, columns, rows);
       double[][] r = new double[rows][columns];
       for(int i = 0;i<rows;i++)
       {
              for(int j=0;j<columns;j++)
              {
                 r[i][j] = x[i][j]/maxCol[j];
              
              }
           
       }
       double[][] t = new double[rows][columns];
       for(int i = 0;i<rows;i++)
       {
          for(int j = 0;j<columns;j++)
          {
             t[i][j] = r[i][j]*weighted[j];
          }
       
       }
       
       double[] idPositiveSol = new double[columns];
       double[] idNegativeSol = new double[columns];
      
       double[] positiveSeparation = new double[rows];
       double[] negativeSeparation = new double[rows];
       double[] coefficient = new double[rows];
       double bestSol =0;
       int[] bestAlternative = new int[10];
       for(int i = 0;i<10;i++)
           bestAlternative[i] = -1;
       for(int i = 0;i<rows;i++)
           bestAlternative[i] = i;
           
       idPositiveSol = identifyPositiveIdealSolution(t, columns, rows);
       idNegativeSol = identifyNegativeIdealSolution(t, columns, rows);
       positiveSeparation = calSeparation(t, idPositiveSol, columns, rows);
       negativeSeparation = calSeparation(t, idNegativeSol, columns, rows);
       coefficient = calCoefficient(positiveSeparation, negativeSeparation, rows);
       //look for best coefficient
       double swap;
       int swap2;
        for (int c = 0; c < ( rows - 1 ); c++) {
      for (int d = 0; d < rows - c - 1; d++) {
        if (coefficient[d] < coefficient[d+1]) /* For descending order use < */
        {
          swap  = coefficient[d];
          swap2 = bestAlternative[d];
          coefficient[d]   = coefficient[d+1];
          bestAlternative[d] = bestAlternative[d+1];
          coefficient[d+1] = swap;
          bestAlternative[d+1] = swap2;
        }
      }
    }
       for(int i = 0;i<10;i++)
       {
          if(bestAlternative[i] != -1)
              h1.add(i, h.get(bestAlternative[i]).getHouses());
          else
              break;
         System.out.println("best alternative is "+h.get(bestAlternative[i]).getHouses().getOdos() + bestAlternative[i] + " with coeffient " + coefficient[i]);    

       }
     //  for(int i=0; i<rows; i++){
       //    if(coefficient[i]>bestSol){
         //      bestSol=coefficient[i];
           //    bestAlternative = i;
          // }
       //   System.out.println("best alternative is "+h.get(bestAlternative).getHouses().getOdos() + bestAlternative + " with coeffient " + bestSol);    
      // }
     System.out.println("dafhasfhsfhsfsfhsfhsfhsfhsfh");
     return h1;
    }//GEN-LAST:event_runButtonActionPerformed
   //call identifyPossitiveIdealSolution
    private double[] findMax(double[][] scores,int columns,int rows)
    {
        double[] positiveIDS = new double[columns];
           for ( int c=0; c< columns; c++ ){
               double max = 0;
            
               for ( int r=0; r<rows; r++ ){
              
                      if(scores[r][c]>max)
                          max=scores[r][c];
               }
                   positiveIDS[c]=max;
           }
           return positiveIDS;
    }
    private double[] identifyPositiveIdealSolution(double[][] scores, int columns, int rows){
           
           double[] positiveIDS = new double[columns];
           for ( int c=0; c< columns; c++ ){
               double max = 0;
               double min = 1;
               for ( int r=0; r<rows; r++ ){
                   if(c == 0)
                   {
                        if(scores[r][c]<min)
                          min=scores[r][c];
                   }
                   else
                      if(scores[r][c]>max)
                          max=scores[r][c];
               }
               if(c == 0)
                   positiveIDS[c]=min;
               else
                   positiveIDS[c]=max;
           }
           return positiveIDS;
       }
    private double[] identifyNegativeIdealSolution(double[][] scores, int columns, int rows){
       
        double[] negativeIDS = new double[columns];
        for( int c=0; c<columns; c++){
            double min = 1;
            double max = 0;
            for (int r=0; r<rows; r++){
                if(c == 0)
                    if(scores[r][c]>max)
                          max=scores[r][c];
                else
                   if(scores[r][c]<min)
                    min=scores[r][c];
            }
            if(c == 0)
                negativeIDS[c]=max;
            else
                negativeIDS[c]=min;
        }
        return negativeIDS;
    }
    //calculate both possitive and negative
    private double[] calSeparation(double[][] scores, double[] idealSolution, int columns, int rows){
        double[] Separation = new double[rows];
       
        for(int r=0; r<rows; r++){
           
            double[] sumation= new double[rows];
            sumation[r]=0;
            double[] subtraction = new double[columns];
           
            for (int c=0; c<columns; c++){
                double sbttn=0;
                subtraction[c]= Math.abs(scores[r][c]-idealSolution[c]);
                sbttn=subtraction[c];
                sumation[r]= sumation[r] + Math.pow(sbttn, 2);
            }
            Separation[r]=Math.sqrt(sumation[r]);
        }
        return Separation;
           
    }
    private double[] calCoefficient(double[] positiveSeparation, double[] negativeSeparation, int rows){
        double[] coefficient = new double[rows];
        for(int r=0; r<rows; r++){
            coefficient[r] = negativeSeparation[r]/(negativeSeparation[r]+positiveSeparation[r]);
        }
       
        return coefficient;
    }
}