package ch9S.chapter2_DataStructure1;
//Version1 use Array
public class _09Add_and_Search_Word_1 {

}

class WordDictionary {
	class TrieNode {
		public TrieNode[] children;
	    public boolean hasWord;
	    
	    public TrieNode() {
	        children = new TrieNode[26];
	        for (int i = 0; i < 26; ++i)
	            children[i] = null;
	        hasWord = false;
	    }
	}
    private TrieNode root;
 
    public WordDictionary(){
        root = new TrieNode();
    }
 
    // Adds a word into the data structure.
    public void addWord(String word) {
        // Write your code here
        TrieNode now = root;
        for(int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (now.children[c - 'a'] == null) {
                now.children[c - 'a'] = new TrieNode();
            }
            now = now.children[c - 'a'];
        }
        now.hasWord = true;
    }
    
    boolean find(String word, int index, TrieNode now) {
        if(index == word.length()) {
            return now.hasWord;
        }
        
        Character c = word.charAt(index);
        if (c == '.') {
            for(int i = 0; i < 26; ++i) 
            if (now.children[i] != null) {
                if (find(word, index+1, now.children[i]))
                    return true;
            }
            return false;
        } else if (now.children[c - 'a'] != null) {
            return find(word, index+1, now.children[c - 'a']);  
        } else {
            return false;
        }
    }
    
    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        // Write your code here
        return find(word, 0, root);
    }
}
