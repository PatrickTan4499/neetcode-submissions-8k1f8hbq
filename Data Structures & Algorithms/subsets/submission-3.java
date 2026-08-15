class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, 0, answer, subset);
        return answer;
    }

    private void dfs(int[] nums, int index, List<List<Integer>> answer, List<Integer> subset) {
        
        if(index == nums.length) {
            answer.add(new ArrayList<>(subset));
            return;
        }

        subset.add(nums[index]);
        dfs(nums, index + 1, answer, subset);
        subset.remove(subset.size()-1);
        dfs(nums, index + 1, answer, subset);
    }
}
