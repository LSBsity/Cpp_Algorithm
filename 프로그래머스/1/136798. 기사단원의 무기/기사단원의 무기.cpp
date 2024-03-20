#include <string>
#include <vector>

using namespace std;

int getNum(int n)
{
    int cnt = 0;
    for (int i = 1; i * i <= n; i++)
    {
        if (n % i == 0)
        {
            cnt++;
            if (i * i < n)
                cnt++;
        }
    }
    return cnt;
}

int solution(int number, int limit, int power)
{
    int answer = 0;
    for (int i = 1; i <= number; i++)
    {
        int result = getNum(i);
        if (result > limit)
            answer += power;
        else
            answer += result;
    }
    return answer;
}
