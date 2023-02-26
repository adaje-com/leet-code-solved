package leetcode._589binarytreepreordertraversal;

import leetcode.common.Node;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    Solution solution = new Solution();

    static Node example1() {
        return Node.of(1)
                .child(Node.of(3)
                        .leaves(5, 6))
                .leaves(2, 4);
    }

    static Node example2() {
        Node root = Node.of(1);
        root.leaf(2);
        root.child(Node.of(3)
                .leaf(6)
                .child(Node.of(7)
                        .child(Node.of(11)
                                .leaf(14))));
        root.child(Node.of(4)
                .child(Node.of(8)
                        .leaf(12)));
        root.child(Node.of(5)
                .child(Node.of(9)
                        .leaf(13))
                .leaf(10));
        return root;
    }


    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.of(null, new Integer[]{}),
                Arguments.of(Node.of(1), new Integer[]{1}),
                Arguments.of(Node.of(1, 2, 3, 4), new Integer[]{1, 2, 3, 4}),
                Arguments.of(example1(), new Integer[]{1, 3, 5, 6, 2, 4}),
                Arguments.of(example2(), new Integer[]{1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10})
        );
    }


    @ParameterizedTest(name = "preorder({0}) = {1}")
    @MethodSource("argumentProvider")
    void iterativePreorder(Node root, Integer[] expected) {
        assertThat(solution.iterativePreorder(root)).isEqualTo(Arrays.asList(expected));
    }

    @ParameterizedTest(name = "preorder({0}) = {1}")
    @MethodSource("argumentProvider")
    void recursivePreorder(Node root, Integer[] expected) {
        assertThat(solution.recursivePreorder(root)).isEqualTo(Arrays.asList(expected));
    }
}
