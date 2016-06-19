// leetcode 101
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
            return true;
        boolean[] ans = new boolean[1];
        ans[0] = true;
        helper(root, ans);
        if(ans[0]==true)
            return true;
        else
            return false;
        
    }
    
    int helper(TreeNode root, boolean[] ans)
    {
        if(root==null)
            return 0;
            
        int leftHeight = 0;
        int rightHeight = 0;
        
        if(root.left != null)
            leftHeight = helper(root.left, ans);
            
        if(root.right != null)
            rightHeight = helper(root.right, ans);
            
        if((leftHeight - rightHeight > 1) || (rightHeight - leftHeight > 1))
            ans[0] = false;
        return (leftHeight > rightHeight) ? (leftHeight+1) : (rightHeight+1);
    }
}
