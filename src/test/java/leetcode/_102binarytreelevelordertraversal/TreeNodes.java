package leetcode._102binarytreelevelordertraversal;

import leetcode.common.TreeNode;

public class TreeNodes {
    static TreeNode example1() {
        return TreeNode.of(3)
                .left(9)
                .right(TreeNode.of(20)
                        .left(15)
                        .right(7));
    }
}
