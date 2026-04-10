class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        dfs(nums, new boolean[nums.length], new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(int[] nums, boolean[] seen, List<Integer> curr, List<List<Integer>> answer){
        if(curr.size() == nums.length) {
            answer.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!seen[i]) {
                curr.add(nums[i]);
                seen[i] = true;
                dfs(nums, seen, curr, answer);
                curr.remove(curr.size()-1);
                seen[i] = false;
            }
        }
    }
}
