class Solution {
    class Node {
        int indegree;
        int val;
        List<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.indegree = 0;
            this.neighbors = new ArrayList<>();
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Node> nodeMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for(int i = 0; i< numCourses; i++) {
            nodeMap.put(i, new Node(i));
        }

        for(int[] prereq : prerequisites) {
            nodeMap.get(prereq[1]).neighbors.add(nodeMap.get(prereq[0]));
            nodeMap.get(prereq[0]).indegree++;
        }

        Queue<Node> bfs = new LinkedList<>();

        for(Node node : nodeMap.values()) {
            if(node.indegree == 0) {
                bfs.offer(node);
                answer.add(node.val);
            }
        }

        while(!bfs.isEmpty()) {
            Node curr = bfs.poll();

            for(Node neighbor : curr.neighbors) {
                neighbor.indegree--;
                if(neighbor.indegree == 0) {
                    bfs.offer(neighbor);
                    answer.add(neighbor.val);
                }
            }
        }

        if(answer.size() != numCourses) {
            return new int[0];
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
