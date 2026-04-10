class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        dfs(nums, 0, subset, answer);
        return answer;
    }

    private void dfs(int[] nums, int index, List<Integer> subset, List<List<Integer>> answer) {
        if(index == nums.length) {
            answer.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index+1, subset, answer);
        subset.remove(subset.size() - 1);
        dfs(nums, index+1, subset, answer);
    }
}
