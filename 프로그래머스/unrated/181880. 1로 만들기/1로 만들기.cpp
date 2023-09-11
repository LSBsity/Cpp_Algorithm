#include <string>
#include <vector>

using namespace std;

int solution(vector<int> num_list) {
    int count = 0;
    
    for (int i = 0; i < num_list.size(); i++)
    {
        while(num_list[i] != 1)
        {
            if (num_list[i] % 2)
            {
                num_list[i] -= 1;
                num_list[i] /= 2;
            }
            else
                num_list[i] /= 2;
            count++;
        }
    }
    
    return count;
}