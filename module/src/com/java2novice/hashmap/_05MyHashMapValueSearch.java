package com.java2novice.hashmap;

import java.util.HashMap;
/*Program: How to search a value in HashMap?

Description:
Below example shows how to find whether specified value exists or not. 
By using containsValue() method you can find out the value existance.

- See more at: http://www.java2novice.com/java-collections-and-util/hashmap/value-search/#sthash.B1WPnkzc.dpuf*/
public class _05MyHashMapValueSearch {
     
    public static void main(String a[]){
        HashMap<String, String> hm = new HashMap<String, String>();
        //add key-value pair to hashmap
        hm.put("first", "FIRST INSERTED");
        hm.put("second", "SECOND INSERTED");
        hm.put("third","THIRD INSERTED");
        System.out.println(hm);
        if(hm.containsValue("SECOND INSERTED")){
            System.out.println("The hashmap contains value SECOND INSERTED");
        } else {
            System.out.println("The hashmap does not contains value SECOND INSERTED");
        }
        if(hm.containsValue("first")){
            System.out.println("The hashmap contains value first");
        } else {
            System.out.println("The hashmap does not contains value first");
        }
    }
}
