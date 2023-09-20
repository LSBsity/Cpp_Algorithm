#include <stdio.h>

int main()
{
    long long a, b, c;
    long long sum = 0;
    scanf("%llu %llu %llu", &a, &b, &c);
    sum = a + b + c;
    printf("%llu", sum);
}