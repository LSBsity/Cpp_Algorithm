import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        int[] num_list2 = Arrays.copyOf(num_list, num_list.length + 1);
        if (num_list[num_list.length - 1] > num_list[num_list.length - 2]) {
            num_list2[num_list2.length - 1] = num_list[num_list.length - 1] - num_list[num_list.length - 2];
        } else {
            num_list2[num_list2.length - 1] = num_list[num_list.length - 1] * 2;
        }
        return num_list2;
    }
}