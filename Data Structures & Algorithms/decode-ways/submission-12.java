class Solution {
    public int numDecodings(String s) {
        int[] cache = new int[s.length()];
        Arrays.fill(cache, -1);
        return dfs(0, s, cache);
    }

    private int dfs(int i, String s, int[] cache) {
        if(i >= s.length()) {
            return 1;
        }

        if(s.charAt(i) == '0') {
            cache[i] = 0;
            return cache[i];
        }

        if(cache[i] != -1) {
            return cache[i];
        }

        cache[i] = dfs(i+1, s, cache);

// Correct grouping:
if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
            cache[i] += dfs(i+2, s, cache);
        }
        return cache[i];
    }
}
