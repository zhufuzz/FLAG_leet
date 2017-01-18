package facebook.leetcode;
//Math, String
/*Convert a non-negative integer to its english words representation. 
 * Given input is guaranteed to be less than 231 - 1.
For example,
123 -> "One Hundred Twenty Three"
12345 -> "Twelve Thousand Three Hundred Forty Five"
1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
Hint:

Did you see a pattern in dividing the number into chunk of words? 
For example, 123 and 123000.
Group the number by thousands (3 digits). 
You can write a helper function that takes a number less than 1000 
and convert just that chunk to words.*/

//https://github.com/jz33/LeetCodeSolutions/blob/master/273%20Integer%20to%20English%20Word.java

public class F_273_Integer_to_English_Words {
String[] lessThan20 = {"","One","Two","Three","Four","Five","Six","Seven",
		"Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
		"Sixteen","Seventeen","Eighteen","Nineteen"};
String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty",
		"Seventy","Eighty","Ninety"};
String[] thousands = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        String words = "";
        for(int i = 0;num > 0;i++){
            int r = num % 1000;
            if (r != 0){
                words = rec(r) + thousands[i] + " " + words;
            }
            num /= 1000;
        }
        return words.trim();
    }
    
    public String rec(int r){
        if (r == 0)
            return "";
        else if (r < 20)
            return lessThan20[r] + " ";
        else if (r < 100)
            return tens[r/10] + " " + rec(r%10);
        else
            return lessThan20[r/100] + " Hundred " + rec(r%100);
    }
}