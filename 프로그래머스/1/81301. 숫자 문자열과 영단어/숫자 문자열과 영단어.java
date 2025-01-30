import java.util.Map;

class Solution {

    private final Map<String, Integer> map = Map.of(
            "zero", 0,
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    );

    public int solution(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
                i++;
            } else {
                String key = this.getKey(s.substring(i, i + 2));
                Integer number = this.map.get(key);
                sb.append(number);
                i += key.length();
            }
        }

        return Integer.parseInt(sb.toString());
    }

    private String getKey(String sub) {
        for (String key : this.map.keySet()) {
            if (key.startsWith(sub)) {
                return key;
            }
        }
        return null;
    }
}