package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToIntTest {

    @ParameterizedTest
    @CsvSource(value = {"M:1000", "MM:2000", "MMM:3000"}, delimiter = ':')
    void testThousands(String input, String expected) {
        assertThat(RomanToInt.solve(input)).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"C:100", "CC:200", "CCC:300", "CD:400", "D:500", "DC:600", "DCC:700", "DCCC:800", "CM:900"}, delimiter = ':')
    void testHundreds(String input, String expected) {
        assertThat(RomanToInt.solve(input)).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"X:10", "XX:20", "XXX:30", "XL:40", "L:50", "LX:60", "LXX:70", "LXXX:80", "XC:90"}, delimiter = ':')
    void testTens(String input, String expected) {
        assertThat(RomanToInt.solve(input)).isEqualTo(Integer.valueOf(expected));
    }

    @ParameterizedTest
    @CsvSource(value = {"I:1", "II:2", "III:3", "IV:4", "V:5", "VI:6", "VII:7", "VIII:8", "IX:9"}, delimiter = ':')
    void testOnes(String input, String expected) {
        assertThat(RomanToInt.solve(input)).isEqualTo(Integer.valueOf(expected));
    }
}
