#include <stdio.h>

int arr[1000001];
int n, s, sum;

void solve(int a, int b, int c) {
  if (a == n) {
    if (b == s && c > 0)
      sum++;
    return;
  }
  solve(a + 1, b, c);
  solve(a + 1, b + arr[a], c + 1);
}

int main(void) {
  scanf("%d %d", &n, &s);
  for (int i = 0; i < n; i++)
    scanf("%d", &arr[i]);

  solve(0, 0, 0);
  printf("%d\n", sum);
  return 0;
}
