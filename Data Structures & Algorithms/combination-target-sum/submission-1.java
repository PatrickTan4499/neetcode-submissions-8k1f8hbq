class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(int[] nums, int target, int index, int sum, List<Integer> subset, List<List<Integer>> answer) {
        if(sum > target || index >= nums.length) {
            return;
        }

        if(sum == target) {
            answer.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, target, index, sum + nums[index], subset, answer);
        subset.remove(subset.size()-1);
        dfs(nums, target, index + 1, sum, subset, answer);

    }
}
