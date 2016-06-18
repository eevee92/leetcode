// leetcode236

// 注意，要直接比较TreeNode是否指向同一个引用，不能只比较树的val是否一样。否则当时树有相同val的TreeNode时，就会出错。

/* 思路一，前序遍历+中序遍历，前序遍历找到root，在中序遍历里面看p和q和root的位置关系，缩小范围直到p和q在root两侧*/
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
        if(p.val==root.val)
            return p;
        if(q.val==root.val)
            return q;
        if(p.left==q || p.right==q)  // p是q的lca
            return p;
        if(q.left==p || q.right==p)  // q是p的lca
            return q;
            
        List<TreeNode> preOrder = new ArrayList<TreeNode>();
        List<TreeNode> inOrder = new ArrayList<TreeNode>();
        preOrder(root, preOrder);
        inOrder(root, inOrder);
        
        for(TreeNode n : preOrder)
            System.out.printf(n.val+" ");
        System.out.println();
        
        for(TreeNode n : inOrder)
            System.out.printf(n.val+" ");
        System.out.println();
        
        int posP = 0;
        int posQ = 0;
        int posRoot = 0;
        int startSearch = 0;
        int endSearch = inOrder.size();
        int searchRange = preOrder.size();
        TreeNode node = null;
        
		// 当p和q是在root两侧的情况
        // 以下是已经排除了p是q的lca, 或q是p的lca的情况
        for(int i=0; i<preOrder.size(); i++)
        {
            node = preOrder.get(i);
            int findRootNode = 0;
            for(int j=startSearch; j<endSearch; j++)
            {
                if(inOrder.get(j).val == p.val)
                    posP = j;
                if(inOrder.get(j).val == q.val)
                    posQ = j;
                if(inOrder.get(j).val == node.val)
                {
                    findRootNode = 1;
                    posRoot = j;
                }
            }
            System.out.println("posP:"+posP+"  posQ:"+posQ+"  posRoot:"+posRoot);
            if(findRootNode == 0)
                continue;
            else
            {
                if(posP == posRoot)
                    break;
                if(posQ == posRoot)
                    break;
                if(posP < posRoot && posRoot < posQ)
                    break;
                if(posQ < posRoot && posRoot < posP)
                    break;
                if(posP < posRoot && posQ < posRoot)
                {
                    startSearch = (posP<posQ)?posP:posQ;
                    endSearch = posRoot;
                }
                if(posP > posRoot && posQ > posRoot)
                {
                    startSearch = posRoot+1;
                    endSearch = (posP>posQ)?posP+1:posQ+1;
                }
            }
        }
        return node;
    }
    
    public void preOrder(TreeNode root, List<TreeNode> list)
    {
        if(root==null)
            return;
        list.add(root);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
    
    public void inOrder(TreeNode root, List<TreeNode> list)
    {
        if(root==null)
            return;
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}

/*思路二，find the path of each node, 然后从后往前遍历，找到第一个共同的节点即是lca*/
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
        
        List<TreeNode> pathP = new ArrayList<TreeNode>();
        List<TreeNode> pathQ = new ArrayList<TreeNode>();
        
        pathP.add(root);
        pathQ.add(root);
        
        findPath(root, p, pathP);
        findPath(root, q, pathQ);
        
        TreeNode lca = null;
        
        /*
        // 从后往前，找到最后一个一样的节点，即为lca
        for(int i=pathP.size()-1; i>=0; i--)
        {
            int flag = 0;
            for(int j=pathQ.size()-1; j>=0; j--)
            {
                if(pathP.get(i)==pathQ.get(j))
                {
                    lca = pathP.get(j);
                    flag = 1;
                    break;
                }
            }
            if(flag==1)
                break;
        }
        */
        // 更加简洁的查找方式
        for(int i=0; i<pathP.size() && i< pathQ.size(); i++)
        {
            if(pathP.get(i)==pathQ.get(i))
                lca = pathP.get(i);   // 不断更新lca
            else break; // 节省计算资源，不进行剩下的计算
        }
        return lca;
        
    }
    
    private boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path)
    {
        if(root==null || target==null)
            return true;
        
        if(root == target)
            return true;
            
        if(root.left!=null)
        {
            path.add(root.left);
            if(findPath(root.left, target, path)==true)
                return true;
            else
                path.remove(path.size()-1);
        }
        if(root.right!=null)
        {
            path.add(root.right);
            if(findPath(root.right, target, path)==true)
                return true;
            else
                path.remove(path.size()-1);
        }
        return false;
    }
}