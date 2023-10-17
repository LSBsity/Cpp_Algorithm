#include <string>
#include <vector>

using namespace std;

int euclid(int a, int b)
{
    if (a % b == 0) return b;

    return euclid(b, a % b);
}
int lcm(int a, int b)
{
    return a * b / euclid(a, b);
}
int solution(vector<int> arr)
{
    int a = lcm(arr[0], arr[1]);
    
    for (int i = 2; i < arr.size(); i++)
        a = lcm(a, arr[i]);
    
    return a;
}