import java.util.ArrayList;

class Solution {
    private static boolean check(int value) {
        String str = String.valueOf(value);
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '0' && c != '5') return false;
        }
        
        return true;
    }
    
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = l; i <= r; i++) {
            if (check(i)) {
                list.add(i);
            }
        }
        
        if (list.size() == 0) return new int[]{-1};
        
        return list.stream()
            .mapToInt(i -> i)
            .toArray();
    }
}