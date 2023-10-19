#include <iostream>

using namespace std;

int main() {
    int z, k;
    cin >> z;
    for (int i = 0; i < z; i++) {
        for (int j = z - i; j > 0; j--)
            printf("*");
        printf("\n");
    }
}