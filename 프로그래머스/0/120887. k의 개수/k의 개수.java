class Solution {
    public int solution(int start, int end, int val) {
        char charValue = (char) (val + '0');
        int count = 0;
        for (int i = start; i <= end; i++) {
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == charValue) {
                    count++;
                }
            }
        }
        return count;
    }
}
