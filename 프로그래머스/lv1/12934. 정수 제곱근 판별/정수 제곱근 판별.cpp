#include <string>
#include <vector>
#include <cmath>
using namespace std;

long long solution(long long n)
{
    long long ans = 0;
    ans = sqrt(n);

    if (ans * ans == n)
        return pow(ans+1, 2);

    return -1;
}