package leetcode._589binarytreepreordertraversal;

import leetcode.common.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Stack;

public class Solution {

    public List<Integer> iterativePreorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            Node current = stack.pop();
            result.add(current.val);
            if (current.children != null) {
                ListIterator<Node> children = current.children.listIterator(current.children.size());
                while (children.hasPrevious()) {
                    stack.push(children.previous());
                }
            }
        }
        return result;
    }

    public List<Integer> recursivePreorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);
        if (root.children == null) {
            return result;
        }
        for (Node child : root.children) {
            result.addAll(recursivePreorder(child));
        }
        return result;
    }
}
