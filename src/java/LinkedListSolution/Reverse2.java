package LinkedListSolution;

/**
 * User: lxcfour
 * Date: 2018/5/2
 * Time: 上午11:25
 * Description: 部分倒置，one-pass
 * 1 -> 2 -> 3 -> 4 -> 5, m = 2, n = 4
 * result: 1 -> 4 -> 3 -> 2 -> 5
 */
public class Reverse2 {

    /**
     * 1 <= m <= n <= len
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m > n || m < 1) {
            return head;
        }

        int i = 1;
        ListNode p = head;
        ListNode prev = null;
        ListNode left = null; // m的前一个节点
        ListNode mthNode = null; // 第m个节点，即倒置部分链表的尾节点
        while (p != null) {
            if (i <= m) {
                if (i == m) { // 记录倒置部分的前一个节点
                    left = prev;
                    mthNode = p;
                }

                prev = p;
                p = p.next;
            } else if (i > m && i <= n) {
                ListNode temp = p.next; // 倒置
                p.next = prev;
                prev = p;
                p = temp;
            } else {
                break;
            }

            i++;
        }

        if (left != null) { // 即 m > 1
            left.next = prev;
        } else { // 即 m = 1，此时头节点发生变动
            head = prev;
        }

        if (mthNode != null) {
            mthNode.next = p;
        }

        return head;
    }

    private ListNode reverseBetween2(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        // pre.next是then的前一个节点
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing

        for(int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed

        // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5

        for(int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }

        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)

        return dummy.next;
    }

    public static void main(String[] args) {
        Reverse2 reverse2 = new Reverse2();
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
        head = reverse2.reverseBetween2(head, 1, 4);
        System.out.println(head);
    }
}
