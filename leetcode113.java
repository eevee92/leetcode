// leetcode 113
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        
        List<List<Integer>> allResult = new ArrayList<List<Integer>>();    
        if(root == null)
            return allResult;
        
        List<ArrayList<TreeNode>> allPath = new ArrayList<ArrayList<TreeNode>>();
        
        ArrayList<TreeNode> path = new ArrayList<TreeNode>();
        path.add(root);
        helper(root, path, allPath);
        for(List<TreeNode> list : allPath)
        {
            int currentSum = 0;
            for(TreeNode node : list)
                currentSum += node.val;
            if(currentSum==sum)
            {
                List<Integer> result = new ArrayList<Integer>();
                for(TreeNode node : list)
                    result.add(new Integer(node.val));
                allResult.add(result);
            }
        }
        return allResult;
    }
    private void helper(TreeNode root,ArrayList<TreeNode> path, List<ArrayList<TreeNode>> allPath)
    {
        if(root==null)
            return;
        
        if(root.left == null && root.right == null)
        {
            allPath.add(path);
        }
        
        if(root.left != null)
        {
            ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
            currentPath = (ArrayList)path.clone();
            TreeNode node = new TreeNode(root.left.val);
            currentPath.add(node);
            helper(root.left, currentPath, allPath);
        }
        
        if(root.right != null)
        {
            ArrayList<TreeNode> currentPath = new ArrayList<TreeNode>();
            currentPath = (ArrayList)path.clone();
            TreeNode node = new TreeNode(root.right.val);
            currentPath.add(node);
            helper(root.right, currentPath, allPath);
        }
    }
}