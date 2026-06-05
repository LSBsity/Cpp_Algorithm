class Solution {
    public int solution(int[][] cards) {
        int answer = 0;
        
        int rowMax = 0x80000000;
        int colMax = 0x80000000;
        for (int[] card : cards) {
            int row = card[0];
            int col = card[1];
            
            if (row < col) {
                card[0] = col;
                card[1] = row;
            }
        }

        for (int[] card : cards) {
            int row = card[0];
            int col = card[1];
            
            rowMax = Math.max(rowMax, row);
            colMax = Math.max(colMax, col);
        }
        
        return rowMax * colMax;
    }
}


/**
1. 가장 큰 가로 세로 길이 값들을 찾는다?
2. 하나씩 체크하면서 가로 세로 길이를 바꿨을 때 반대 길이보다 작으면서 가장 작은 걸 찾는다
**/