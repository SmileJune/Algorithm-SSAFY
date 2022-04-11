package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_3289_서로소집합 {
	static int n, m;
	static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n+1];
			for (int i = 1; i <= n; i++) {
				arr[i] = i;
			}
			sb.append("#" + tc + " ");
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine()," ");
				switch (Integer.parseInt(st.nextToken())) {
				case 0 :
					unionSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
					break;
				case 1 :
					if (findSet(Integer.parseInt(st.nextToken())) == findSet(Integer.parseInt(st.nextToken()))) {
						sb.append(1);
					} else sb.append(0);
					break;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
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
