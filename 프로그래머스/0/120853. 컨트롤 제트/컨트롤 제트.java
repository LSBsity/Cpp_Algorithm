class Solution {

    public int solution(String s) {
        int result = 0, before = 0;
        for (String string : s.split(" ")) {
            if (string.equals("Z")) {
                result -= before;
                continue;
            }
            int converted = Integer.parseInt(string);
            result += before = converted;
        }
        return result;
    }
}