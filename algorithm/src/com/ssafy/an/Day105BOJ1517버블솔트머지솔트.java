package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day105BOJ1517버블솔트머지솔트 { // 1517 제목은 버블솔트인데, 버블솔트 쓰면 안됨.
	static int N;
	static long ans;
	static long[] arr, tmp;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		arr = new long[N];
		tmp = new long[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		divide(0, N - 1);
		System.out.println(ans);
		br.close();
	}

	static void divide(int st, int ed) {
		if (st < ed) {
			int mid = (st + ed) / 2;

			divide(st, mid);
			divide(mid + 1, ed);

			merge(st, mid, ed);
		}
	}

	static void merge(int st, int mid, int ed) {
		int i = st, j = mid + 1, idx = st;

		while (i < mid + 1 && j < ed + 1)
			if (arr[i] <= arr[j])
				tmp[idx++] = arr[i++];
			else {
				tmp[idx++] = arr[j++];
				ans += (mid + 1 - i);
			}

		while (i < mid + 1)
			tmp[idx++] = arr[i++];

		while (j < ed + 1)
			tmp[idx++] = arr[j++];

		for (int n = st; n < ed + 1; n++)
			arr[n] = tmp[n];

	}
}
