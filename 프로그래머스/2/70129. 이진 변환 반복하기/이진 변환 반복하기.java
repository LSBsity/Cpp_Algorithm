class Solution {

    public int[] solution(String s) {
        int iterateCount = 0;
        int zeroSum = 0;
        while (!s.equals("1")) {
            int zeroCount = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                }
            }
            s = Integer.toBinaryString(s.length() - zeroCount);
            iterateCount++;
            zeroSum += zeroCount;
        }

        return new int[]{iterateCount, zeroSum};
    }
}