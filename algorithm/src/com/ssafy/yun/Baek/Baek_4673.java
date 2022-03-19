package com.ssafy.yun.Baek;

public class Baek_4673 {

	public static void main(String[] args) {
		int[] arr = new int[10001];
		for (int i = 0; i <= 10000; i++) {
			int dn = getDn(i);
			if (dn > 10000) {
				continue;
			}
			arr[dn]++;
		}
		for (int i = 1; i <= 10000; i++) {
			if (arr[i] == 0) {
				System.out.println(i);
			}
		}

	}

	static int getDn(int i) {
		int num = i;
		while (true) {
			if (i == 0) {
				break;
			}
			num += i % 10;
			i /= 10;
		}
		return num;
	}

}
