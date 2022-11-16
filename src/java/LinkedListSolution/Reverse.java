package LinkedListSolution;

/**
 * User: lxcfour
 * Date: 2018/5/2
 * Time: 上午10:51
 */
public class Reverse {
    private ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        ListNode prev = null;

        while (p != null) {
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
        }

        return prev;
    }

    private ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return p;
    }

    public static void main(String[] args) {
        ListNode head, n1, n2, n3, n4;
        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = null;
        head = n1;

        Reverse reverse = new Reverse();
        System.out.println(reverse.reverseList2(head));
    }
}
