/*

208. Implement Trie (Prefix Tree)
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

https://leetcode.com/problems/implement-trie-prefix-tree/description/


*/

class TrieNode{
    private TrieNode[] links;
    private final int R = 26; // No of children
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char c){
        return links[c-'a'] != null;
    }
    public TrieNode get(char c){
        return links[c-'a'];
    }
    public void put(char c, TrieNode node){
        links[c-'a'] = node;
    }
    public void setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return isEnd;
    }
}


class Trie {
    private TrieNode root;
    public Trie() {
      root = new TrieNode();  
    }
    //Time Complexity - O(m) m is key or prefix length, Space Complexity - O(m)
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i< word.length(); i++){
            char cur = word.charAt(i);
            if(!node.containsKey(cur)){
                node.put(cur, new TrieNode());
            }
            node = node.get(cur);
        }
        node.setEnd();
    }
    //Time Complexity - O(m) m is key or prefix length, Space Complexity - O(1)
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }
    
    //Time Complexity - O(m) m is key or prefix length, Space Complexity - O(1)
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
    
    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(int i = 0; i< word.length(); i++){
            char cur = word.charAt(i);
            if(node.containsKey(cur)){
                node = node.get(cur);
            }else{
                return null;
            }
        }
        return node;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
