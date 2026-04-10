class Solution {
    Map<Integer, List<Integer>> preq = new HashMap<>();
    Set<Integer> seen = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i <numCourses; i++) {
            preq.put(i, new ArrayList<>());
        }

        for(int[] courses : prerequisites) {
            if(preq.get(courses[0]) != null) {
                preq.get(courses[1]).add(courses[0]);
            }
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i) {
        if(preq.get(i).isEmpty()) {
            return true;
        }

        if(seen.contains(i)) {
            return false;
        }

        seen.add(i);
        for(int course : preq.get(i)) {
            if(!dfs(course)) {
                return false;
            }
        }
        seen.remove(i);
        return true;
    }
}
