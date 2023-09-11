#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> keyinput, vector<int> board)
{
    vector<int> answer;
    int idx = 0, x = 0, y = 0, dx = board[0] / 2, dy = board[1] / 2;

    while (1)
    {
        if (idx == keyinput.size())
            break;

        if (keyinput[idx] == "up" && y + 1 <= dy)
            y += 1;
        else if (keyinput[idx] == "down" && y - 1 >= -dy)
            y -= 1;
        else if (keyinput[idx] == "left" && x - 1 >= -dx)
            x -= 1;
        else if (keyinput[idx] == "right" && x + 1 <= dx)
            x += 1;
        idx++;
    }

    answer.push_back(x);
    answer.push_back(y);

    return answer;
}