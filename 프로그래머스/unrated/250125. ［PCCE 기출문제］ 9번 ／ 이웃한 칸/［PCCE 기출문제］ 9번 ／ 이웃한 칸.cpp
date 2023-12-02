#include <string>
#include <vector>
using namespace std;

struct coord {
    int x;
    int y;
};

coord dir[4] = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

int solution(vector<vector<string>> board, int h, int w) {
    int answer = 0;
    for (int i = 0; i < 4; i++) {
        int z = h + dir[i].x, k = w + dir[i].y;
        if (z >= 0 && z < board[0].size() && k >= 0 && k < board.size())
            if (board[h][w] == board[z][k]) answer++;
    }
    return answer;
}