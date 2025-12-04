class TrieNode{
   Map<Character,TrieNode> children=new HashMap<>();
   Boolean isEndOfWord=false;
}
class PrefixTree {
     private TrieNode root;
    public PrefixTree() {
   root=new TrieNode();
    }

    public void insert(String word) {
       TrieNode current=root;
       for(char ch:word.toCharArray())
       { current.children.putIfAbsent(ch,new TrieNode());
         current=current.children.get(ch);        
       }
        current.isEndOfWord = true;
    }

    public boolean search(String word) {
       TrieNode current=root;
       for(char ch:word.toCharArray())
       { if(!current.children.containsKey(ch))
            return false;
          current = current.children.get(ch);
       }
       return current.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) {
                return false;   
            }
            current = current.children.get(ch);
        }

        return true; 
    }
}
