#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> prices)
{
    vector<int> answer;

    for (int i = 0; i < prices.size(); i++)
    {
        int tmp = prices[i];
        int count = 0;
        if (i == prices.size() - 1)
        {
            answer.push_back(0);
            break;
        }
        for (int j = i + 1; j < prices.size(); j++)
        {
            count++;
            if (tmp > prices[j])
            {
                answer.push_back(count);
                break;
            }
            else if (j == prices.size() - 1)
                answer.push_back(count);
        }
    }

    return answer;
}