class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);

        int maxLIS = 1;
        for(int i = 0; i< nums.length; i++) {
            maxLIS = Math.max(maxLIS, dfs(i, nums, cache));
        }
        return maxLIS;
    }

    private int dfs(int i, int[] nums, int[] cache) {
        if(cache[i] != -1) {
            return cache[i];
        }

        int LIS = 1;
        for(int j = i+1; j < nums.length; j++) {
            if(nums[i] < nums[j]) {
                LIS = Math.max(LIS, 1+ dfs(j, nums, cache));
            }
        }

        cache[i] = LIS;
        return LIS;
    }
}
