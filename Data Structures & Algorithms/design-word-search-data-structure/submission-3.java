class WordDictionary {
    
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(curr.children.get(c) == null) {
                curr.children.put(c, new TrieNode());
            } 
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    private boolean searchHelper(TrieNode root, String word, int index) {
        if(index == word.length()) {
            return root.isEnd;
        }

        char c = word.charAt(index);
        if(c == '.') {
            for(TrieNode children : root.children.values()) {
                if(searchHelper(children, word, index+1)) {
                    return true;
                }

            }
                            return false;
        } else if(root.children.get(c) == null) {
            return false;
        }
        
        return searchHelper(root.children.get(c), word, index+1);
    }
}
