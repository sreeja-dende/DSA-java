class TrieNode{
 Map<Character,TrieNode> children=new HashMap<>();
 Boolean isEndofWord=false;
}

class WordDictionary {
      private TrieNode root;
    public WordDictionary() {
       root=new TrieNode();
    }

    public void addWord(String word) {
      TrieNode current =root;
      for(char ch :word.toCharArray())
      { current.children.putIfAbsent(ch,new TrieNode());
        current=current.children.get(ch);       
      }
      current.isEndofWord=true;
    }

    public boolean search(String word) {
     return searchHelper(word, 0, root);
    }
    private boolean searchHelper(String word, int index, TrieNode node) {
    if (index == word.length()) return node.isEndofWord;

    char ch = word.charAt(index);

    if (ch == '.') {
      
        for (TrieNode child : node.children.values()) {
            if (searchHelper(word, index + 1, child)) return true;
        }
        return false;
    } else {
        if (!node.children.containsKey(ch)) return false;
        return searchHelper(word, index + 1, node.children.get(ch));
    }
}
}
