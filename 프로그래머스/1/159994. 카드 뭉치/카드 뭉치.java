class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        
        for (int i = 0, idx1 = 0, idx2 = 0; i < goal.length; i++) {
            if (idx1 < cards1.length && cards1[idx1].equals(goal[i])) {
                idx1++;
            } else if (idx2 < cards2.length && cards2[idx2].equals(goal[i])){
                idx2++;
            } else {
                return "No";
            }
        }
        
        return "Yes";
    }
}