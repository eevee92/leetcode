// leetcode 95
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
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        if(n<1)
            return ans;
        ans = buildTrees(1, n);
        return ans;
    }
    
    public List<TreeNode> buildTrees(int start, int end)
    {
        List<TreeNode> ans = new ArrayList<TreeNode>();
        
        if(start > end)
        {
            ans.add(null);
            return ans;
        }
        
        for(int k=start; k<=end; k++)
        {
            List<TreeNode> leftTrees = buildTrees(start, k-1);
            List<TreeNode> rightTrees = buildTrees(k+1, end);
            // wrong : TreeNode root = new TreeNode(k); 不能放在这
            for(TreeNode left : leftTrees)
            {
                for(TreeNode right : rightTrees)
                {
                    TreeNode root = new TreeNode(k);    //　记得是在这里new 一个 TreeNode作为root, 不能放在for外面，这样每一个递归处才有自己的一个变量～
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
