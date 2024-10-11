class Solution {
    public int[] solution(int[] array) {
        int index = 0, value = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > value) {
                value = array[i];
                index = i;
            }
        }
        return new int[]{value, index};
    }
}