#include <iostream>

using namespace std;

int n, m;
int map[100001];
int dp[100001];

int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0);
    cout.tie(0);
    cin >> n >> m;

    for (int i = 1; i <= n; i++)
    {
        int a;
        cin >> a;
        map[i] = a;
        dp[i] = a + dp[i - 1];
    }
    while (m--)
    {
        int a, b;
        cin >> a >> b;
        cout << dp[b] - dp[a - 1] << '\n';
    }
}