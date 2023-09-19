#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;


int euclid(int a, int b)
{
    if (a % b == 0)
        return b;
    return euclid(b, a % b);
}


int main()
{
    int a;
    cin >> a;

    vector<int> v(a);

    for (int i = 0; i < a; i++)
        cin >> v[i];

    int b = v[0];

    for (int i = 1; i < a; i++)
    {
        int gcd = euclid(b, v[i]);

        cout << b / gcd << "/" << v[i] / gcd << "\n";
    }
    
    

}