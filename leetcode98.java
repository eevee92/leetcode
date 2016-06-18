// leetcode 98
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 // 思路一，用中序遍历，出来的ArrayList是递增的话，BST is valid
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        List<TreeNode> inorder = new ArrayList<TreeNode>();
        helper(root, inorder);
        boolean ans = true;
        for(int i=0; i<inorder.size()-1; i++)
        {
            if(inorder.get(i).val >= inorder.get(i+1).val)
                ans = false;
        }
        return ans;
    }
    private void helper(TreeNode root, List<TreeNode> inorder)
    {
        if(root.left != null)
            helper(root.left, inorder);
        inorder.add(new TreeNode(root.val));
        if(root.right != null)
            helper(root.right, inorder);
    }
}