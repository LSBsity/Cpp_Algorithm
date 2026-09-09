import java.util.*;
import static java.util.Map.entry;

class Solution {
    static Map<String, Character> map = Map.ofEntries(
        entry(".-", 'a'),
        entry("-...", 'b'),
        entry("-.-.", 'c'),
        entry("-..", 'd'),
        entry(".", 'e'),
        entry("..-.", 'f'),
        entry("--.", 'g'),
        entry("....", 'h'),
        entry("..", 'i'),
        entry(".---", 'j'),
        entry("-.-", 'k'),
        entry(".-..", 'l'),
        entry("--", 'm'),
        entry("-.", 'n'),
        entry("---", 'o'),
        entry(".--.", 'p'),
        entry("--.-", 'q'),
        entry(".-.", 'r'),
        entry("...", 's'),
        entry("-", 't'),
        entry("..-", 'u'),
        entry("...-", 'v'),
        entry(".--", 'w'),
        entry("-..-", 'x'),
        entry("-.--", 'y'),
        entry("--..", 'z')
    );

    public String solution(String letter) {
        StringBuilder sb = new StringBuilder();
        for (String str : letter.split(" ")) {
            sb.append(map.get(str));
        }
        return sb.toString();
    }
}