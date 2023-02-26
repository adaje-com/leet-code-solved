package leetcode._102binarytreelevelordertraversal;

import leetcode.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Solution {

    private List<List<Integer>> levels = new ArrayList<>();

    public List<List<Integer>> recursiveLevelOrder(TreeNode root) {
        traverse(root, 0);
        return levels;
    }

    void traverse(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        getLevel(level).add(node.val);
        traverse(node.left, level + 1);
        traverse(node.right, level + 1);
    }

    private List<Integer> getLevel(int level) {
        if (levels.size() == level) {
            List<Integer> emptyList = new ArrayList<>();
            levels.add(emptyList);
            return emptyList;
        }
        return levels.get(level);
    }

    public List<List<Integer>> iterativeLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.remove();
                level.add(node.val);
                queueChildren(node, queue);
            }
            result.add(level);
        }
        return result;
    }

    private void queueChildren(TreeNode node, Queue<TreeNode> nodes) {
        if (node.left != null) {
            nodes.add(node.left);
        }
        if (node.right != null) {
            nodes.add(node.right);
        }
    }
}
