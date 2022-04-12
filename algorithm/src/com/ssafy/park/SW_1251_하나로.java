package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SW_1251_하나로 {

	static int[] arrx;
	static int[] arry;
	static double E;
	static List<double[]> list;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			arrx = new int[N + 1];
			arry = new int[N + 1];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				arrx[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 1; i <= N; i++) {
				arry[i] = Integer.parseInt(st.nextToken());
			}

			E = Double.parseDouble(br.readLine());
			list = new ArrayList<>();
			for (int i = 1; i <= N - 1; i++) {
				for (int j = i + 1; j <= N; j++) {
					double[] temp = new double[3];
					temp[0] = i;
					temp[1] = j;
					temp[2] = dif(arrx[i], arrx[j], arry[i], arry[j]);
					list.add(temp);
				}
			}
			Collections.sort(list, new Comparator<double[]>() {
				@Override
				public int compare(double[] o1, double[] o2) {
					if (o1[2] > o2[2]) {
						return 1;
					} else if (o1[2] < o2[2]) {
						return -1;
					}
					return 0;
				}
			});
			parent = new int[N + 1];
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}
			int cnt = 0;
			double ans = 0;
			for (int i = 0; i < list.size(); i++) {
				int a = (int) list.get(i)[0];
				int b = (int) list.get(i)[1];
				if (findSet(a) == findSet(b))
					continue;
				unionSet(a, b);
				cnt++;
				ans += list.get(i)[2];

				if (cnt == N - 1)
					break;
			}
			System.out.format("#%d %.0f\n", tc, ans);
		}
	}

	public static double dif(int x1, int x2, int y1, int y2) {
		return E * ((Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2)));
	}

	public static int findSet(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = findSet(parent[x]);
	}

	public static void unionSet(int x, int y) {
		int dx = findSet(x);
		int dy = findSet(y);
		parent[dy] = dx;
	}
}
