#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int Euclidean(int a, int b)
{
    int r = a % b;
    if (r == 0)
    {
        return b;
    }
    return Euclidean(b, r);
}
int solution(int a, int b)
{
    if (a == b)
        return 1;
    
    int A = Euclidean(a, b);
    int deno = b / A;
    vector<int> vec;
    int prime = 0;
    int i = 2;
    while (deno != 1)
    {
        if (deno % i == 0)
        {
            prime = i;
            vec.push_back(i);
            deno = deno / i;
            i = 2;
        }
        else if (deno % i != 0)
            i++;
        else
            vec.push_back(deno);
    }

    for (int i = 0; i < vec.size(); i++)
    {
        if (!(vec[i] == 2 || vec[i] == 5))
            return 2;
    }
    
    return 1;
}
