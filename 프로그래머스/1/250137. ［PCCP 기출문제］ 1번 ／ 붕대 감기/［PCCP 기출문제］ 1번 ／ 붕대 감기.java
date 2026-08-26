class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0, fever = 0;   
        int max = health;
        
        int t = bandage[0], x = bandage[1], y = bandage[2];
        
        if (attacks[0][0] == 0) health -= attacks[0][1];
        if (health <= 0) return -1;

        for (int i = 1, j = 0; i <= attacks[attacks.length - 1][0]; i++) {
            if (i == attacks[j][0]) {
                health -= attacks[j][1];
                if (health <= 0) return -1;
                
                fever = 0;
                j++;
            } else {
                health += x;
                fever++;

                if (fever == t) {
                    health += y;
                    fever = 0;
                }
                
                if (health > max) health = max;
            }
        }
        
        return health;
    }
}