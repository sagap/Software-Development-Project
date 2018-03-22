
package home;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class Renter {

    private String value1,value2;
    private String[] regions;
    private Double t2,t1=0.0;
    private Double v2,v1=0.0;
    private String single;
    private String kataskevi1;
    private String kataskevi2 = null;
    private String anakainhsh;
    private String thermansi;
    private List<Houses> h1;
    private List<SellRent> h;
    private String a = " ,";
    private String noHouses;
    private PropertyFile p;
    String w1,w2,w3,w4,w5;
    int w11 =1,w22=1,w33=1;    
    public Renter() {
    }

    public int getW11() {
        return w11;
    }

    public void setW11(int w11) {
        this.w11 = w11;
    }

    public int getW22() {
        return w22;
    }

    public void setW22(int w22) {
        this.w22 = w22;
    }

    public int getW33() {
        return w33;
    }

    public void setW33(int w33) {
        this.w33 = w33;
    }
    
    
    
    public Double getV1() {
        return v1;
    }

    public void setV1(Double v1) {
        this.v1 = v1;
    }

    public Double getV2() {
        return v2;
    }

    public void setV2(Double v2) {
        this.v2 = v2;
    }
    
    public String getNoHouses() {
        return noHouses;
    }
    
    public List<Houses> getH1() {
        return h1;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public void setH1(List<Houses> h1) {
        this.h1 = h1;
    }

    public String getW1() {
        return w1;
    }

    public void setW1(String w1) {
        this.w1 = w1;
    }

    public String getW2() {
        return w2;
    }

    public void setW2(String w2) {
        this.w2 = w2;
    }

    public String getW3() {
        return w3;
    }

    public void setW3(String w3) {
        this.w3 = w3;
    }

    public String getW4() {
        return w4;
    }

    public void setW4(String w4) {
        this.w4 = w4;
    }

    public String getW5() {
        return w5;
    }

    public void setW5(String w5) {
        this.w5 = w5;
    }
    
    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public String getKataskevi1() {
        return kataskevi1;
    }

    public void setKataskevi1(String kataskevi1) {
        this.kataskevi1 = kataskevi1;
    }

    public String getKataskevi2() {
        return kataskevi2;
    }

    public void setKataskevi2(String kataskevi2) {
        this.kataskevi2 = kataskevi2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String[] getRegions() {
        return regions;
    }

    public void setRegions(String[] regions) {
        this.regions = regions;
    }

    public Double getT1() {
        return t1;
    }

    public void setT1(Double t1) {
        this.t1 = t1;
    }

    public Double getT2() {
        return t2;
    }

    public void setT2(Double t2) {
        this.t2 = t2;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    

    public String getAnakainhsh() {
        return anakainhsh;
    }

    public void setAnakainhsh(String anakainhsh) {
        this.anakainhsh = anakainhsh;
    }

    public String getThermansi() {
        return thermansi;
    }

    public void setThermansi(String thermansi) {
        this.thermansi = thermansi;
    }
    public String search(String username)
    {
        h = new ArrayList<SellRent>();
        value1 = v1.toString();
        value2 = v2.toString();
        if(kataskevi2 == null)
        {   
        h = (new HouseHelper()).House_searchR(regions,this.value1,this.value2,this.kataskevi1,this.t1,this.t2,this.thermansi,this.single,username);
        }
        else
        {
        h = (new HouseHelper()).House_searchR1(regions,this.value1,this.value2,this.kataskevi1,this.kataskevi2,this.t1,this.t2,this.thermansi,this.single,username);
        
        }    
      
        if(h!=null)
        for(int i = 0;i<h.size();i++)
        {
           System.out.println("ela re trelegka! "+h.get(i).getHouses().getOdos()+"yiha");
        
        }

        double[] w = new double[5];
        w[0] = (double)w11/10;
        w[1] = (double)w22/10;
        w[2] = (double)w33/10;
        w[3] = 0.3;//(double)Integer.parseInt(w3)/10;
        w[4] = 0.3;//(double)Integer.parseInt(w3)/10;
        String[] ab = new String[2];
        ab[0] = this.thermansi;
        ab[1] = this.single;
        this.p = new PropertyFile();
        System.out.println("edwwwww"+ w[0] +"  "+w[1]+" " +w[2]+" " +w[3]+" " +w[4]);
        if(h != null )
        {
            noHouses = "";
            if(p.Algo().compareTo("Saw") == 0)   
            {
                        //
                Saw t = new Saw();
                this.h1 = t.callSaw(h.size(), 5, h, w, ab);
            }
            else
            {
                Topsis t = new Topsis();
                this.h1 = t.callTopsis(h.size(), 5, h, w,ab);
            }
        }
        else
        {
            noHouses = "No houses are available right now.";
            if(this.h1 != null)
                this.h1.clear();
        }
        
        
        
       return "/secured/renter?faces-redirect=true";
    }
    public String make(Houses h)
    {
      this.a = h.getOdos()+" ,"+h.getRegion();
      return a;
    
    }
    
}
