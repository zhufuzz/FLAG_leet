package com.java2novice.dp.composite.pattern;
 
public class Engineer implements Employee {
 
    private String name;
    private long empId;
    private String department;
 
    public Engineer(long empId, String name, String department){
        this.empId = empId;
        this.name = name;
        this.department = department;
    }
     
    @Override
    public void showEmployeeDetails() {
        System.out.println(empId+" ***** "+name+" ***** "+department);
    }
}
