class Solution {
    public int[] solution(int brown, int yellow) {
        int blocks = brown + yellow;
        
        int first = 3;

        while (first < blocks) {
            int b = first;

            if (blocks % b == 0) {
                int a = blocks / b;
                
                int upDown = a * 2;
                int side = (b - 2) * 2;
                
                if (upDown + side + yellow == blocks) {
                    return new int[]{a, b};
                }
            }
            
            first++;
        }
    
        return null;
    }
}