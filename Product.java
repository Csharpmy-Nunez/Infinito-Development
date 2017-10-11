/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manageit;

import java.util.ArrayList;

/**
 *
 * @author Samy
 */
public class Product {
    
    //Properties
    ArrayList<Part> _partList;
    private String _name;
    private int _productID;
    private double _price;
    private int _inStock;
    private int _min;
    private int _max;
    
    //Constructor
    public Product(ArrayList<Part> partList, String name, int productID, double price, int insTock, int min, int max){
        this._partList = partList;
        this._productID = productID;
        this._name = name;
        this._price = price;
        this._inStock = insTock;
        this._min = min;
        this._max = max;
    }
    
    
     //Getters and Setters
    public void setName(String name){
        this._name = name;
    }
     public String getName(){
        return this._name;
    }
     
    public void setProductID(int productID){
        this._productID = productID;
    }
    public int getProductID(){
        return this._productID;
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
    
    //Method
    public void addToList(Part part){
        _partList = new ArrayList<>();
        _partList.add(part);
    }
    
    
}
