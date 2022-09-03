#include <stdio.h>

int a[11];
int main() {
  int n;
  scanf("%d", &n);
  for (int i = 0; i < n; i++) {
    int b, flag = 0, w = -1;
    scanf("%d", &b);
    while (flag != b) {
      w++;
      if (a[w] == 0)
        flag++;
    }
    w++;
    while (a[w] != 0)
      w++;
    a[w] = i + 1;
  }
  for (int i = 0; i < n; i++)
    printf("%d ", a[i]);
}