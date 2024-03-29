package facebook.leetcode;
//Trie, Design
//F_208_Implement_Trie_v1
/*Implement a trie with insert, search, and startsWith methods.
Note:You may assume that all inputs are consist of lowercase letters a-z.*/
// Version 1: Array of TrieNode
/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */


public class F_208_Implement_Trie_v1 {
	class TrieNode {
	    private TrieNode[] children;
	    public boolean hasWord;    
	    // Initialize your data structure here.
	    public TrieNode() { children = new TrieNode[26]; hasWord = false;}    
	    public void insert(String word, int index) {
	        if (index == word.length()) {this.hasWord = true; return;}        
	        int pos = word.charAt(index) - 'a';
	        if (children[pos] == null) {
	            children[pos] = new TrieNode();
	        }
	        children[pos].insert(word, index + 1);
	    }    
	    public TrieNode find(String word, int index) {
	        if (index == word.length()) {return this;}        
	        int pos = word.charAt(index) - 'a';
	        if (children[pos] == null) {return null;}
	        return children[pos].find(word, index + 1);
	    }
	}
	
    private TrieNode root; public F_208_Implement_Trie_v1() { root = new TrieNode(); }
    
    // Inserts a word into the trie.    
    public void insert(String word) { root.insert(word, 0); }
    
    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.find(word, 0);
        return (node != null && node.hasWord);}
    
    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root.find(prefix, 0);
        return node != null;
    }
}