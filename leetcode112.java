// leetcode112
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        
		// 这里要用数组，否则函数是不会修改boolean result的值。
        boolean[] result = new boolean[1];
        result[0]=false;
        
        int currentSum = root.val;
        
        adder(root, sum, currentSum, result);
        
        if(result[0]==true)
            return true;
        else
            return false;
    }
    
    public void adder(TreeNode root, int target, int currentSum,  boolean[] result)
    {
       if(root.left == null && root.right == null)
       {
           if(currentSum == target)
                result[0] = true;
       }
       
       if(root.left != null)
       {
           int LeftSum = root.left.val + currentSum;   // 每一次都要new 一个 LeftSum 作为当前栈的currentSum, 这样返回的时候才不是在原来的基础上重新累加
           adder(root.left, target, LeftSum, result);
       }
       
       if(root.right != null)
       {
           int RightSum = root.right.val + currentSum;
           adder(root.right, target, RightSum, result);
       }
    }

}