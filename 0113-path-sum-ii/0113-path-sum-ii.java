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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        generatePath(root, targetSum, res, new ArrayList<>());
        return res;
    }

    private void generatePath(TreeNode root, int targetSum, List<List<Integer>> res, List<Integer> currPath){
        if(root == null) return;
        currPath.add(root.val);
        if(root.left == null && root.right == null && targetSum == root.val){
            res.add(new ArrayList<>(currPath));
        }
        generatePath(root.left, targetSum - root.val, res, currPath);
        generatePath(root.right, targetSum - root.val, res, currPath);
        currPath.remove(currPath.size() - 1);
    }
}