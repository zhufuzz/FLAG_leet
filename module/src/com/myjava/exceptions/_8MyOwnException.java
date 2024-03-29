package com.myjava.exceptions;
 
public class _8MyOwnException {
    public static void main(String[] a){
        try{
            _8MyOwnException.myTest(null);
        } catch(MyAppException mae){
            System.out.println("Inside catch block: "+mae.getMessage());
        }
    }
     
    static void myTest(String str) throws MyAppException{
        if(str == null){
            throw new MyAppException("String val is null");
        }
    }
}
 
class MyAppException extends Exception {
 
    private String message = null;
 
    public MyAppException() {
        super();
    }
 
    public MyAppException(String message) {
        super(message);
        this.message = message;
    }
 
    public MyAppException(Throwable cause) {
        super(cause);
    }
 
    @Override
    public String toString() {
        return message;
    }
 
    @Override
    public String getMessage() {
        return message;
    }
}

/*How to Create Java Custom Exception
Sometimes it is required to develop meaningful exceptions based on application requirements. We can create our own exceptions by extending 'Exception' class. Below example shows how to create custom exception by extending Exception class.

- See more at: http://www.java2novice.com/java_exception_handling_examples/create_custom_exception/#sthash.iWJSXDis.dpuf*/