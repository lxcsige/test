package BinaryTreeTraversal;

import java.util.List;

/**
 * User: lxcfour
 * Date: 2018/5/10
 * Time: 上午10:53
 */
public class LCA {

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
