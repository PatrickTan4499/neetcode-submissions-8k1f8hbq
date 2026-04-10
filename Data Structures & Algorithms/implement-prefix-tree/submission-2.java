class PrefixTree {

    TrieNode root;
    class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEnd;

        TrieNode() {
            this.children = new HashMap<>();
            this.isEnd = false;
        }
    }
    public PrefixTree() {
         this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children.get(c) == null) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c : word.toCharArray()) {
            if(curr.children.get(c) == null) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c : prefix.toCharArray()) {
            if(curr.children.get(c) == null) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
