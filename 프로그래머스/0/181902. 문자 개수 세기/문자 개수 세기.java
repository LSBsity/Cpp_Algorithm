class Solution {

    public int[] solution(String my_string) {
        int[] arr = new int[52];
        for (int i = 0; i < my_string.length(); i++) {
            char charAt = my_string.charAt(i);
            if (Character.isUpperCase(charAt)) {
                arr[charAt - 65]++;
            } else { 
                arr[charAt - 71]++;
            }
        }
        return arr;
    }
}