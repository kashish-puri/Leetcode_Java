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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean lefttoRight=true;
        while(!q.isEmpty()){
            int size=q.size();
            List<Integer> lt=new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(lefttoRight) lt.add(temp.val);
                else lt.add(0,temp.val);
                if(temp.left!=null) q.add(temp.left);
                if(temp.right!=null) q.add(temp.right);
            }
            result.add(lt);
            lefttoRight=!lefttoRight;
        }
        return result;
    } 
}