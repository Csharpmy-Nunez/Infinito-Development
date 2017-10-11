/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageit;

import javax.swing.JOptionPane;

/**
 *
 * @author Samy
 */
public abstract class Part {

    //Properties
    private String _name;
    private int _partID;
    private double _price;
    private int _inStock;
    private int _min;
    private int _max;
    
//    Constructors
//    public Part(){
//        JOptionPane.showMessageDialog(null, "A Part object without properties has been created");
//    }
//    public Part(String name, int partID, double price, int insTock, int min, int max){
//        
//        this._name = name;
//        this._partID = partID;
//        this._price = price;
//        this._inStock = insTock;
//        this._min = min;
//        this._max = max;
//    }
    
    
    
    //Getters and Setters
    public void setName(String name){
        this._name = name;
    }
     public String getName(){
        return this._name;
    }
     
    public void setPartID(int partID){
        this._partID = partID;
    }
    public int getPartID(){
        return this._partID;
    }
    
    public void setPrice(double price){
        this._price = price;
    }
    public double getPrice(){
        return this._price;
    }
    
    public void setInStock(int inStock){
        this._inStock = inStock;
    }
    public int getInStock(){
        return this._inStock;
    }
    
    public void setMin(int min){
        this._min = min;
    }
    public int getMin(){
        return this._min;
    }
    
    public void setMax(int max){
        this._max = max;
    }
    public int getMax(){
        return this._max;
    }

}
