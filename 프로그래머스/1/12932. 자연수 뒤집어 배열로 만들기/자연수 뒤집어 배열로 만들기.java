class Solution {
    public int[] solution(long n) {
        String str2 = new StringBuffer(String.valueOf(n))
            .reverse()
            .toString();
        return str2.chars()
                .map(i -> i - '0')
                .toArray();
    }
}