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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> answer = new ArrayList<>();

        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(root);
        while(!bfs.isEmpty()) {
            int size = bfs.size();

            for(int i = 0; i< size; i++) {
                TreeNode curr = bfs.poll();
                if(curr != null) {
if (curr.left != null) {
                    bfs.add(curr.left);
                }
                // Only add right child if it exists
                if (curr.right != null) {
                    bfs.add(curr.right);
                }
                    if(i == size -1) {
                        answer.add(curr.val);
                    }
                }
            }

        }

        return answer;
    }
}
