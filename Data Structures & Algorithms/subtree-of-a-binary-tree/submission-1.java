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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot != null) {
            return false;
        } else if (root != null && subRoot == null) {
            return false;
        } else if (root == null && subRoot == null) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot) || isSameTree(root, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode root2) {
        if(root == null && root2 != null) {
            return false;
        } else if (root != null && root2 == null) {
            return false;
        } else if (root == null && root2 == null) {
            return true;
        }

        return isSameTree(root.left, root2.left) && isSameTree(root.right, root2.right)
        && root.val == root2.val;
    }
}
