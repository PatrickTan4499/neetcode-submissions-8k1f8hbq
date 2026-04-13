class Solution {
    public int numDecodings(String s) {
        int dpI= 0;
        int dp2 = 0;
        int dp1 = 1;
        for(int i = s.length()-1; i >= 0; i--) {
            if(s.charAt(i) == '0') {
                dpI = 0;
            } else {
                dpI = dp1;
                if(i+1 < s.length() && (s.charAt(i) == '1' || s.charAt(i) == '2' &&
                s.charAt(i+1) < '7')) {
                    dpI += dp2;
                }
            }
            dp2 = dp1;
            dp1 = dpI;
            dpI = 0;
        }
        return dp1;
    }
}
