package LinkedListTest;

/**
 * User: lxcfour
 * Date: 2018/5/2
 * Time: 下午4:03
 * Description: 删除倒数第n个元素
 */
public class RemoveNthNodeFromEnd {

    private ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null || n < 1) {
            return null;
        }

        ListNode fast = head, slow = head;
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                return null;
            }

            fast = fast.next;
        }

        if (fast == null) { // 需要删掉头节点
            return head.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除中间节点
        slow.next = slow.next.next;

        return head;
    }

    private ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // 删除中间节点
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        RemoveNthNodeFromEnd test = new RemoveNthNodeFromEnd();
        ListNode head, n1, n2, n3, n4, n5;
        n1 = new ListNode(1);
        n2 = new ListNode(2);
        n3 = new ListNode(3);
        n4 = new ListNode(4);
        n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        head = n1;
        ListNode res = test.removeNthFromEnd2(head, 1);
        System.out.println(res);
    }
}
