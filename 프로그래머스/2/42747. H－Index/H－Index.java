import java.util.*;

class Solution {
    public int solution(int[] arr) {
        int answer = arr[0];
        
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        
        int count = 0;
        while (true) {
            count++;
            int checks = 0;
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > count) {
                    checks++;
                }
                if (checks > count) {
                    flag = false;
                    break;
                } 

            }   
            if (checks >= count) {
                flag = true;
            } 
            if (flag) {
                int checks2 = 0;
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] <= count) checks2++;   
                }
                System.out.println(checks2);
                if (checks2 <= arr.length - checks) answer = count;
            }
            if (count > 10000) {
                break;
            }
        }
        return answer;
    }
}
// 5 6 7 8 -> 4