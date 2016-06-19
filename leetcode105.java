// leetcode 105
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = null;
        if(preorder.length==0)
            return root;
        
        if(preorder.length > 0)    
            root = new TreeNode(preorder[0]);
        
        // find index in inorder:
        int index = findIndex(root.val, inorder);
        
        if(index >0)   // 存在左子树
        {
            int[] left_inorder = Arrays.copyOfRange(inorder, 0, index);
            int[] left_preorder = Arrays.copyOfRange(preorder, 1, 1+left_inorder.length);
            root.left = buildTree(left_preorder, left_inorder);
        }
        
        if(index < inorder.length-1) //　存在右子树
        {
            int[] right_inorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
            int[] right_preorder = Arrays.copyOfRange(preorder, 1+index, preorder.length);
            root.right = buildTree(right_preorder, right_inorder);
        }
        return root;
    }
    
    private int findIndex(int val, int[] inorder)
    {
        for(int i=0; i<inorder.length; i++)
            if(val == inorder[i])
                return i;
        return -1;
    }
}
