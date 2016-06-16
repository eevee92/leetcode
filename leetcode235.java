//leetcode 235
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null)
            return null;
        if(p.right == q || p.left == q)
            return p;
        if(q.right == p || q.left == p)
            return q;
        if(root.val == p.val)
            return p;
        if(root.val == q.val)
            return q;
        TreeNode node = root;
        TreeNode lca = root;
        while(node != null)
        {
            if(p.val == node.val)
                return p;
            else if (q.val == node.val)
                return q;
            if(p.val < node.val && q.val > node.val)
                return node;
            if(p.val > node.val && q.val < node.val)
                return node;
            if(p.val < node.val && q.val < node.val)
                node = node.left;
            if(p.val > node.val && q.val > node.val)
                node = node.right;
        }
        return lca;
    }
}
