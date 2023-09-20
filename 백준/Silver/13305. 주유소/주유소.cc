#include <iostream>
#include <string>
#include <vector>
using namespace std;

int A;
int dist[100001];  // 도시 간 거리
int price[100001]; // 도시의 기름값

int main()
{
    int answer = 0;
    int min_price = 1000000000;
    int last_dist = 0;
    cin >> A;
    for (int i = 0; i < A - 1; i++)
    {
        scanf("%d", &dist[i]);
        last_dist += dist[i];
    }
    for (int i = 0; i < A; i++)
    {
        scanf("%d", &price[i]);
        if (min_price > price[i] && i != A - 1)
            min_price = price[i];
    }

    for (int i = 0; i < A - 1; i++)
    {
        if (price[i] > price[i + 1]) // 현재 주유소가 다음 주유소보다 비싸면
        {
            answer += price[i] * dist[i]; // 총 비용에 다음 주유소까지 갈 최소한의 기름을 넣어줌
            last_dist -= dist[i];
        }
        else if (price[i] == min_price) // 현재 주유소의 기름값이 최저값이라면
        {
            answer += price[i] * last_dist; // 끝까지 갈 기름을 넣어줌
            break;
        }
        else if (price[i] == price[i + 1]) // 현재 주유소의 기름값이 다음 주유소의 값과 같다면
        {
            answer += price[i] * (dist[i] + dist[i + 1]); // 총 비용에 다다음 주유소까지 갈 최소한의 기름을 넣어줌
            last_dist -= dist[i] + dist[i + 1];
        }
    }
    cout << answer;

    return 0;
}