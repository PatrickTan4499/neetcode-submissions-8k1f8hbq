class Solution {
    public int rob(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);

        return Math.max(dfs(0, cache, nums), dfs(1, cache, nums));
    }

    private int dfs(int i, int[] cache, int[] nums){
        if(i >= nums.length) {
            return 0;
        }
        if(cache[i] != -1) {
            return cache[i];
        }

        cache[i] = Math.max(dfs(i+2, cache, nums) + nums[i], dfs(i+1, cache, nums));
        return cache[i];
    }
}
