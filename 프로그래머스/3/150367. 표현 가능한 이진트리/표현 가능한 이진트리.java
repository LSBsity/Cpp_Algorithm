class Solution {
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            String bitString = this.getBitString(numbers[i]);
            boolean valid = this.check(bitString, 0, bitString.length() - 1).valid;
            answer[i] = valid ? 1 : 0;
        }

        return answer;
    }

    private String getBitString(long number) {
        String bin = Long.toBinaryString(number);
        int len = bin.length();
        int k = 0;

        while ((1L << k) - 1 < len)
            k++;

        int targetLen = (int)((1L << k) - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < targetLen - len; i++)
            sb.append('0');
        sb.append(bin);

        return sb.toString();
    }

    private static class NodeResult {
        boolean valid;   // 규칙을 만족하는지
        boolean hasOne;  // 이 구간에 '1'이 있는지

        NodeResult(boolean valid, boolean hasOne) {
            this.valid = valid;
            this.hasOne = hasOne;
        }
    }

    private NodeResult check(String str, int left, int right) {
        if (left > right) return new NodeResult(true, false);

        int mid = (left + right) / 2;
        NodeResult leftRes = check(str, left, mid - 1);
        NodeResult rightRes = check(str, mid + 1, right);

        boolean midIsOne = str.charAt(mid) == '1';
        boolean hasOne = midIsOne || leftRes.hasOne || rightRes.hasOne;

        boolean valid = leftRes.valid && rightRes.valid;
        if (!midIsOne && (leftRes.hasOne || rightRes.hasOne)) {
            valid = false;
        }

        return new NodeResult(valid, hasOne);
    }
}
