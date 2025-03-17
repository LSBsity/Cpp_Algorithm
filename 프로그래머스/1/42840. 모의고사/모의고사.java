import java.util.*;

class Solution {
    int[] arr1 = new int[]{1, 2, 3, 4, 5};
    int[] arr2 = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
    int[] arr3 = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        List<Integer> list = Arrays.asList(0, 0, 0);
        
        int idx = 0;
        for (int i : answers) {
            if (arr1[idx % arr1.length] == i) {
                list.set(0, list.get(0) + 1);
            }
            if (arr2[idx % arr2.length] == i) {
                list.set(1, list.get(1) + 1);
            }
            if (arr3[idx % arr3.length] == i) {
                list.set(2, list.get(2) + 1);
            }
            idx++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 3; i++) {
            if (max < list.get(i)) {
                max = list.get(i);
            }
        }
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (list.get(i) == max) {
                answer.add(i + 1);
            }
        }
        
        return answer.stream().sorted().mapToInt(i -> i).toArray();
    }
}