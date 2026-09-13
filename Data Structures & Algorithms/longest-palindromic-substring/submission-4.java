class Solution {
private Boolean[][] memo;

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n <= 1) return s;

        memo = new Boolean[n][n];
        int maxLen = 0;
        int start = 0;

        // Check all possible substrings (i to j)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) {
                    if (j - i + 1 > maxLen) {
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(String s, int i, int j) {
        // Base cases
        if (i >= j) return true;
        
        // Return cached result if already calculated
        if (memo[i][j] != null) return memo[i][j];

        // Recursive case
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            memo[i][j] = false;
        }

        return memo[i][j];
    }
}
