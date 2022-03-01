package com.ssafy.namja;

import java.util.Scanner;

public class JO_1205_박성현 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] cards = new int[N];
		int max = 0, min = Integer.MAX_VALUE;
		int cnt_zero = 0;
		for (int i = 0; i < cards.length; i++) {
			cards[i] = sc.nextInt();
			max = Math.max(max, cards[i]);
			if (cards[i] != 0)
				min = Math.min(min, cards[i]);
			else if (cards[i] == 0)
				cnt_zero++;
		}
		if (max == 0)
			min = 0;

		int[] numCard = new int[max + 1 + cnt_zero];
		for (int i = 0; i < cards.length; i++) {
			if (cards[i] != 0)
				numCard[cards[i]]++;
		}
		int max_length = 0;
		for (int i = (min - cnt_zero >= 0 ? min - cnt_zero : 0); i < numCard.length; i++) {
			int zero = cnt_zero;
			int idx = i;
			int length = 0;
			while (true) {
				if (idx == numCard.length)
					break;
				if (numCard[idx] == 0)
					zero--;
				if (zero < 0)
					break;
				idx++;
				length++;
			}
			max_length = Math.max(max_length, length);
		}

		System.out.println(max_length);
	}
}
