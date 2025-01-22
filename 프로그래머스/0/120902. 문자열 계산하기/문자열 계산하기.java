class Solution {

    public int solution(String my_string) {
        String[] split = my_string.split(" ");
        int sum = 0;

        int sign = 0;
        for (String s : split) {
            String trimmed = s.trim();
            if (trimmed.equals("+")) {
                sign = 1;
            } else if (trimmed.equals("-")) {
                sign = 2;
            } else if (sign == 0) {
                sum = Integer.parseInt(trimmed);
            } else {
                if (sign == 1) {
                    sum += Integer.parseInt(trimmed);
                } else {
                    sum -= Integer.parseInt(trimmed);
                }
                sign = 0;
            }
        }
        return sum;
    }
}