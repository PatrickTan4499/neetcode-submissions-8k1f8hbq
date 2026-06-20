class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> answer = new ArrayList<>();

        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String str : strs) {
            int[] sArray = new int[26];

            for(int i = 0; i < str.length(); i++) {
                sArray[str.charAt(i) - 'a']++;

            }
            String array = Arrays.toString(sArray);
            anagramMap.putIfAbsent(array, new ArrayList<>());
            anagramMap.get(array).add(str);
        }

        for(List<String> list : anagramMap.values()) {
            answer.add(list);
        }
        return answer;
    }
}
