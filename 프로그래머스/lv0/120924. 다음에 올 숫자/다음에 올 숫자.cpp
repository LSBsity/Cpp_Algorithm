#include <string>
#include <vector>

using namespace std;

int solution(vector<int> common)
{
    int answer = 0;
    int A = 0;
    for (int i = common.size()-1; i > 0; i--)
        A += common[i] - common[i-1];

    if (A / (common.size() - 1) == common[common.size()-1] - common[common.size()-2])
        answer = common[common.size()-1] + (A / (common.size() - 1));
    else
        answer = common[common.size()-1] * common[common.size() - 1] / common[common.size()-2];
    
    return answer;
}