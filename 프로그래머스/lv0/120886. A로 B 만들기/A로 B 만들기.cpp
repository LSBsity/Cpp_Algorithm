#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(string before, string after)
{
    sort(before.begin(), before.end());
    sort(after.begin(), after.end());

    if (before.length() == after.length() && before == after)
        return 1;
    else
        return 0;



    return -1;
}