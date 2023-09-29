#include <iostream>
#include <math.h>

int main() {
    int sum = 0;
    for (int i = 0; i < 5; i++) {
        int t;
        scanf("%d", &t);
        sum += pow(t, 2);
    }
    printf("%d ", sum % 10);
}