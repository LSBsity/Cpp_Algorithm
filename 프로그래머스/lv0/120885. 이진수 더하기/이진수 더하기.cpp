#include <string>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

string solution(string arr1, string arr2)
{
    string answer = "";
    if (arr1 == "0" && arr2 == "0")
    {
        answer.append("0");
        return answer;
    }
    reverse(arr1.begin(), arr1.end());
    reverse(arr2.begin(), arr2.end());
    int arr1Sum = 0;
    int arr2Sum = 0;
    for (int i = 0; i < arr1.length(); i++)
    {
        if (i == 0 && arr1[i] == '1')
            arr1Sum += 1;
        if (i >= 1)
        {
            if (arr1[i] == '1')
                arr1Sum += pow(2, i);
        }
    }
    for (int i = 0; i < arr2.length(); i++)
    {
        if (i == 0 && arr2[i] == '1')
            arr2Sum += 1;
        if (i >= 1)
        {
            if (arr2[i] == '1')
                arr2Sum += pow(2, i);
        }
    }
    int total = arr1Sum + arr2Sum;

    while (total >= 1)
    {
        answer.append(to_string(total % 2));
        total = total / 2;
    }

    reverse(answer.begin(), answer.end());

    return answer;
}