//leetcode No.2 Add two numbers
    
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        if(l1 == null || l2 == null)
            return null;
        
        int cascade = 0;
        ListNode head = new ListNode( (l1.val + l2.val + cascade)%10 );
        if(l1.val + l2.val + cascade >= 10)				　//　　bug 1 : >10
           cascade = 1; 

        ListNode current = head;
        while(l1.next != null && l2.next != null)			
        {
            l1 = l1.next;						　//　　bug 2: > forget to move to next
            l2 = l2.next;
            ListNode nextNode = new ListNode( (l1.val + l2.val + cascade)%10 );
            if (l1.val + l2.val + cascade >= 10)
                cascade = 1;
            else cascade = 0;
            current.next = nextNode;
            current = current.next;
        }
        while(l1.next != null)
        {
            l1 = l1.next;
            ListNode nextNode = new ListNode( (l1.val + cascade)%10 );
            if( l1.val + cascade >= 10 )
                cascade = 1;
            else cascade = 0;
            current.next = nextNode;
            current = current.next;
        }
        while(l2.next != null)
        {
            l2 = l2.next;
            ListNode nextNode = new ListNode( (l2.val + cascade)%10 );
            if( l2.val + cascade >= 10 )
                cascade = 1;
            else cascade = 0;
            current.next = nextNode;
            current = current.next;
        }
        if(cascade == 1)						//　　bug 3: > forget this last case
        {
            ListNode nextNode = new ListNode(1);
            cascade = 0;
            current.next = nextNode;
        }
        return head;
    }
