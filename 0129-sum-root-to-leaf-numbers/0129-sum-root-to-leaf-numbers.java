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
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[]{0};
        calculateSum(root, 0, sum);
        return sum[0];
    }

    private void calculateSum(TreeNode root, int path, int[] sum){
        if(root == null) return;
        path = path * 10 + root.val;
        if(root.left == null && root.right == null) sum[0] += path;
        calculateSum(root.left, path, sum);
        calculateSum(root.right, path, sum);
    }
}