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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        long rootSum = 0;
        for(int[] desc : descriptions){
            int parentVal = desc[0];
            int childVal = desc[1];
            boolean isLeft = desc[2] == 1;

            nodes.putIfAbsent(parentVal, new TreeNode(parentVal));
            TreeNode parent = nodes.get(parentVal);
            nodes.putIfAbsent(childVal, new TreeNode(childVal));
            TreeNode child = nodes.get(childVal);

            if(isLeft) parent.left = child;
            else parent.right = child;

            children.add(child.val);
        }
        for(int val : nodes.keySet()){
            if(!children.contains(val)) return nodes.get(val);
        }
        return null;
    }
}