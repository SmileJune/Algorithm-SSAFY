package com.ssafy.park;

public class BOJ_4673_셀프넘버 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		boolean[] bo = new boolean[10001];
		for (int i = 1; i < bo.length; i++) {
			if (bo[i]) continue;
			int temp = i + cal(i);
			while (true) {				
				if (temp < bo.length) {
					bo[temp] = true;
				} else break;
				temp = temp + cal(temp);
			}
		}
		for (int i = 1; i < bo.length; i++) {
			if (!bo[i]) {
				sb.append(i + "\n");
			}
		}
		System.out.println(sb);
	}
	public static int cal(int num) {
		int sum = 0;
		while (true) {
			sum += num % 10;
			num /= 10;
			if (num == 0) break;
		}
		return sum;
	}
}
