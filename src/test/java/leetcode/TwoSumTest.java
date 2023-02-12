package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumTest {

    @Test
    void test() {
        assertThat(new TwoSum()
                .solve(new int[]{2, 7, 11, 15}, 9))
                .isEqualTo(new int[]{0, 1});
        assertThat(new TwoSum()
                .solve(new int[]{3, 2, 4}, 6))
                .isEqualTo(new int[]{1, 2});
        assertThat(new TwoSum()
                .solve(new int[]{3, 3}, 6))
                .isEqualTo(new int[]{0, 1});
        assertThat(new TwoSum()
                .solve(new int[]{145, 9, 112, 5, 11}, 123))
                .isEqualTo(new int[]{2, 4});
    }
}
