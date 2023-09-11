#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(int n)
{
    vector<int> answer;

    int prime = 0;
    int i = 2;
    while (n != 1)
    {
        if (n % i == 0)
        {
            prime = i;
            answer.push_back(i);
            n = n / i;
            i = 2;
        }
        else if (n % i != 0)
            i++;
        else
        {
            answer.push_back(n);
        }
    }

    answer.erase(unique(answer.begin(), answer.end()), answer.end());
    sort(answer.begin(), answer.end());

    return answer;
}