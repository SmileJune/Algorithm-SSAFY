package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2961_도영이가만든맛있는음식 {
	public static class food {
		int S;
		int B;
		public food(int s, int b) {
			S = s;
			B = b;
		}
	}
	static int N;
	static food[] arr;
	static boolean[] sel;
	static int min = Integer.MAX_VALUE;
	static List<food> list;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new food[N];
		sel = new boolean[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i] = new food(Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}
		powerset(N,0);
		System.out.println(min);
	}
	public static void powerset(int n, int k) {
		if (n == k) {
			list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (sel[i]) {
					list.add(arr[i]);
				}
			}
			if (list.size()>0) {				
				check();
			}
			return;
		}
		sel[k] = false;
		powerset(n, k+1);
		sel[k] = true;
		powerset(n, k+1);
	}
	public static void check() {
		int sumS = 1;
		int sumB = 0;
		for (int i = 0; i < list.size(); i++) {
			sumS *= list.get(i).S;
			sumB += list.get(i).B;
		}
		int result = Math.abs(sumS - sumB);
		min = Math.min(min, result);
	}
}
