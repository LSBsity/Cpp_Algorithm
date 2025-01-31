import java.util.Set;
import java.util.HashSet;

class Solution {

    private final Set<String> set = new HashSet<>();

    public int[] solution(int n, String[] words) {
        String last = words[0];
        set.add(last);

        for (int i = 1; i < words.length; i++) {
            if (last.charAt(last.length() - 1) != words[i].charAt(0) || !set.add(words[i])) {
                return new int[]{(i % n) + 1, (i / n) + 1};
            }

            last = words[i];
        }

        return new int[]{0, 0};
    }
}