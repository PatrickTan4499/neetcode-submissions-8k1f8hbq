class Solution {
    public int rob(int[] nums) {
                if (nums.length == 1) return nums[0];
        int[] cache = new int[nums.length];
        int[] cache2 = new int[nums.length];
        Arrays.fill(cache, -1);
                Arrays.fill(cache2, -1);

        return Math.max(dfs(nums, 0, nums.length-1, cache), 
        dfs(nums, 1, nums.length, cache2));
    }

    private int dfs(int[] nums, int curr, int end, int[] cache){
        if(curr >= end) {
            return 0;
        }

        if(cache[curr] != -1) {
            return cache[curr];
        }

        cache[curr] = Math.max(nums[curr] + dfs(nums, curr +2, end, cache), dfs(nums, curr +1, end, cache));
        return cache[curr];
    }
}
