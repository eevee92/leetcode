// leetcode 108
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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = null;
        if(nums.length == 0)
            return root;
        if(nums.length == 1)
            return new TreeNode(nums[0]);
            
        root = buildTree(nums);
        return root;
    }
    
    private TreeNode buildTree(int[] nums)
    {
        int mid = nums.length/2;
        TreeNode root = new TreeNode(nums[mid]);
        
        if(mid == 0)    // remains only 1 leaf
            return root;
            
        if(mid > 0)  // has left tree
            root.left = buildTree( Arrays.copyOfRange(nums,0,mid) );
        if(mid < nums.length-1)  // has right tree
            root.right = buildTree( Arrays.copyOfRange(nums, mid+1, nums.length) );
        return root;
        
    }
}
