import java.util.Set;
import java.util.HashSet;
class Solution {

    private final Set<String> set = new HashSet<>();

    public int[] solution(int n, String[] words) {
        String lastWord = words[0];
        set.add(lastWord);
        for (int i = 1; i < words.length; i++) {
            if ((lastWord.charAt(lastWord.length() - 1) != words[i].charAt(0)) || set.contains(
                    words[i])) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            set.add(words[i]);
            lastWord = words[i];
        }
        return new int[]{0, 0};
    }
}

