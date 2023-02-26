package leetcode._102binarytreelevelordertraversal;

import leetcode.common.TreeNode;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("102. Binary Tree Level Order Traversal")
class SolutionTest {

    private final Solution solution = new Solution();

    private static Stream<Arguments> argumentProvider() {
        List<List<Integer>> one = List.of(List.of(new Integer[]{1}));
        List<List<Integer>> example1LevelOrder = List.of(
                List.of(new Integer[]{3}),
                List.of(new Integer[]{9, 20}),
                List.of(new Integer[]{15, 7}));
        return Stream.of(
                Arguments.of(null, new ArrayList<>()),
                Arguments.of(TreeNode.of(1), one),
                Arguments.of(TreeNodes.example1(), example1LevelOrder));
    }

    @ParameterizedTest(name = "levelOrder({0} = {1}")
    @MethodSource("argumentProvider")
    void recursiveLevelOrder(TreeNode tree, List<List<Integer>> expected) {
        assertThat(solution.recursiveLevelOrder(tree)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "levelOrder({0} = {1}")
    @MethodSource("argumentProvider")
    void iterativeLevelOrder(TreeNode tree, List<List<Integer>> expected) {
        assertThat(solution.iterativeLevelOrder(tree)).isEqualTo(expected);
    }

}
