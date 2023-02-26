package leetcode.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Node {

    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, List<Node> children) {
        this.val = val;
        this.children = children;
    }

    public static Node of(int root) {
        return new Node(root);
    }

    public static Node of(int root, int... leaves) {
        return new Node(root, Node.list(leaves));
    }

    public static Node of(int root, int child) {
        return Node.of(root, new int[]{child});
    }

    public static Node of(int root, Node... children) {
        return new Node(root, Arrays.asList(children));
    }

    public static Node of(Node root, int child) {
        return Node.of(root, new int[]{child});
    }

    public static Node of(Node root, int... children) {
        return Node.of(root, Node.list(children));
    }

    public static Node of(Node root, Node child) {
        return Node.of(root, new Node[]{child});
    }

    public static Node of(Node root, Node... children) {
        return Node.of(root, Arrays.asList(children));
    }

    public static Node of(Node root, List<Node> children) {
        root.children = children;
        return root;
    }

    public static List<Node> list(int... numbers) {
        List<Node> nodes = new ArrayList<>(numbers.length);
        for (int number : numbers) {
            nodes.add(new Node(number));
        }
        return nodes;
    }

    public Node leaf(int number) {
        return child(new Node(number));
    }

    public Node leaves(int... numbers) {
        for (int number : numbers) {
            leaf(number);
        }
        return this;
    }

    public Node child(Node node) {
        if (this.children == null) {
            children = new ArrayList<>();
        }
        this.children.add(node);
        return this;
    }
}
