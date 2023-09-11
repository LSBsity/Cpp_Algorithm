#include <string>
#include <vector>
#include <algorithm>
#include <cmath>
using namespace std;

int solution(int n)
{
    int answer = 0;
    string a = "";
    while (n >= 3)
    {
        a.append(to_string(n % 3));
        n = n / 3;
    }
    if (n == 1)
        a.append(to_string(n));
    else if (n == 2)
        a.append(to_string(n));

    reverse(a.begin(), a.end());

    if (a[0] == '1')
        answer += 1;
    else if (a[0] == '2')
        answer += 2;
    
    
    for (int i = 1; i < a.length(); i++)
    {
        if (a[i] == '1')
            answer += 1 * pow(3, i);
        else if (a[i] == '2')
            answer += 2 * pow(3, i);
    }

    return answer;
}