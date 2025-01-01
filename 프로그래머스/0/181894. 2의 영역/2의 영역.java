
class Solution {
    public int[] solution(int[] arr) {
        int idx1 = -1, idx2 = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                idx1 = i;
                break;
            }
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 2) {
                idx2 = i;
                break;
            }
        }

        if (idx1 == -1 || idx2 == -1) return new int[]{-1};
        if (idx1 == idx2) return new int[]{2};
    

        int[] answer = new int[idx2 - idx1 + 1];
        for (int i = idx1, idx = 0; i <= idx2; i++) {
            answer[idx++] = arr[i];
        }

        return answer;
    }
}