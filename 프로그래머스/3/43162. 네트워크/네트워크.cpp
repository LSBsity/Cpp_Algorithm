#include <string>
#include <vector>
using namespace std;

int parent[201];
int getParent(int parent[], int x) {
    if (parent[x] == x) return x;
    return parent[x] = getParent(parent, parent[x]);
}

void unionParent(int parent[], int a, int b) {
    a = getParent(parent, a);
    b = getParent(parent, b);
    if (a < b)
        parent[b] = a;
    else
        parent[a] = b;
}

int findParent(int parent[], int a, int b) {
    return (getParent(parent, a) == getParent(parent, b));
}

int solution(int n, vector<vector<int>> v) {
    int answer = 0;
    for (int i = 0; i <= n; i++) parent[i] = i;

    for (int i = 0; i < v.size(); i++)
        for (int j = 0; j < v[0].size(); j++)
            for (int k = 0; k < v[0].size(); k++)
                if (v[i][j] == 1 && v[j][k] == 1 && !findParent(parent, j, k))
                    unionParent(parent, j, k);

    for (int i = 0; i < n; i++) 
        if (parent[i] == i)
            answer++;

    return answer;
}