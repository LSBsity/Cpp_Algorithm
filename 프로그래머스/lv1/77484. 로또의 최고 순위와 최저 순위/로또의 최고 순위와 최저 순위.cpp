#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums)
{
    vector<int> answer;
    int correctNum = 0;
    int deletedNum = 0;
    for (int i = 0; i < 6; i++)
    {
        for (int j = 0; j < 6; j++)
            if (win_nums[i] == lottos[j])
                correctNum++;

        if (lottos[i] == 0)
            deletedNum++;
    }

    int maximumNum = correctNum + deletedNum;
    if (correctNum == 0 && deletedNum == 0)
    {
        answer.push_back(6);
        answer.push_back(6);
    }
    else
    {
        answer.push_back(7 - maximumNum);

        if (correctNum >= 2)
            answer.push_back(7 - correctNum);
        else
            answer.push_back(6);
    }

    return answer;
}
