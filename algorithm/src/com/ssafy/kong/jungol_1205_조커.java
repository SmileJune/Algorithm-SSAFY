package com.ssafy.kong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class jungol_1205_조커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] card = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int zeroCnt = 0;
		int K = -1; // 카운트 배열을 만들기 위해 최댓값을 구한다.
		int M = 1000001; // 최솟값이 너무 크면 불필요한 계산이 많아질수도 있으니까...
		for (int i = 0; i < n; ++i) {
			card[i] = Integer.parseInt(st.nextToken());
			if (K < card[i]) {
				K = card[i];
			}
			if (M > card[i]) {
				M = card[i];
			}
			if (card[i] == 0)
				zeroCnt++; // 0의 갯수를 세어준다.
		}
		Arrays.sort(card);
		int[] count = new int[K + 1];
		for (int i = zeroCnt; i < n; ++i) {
			count[card[i]]++; // 카운트배열을 만들어준다.
		}
//		for (int i = 1; i < K + 1; ++i) {
//			System.out.print(count[i] + " ");
//		}
//		System.out.println();
		
		
		int maxL = 0;
		if( K == 0 ) { 	//최댓값이 0인 경우. 
			maxL = zeroCnt;
		}
		for (int i = M; i < K+1; ++i) {
			int length = 0;
			int tmp = zeroCnt;
			if (count[i] >= 1) {
				length++;
				for (int j = i + 1; j < K + 1; ++j) {
					if (count[j] >= 1) {
						length++;
					} else if (count[j] == 0 && tmp > 0) {
						tmp--;
						length++;
					} else if (tmp == 0) {
						break;
					}
				}
				length += tmp;
				if (length <= n) {
					maxL = Math.max(maxL, length);
				}
			}
		}
		
		System.out.println(maxL);
	}
}