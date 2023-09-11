#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board)
{
    int answer = 0;
    int n = board.size();
    int X[8] = {1, 1, 1, 0, 0, -1, -1, -1};
    int Y[8] = {1, 0, -1, 1, -1, 1, 0, -1};

    for (int i = 0; i < n; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (board[i][j] == 1)
            {
                for (int k = 0; k < 8; k++)
                {
                    if (i + X[k] >= 0 && i + X[k] < n && j + Y[k] >= 0 && j + Y[k] < n)
                        if (board[i + X[k]][j + Y[k]] != 1)
                            board[i + X[k]][j + Y[k]] = 2;
                }
            }
        }
    }

    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            if (board[i][j] == 0)
                answer++;

    return answer;
}