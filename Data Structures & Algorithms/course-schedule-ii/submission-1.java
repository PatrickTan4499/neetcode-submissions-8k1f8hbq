class Solution {
    class Node {
        int indegree;
        int value;
        List<Node> dependents;

        public Node(int value) {
            this.value = value;
            this.indegree = 0;
            this.dependents = new ArrayList<>();
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) {
            nodeMap.put(i, new Node(i));
        }

        for(int[] prereq : prerequisites) {
            nodeMap.get(prereq[1]).dependents.add(nodeMap.get(prereq[0]));
            nodeMap.get(prereq[0]).indegree++;
        }

        Queue<Node> bfs = new LinkedList<>();
        for(Node node : nodeMap.values()) {
            if(node.indegree == 0) {
                bfs.add(node);
                answer.add(node.value);
            }
        }

        while(!bfs.isEmpty()) {
            int size = bfs.size();
            for(int i = 0; i< size; i++) {
                Node curr = bfs.poll();
                for(Node dependent : curr.dependents) {
                    dependent.indegree--;
                    if(dependent.indegree == 0) {
                        bfs.add(dependent);
                        answer.add(dependent.value);
                    }
                }
            }
        }

        if(!bfs.isEmpty() || answer.size() != numCourses) {
            return new int[0];
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
