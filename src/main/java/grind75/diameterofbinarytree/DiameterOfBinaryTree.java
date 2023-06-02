package grind75.diameterofbinarytree;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 * <p>
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 * <p>
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiameterOfBinaryTree {

    private int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        diameterCalculating(root);
        return diameter;
    }

    private int diameterCalculating(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = diameterCalculating(node.left);
        int right = diameterCalculating(node.right);

        if (diameter < left + right) {
            diameter = left + right;
        }

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree dbt = new DiameterOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);

        System.out.println(dbt.diameterOfBinaryTree(root));

        root = new TreeNode(1);
        root.left = new TreeNode(2);

        System.out.println(dbt.diameterOfBinaryTree(root));
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

