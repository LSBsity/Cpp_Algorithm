#include <iostream>
#include <map>
#include <string>

using namespace std;

int main() {
    map<int, int> map;
    long long sum = 1;

    for (int i = 0; i < 3; i++) {
        int t;
        scanf("%d", &t);
        sum *= t;
    }

    string str = to_string(sum);
    for (int i = 0; i < 9; i++) {
        map[str[i] - '0']++;
    }

    for (int i = 0; i <= 9; i++) {
        if (map[i] != 0)
            printf("%d\n", map[i]);
        else
            printf("0\n");
    }

}