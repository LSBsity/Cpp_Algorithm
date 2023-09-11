#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> emergency)
{
    vector<int> answer;
    answer = emergency;

    sort(emergency.rbegin(), emergency.rend());

    for (int i = 0; i < answer.size(); i++)
    {
        emergency[i] += 10;
        answer[i] += 10;
    }    

    for (int i = 0; i < emergency.size(); i++)
    {
        for (int j = 0; j < answer.size(); j++)
        {
            if (emergency[i] == answer[j])
                answer[j] = i + 1;
        }
    }

    return answer;
}