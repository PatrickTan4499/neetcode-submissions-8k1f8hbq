class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> seen = new HashSet<>();
        int answer = 0;
        while(right < s.length()) {
            if(!seen.contains(s.charAt(right))) {
                seen.add(s.charAt(right));
                right++;
                answer = Math.max(answer, right - left);
            } else {
                while(seen.contains(s.charAt(right))) {
                    seen.remove(s.charAt(left));
                    left++;
                }
            }
        }

        return answer;
    }
}
