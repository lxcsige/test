package BinaryTreeTraversal;

import java.util.*;

/**
 * Created by liuxucheng on 2018/5/8.
 */
public class Solution {

    public static void main(String[] args) {

    }


    public List<Integer> traversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode node, List<Integer> res) {
        if (node != null) {
            res.add(node.val);
            preOrder(node.left, res);
            preOrder(node.right, res);
        }
    }

    /**
     * 栈中保存的是根节点
     * @param root
     * @return
     */
    private List<Integer> preOrder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            res.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return res;
    }

    /**
     * 左子树节点依次入栈，然后出栈访问右子树
     * @param root
     * @return
     */
    private List<Integer> preOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                res.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                cur = cur.right;
            }
        }

        return res;
    }

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node != null) {
            inOrder(node.left, res);
            res.add(node.val);
            inOrder(node.right, res);
        }
    }

    private List<Integer> inOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            if (!stack.isEmpty()) {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }

    private List<Integer> postOrder1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode prev = null; // 记录前驱节点
        while (cur != null || !stack.isEmpty()) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            if (!stack.isEmpty()) {
                cur = stack.peek();
                if (cur.right == null || cur.right == prev) {
                    res.add(cur.val);
                    stack.pop();
                    prev = cur;
                    cur = null;
                } else {
                    cur = cur.right;
                }
            }
        }

        return res;
    }

    /**
     * 节点入栈，不存在子节点或存在且左节点和又节点都被访问过则直接出栈并输出
     * @param root
     * @return
     */
    private List<Integer> postOrder2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur;
        TreeNode prev = null; // 记录前驱节点
        stack.push(root);
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if ((cur.left == null && cur.right == null) || (prev != null && (prev == cur.left || prev == cur.right))) {
                res.add(cur.val);
                stack.pop();
                prev = cur;
            } else {
                if (cur.right != null) {
                    stack.push(cur.right);
                }
                if (cur.left != null) {
                    stack.push(cur.left);
                }
            }
        }

        return res;
    }

    private void postOrder(TreeNode node, List<Integer> res) {
        if (node != null) {
            postOrder(node.left, res);
            postOrder(node.right, res);
            res.add(node.val);
        }
    }

    /**
     * 层次遍历
     * @param root
     */
    private List<Integer> levelTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        int level = 0;
        int parentSize = 1;
        int childSize = 0;
        TreeNode cur;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            cur = queue.poll();
            res.add(cur.val);
            parentSize--;

            if (cur.left != null) {
                queue.offer(cur.left);
                childSize++;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                childSize++;
            }

            if (parentSize == 0) {
                parentSize = childSize;
                childSize = 0;
                level++;
            }
        }

        System.out.println("level = " + level);

        return res;
    }

    private List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                subList.add(cur.val);
            }

            res.add(0, subList);
        }

        return res;
    }
}
