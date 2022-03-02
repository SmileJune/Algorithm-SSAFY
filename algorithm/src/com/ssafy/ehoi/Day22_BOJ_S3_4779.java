package com.ssafy.ehoi;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Day22_BOJ_S3_4779 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while (sc.hasNextInt()) {
			int N = sc.nextInt();
			int len = 1;
			for (int i = 0; i < N; i++) {
				len = len * 3;
			}
//		double len = Math.pow(3, N); // pow는 double을 주는구나
			char[] ch = new char[len];
			for (int i = 0; i < ch.length; i++) {
				ch[i] = '-';
			}

			remove(0, len, ch);

			for (int i = 0; i < ch.length; i++) {
				bw.append(ch[i]);
			}
			bw.append('\n').flush();
		}

		sc.close();
	}

	public static void remove(int s, int e, char[] arr) {
		if (s + 1 == e)
			return;

		int a = s + ((e - s) / 3);
		int b = a + ((e - s) / 3);
		for (int i = a; i < b; i++) {
			arr[i] = ' ';
		}
		remove(s, a, arr);
		remove(b, e, arr);

	}
}
