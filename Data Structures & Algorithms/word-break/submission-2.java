class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] cache = new Boolean[s.length()];
        return dfs(s, wordDict, cache, 0);
    }

    private boolean dfs(String s, List<String> wordDict, Boolean[] cache, int i) {
        if(i == s.length()) {
            return true;
        }

        if(cache[i] != null) {
            return cache[i];
        }

        for(String word : wordDict) {
            if(i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                if(dfs(s, wordDict, cache, i + word.length())) {
                    cache[i] = true;
                    return true;
                }
            }
        }
        cache[i] = false;
        return false;
    }
}
