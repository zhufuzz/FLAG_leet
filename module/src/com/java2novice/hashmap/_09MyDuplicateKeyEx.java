package com.java2novice.hashmap;

import java.util.HashMap;
import java.util.Set;
 /*Program: How to eliminate duplicate user defined objects as a key from HashMap?

Description:
Below example shows how to avoid duplicate user defined objects as a key from HashMap. 
You can achieve this by implementing equals and hashcode methods at the user defined objects.

- See more at: http://www.java2novice.com/java-collections-and-util/hashmap/duplicate-key/#sthash.bUdyRMfI.dpuf*/
public class _09MyDuplicateKeyEx {
 
    public static void main(String a[]){
         
        HashMap<Price, String> hm = new HashMap<Price, String>();
        hm.put(new Price("Banana", 20), "Banana");
        hm.put(new Price("Apple", 40), "Apple");
        hm.put(new Price("Orange", 30), "Orange");
        printMap(hm);
        Price key = new Price("Banana", 20);
        System.out.println("Adding duplicate key...");
        hm.put(key, "Grape");
        System.out.println("After adding dulicate key:");
        printMap(hm);
    }
     
    public static void printMap(HashMap<Price, String> map){
         
        Set<Price> keys = map.keySet();
        for(Price p:keys){
            System.out.println(p+"==>"+map.get(p));
        }
    }
}
 
class Price{
     
    private String item;
    private int price;
     
    public Price(String itm, int pr){
        this.item = itm;
        this.price = pr;
    }
     
    public int hashCode(){
        int hashcode = 0;
        hashcode = price*20;
        hashcode += item.hashCode();
        return hashcode;
    }
     
    public boolean equals(Object obj){
        if (obj instanceof Price) {
            Price pp = (Price) obj;
            return (pp.item.equals(this.item) && pp.price == this.price);
        } else {
            return false;
        }
    }
     
    public String getItem() {
        return item;
    }
    public void setItem(String item) {
        this.item = item;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
     
    public String toString(){
        return "item: "+item+"  price: "+price;
    }
}
