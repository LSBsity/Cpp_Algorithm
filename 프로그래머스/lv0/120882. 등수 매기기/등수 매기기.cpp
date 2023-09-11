#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<vector<int>> score)
{
    vector<int> answer;
    vector<int> vec;

    for (int i = 0; i < score.size(); i++)
        vec.push_back(score[i][0] + score[i][1]);
 
    for (int i = 0; i < vec.size(); i++)
    {
        int count = 1;
        for (int j = 0; j < vec.size(); j++)
        {
            if (vec[i] < vec[j])
                count++;
        }
        answer.push_back(count);
    }

    return answer;
}