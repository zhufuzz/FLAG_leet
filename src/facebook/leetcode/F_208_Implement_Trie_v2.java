package facebook.leetcode;
//Trie, Design //F_208_Implement_Trie_v2
import java.util.*;
/*Implement a trie with insert, search, and startsWith methods.
Note:You may assume that all inputs are consist of lowercase letters a-z.*/

/** * Your Trie object will be instantiated and called as such: 
 * Trie trie = new Trie(); * trie.insert("lintcode"); * trie.search("lint"); 
 * will return false * trie.startsWith("lint"); will return true*/


public class F_208_Implement_Trie_v2 {
	
class TrieNode {
    // Initialize your data structure here.
    public HashMap<Character, TrieNode> children;public boolean hasWord;    
    // Initialize your data structure here.
    public TrieNode() {children = new HashMap<Character, TrieNode>();hasWord = false;}
}
	
	
private TrieNode root;
public F_208_Implement_Trie_v2() {root = new TrieNode();}    
// Inserts a word into the trie.
public void insert(String word) {
    TrieNode now = root;
    for(int i = 0; i < word.length(); i++) {
        Character c = word.charAt(i);
        if (!now.children.containsKey(c)) {
            now.children.put(c, new TrieNode());
        }
        now = now.children.get(c);
    }
    now.hasWord = true;
}

// Returns if the word is in the trie.
public boolean search(String word) {
    TrieNode now = root;
    for(int i = 0; i < word.length(); i++) {
        Character c = word.charAt(i);
        if (!now.children.containsKey(c)) {
            return false;
        }
        now = now.children.get(c);
    }
    return now.hasWord;
}
// Returns if there is any word in the trie// that starts with the given prefix.
public boolean startsWith(String prefix) {
    TrieNode now = root;
    for(int i = 0; i < prefix.length(); i++) {
        Character c = prefix.charAt(i);
        if (!now.children.containsKey(c)) {return false;}
        now = now.children.get(c);
    }
    return true;
}
}