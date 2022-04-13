package com.ssafy.BOJ_BZ;

public class BOJ_4673_셀프넘버 {
    public static void main(String[] args) {
        int[] selfNumbers = new int[10000];
        for (int i = 1; i < 10000; i++) {
            selfNumbers[generator(i)]++;
        }

        for (int i = 1; i < selfNumbers.length; i++) {
            if (selfNumbers[i] == 0) {
                System.out.println(i);
            }
        }
    }

    public static int generator(int n) {
        int sum = n;

        while (n != 0) {
            sum += n % 10;
            n /= 10;

            if (sum > 9999) {
                return 0;
            }
        }

        return sum;
    }
}