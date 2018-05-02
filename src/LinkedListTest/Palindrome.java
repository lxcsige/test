package LinkedListTest;

/**
 * User: lxcfour
 * Date: 2018/5/2
 * Time: 下午3:18
 * Description: 回文，reverse一半
 */
public class Palindrome {
    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = null;
        ListNode head = n1;
        System.out.println(palindrome.isPalindrome(head));
    }

    private boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            slow = slow.next;
        }

        ListNode prev = null;
        ListNode p = slow;

        while (p != null) {
            ListNode temp = p.next;
            p.next = prev;
            prev = p;
            p = temp;
        }

        slow = prev;
        fast = head;
        while (slow != null) {
            if (slow.val == fast.val) {
                slow = slow.next;
                fast = fast.next;
            } else {
                return false;
            }
        }

        return true;
    }
}
