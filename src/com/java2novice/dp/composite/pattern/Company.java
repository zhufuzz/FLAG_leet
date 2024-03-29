package com.java2novice.dp.composite.pattern;
 
public class Company {
 
    public static void main(String a[]){
         
        Engineer eng1 = new Engineer(100, "Nataraj", "Engineering");
        Engineer eng2 = new Engineer(101, "Ravi", "Engineering");
        CompanyDirectory engDirectory = new CompanyDirectory();
        engDirectory.addEmployee(eng1);
        engDirectory.addEmployee(eng2);
         
        Accountant acc1 = new Accountant(200, "Gopi", "Accounts");
        Accountant acc2 = new Accountant(201, "RamGopal", "Accounts");
        CompanyDirectory accDirectory = new CompanyDirectory();
        accDirectory.addEmployee(acc1);
        accDirectory.addEmployee(acc2);
     
        CompanyDirectory directory = new CompanyDirectory();
        directory.addEmployee(engDirectory);
        directory.addEmployee(accDirectory);
        directory.showEmployeeDetails();
    }
}
