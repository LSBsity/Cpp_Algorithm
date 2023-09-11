#include <string>
#include <vector>

using namespace std;

int solution(vector<int> arr) {
    int count = 0;
    int sign = 0;
    
    while(sign != 1)
    {
        vector<int> memo(arr.begin(), arr.end());

        for (int i = 0; i < arr.size(); i++)
        {
            if (arr[i] >= 50 && !(arr[i] & 1))
                arr[i] /= 2;
            else if (arr[i] <= 50 && arr[i] & 1)
            {
                arr[i] *= 2;
                arr[i]++;
            }
        }
        count++;
        
        for (int i = 0; i < arr.size(); i++)
        {
            if (arr[i] == memo[i])
                sign = 1;
            else
            {
                sign = 0;
                break;
            }
                
        }
    }
    

    
    return count - 1;
}