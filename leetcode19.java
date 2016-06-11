// leetcode 19 Remove Nth Node From End of List
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head==null)
            return head;
        
        if (getLength(head)==1 && n==1)
        {
            head = head.next;
            return head;
        }
        
        if( getLength(head)==n )
        {
            head = head.next;
            return head;
        }
        
        ListNode p = head;
        int count = getLength(head)-n;
       
            
        while(count > 1)
        {
            p = p.next;
            count--;
        }
        
        p.next = p.next.next;
        return head;
    }
    
    public int getLength(ListNode head)
    {
        if(head==null)
            return 0;
        ListNode p = head;
        int count = 1;
        while(p.next!=null)
        {
            p = p.next;
            count++;
        }
        return count;
    }
