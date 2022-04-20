package com.ssafy.hwang;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day72_BOJ_쉽게푸는문제 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		List<Integer> list = new ArrayList<>();
		int num = 1;
		int cnt = 0;
		for (int i = 1; i <= 1000; i++) {
			list.add(num);
			cnt++;
			if(cnt==num) {
				num++;
				cnt=0;
			}
		}
		int res = 0;
		for (int i = A-1; i < B; i++) {
			res += list.get(i);
		}
		System.out.println(res);
	}
}
