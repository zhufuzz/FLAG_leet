package OA1_xiaoyucool;

import java.util.*;

public class ValidParentheses{

	public static boolean validParenthese(String input){
		if(input == null || input.length() %2 == 1){
			return false;
		}
		int leftCount = 0;
		for(int i = 0;i<input.length();i++){
			Character curChar = input.charAt(i);
			if(curChar == '('){
				leftCount++;
			}else{
				if(leftCount == 0){
					return false;
				}
				leftCount--;
			}
		}
		return leftCount == 0;
	}

	public static void main(String[] args){
		 @SuppressWarnings("resource")
    Scanner sc = new Scanner(System.in);
		 String input = sc.nextLine();
		 if(validParenthese(input)){
		 	System.out.println(input + " is Valid!");
		 }else{
		 	System.out.println(input + " is not Valid!");
		 }
	}
}