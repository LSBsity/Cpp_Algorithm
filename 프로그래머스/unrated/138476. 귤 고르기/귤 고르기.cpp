#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(int a, int b)
{
    return a > b; 
}
int solution(int k, vector<int> tangerine) {
    int answer = 0;
    int arr[10000001] = {0,};
    
    for (int i = 0; i < tangerine.size(); i++)
        arr[tangerine[i]]++;

    sort(arr, arr + 10000001, compare);
        
    for (int i = 0; i < 10000001; i++)
    {
        answer += arr[i];
        if (answer >= k)
            return i + 1;
    }
}
