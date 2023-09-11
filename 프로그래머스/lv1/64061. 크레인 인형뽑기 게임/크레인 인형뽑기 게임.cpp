#include <string>
#include <vector>
#include <stack>
using namespace std;
stack<int> stk;

int solution(vector<vector<int>> board, vector<int> moves)
{
    int answer = 0;

    for (int i = 0; i < moves.size(); i++)
    {
        for (int j = 0; j < board[0].size(); j++)
        {
            if (board[j][moves[i] - 1] > 0 && board[j][moves[i] - 1] <= 100)
            {
                if (!(stk.empty()) && stk.top() == board[j][moves[i] - 1])
                {
                    stk.pop();
                    answer+=2;
                    board[j][moves[i] - 1] = 0;
                    break;
                }
                else
                {
                    stk.push(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
        }   
    }

    return answer;
}