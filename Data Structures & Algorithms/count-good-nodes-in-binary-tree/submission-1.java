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
    public int goodNodes(TreeNode root) {
        int[] answer = new int[1];

        dfs(root, root.val, answer);
        return answer[0];
    }
    private void dfs(TreeNode root, int maxSeen, int[] answer) {
        if(root == null) {
            return;
        }
        
        if(root.val >= maxSeen) {
            answer[0]++;
            maxSeen = root.val;
        }

        dfs(root.left, maxSeen, answer);
        dfs(root.right, maxSeen, answer);
    }
}
