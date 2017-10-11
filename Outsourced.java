/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageit;

/**
 *
 * @author Samy
 */
public class Outsourced extends Part{
    
    //Properties
    private String _companyName;
    
    //Constructor
    public Outsourced(String companyName, String name, int partID, double price, int insTock, int min, int max){
        this._companyName = companyName;
        this.setName(name);
        this.setPartID(partID);
        this.setPrice(price);
        this.setInStock(insTock);
        this.setMin(min);
        this.setMax(max);
    }
    
    
    //Getter and Setter
    public void setCompanyName(String companyName){
        this._companyName = companyName;
    }
    public String getCompanyName(){
        return this._companyName;
    }
    
}
