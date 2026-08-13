class Solution {
    class Node {
        int value;
        int indegree;
        List<Node> dependents;

        public Node(int value) {
            this.value = value;
            this.indegree =0;
            this.dependents = new ArrayList<>();
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Node> answer = new ArrayList<>();
        Map<Integer, Node> prereq = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            prereq.put(i, new Node(i));
        }

        for (int[] pre : prerequisites) {
            prereq.get(pre[1]).dependents.add(prereq.get(pre[0]));
            prereq.get(pre[0]).indegree++;
        }

        Queue<Node> bfs = new LinkedList<>();
        for(Node node : prereq.values()) {
            if(node.indegree == 0) {
                bfs.add(node);
            }
        }

        while(!bfs.isEmpty()) {

                Node curr = bfs.poll();
                answer.add(curr);
                for(Node neigh : curr.dependents) {
                    neigh.indegree--;
                    if(neigh.indegree == 0) {
                        bfs.add(neigh);
                    }
                }
            
        }
        
        if (answer.size() != numCourses) {
            return new int[0];
        }
        
        int[] result = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i).value;
        }
        return result;
    }
}
