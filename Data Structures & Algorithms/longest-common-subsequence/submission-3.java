class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] cache = new int[text1.length()][text2.length()];
        for(int[] row : cache) {
            Arrays.fill(row, -1);
        }

        return dfs(0, 0, text1, text2, cache);
    }

    private int dfs(int i, int j, String text1, String text2, int[][] cache) {
        if(i >= text1.length() || j >= text2.length()) {
            return 0;
        }

        if(cache[i][j] != -1) {
            return cache[i][j];
        }
        
        if(text1.charAt(i) == text2.charAt(j)) {
            cache[i][j] = 1 + dfs(i+1, j+1, text1, text2, cache);
        } else {
            cache[i][j] = Math.max(dfs(i+1, j, text1, text2, cache),
            dfs(i, j+1, text1, text2, cache));
        }
        return cache[i][j];
    }
}
