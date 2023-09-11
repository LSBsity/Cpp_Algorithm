#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> arr) {
    vector<int> stk;
    int i = 0;
    while(i < arr.size())
    {
        if (!stk.size())
        {
            stk.push_back(arr[i]);
            i++;
        }
        else if (stk.size() && stk.back() == arr[i])
        {
            stk.pop_back();
            i++;
        }
        else if (stk.size() && stk.back() != arr[i])
        {
            stk.push_back(arr[i]);
            i++;
        }
    }
    
    return stk.size() ? stk : vector<int> (1, -1);
}