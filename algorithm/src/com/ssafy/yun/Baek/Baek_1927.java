
package com.ssafy.yun.Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek_1927 {

	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	public static PriorityQueue<Integer> q;

	public static void main(String[] args) throws NumberFormatException, IOException {
		q = new PriorityQueue<>();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			solution();
		}
	}
	static void solution() throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		
		if(n==0) {
			if(q.isEmpty()) {
				System.out.println(0);
				return;
			}
			
			System.out.println(q.poll());
			return;
		}
		
		q.add(n);
	}
}
