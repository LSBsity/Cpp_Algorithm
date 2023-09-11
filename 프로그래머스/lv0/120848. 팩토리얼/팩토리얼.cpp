#include <string>
#include <vector>

using namespace std;

int solution(int n)
{
    int i = 1;
    int j = 1;
    while (n >= i)
    {
        i *= j;
        j++;
    }

    return j - 2;
}