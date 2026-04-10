public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Set<Character> chars = new HashSet<>();
        int left = 0;
        int right = 0;

        for(int i =0; i < s.length(); i++) {
            if(chars.contains(s.charAt(i))) {
                while(s.charAt(left) != s.charAt(i)) {
                    chars.remove(s.charAt(left));
                    left++;
                }
                left++;
            } else {
                chars.add(s.charAt(i));
                answer = Math.max(answer, chars.size());
            }
        }

        return answer;
    }
}