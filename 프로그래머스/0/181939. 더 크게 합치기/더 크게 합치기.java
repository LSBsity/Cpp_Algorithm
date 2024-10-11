class Solution {
    public int solution(int a, int b) {
        int i = Integer.parseInt(a + "" + b);
        int j = Integer.parseInt(b + "" + a);
        return Math.max(i, j);
    }
}