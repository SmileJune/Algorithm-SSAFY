package com.ssafy.park;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SW_7465_창용마을무리의개수 {
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc =1 ; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			arr = new int[N+1];
			for (int i = 1; i <= N; i++) {
				arr[i] = i;
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine()," ");
				unionSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			int cnt = 0;
			for (int i = 1; i < arr.length; i++) {
				if (arr[i] == i) {
					cnt++;
				}
			}
			bw.append("#" + tc + " " + cnt + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
	private static void unionSet(int x, int y) {
		int px = findSet(x);
		int py = findSet(y);
		arr[py] = px;
		
	}
	private static int findSet(int x) {
		if (x== arr[x]) return x;
		return arr[x] = findSet(arr[x]);
	}
}
