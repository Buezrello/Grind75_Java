package grind75.balancedbinarytree;

/**
 * Given a binary tree, determine if it is
 * height-balanced.
 * <p>
 * A height-balanced binary tree is a binary tree
 * in which the depth of the two subtrees of every node never differs by more than one.
 */
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return heightBalance(root) >= 0;
    }

    private int heightBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = heightBalance(node.left);
        if (leftHeight == -1) return -1;

        int rightHeight = heightBalance(node.right);
        if (rightHeight == -1) return -1;

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
