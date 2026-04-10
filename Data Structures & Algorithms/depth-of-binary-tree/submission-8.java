/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        
        while(!bfs.isEmpty()) {
            int length = bfs.size();
            for(int i = 0; i < length; i++) {
                TreeNode curr = bfs.poll();
                if(curr.left != null) {
                    bfs.add(curr.left);
                }

                if(curr.right != null) {
                    bfs.add(curr.right);
                }
            }
            depth++;
        }
        return depth;
    }
}
