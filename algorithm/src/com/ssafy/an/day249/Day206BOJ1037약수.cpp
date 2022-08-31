#include <stdio.h>

int main() {
  int N;
  int n[50] = {0};
  int max = 0;
  int min = 1000000;
  scanf("%d", &N);
  for (int i = 0; i < N; i++) {
    scanf("%d", &n[i]);
    min = (min < n[i]) ? min : n[i];
    max = (max > n[i]) ? max : n[i];
  }
  printf("%d", max * min);
  return 0;
}