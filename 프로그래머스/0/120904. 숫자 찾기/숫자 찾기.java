class Solution {
    public int solution(int num, int k) {
        String temp = String.valueOf(num);
        int pos = temp.indexOf(String.valueOf(k));
        return pos == -1 ? -1 : pos + 1;
    }
}
