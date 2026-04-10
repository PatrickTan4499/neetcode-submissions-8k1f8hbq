public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Set<Character> chars = new HashSet<>();
        int left = 0;

        for(int right =0; right < s.length(); right++) {
            if(chars.contains(s.charAt(right))) {
                while(s.charAt(left) != s.charAt(right)) {
                    chars.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                chars.add(s.charAt(right));
                answer = Math.max(answer, right - left + 1);
            }
        }

        return answer;
    }
}