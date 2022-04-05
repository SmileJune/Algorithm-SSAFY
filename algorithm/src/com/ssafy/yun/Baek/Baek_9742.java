package com.ssafy.yun.Baek;

import java.util.Scanner;

public class Baek_9742 {

	static Scanner sc = new Scanner(System.in);
	static char[] arr;
	static int order;
	static StringBuffer sb;
	static int n, flag;

	public static void main(String[] args) {
		if (sc.hasNext()) {
			solution();
		}
	}

	static void solution() {
		sb = new StringBuffer();
		arr = sc.next().toCharArray();
		n = arr.length;
		flag = 0;
		order = sc.nextInt();

	}

	static void perm(int idx) {
		if (n == idx) {
			flag++;
			if(flag==order) {
				sb.append()
			}
		}
	}

}
