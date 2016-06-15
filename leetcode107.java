// leetcode 107
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        if(root==null)
            return ans;
            
        queue.add(root);
        int count = 1;
        int levelCount = 1;
        int noChildNodeCount=0;
        
        TreeNode node = null;
        List levelResult = new ArrayList<Integer>();
        
        while(!queue.isEmpty())
        {
            node = queue.peek();
            if(node.left!=null)
                queue.add(node.left);
            else
                noChildNodeCount++;
            if(node.right!=null)
                queue.add(node.right);
            else
                noChildNodeCount++;
            
            levelResult.add(new Integer(node.val));
            
            if(levelResult.size() == levelCount)
            {
                List level = new ArrayList<Integer>(levelResult);
                ans.add(level);
                levelCount = levelResult.size()*2 - noChildNodeCount;
                noChildNodeCount = 0;
                levelResult.clear();
            }
            queue.poll();
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int i=ans.size()-1; i>=0; i--)
        {
            result.add(ans.get(i));
        }
        return result;
    }
}
