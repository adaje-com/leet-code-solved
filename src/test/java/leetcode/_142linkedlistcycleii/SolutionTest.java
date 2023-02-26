package leetcode._142linkedlistcycleii;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("142. Linked List Cycle II")
class SolutionTest {

    static Stream<Arguments> listsWithoutCycles() {
        ListNode one = new ListNode(1);
        ListNode two = ListNode.of(1, 2);
        ListNode three = ListNode.of(1, 2, 3);
        return Stream.of(one, two, three)
                .map(Arguments::of);
    }

    static Stream<Arguments> listsWithCycles() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode cycle = ListNode.of(one, two, three, four, two);

        System.out.print("cycle = " + cycle);
        System.out.print(" two = " + two);
        return Stream.of(Arguments.of(cycle, two));
    }

    @ParameterizedTest(name = "{0} cycle detected = {1}") //TODO: how can we do better here? has a cycle, has no cycle.
    @MethodSource("listsWithCycles")
    void listsWithCycles(ListNode head, ListNode expected) {
        Assertions.assertThat(new Solution().detectCycle(head))
                .isSameAs(expected);
    }

    @ParameterizedTest(name = "{0} has no cycles")
    @MethodSource("listsWithoutCycles")
    void hasNoCycles(ListNode head) {
        Assertions.assertThat(new Solution().detectCycle(head))
                .isNull();
    }
}
