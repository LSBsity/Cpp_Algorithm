#include <string>
#include <vector>

using namespace std;

int solution(int num, int k)
{
    string str;

    str = to_string(num);

    for (int i = 0; i < str.length(); i++)
        if (str[i] == k + 48)
            return i + 1;

    return -1;
}