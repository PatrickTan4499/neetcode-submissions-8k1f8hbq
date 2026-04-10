class Solution {

    Map<Integer, List<Integer>> preq = new HashMap<>();
    Set<Integer> seen = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i < numCourses; i++) {
            preq.put(i, new ArrayList<>());
        }    

        for(int[] course : prerequisites) {
            preq.get(course[0]).add(course[1]);
        } 

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)) {
                return false;
            } 
        }   
        return true;
    }

    private boolean dfs(int curr) {
        if(seen.contains(curr)) {
            return false;
        }

        if(preq.get(curr).isEmpty()) {
            return true;
        }

        seen.add(curr);
        for(int pre : preq.get(curr)) {
            if(!dfs(pre)) {
                return false;
            }
        }
        seen.remove(curr);
        return true;
    }
}
