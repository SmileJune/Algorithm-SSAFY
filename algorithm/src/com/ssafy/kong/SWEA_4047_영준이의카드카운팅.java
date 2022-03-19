package com.ssafy.kong;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Card {
	int num;
	char shape;

	public Card(char shape, int num) {
		this.shape = shape;
		this.num = num;
	}
}

class Deck {
	char shape;
	int num;

	public Deck(char shape, int num) {
		this.shape = shape;
		this.num = num;
	}

}

public class SWEA_4047_영준이의카드카운팅 {
	static int n;
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ");
			String str = br.readLine();
			int len = str.length();
			n = len / 3;
			Card[] card = new Card[n];
			for (int i = 0; i < n; ++i) {
				char shape = str.charAt(3 * i);
				int n1 = (str.charAt(3 * i + 1) - '0') * 10;
				int n2 = str.charAt(3 * i + 2) - '0';
				card[i] = new Card(shape, (n1 + n2));
			}
//			for (int i = 0; i < n; ++i) {
//				System.out.print(card[i].num + " ");
//			}
//			System.out.println();
			Deck[] deck = new Deck[4];
			for (int i = 0; i < 4; ++i) {
				deck[i] = new Deck("SDHC".charAt(i), 13);
			}

			deck = solution(card, deck);

			if (flag) {
				for (int i = 0; i < 4; ++i) {
					sb.append(deck[i].num).append(" ");
				}
			} else {
				sb.append("ERROR");
			}
			System.out.println(sb);
		}
	}

	static Deck[] solution(Card[] card, Deck[] deck) {
		flag = true;
		outer: for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				if (card[j].shape == card[i].shape && card[i].num == card[j].num) {
					flag = false;
					break outer;
				}
			}
			for(int k = 0; k < 4; ++k) {
				if(deck[k].shape == card[i].shape)
					deck[k].num--;
			}
		}
		return deck;
	}
}