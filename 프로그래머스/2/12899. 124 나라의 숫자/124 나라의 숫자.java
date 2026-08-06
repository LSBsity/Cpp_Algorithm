class Solution {
    
    public String solution(int n) {
        String[] d = {"4", "1", "2"};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, d[n % 3]);
            n = (n - 1) / 3;
        }
        return sb.toString();
    }
}