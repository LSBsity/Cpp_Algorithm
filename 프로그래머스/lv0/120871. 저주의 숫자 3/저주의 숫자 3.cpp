#include <string>
#include <vector>

using namespace std;

int solution(int n)
{
    int answer = 0;
    int count = 1, a = 1;

    while (1)
    {
        bool check = false;
        string str = to_string(a);

        if (a % 3 == 0)
        {
            a += 1;
            continue;
        }

        else
        {
            for (int i = 0; i < str.size(); i++)
            {
                if (str[i] == '3')
                {
                    a += 1;
                    check = true;
                    break;
                }
            }
        }

        if (check)
            continue;

        if (count == n)
            break;

        count++;
        a++;
    }

    return a;
}