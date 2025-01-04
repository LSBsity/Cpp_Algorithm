class Solution {
    public String solution(String s) {
        int beginIndex = s.length() / 2 - 1;
        int midIndex = s.length() / 2;
        int lastIndex = s.length() / 2 + 1;
        return s.length() % 2 == 0 ?
                s.substring(beginIndex, lastIndex) : s.substring(midIndex, lastIndex);
    }
}