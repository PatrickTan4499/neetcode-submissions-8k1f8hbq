class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> nums2 = new HashSet<>();
        for(int num : nums) {
            if (nums2.contains(num)) {
                return true;
            } else {
                nums2.add(num);
            }
        }
        return false;
    }
}