#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> citations)
{
    sort(citations.rbegin(), citations.rend());
    int answer = 0;
    for (int i = 0; i < citations.size(); i++)
    {
        if (i + 1 <= citations[i])
            answer++;
    }
    
    return answer;
}   