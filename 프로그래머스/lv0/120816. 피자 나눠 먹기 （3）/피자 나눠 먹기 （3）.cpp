#include <string>
#include <vector>

using namespace std;

int solution(int slice, int n)
{
    int ans = n / slice;
    if (n % slice != 0)
    {
        ans++;
    }


    return ans;
}