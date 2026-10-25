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
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isValid(root.left, Integer.MIN_VALUE, root.val) && isValid(root.right, root.val, Integer.MAX_VALUE);
    }

    private boolean isValid(TreeNode root, int lowerLimit, int upperLimit) {
        if(root == null) {
            return true;
        }

        if(root.val >= upperLimit || root.val <= lowerLimit) {
            return false;
        }

        return isValid(root.left, lowerLimit, root.val) && isValid(root.right, root.val, upperLimit);

    }
}
