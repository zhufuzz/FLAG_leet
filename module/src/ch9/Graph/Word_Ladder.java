package ch9.Graph;import java.util.ArrayList;import java.util.HashSet;import java.util.LinkedList;import java.util.Queue;import java.util.Set;
public class Word_Ladder {
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict == null) {           return 0;        }        
        dict.add(start);        dict.add(end);
        HashSet<String> hash = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);        hash.add(start);        
        int length = 1;
        while(!queue.isEmpty()) {
            length++;            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (hash.contains(nextWord)) {continue;}
                    if (nextWord.equals(end)) {return length;}                    
                    hash.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        return 0;
    }
    // replace character of a string at given index to a given character    
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();        chars[index] = c;
        return new String(chars);// return a new string
    }    
    // get connections with given word.
    // for example, given word = 'hot', dict = {'hot', 'hit', 'hog'}    
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {continue;}
                String nextWord = replace(word, i, c);
                if (dict.contains(nextWord)) {           nextWords.add(nextWord);           }
            }
        }
        return nextWords;// it will return ['hit', 'hog']
    }
}