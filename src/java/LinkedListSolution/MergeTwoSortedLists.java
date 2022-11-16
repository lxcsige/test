package LinkedListSolution;

/**
 * User: lxcfour
 * Date: 2018/5/2
 * Time: 下午4:49
 */
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p = l1, q = l2, k = dummy;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                k.next = p;
                p = p.next;
            } else {
                k.next = q;
                q = q.next;
            }
            k = k.next;
        }
        while (p != null) {
            k.next = p;
            p = p.next;
            k = k.next;
        }
        while (q != null) {
            k.next = q;
            q = q.next;
            k = k.next;
        }

        return dummy.next;
    }
}
