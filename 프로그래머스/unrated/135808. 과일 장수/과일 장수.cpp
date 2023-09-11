#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, int m, vector<int> score)
{
    int answer = 0;
    int i = 0;
    int size = score.size() / m;
    sort(score.rbegin(), score.rend());
    
    while (size--)
    {
        answer += *min_element(score.begin() + i, score.begin() + m + i) * m;
        i += m;
    }
    return answer;
}