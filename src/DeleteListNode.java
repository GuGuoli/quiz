public class DeleteListNode {

    public void deleteNode(ListNode node)
    {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    class ListNode {
        int val;
        ListNode next;
        public ListNode(int x)
        {
            val = x;
        }
    
    }
    
}


