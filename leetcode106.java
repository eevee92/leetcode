// leetcode 106
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        TreeNode root = null;
        if(inorder.length==0)
            return root;
        
        if(postorder.length > 0)
            root = new TreeNode(postorder[postorder.length-1]);
            
        int index = findIndex(inorder, root.val);
        
        if(index > 0)
        {
            int[] left_inorder = Arrays.copyOfRange(inorder, 0, index);
            int[] left_postorder = Arrays.copyOfRange(postorder, 0, index);
            root.left = buildTree( left_inorder, left_postorder);
        }
        if(index < inorder.length-1)
        {
            int[] right_inorder = Arrays.copyOfRange(inorder, index+1, inorder.length);
            int[] right_postorder = Arrays.copyOfRange(postorder, index, postorder.length-1);
            root.right = buildTree( right_inorder, right_postorder);
        }
        return root;
    }
    
    private int findIndex(int[] list, int val)
    {
        for(int i=0; i<list.length; i++)
            if(list[i] == val)
                return i;
        return -1;
    }
}
