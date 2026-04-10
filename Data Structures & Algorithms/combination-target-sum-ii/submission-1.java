class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> answer = new HashSet<>();
        Arrays.sort(candidates);
        List<Integer> subset = new ArrayList<>();
        dfs(candidates, target, 0, 0, subset, answer);
        return new ArrayList<>(answer);
    }

    private void dfs(int[] candidates, int target, int index, int sum, List<Integer> subset, Set<List<Integer>> answer) {
        if(target == sum) {
            answer.add(new ArrayList<>(subset));
            return;
        }

        if(sum > target || index >= candidates.length) {
            return;
        }

        subset.add(candidates[index]);
        while(index > candidates.length - 1 && candidates[index] == candidates[index + 1]) {
            index++;
        }
        dfs(candidates, target, index + 1, sum + candidates[index], subset, answer);

        subset.remove(subset.size()-1);
        dfs(candidates, target, index + 1, sum, subset, answer);

    }
}
