class Solution {

    public int[] solution(int n, long left, long right) {
        int size = (int) (right - left + 1);
        int[] answer = new int[size];

        long range = left;
        for (int i = 0 , pos = 0; i < size; i++, range++, pos++) {
            int j = (int) (range / (long) n);
            int k = (int) (range % (long) n);
            answer[pos] = k < j + 1 ? j + 1 : k + 1;
        }

        return answer;
    }
}
