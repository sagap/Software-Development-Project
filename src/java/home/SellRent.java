package home;
// Generated Sep 3, 2014 1:26:11 PM by Hibernate Tools 3.2.1.GA



/**
 * SellRent generated by hbm2java
 */
public class SellRent  implements java.io.Serializable {


     private SellRentId id;
     private Houses houses;
     private double payment;

    public SellRent() {
    }

    public SellRent(SellRentId id, Houses houses, double payment) {
       this.id = id;
       this.houses = houses;
       this.payment = payment;
    }
   
    public SellRentId getId() {
        return this.id;
    }
    
    public void setId(SellRentId id) {
        this.id = id;
    }
    public Houses getHouses() {
        return this.houses;
    }
    
    public void setHouses(Houses houses) {
        this.houses = houses;
    }
    public double getPayment() {
        return this.payment;
    }
    
    public void setPayment(double payment) {
        this.payment = payment;
    }




}


