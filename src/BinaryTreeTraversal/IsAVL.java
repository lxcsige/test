package BinaryTreeTraversal;

/**
 * User: lxcfour
 * Date: 2018/5/9
 * Time: 下午9:35
 */
public class IsAVL {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (Math.abs(leftHeight -  rightHeight) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == -1) {
            return -1;
        }
        if (rightHeight == -1) {
            return -1;
        }
        if (Math.abs(leftHeight -  rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
