/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        Map<Node, Node> oldToNew = new HashMap<>();
        Node newNode = new Node(node.val);

        oldToNew.put(node, newNode);

        for(Node neighbor : node.neighbors) {
            Node newNeighbor = addNeighbors(neighbor, oldToNew);
            newNode.neighbors.add(newNeighbor);
        }

        return oldToNew.get(node);
    }

    private Node addNeighbors(Node oldNeighbor, Map<Node, Node> oldToNew) {
         if (oldToNew.containsKey(oldNeighbor)) {
            return oldToNew.get(oldNeighbor);
        }
         Node newNode = new Node(oldNeighbor.val);

        oldToNew.put(oldNeighbor, newNode);

        for(Node neighbor : oldNeighbor.neighbors) {
            Node newNeighbor = addNeighbors(neighbor, oldToNew);
            newNode.neighbors.add(newNeighbor);
        }
        return newNode;
    }
}