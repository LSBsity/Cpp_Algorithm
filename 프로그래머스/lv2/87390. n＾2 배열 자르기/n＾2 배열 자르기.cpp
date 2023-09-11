#include <string>
#include <vector>

using namespace std;

vector<int> solution(int n, long long left, long long right)
{
    int len = right - left + 1;
    vector<int> answer;
    int r = left / n;
    int c = left % n;
    for (int i = 0; i < len; i++)
    {
        answer.push_back((r > c ? r : c) + 1);
        r += ++c / n;
        c %= n;
    }
    return answer;
}