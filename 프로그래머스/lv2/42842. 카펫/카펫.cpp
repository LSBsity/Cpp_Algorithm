#include <string>
#include <vector>
#include <cmath>
#include <algorithm>
using namespace std;

vector<int> solution(int brown, int yellow)
{
    vector<int> answer;
    int carp = brown + yellow;

    for (int i = carp / 2; i > 0; i--)
    {
        if (carp % i == 0)
        {
            int a = i;
            int b = carp / i;
            if ((a - 2) * (b - 2) == yellow)
            {
                answer.push_back(a);
                answer.push_back(b);
                break;
            }
        }
    }

    return answer;
}