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
    int maxi=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxi;
    }
    public int maxPath(TreeNode root){
        if(root==null) return 0;
        int ls=Math.max(0,maxPath(root.left));
        int rs=Math.max(0,maxPath(root.right));
        int curr=root.val+ls+rs;
        maxi=Math.max(curr,maxi);
        return root.val+Math.max(ls,rs);
    }
}