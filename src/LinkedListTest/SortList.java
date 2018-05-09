package LinkedListTest;

import javax.swing.text.Position;

/**
 * User: lxcfour
 * Date: 2018/5/2
 * Time: 下午8:07
 * Description: 链表排序
 */
public class SortList {

    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return insertionSort(head);
    }

    /**
     * 直接插入排序
     * @param head
     * @return
     */
    private ListNode insertionSort(ListNode head) {
        ListNode pStart = new ListNode(0); // 有序区域开始节点
        pStart.next = head;
        ListNode cur = head.next; // 待插入的节点
        ListNode pEnd = head; // 有序区域结束节点

        while (cur != null) {
            ListNode pre = pStart;
            while (pre.next != cur && pre.next.val <= cur.val) { // 寻找有序区域的待插入位置，pre和pre.next之间
                pre = pre.next;
            }
            if (pre.next == cur) {
                pEnd = cur;
            } else { // 否则将节点插入
                pEnd.next = cur.next;
                cur.next = pre.next;
                pre.next = cur;
            }
            cur = pEnd.next;
        }

        return pStart.next;
    }

    private ListNode insertionSort2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0); // 未设置dummy的next，将待插入的有序区域和原链表断开
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val <= cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }

        return dummy.next;
    }

    /**
     * 直接选择排序，时间复杂度O(n^2)，空间复杂度O(1)
     * @param head
     * @return
     */
    private ListNode selectSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0), pEnd = dummy;
        dummy.next = head;

        while (pEnd.next != null) {
            ListNode min = pEnd.next;
            ListNode p = pEnd.next.next;
            while (p != null) {
                if (p.val < min.val) {
                    min = p;
                }
                p = p.next;
            }
            if (min != pEnd.next) {
                swap(min, pEnd.next);
            }
            pEnd = pEnd.next;
        }

        return dummy.next;
    }

    /**
     * 快排，时间复杂度O(nlogn)，空间复杂度O(logn)
     *
     * @param head
     */
    private ListNode quickSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        quickSort(head, null);

        return head;
    }

    private void quickSort(ListNode head, ListNode tail) {
        if (head != tail && head.next != tail) {
            ListNode mid = partition(head, tail);
            quickSort(head, mid);
            quickSort(mid.next, tail);
        }
    }

    private ListNode partition(ListNode low, ListNode high) {
        int pivot = low.val;
        ListNode loc = low;
        for (ListNode i = low.next; i != high; i = i.next) {
            if (i.val < pivot) {
                loc = loc.next;
                swap(i, loc);
            }
        }
        swap(loc, low);
        return loc;
    }

    /**
     * 交换节点的值
     *
     * @param n1
     * @param n2
     */
    private void swap(ListNode n1, ListNode n2) {
        int temp = n1.val;
        n1.val = n2.val;
        n2.val = temp;
    }


    /**
     * 归并排序，链表排序的最佳选择
     *
     * @param head
     * @return
     */
    private ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) { // 避免偶数个节点时fast最终指向null
            fast = fast.next.next;
            slow = slow.next;
        }

        fast = slow;
        slow = slow.next;
        fast.next = null;

        fast = mergeSort(head);
        slow = mergeSort(slow);

        return merge(fast, slow);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode p = head1, q = head2, k = dummy;
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

    /**
     * 冒泡排序
     *
     * @param head
     * @return
     */
    private ListNode bubbleSort(ListNode head) {
        if (head == null || head .next == null) {
            return head;
        }

        ListNode p = null;
        boolean isChange = true;
        while (p != head.next && isChange) {
            ListNode q = head;
            ListNode position = head.next;
            isChange = false;
            while (q.next != null && q.next != p) {
                if (q.val > q.next.val) {
                    swap(q, q.next);
                    isChange = true;
                    position = q.next;
                }
                q = q.next;
            }
            p = position;
        }

        return head;
    }

    public static void main(String[] args) {
        SortList test = new SortList();
        ListNode head, n1, n2, n3, n4, n5;
        n1 = new ListNode(5);
        n2 = new ListNode(1);
        n3 = new ListNode(3);
        n4 = new ListNode(4);
        n5 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        head = n1;
        ListNode res = test.bubbleSort(head);
    }
}
