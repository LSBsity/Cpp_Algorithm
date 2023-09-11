#include <string>
#include <cmath>
#include <vector>
#include <numeric>

using namespace std;

int solution(string s)
{
    int answer = 0;
    int count = 0;
    int temp = 0;
    vector<int> arr(3, 0);

    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] >= '0' && s[i] <= '9')
        {
            temp += s[i] - '0';
            if (s[i + 1] == '0') temp += '9' - '0';
        }
        if (s[i] == 'S')
        {
            temp = pow(temp, 1);
            arr[count] = temp;
        }
        else if (s[i] == 'D')
        {
            temp = pow(temp, 2);
            arr[count] = temp;
        }
        else if (s[i] == 'T')
        {
            temp = pow(temp, 3);
            arr[count] = temp;
        }
        if (s[i] == '*')
        {
            arr[count - 1] *= 2;
            arr[count - 2] *= 2;
        }
        else if (s[i] == '#')
        {
            arr[count - 1] *= -1;
        }

        if (s[i] >= 65 && s[i] <= 90)
        {
            count++;
            temp = 0;
        }
    }
    answer = accumulate(arr.begin(), arr.end(), 0);
    return answer;
}