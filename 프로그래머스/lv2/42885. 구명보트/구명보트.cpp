#include <string>
#include <vector>
#include <algorithm>
#include <deque>
using namespace std;
deque<int> dq;
int solution(vector<int> people, int limit)
{
    int answer = 0;
    copy(people.begin(), people.end(), inserter(dq, dq.end()));

    sort(dq.begin(), dq.end());

    while (dq.size() != 0)
    {
        if (dq.size() == 1)
        {
            answer++;
            break;
        }
        if (dq[0] + dq[dq.size() - 1] <= limit)
        {
            dq.pop_front();
            dq.pop_back();
            answer++;
        }
        else
        {
            dq.pop_back();
            answer++;
        }
    }
    return answer;
}