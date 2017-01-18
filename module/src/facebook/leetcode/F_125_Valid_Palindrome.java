package facebook.leetcode;
//Two pointers, String
/*Given a string, determine if it is a palindrome, 
 * considering only alphanumeric characters and ignoring cases.
For example, "A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.
Note: Have you consider that the string might be empty? 
This is a good question to ask during an interview.
For the purpose of this problem, we define empty string as valid palindrome.*/

public class F_125_Valid_Palindrome {
    public boolean isPalindrome(String s) {
         if(s.length() == 0) return true;
         s = s.replaceAll("[\\p{Punct}\\s]+", "").toLowerCase();
         int mid = s.length()/2, j = s.length() - 1;
         int i = 0;
         
         while(i < mid){
             if(s.charAt(i++) != s.charAt(j--)) return false;
         }
         return true;
     }

    public boolean isPalindrome2(String s) {
        if(s==null || s.length()<=1)
            return true;
        s=s.toLowerCase();
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!isValid(ci)){
                i++;
                continue;
            }
            if(! isValid(cj)){
                j--;
                continue;
            }
            if(ci!=cj)
                return false;
            i++;
            j--;
        }
        return true;
    }

    boolean isValid(char c){
        return (c>='0' && c<='9'|| c>='a' && c<='z');
    }
}