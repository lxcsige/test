package LinkedListTest;

/**
 * User: lxcfour
 * Date: 2018/5/2
 * Time: 下午8:07
 * Description: O(nlogn)时间复杂度 & O(1)空间复杂度排序 --> 堆排序
 */
public class SortList {

    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        return insertionSort2(head);
    }

    /**
     * 直接插入排序
     * @param head
     * @return
     */
    private ListNode insertionSort(ListNode head) {
        ListNode pStart = new ListNode(0); // 有序区域开始节点
        pStart.next = head;
        ListNode pEnd = head; // 有序区域结束节点
        ListNode p = head.next; // 遍历链表的指针，从head.next开始

        while (p != null) {
            ListNode tmp = pStart.next, pre = pStart;
            while (tmp != p && p.val >= tmp.val) { // 寻找有序区域第一个比待插入节点的值小的节点
                tmp = tmp.next;
                pre = pre.next;
            }
            if (tmp == p) { // 未找到则直接将pEnd指向p
                pEnd = p;
            } else { // 否则将节点插入
                pEnd.next = p.next;
                p.next = tmp;
                pre.next = p;
            }
            p = pEnd.next;
        }

        return pStart.next;
    }

    private ListNode insertionSort2(ListNode head) {
        if( head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = head; //the node will be inserted
        ListNode pre = dummy; //insert node between pre and pre.next
        ListNode next; //the next node will be inserted
        while( cur != null ){
            next = cur.next;
            while( pre.next != null && pre.next.val < cur.val ){
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SortList test = new SortList();
        ListNode head, n1, n2, n3, n4, n5;
        n1 = new ListNode(5);
        n2 = new ListNode(2);
        n3 = new ListNode(4);
        n4 = new ListNode(3);
        n5 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        head = n1;
        ListNode res = test.sortList(head);
        System.out.print(res);
    }
}
