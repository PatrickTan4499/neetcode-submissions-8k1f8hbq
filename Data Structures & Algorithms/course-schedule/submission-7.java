class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            nodeMap.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            nodeMap.get(prereq[0]).add(prereq[1]);
        }

        Set<Integer> seen = new HashSet<>();
        for(int i = 0; i < numCourses; i++) {
            if(!dfs(nodeMap, i, seen)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(Map<Integer, List<Integer>> nodeMap, int node, Set<Integer> seen) {
        if(seen.contains(node)) {
            return false;
        }

        if(nodeMap.get(node).isEmpty()) {
            return true;
        }

        seen.add(node);

        for(int neighbor : nodeMap.get(node)) {
            if(!dfs(nodeMap, neighbor, seen)) {
                return false;
            }
        }
        seen.remove(node);
        nodeMap.put(node, new ArrayList<>());

        return true;
    }
}
