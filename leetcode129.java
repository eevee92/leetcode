// leetcode 129
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
    public int sumNumbers(TreeNode root) {
        if(root == null)
            return 0;
        
        if(root.left == null && root.right == null)
            return root.val;
            
        List<String> allNumbers = new ArrayList<String>();
        String path = String.valueOf(root.val);
        helper(root, path, allNumbers);
        int ans = 0;
        for(String str : allNumbers)
            ans += Integer.parseInt(str);
        return ans;
    }
    
    private void helper(TreeNode root, String path, List<String> allNumbers)
    {
        if(root.left==null && root.right==null)
            allNumbers.add(path);
        if(root.left != null)
        {
            String currentPath = new String(path);
            currentPath += String.valueOf(root.left.val);
            helper(root.left, currentPath, allNumbers);
        }
        if(root.right != null)
        {
            String currentPath = new String(path);
            currentPath += String.valueOf(root.right.val);
            helper(root.right, currentPath, allNumbers);
        }
    }
}