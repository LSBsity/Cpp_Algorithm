#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n)
{
    int answer = 0;
    while (n >= a)
    {
        answer += (n / a) * b;
        int temp = (n / a) * b;
        n %= a;
        n += temp;
    }
    return answer;
}