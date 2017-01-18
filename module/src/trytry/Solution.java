package trytry;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;




public class Solution {
	public static void main (String[] args) throws FileNotFoundException{
		Scanner in = new Scanner(new File("input.txt"));
		
		int n = in.nextInt();
		while (in.hasNext()) {
			System.out.println(n);
		}
		in.close();
	}
}

