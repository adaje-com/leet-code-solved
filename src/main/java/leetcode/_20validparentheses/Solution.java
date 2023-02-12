package leetcode._20validparentheses;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

public class Solution {

    static final Map<Character, Character> closeByOpen = new HashMap<>();

    static {
        closeByOpen.put('(', ')');
        closeByOpen.put('[', ']');
        closeByOpen.put('{', '}');
    }

    private final Stack<Character> unmatched = new Stack<>();

    private Iterator<Character> iterator(String word) {
        return word.chars()
                .mapToObj(c -> (char) c)
                .iterator();
    }

    public boolean isValid(String word) {
        //TODO: this is slow, profile it to see where
        if (word.isEmpty()) {
            return true;
        }
        if (word.length() % 2 != 0) {
            return false;
        }
        Iterator<Character> chars = iterator(word);
        while (chars.hasNext()) {
            Character next = chars.next();
            if (isOpenParens(next)) {
                unmatched.push(next);
            }
            if (isCloseParens(next)) {
                if (unmatched.isEmpty() || !isMatchedPair(unmatched.pop(), next)) {
                    return false;
                }
            }
        }
        return unmatched.isEmpty();
    }

    private boolean isOpenParens(Character c) {
        return closeByOpen.containsKey(c);
    }

    private boolean isCloseParens(Character c) {
        return closeByOpen.containsValue(c);
    }

    private boolean isMatchedPair(Character open, Character close) {
        return close.equals(closeByOpen.get(open));
    }
}
