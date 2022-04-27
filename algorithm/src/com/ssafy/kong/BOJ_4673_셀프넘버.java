package com.ssafy.BOJ_SB;

public class BOJ_4673_셀프넘버 {
	static boolean[] num;

	public static void main(String[] args) {
		num = new boolean[10001];
		for (int i = 1; i <= 10000; ++i) {
			if(!num[i]) {
				d(i);
			}
		}
		for (int i = 1; i <= 10000; ++i) {
			if (!num[i]) {
				System.out.println(i);
			}
		}
	}

	static void d(int n) {
		if (n > 10000) {
			return;
		}
		int tmp = n;
		int sum = 0;
		while (tmp > 0) {
			sum += tmp % 10;
			tmp /= 10;
		}
		if (sum + n > 10000) {
			return;
		}
		num[sum + n] = true;
		d(sum + n);
	}
}
