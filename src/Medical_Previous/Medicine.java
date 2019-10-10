/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Medical_Previous;

/**
 *
 * @author herrerach_sd2022
 */
public class Medicine {
    String GenericName;
    String BrandName;
    double Medprice;
    String illness;

    public Medicine(String GenericName, String BrandName, double Medprice, String illness) {
        this.GenericName = GenericName;
        this.BrandName = BrandName;
        this.Medprice = Medprice;
        this.illness = illness;
    }

    public String getGenericName() {
        return GenericName;
    }

    public void setGenericName(String GenericName) {
        this.GenericName = GenericName;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String BrandName) {
        this.BrandName = BrandName;
    }

    public double getMedprice() {
        return Medprice;
    }

    public void setMedprice(double Medprice) {
        this.Medprice = Medprice;
    }

    public String getIllness() {
        return illness;
    }

    public void setIllness(String illness) {
        this.illness = illness;
    }

    @Override
    public String toString() {
        return String.format("%20s %5s %20s %5s %15s %5s", GenericName,"|", BrandName,"|",Medprice,"|", illness, "\n");
        
    }
    
    
 
}