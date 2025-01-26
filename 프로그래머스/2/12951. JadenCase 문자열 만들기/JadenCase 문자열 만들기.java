class Solution {

    public String solution(String s) {
        char[] arr = s.toCharArray();
        char last = ' ';
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            if (last == ' ' && Character.isAlphabetic(c)) {
                arr[i] = Character.toUpperCase(c);
            } else {
                arr[i] = Character.toLowerCase(c);
            }
            last = c;
        }

        return new String(arr);
    }
}