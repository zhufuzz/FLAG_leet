package com.java2novice.hashtable;

import java.util.Hashtable;
import java.util.Set;
 
public class _13MyHashtableDupEntry {
 
    public static void main(String a[]){
 
        Hashtable<Empl_3,String> tm = new Hashtable<Empl_3, String>();
        tm.put(new Empl_3(134,"Ram",3000), "RAM");
        tm.put(new Empl_3(235,"John",6000), "JOHN");
        tm.put(new Empl_3(876,"Crish",2000), "CRISH");
        tm.put(new Empl_3(512,"Tom",2400), "TOM");
        System.out.println("Adding duplicate entry:");
        tm.put(new Empl_3(512,"Tom",2400), "TOM");
        System.out.println("Hashtable entries:");
        Set<Empl_3> keys = tm.keySet();
        for(Empl_3 key:keys){
            System.out.println(key+" ==> "+tm.get(key));
        }
        System.out.println("Duplicate got eliminated!!!");
    }
}
 
class Empl_3{
     
    private String name;
    private int salary;
    private int id;
     
    public Empl_3(int id, String n, int s){
        this.id = id;
        this.name = n;
        this.salary = s;
    }
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getSalary() {
        return salary;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public String toString(){
        return "Id: "+this.id+" -- Name: "+this.name+" -- Salary: "+this.salary;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public int getId() {
        return id;
    }
     
    @Override
    public int hashCode() {
        System.out.println("In hashcode");
        return this.getId();
    }
     
    @Override
    public boolean equals(Object obj) {
        Empl_3 e = null;
        if(obj instanceof Empl_3){
            e = (Empl_3) obj;
        }
        System.out.println("In equals");
        if(this.getId() == e.getId()){
            return true;
        } else {
            return false;
        }
         
    }
}
