#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int psum[100001];
int n, k, tmp, ret = -1000000;

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);

    cin >> n >> k;

    for (int i = 1; i <= n; i++)
    {
        cin >> tmp;
        psum[i] = psum[i - 1] + tmp;
    }
        
    for (int i = k; i <= n; i++)
    {
        ret = max(ret, psum[i] - psum[i - k]);
    }
    
    cout << ret;
}