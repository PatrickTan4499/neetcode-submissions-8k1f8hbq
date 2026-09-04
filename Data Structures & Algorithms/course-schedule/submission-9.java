class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> nodeMap = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            nodeMap.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            nodeMap.get(prereq[1]).add(prereq[0]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, nodeMap, new HashSet<>())) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int node, Map<Integer, List<Integer>> nodeMap, Set<Integer> seen) {
        if(seen.contains(node)) {
            return false;
        }
        if (nodeMap.get(node).isEmpty()) return true; 

        seen.add(node);

        for(int prereq : nodeMap.get(node)) {
            if(!dfs(prereq, nodeMap, seen)) {
                return false;
            }
        }

        seen.remove(node);
        nodeMap.get(node).clear();
        return true;
    }
}
