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
public class Inventory {
    
    
    //Properties
    private static ArrayList<Product> productList =  new ArrayList<>();
    public static int _count = 0;
    
    
    //Methods...
    public void addProduct(Product product){   
        if(product != null){
            this.productList.add(product);
            _count++;
        }
    }
    
    public boolean removeProduct(int productID){
        boolean removed = false;
        //Product product = null;        
        for(int index = 0; index < this.productList.size(); index++){
                  if(this.productList.get(index).getProductID() == productID){
                     this.productList.remove(index);
                     _count--;
                     removed =  true;
                 }
             }
        
        return removed;
    }
    
    public Product lookUpProduct(String ProductName){
        Product product = null;
        for(int index = 0; index < this.productList.size(); index++){
            String name = this.productList.get(index).getName();
            
             if(name.equalsIgnoreCase(ProductName)){
                 product = this.productList.get(index);
             }
           
        }//-------------------------- 
     
        return product;
    }
    
    public void updateProduct(int productIndex, Product element){
            this.productList.set(productIndex - 1, element);       
    }
    
    public ArrayList<Product> accessProductList(){
        ArrayList<Product> list = this.productList;
        return list;
    }
    
}
