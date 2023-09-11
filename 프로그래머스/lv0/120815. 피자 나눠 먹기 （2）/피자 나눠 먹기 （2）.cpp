#include <string>
#include <vector>

using namespace std;

int solution(int n)
{
    int pizza = 0;
    int a = n;
    if (n % 6 == 0)
        pizza = n / 6;
    else
    {
        while (1)
        {
            if (n % 6 == 0)
            {
                pizza = n / 6;
                break;
            }
            n += a;
        }
    }
    return pizza;
}