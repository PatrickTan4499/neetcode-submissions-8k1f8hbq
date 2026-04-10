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
    public int diameterOfBinaryTree(TreeNode root) {
        int[] maxPath = new int[1];
        maxPath[0] = 0;
        dfs(root, maxPath);
        return maxPath[0];
    }

    private int dfs(TreeNode root, int[] maxPath) {
        if(root == null) {
            return 0;
        }
        int leftHeight = dfs(root.left, maxPath);
        int rightHeight = dfs(root.right, maxPath);

        int diameter = leftHeight + rightHeight;
        if(diameter > maxPath[0]) {
            maxPath[0] = diameter;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
