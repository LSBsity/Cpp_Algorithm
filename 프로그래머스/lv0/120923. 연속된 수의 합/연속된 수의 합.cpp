#include <string>
#include <vector>

using namespace std;

vector<int> solution(int num, int total)
{
    vector<int> answer;
    int a = 0;
    int sum2 = 0;
    int count = -100;
    while (1)
    {   
        vector<int> temp;
        int sum = 0;
        a = count;
        for (int i = 0; i < num; i++)
        {
            sum = sum + a;
            temp.push_back(a);
            a++;
        }
        if (sum == total)
        {
            sum2 = sum;
            answer = temp;
            break;
        }
        count++;
    }

    return answer;
}