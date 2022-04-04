package com.ssafy.yun;

import java.util.Arrays;

public class Permutation3 {
	static int[] arr, sel;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) {
		n = 6;
		arr = new int[] { 1, 2, 3, 4, 5, 6 };
		sel = new int[n];
		visited = new boolean[n];

		perm(0);
	}
	static void perm(int idx) {
		if(idx==n) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(visited[i]) {
				continue;
			}
			sel[idx] = arr[i];
			visited[i] = true;
			perm(idx+1);
			visited[i] = false;
			
		}
	}
}
