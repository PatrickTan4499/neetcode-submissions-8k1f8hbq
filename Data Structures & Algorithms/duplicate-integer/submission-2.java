class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> alreadySeen = new HashSet<>();

        for(int number : nums) {
            if(alreadySeen.contains(number)) {
                return true;
            } 
            alreadySeen.add(number);
        }
        return false;
    }
}