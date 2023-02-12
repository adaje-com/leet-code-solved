package leetcode._20validparentheses;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SolutionNoNesting {

    static final Map<Character, Character> closeByOpen = new HashMap<>();

    static {
        closeByOpen.put('(', ')');
        closeByOpen.put('[', ']');
        closeByOpen.put('{', '}');
    }

    private static Iterator<Character> iterator(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .iterator();
    }

    public boolean isValid(String word) {
        if (word.isEmpty()) {
            return true;
        }
        if (word.length() % 2 != 0) {
            return false;
        }
        Iterator<Character> chars = iterator(word);
        while (chars.hasNext()) {
            if (!isMatchedPair(chars.next(), chars.next())) {
                return false;
            }
        }
        return true;
    }

    private boolean isMatchedPair(Character open, Character close) {
        return close.equals(closeByOpen.get(open));
    }
}
