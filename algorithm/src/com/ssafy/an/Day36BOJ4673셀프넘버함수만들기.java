package com.ssafy.an;

public class Day36BOJ4673셀프넘버함수만들기 { // 4673 셀프 넘버
	public static void main(String[] args) {
		boolean[] d = new boolean[10001];
		for (int i = 1; i <= 10000; i++)
			if (d(i) < 10001)
				d[d(i)] = true;
		for (int i = 1; i <= 10000; i++) 
			if (!d[i])
				System.out.println(i);
	}

	private static int d(int n) {
		int sum = n;
		while (n != 0) {
			sum += (n % 10);
			n /= 10;
		}
		return sum;
	}
}
