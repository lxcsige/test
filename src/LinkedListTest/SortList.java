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
        ListNode p = head.next; // 遍历链表的指针，从head.next开始
        ListNode pEnd = head; // 有序区域结束节点

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
}
