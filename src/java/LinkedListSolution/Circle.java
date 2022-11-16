package LinkedListSolution;

/**
 * User: lxcfour
 * Date: 2018/5/23
 * Time: 下午9:23
 */
public class Circle {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node5;

        Circle solution = new Circle();
        System.out.println("环长 = " + solution.existCircle(head));
        System.out.println("环入口节点 = " + (solution.circleNode(head) == null ? -1 : solution.circleNode(head).getValue()));
    }

    /**
     * 单链表中是否存在环
     * @param head
     * @return 0 - 不存在环，> 0 - 环的长度
     */
    public int existCircle(Node head) {
        if (head == null) {
            return 0;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) { // 存在环

                // 第二次相遇，多走的距离就是环的长度
                int len = 0;
                while(true) {
                    slow = slow.next;
                    fast = fast.next.next;
                    len++;

                    if (slow == fast) {
                        return len;
                    }
                }
            }
        }

        return 0;
    }

    /**
     * 单链表中是否存在环
     * @param head
     * @return null - 不存在环，!= null - 环的入口节点
     */
    public Node circleNode(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // 相遇之后，两个指针以相同的速度继续走，直到再次相遇，相遇节点即环的入口点
                // 相遇点到入口点的距离 +  n * 环长 = 头节点到入口点的距离
                fast = head;
                while(true) {
                    slow = slow.next;
                    fast = fast.next;

                    if (slow == fast) {
                        return slow;
                    }
                }
            }
        }

        return null;
    }

    public static class Node {
        private int value;

        private Node next;

        public Node() {

        }

        public Node (int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}
