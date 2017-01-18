package com.java2novice.dp.proxy;
 
public class ProxyDemo {
 
    public static void main(String a[]){
         
        Internet intConn = new InternetProxy();
        try {
            intConn.connectTo("java2novice.com");
            intConn.connectTo("adult-site.com");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
