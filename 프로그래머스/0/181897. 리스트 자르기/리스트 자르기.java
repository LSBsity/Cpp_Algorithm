import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        if (n == 1) {
            return Arrays.copyOfRange(num_list, 0, slicer[1] + 1);
        } else if (n == 2) {
            return Arrays.copyOfRange(num_list, slicer[0], num_list.length);
        } else if (n == 3) {
            return Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = slicer[0]; i <= slicer[1]; i += slicer[2]) {
                list.add(num_list[i]);
            }
            return list.stream().mapToInt(i -> i).toArray();
        }
    }
}