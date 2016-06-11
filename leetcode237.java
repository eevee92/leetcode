//leetcode 237 delete node in a linked list
    public void deleteNode(ListNode node) {
        
        if(node!=null)
        {
            node.val = node.next.val;
            node.next = node.next.next;
            node = node.next;
        }
    }
