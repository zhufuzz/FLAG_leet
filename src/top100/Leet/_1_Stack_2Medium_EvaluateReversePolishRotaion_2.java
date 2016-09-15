package top100.Leet;

import java.util.Deque;
import java.util.LinkedList;

import com.sun.javafx.css.CalculatedValue;

public class _1_Stack_2Medium_EvaluateReversePolishRotaion_2 {
	public int evalInFix(char[] tokens) {
		//Corner Case Checked
		Deque<Integer> valStack = new LinkedList<Integer>();//Stack to store numbers
		Deque<Character> opStack = new LinkedList<Character>();//Stack to store operators
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i] == '(') {//Case 1:'('
				opStack.offerLast(tokens[i]);
			} else if (tokens[i] == ')') {//Case 2; ')'
				 while(opStack.peekLast() != '(') {
					 valStack.offerLast(cal(opStack.pollLast(), valStack.peekLast(), valStack.pollLast()));
				 }
				opStack.pollLast();//Poll '(';
			} else if (tokens[i] == '+' || tokens[i] == '-' 
					|| tokens[i] == '*' || tokens[i] == '/' ){//Case 3: Operators other than parentheses
				while  (!opStack.isEmpty() &&  isLowerThan(tokens[i], opStack.peekLast())) {
					valStack.offerLast(cal(opStack.peekLast(),valStack.pollLast(),valStack.pollLast()));
				}
				opStack.offerLast(tokens[i]); //offer current operator
				
			} else {//Case 4: number
				valStack.offerLast(Integer.parseInt(tokens[i]));
			}
		}
		//Calculate all numbers rest in stack
		while (!opStack.isEmpty()) {
			valStack.offerLast(cal(opStack.pollLast(), valStack.pollLast(), valStack.pollLast()));
		}
		return valStack.pollLast();
	}

	private boolean isLowerThan(char c, Character peekLast) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
