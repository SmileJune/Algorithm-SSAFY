#include <stdio.h>

int main() {
  int T, a, b, aa;
  scanf("%d", &T);
  for (int i = 0; i < T; i++) {
    scanf("%d%d", &a, &b);
    a %= 10;
    b %= 4;
    aa = a;
    for (; b > -3; b--) {
      aa *= a;
      aa %= 10;
    }
    if (aa == 0)
      printf("%d\n", 10);
    else
      printf("%d\n", aa);
  }
  return 0;
}