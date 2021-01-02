import java.util.Deque;
import java.util.LinkedList;

/**
 * 善用哑节点
 */
public class RemoveNthFromEnd {
    public int getLength(ListNode head)
    {
        int length = 0;
        while (head != null)
        {
            ++length;
            head = head.next;
        }
        return length;
    }

    // 计算链表长度
    
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i=1;i<length-n+1; i++)
        {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    // 栈
    public ListNode removeNthFromEnd2(ListNode head, int n)
    {
        ListNode dummy = new ListNode(0, head);
        Deque<ListNode> stack = new LinkedList<ListNode>();
        ListNode cur = dummy;
        while (cur != null)
        {
            stack.push(cur);
            cur = cur.next;
        }
        for (int i=0; i<n; i++)
        {
            stack.pop();
        }
        ListNode prev = stack.peek();
        prev.next = prev.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    // 双指针 一次遍历
    public ListNode removeNthFromEnd3(ListNode head, int n) 
    {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;

        for (int i=0; i<n; i++) {
            first = first.next;
        }
        while (first != null)
        {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    class ListNode 
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}


