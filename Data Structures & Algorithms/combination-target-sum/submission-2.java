class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
     List<List<Integer>> answer = new ArrayList<>();
     List<Integer> subset = new ArrayList<>();
     dfs(nums, target, 0, 0, subset, answer);
     return answer;
    }

    private void dfs(int[] nums, int target, int index, int sum, List<Integer> subset, List<List<Integer>> answer) {
        if(target == sum) {
            answer.add(new ArrayList<>(subset));
            return;
        }

        if(sum > target || index >= nums.length) {
            return;
        }

        //choose num
        subset.add(nums[index]);
        dfs(nums, target, index, sum + nums[index], subset, answer);
        //dont choose num
        subset.remove(subset.size()-1);
        dfs(nums, target, index+1, sum, subset, answer);

    }

}
