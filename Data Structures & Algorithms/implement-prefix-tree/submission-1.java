class PrefixTree {

    TrieNode root; 
    class TrieNode {
        Map<Character, TrieNode> dependents = new HashMap<>();
        boolean isEnd = false;

        TrieNode() {

        }
    }
    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.dependents.get(c) == null) {
                curr.dependents.put(c, new TrieNode());
            }
            curr = curr.dependents.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.dependents.get(c) == null) {
                return false;
            }
            curr = curr.dependents.get(c);
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if(curr.dependents.get(c) == null) {
                return false;
            }
            curr = curr.dependents.get(c);
        }
        return true;
    }
}
