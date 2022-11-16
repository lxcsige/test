package LinkedListSolution;

/**
 * User: lxcfour
 * Date: 2018/5/2
 * Time: 下午5:22
 * Description: 回转最右边的元素，思路就是找规律
 */
public class Rotate {

    private ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        // 第一次循环得到链表长度
        int i; // length
        for (i = 0; fast.next != null; i++) {
            fast = fast.next;
        }

        for (int j = i - k % i; j > 0; j--) {
            slow = slow.next;
        }

        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }

    public static void main(String[] args) {
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
        Rotate test = new Rotate();
        ListNode res = test.rotateRight(head, 6);
    }
}
