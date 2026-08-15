class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, target, answer, subset, 0);
        return answer;
    }

    private void dfs(int[] nums, int index, int target, List<List<Integer>> answer, List<Integer> subset, int currSum) {

        if(currSum == target) {
            answer.add(new ArrayList<>(subset));
            return;
        }

        if(currSum > target || index >= nums.length) {
            return;
        }


        subset.add(nums[index]);
        dfs(nums, index, target, answer, subset, currSum + nums[index]);
        subset.remove(subset.size()-1);
        dfs(nums, index+1, target, answer, subset, currSum);
    }
}
