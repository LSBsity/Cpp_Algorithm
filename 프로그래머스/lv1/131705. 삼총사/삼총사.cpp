#include <string>
#include <vector>

using namespace std;

int solution(vector<int> number)
{
    int answer = 0;
    for (int i = 0; i < number.size() - 1; i++)
    {
        for (int j = i + 1; j < number.size(); j++)
        {
            int temp = number[i] + number[j];
            vector<int> temp2;
            temp2 = number;
            temp2.erase(temp2.begin() + i);
            temp2.erase(temp2.begin() + j - 1);
            for (int z = 0; z < temp2.size(); z++)
            {
                if (temp + temp2[z] == 0)
                    answer++;
            }
            
        }
    }

    return answer / 3;
}