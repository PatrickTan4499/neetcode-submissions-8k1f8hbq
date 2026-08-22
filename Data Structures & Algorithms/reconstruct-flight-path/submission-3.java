class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
Map<String, PriorityQueue<String>> adj = new HashMap<>();
        
        // Build adjacency list with Min-Heaps for lexicographical order
        for (List<String> ticket : tickets) {
            adj.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            adj.get(ticket.get(0)).add(ticket.get(1));
        }

        LinkedList<String> res = new LinkedList<>();
        dfs("JFK", adj, res);
        return res;
    }

    private void dfs(String curr, Map<String, PriorityQueue<String>> adj, LinkedList<String> res) {
        PriorityQueue<String> neighbors = adj.get(curr);
        while (neighbors != null && !neighbors.isEmpty()) {
            // Remove the lexicographically smallest destination and recurse
            dfs(neighbors.poll(), adj, res);
        }
        // Add to head to reverse the post-order traversal automatically
        res.addFirst(curr);
    
    }
}
