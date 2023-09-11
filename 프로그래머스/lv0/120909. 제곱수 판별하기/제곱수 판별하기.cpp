#include <string>
#include <vector>

using namespace std;

int solution(int n)
{
    int a = 1;

    while((a * a) != n)
    {
        a++;
        if ((a * a) > n)
        {
            return 2;
        }
    }
    return 1;
}