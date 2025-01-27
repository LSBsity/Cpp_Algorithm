import java.util.Arrays;

class Solution {

    public int solution(String[] spell, String[] dic) {
        Arrays.sort(spell);
        String join = String.join("", spell);
        for (String s : dic) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String convert = new String(charArray);
            if (join.equals(convert)) {
                return 1;
            }
        }
        return 2;
    }
}