package com.ssafy.an.day199;

import java.util.Scanner;

public class Day176BOJ1019t수 {
	static int st, ed, digit;
	static int[] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		digit = 1;
		st = 1;
		ed = sc.nextInt();

		cnt = new int[10];

		while (st <= ed) {
			while (st % 10 != 0 && st <= ed) {
				counting(st, digit);
				st++;
			}

			while (ed % 10 != 9 && st <= ed) {
				counting(ed, digit);
				ed--;
			}

			if (st > ed)
				break;

			st /= 10;
			ed /= 10;

			for (int i = 0; i < 10; ++i) {
				cnt[i] += (ed - st + 1) * digit;
			}

			digit *= 10;
		}

		for (long i : cnt) {
			System.out.print(i + " ");
		}
	}

	private static void counting(int num, int digit) {
		while (num > 0) {
			cnt[num % 10] += digit;
			num /= 10;
		}
	}
}
