package leetcode.common;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode of(int value) {
        return new TreeNode(value);
    }

    public TreeNode left(int value) {
        this.left = new TreeNode(value);
        return this;
    }

    public TreeNode right(int value) {
        this.right = new TreeNode(value);
        return this;
    }

    public TreeNode right(TreeNode right) {
        this.right = right;
        return this;
    }
}
