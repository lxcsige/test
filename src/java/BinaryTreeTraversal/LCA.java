package BinaryTreeTraversal;

import java.util.List;

/**
 * Created by liuxucheng on 2018/5/9.
 */
public class LCA {

    /**
     * 在BST中找两个节点的LCA
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null || root == null) {
            return null;
        }

        int a = p.val;
        int b = q.val;
        if (root.val > a && root.val > b) {
            return findLCA(root.right, p, q);
        } else if (root.val < a && root.val < b) {
            return findLCA(root.left, p, q);
        }
        return root;
    }

    public TreeNode findLCA2(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null || root == null) {
            return null;
        }

        if (root == p) {
            return root;
        }
        if (root == q) {
            return root;
        }

        TreeNode left = findLCA2(root.left, p, q);
        TreeNode right = findLCA2(root.right, p, q);
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return root;
    }

    private boolean getPath(TreeNode root, TreeNode p, List<TreeNode> path) {
        if (root == null || p == null) {
            return false;
        }

        if (root == p) {
            path.add(root);
            return true;
        }

        path.add(root);
        if (getPath(root.left, p, path) || getPath(root.right, p, path)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }
}
