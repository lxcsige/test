package BinaryTreeTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

        return res;
    }

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

    private void inOrder(TreeNode node, List<Integer> res) {
        if (node != null) {
            inOrder(node.left, res);
            res.add(node.val);
            inOrder(node.right, res);
        }
    }

    private void postOrder(TreeNode node, List<Integer> res) {
        if (node != null) {
            postOrder(node.left, res);
            postOrder(node.right, res);
            res.add(node.val);
        }
    }
}
