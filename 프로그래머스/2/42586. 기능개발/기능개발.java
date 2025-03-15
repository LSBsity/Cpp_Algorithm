import java.util.*;

class Solution {
    public int[] solution(int[] p, int[] s) {
        
        int[] arr = new int[p.length];
        
        for (int i = 0; i < p.length; i++) {
            arr[i] = (100 - p[i]) / s[i];
            if ((100 - p[i]) % s[i] != 0) arr[i]++;
        }
        
        List<Integer> list = new ArrayList<>();
        int last = arr[0];
        int cnt = 1;
        for (int i = 1; i < arr.length; i++) {
            if (last < arr[i]) {
                list.add(cnt);
                last = arr[i];
                cnt = 1;
            } else {
                cnt++;
            }
        }
        list.add(cnt);

        return list.stream().mapToInt(i -> i).toArray();
    }
}