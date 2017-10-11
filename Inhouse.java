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
public class Inhouse extends Part{
    
    //Properties
    private int _machineID;
    
    //Constructor
    public Inhouse(int manchineID, String name, int partID, double price, int insTock, int min, int max){
        this._machineID = manchineID;
        this.setName(name);
        this.setPartID(partID);
        this.setPrice(price);
        this.setInStock(insTock);
        this.setMin(min);
        this.setMax(max);
    }
    
    
    //Getter and Setter Methods...
    public void setMachineID(int machineID){
        this._machineID = machineID;
    }
    public int getMachineID(){
        return this._machineID;
    }
    
}
