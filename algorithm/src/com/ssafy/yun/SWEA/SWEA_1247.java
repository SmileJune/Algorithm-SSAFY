package com.ssafy.yun.SWEA;

import java.util.Arrays;
import java.util.Scanner;

public class SWEA_1247 {

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

	}

	static Scanner sc = new Scanner(System.in);
	static Node[] data;
	static int[] arr;
	static int[] sel;
	static int n, min;

	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.printf("#%d %d\n", tc, solution());
		}
	}

	static int solution() {
		n = sc.nextInt();
		data = new Node[n+2];
		arr = new int[n];
		sel = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		data[0] = new Node(sc.nextInt(), sc.nextInt());
		data[n+1] = new Node(sc.nextInt(), sc.nextInt());
		for(int i=1; i<=n; i++) {
			data[i] = new Node(sc.nextInt(), sc.nextInt());
		}

		min = Integer.MAX_VALUE;
		perm(0, 0);

		return min;
	}

	static void perm(int sidx, int visited) {
		if(sidx == n) {
			min = Math.min(min, checkDis());
			return;
		}
		
		for(int i=0; i<n; i++) {
			if((visited & (1<<i)) > 0) continue;
			sel[sidx] = arr[i];
			perm(sidx+1, visited | (1<<i));
		}
	}
	static int checkDis() {
		int dis=0;
		//0과 첫번째
		dis += checkEachDis(data[0], data[sel[0]]);
		//첫번째부터 n번째 집
		for(int i=0; i<n-1; i++) {
			dis += checkEachDis(data[sel[i]], data[sel[i+1]]);
		}
		//n번째 집과 집
		dis += checkEachDis(data[sel[n-1]], data[n+1]);
		return dis;
	}
	static int checkEachDis(Node n1, Node n2) {
		return Math.abs(n1.x-n2.x)+Math.abs(n1.y-n2.y);
	}

}
