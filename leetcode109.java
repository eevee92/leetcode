// leetcode 109

// 需要优化，曾经有一个case说超时

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return new TreeNode(head.val);
            
        int[] list = new int[length(head)];
        int i=0;
        while(head!=null)
        {
            list[i] = head.val;
            head = head.next;
            i++;
        }
        TreeNode root = buildTree(list);
        return root;
    }
    
    private TreeNode buildTree(int[] list)
    {
        int mid = list.length/2;
        TreeNode root = new TreeNode(list[mid]);
        if(mid==0)
        {
            return root;
        }
        if(mid>0)
        {
            root.left = buildTree(Arrays.copyOfRange(list,0,mid));
        }
        if(mid<list.length-1)
        {
            root.right = buildTree(Arrays.copyOfRange(list, mid+1, list.length));
        }
        return root;
        
    }
    
    private int length(ListNode head)
    {
        int i=0;
        while(head != null)
        {
            head = head.next;
            i++;
        }
        return i;
    }
}
