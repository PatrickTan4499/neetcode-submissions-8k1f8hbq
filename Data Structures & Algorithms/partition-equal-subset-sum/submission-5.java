class Solution {
    public boolean canPartition(int[] nums) {
        if (Arrays.stream(nums).sum() % 2 != 0) {
            return false;
        }

        Set<Integer> cache = new HashSet<>();
        cache.add(0);
        int target = Arrays.stream(nums).sum() / 2;

        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> nextcache = new HashSet<>();
            for (int t : cache) {
                if (t + nums[i] == target) {
                    return true;
                }
                nextcache.add(t + nums[i]);
                nextcache.add(t);
            }
            cache = nextcache;
        }
        return false;
    }
}
