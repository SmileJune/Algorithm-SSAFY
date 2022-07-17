package com.ssafy.an.day199;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Day161BOJ11758신발끈 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int y1 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int z1 = Integer.parseInt(st.nextToken());
		int z2 = Integer.parseInt(st.nextToken());
		int m1 = y1 - x1;
		int n1 = y2 - x2;
		int m2 = z1 - x1;
		int n2 = z2 - x2;
		int temp = m1 * n2 - n1 * m2;
		if (temp > 0)
			System.out.println(1);
		else if (temp == 0)
			System.out.println(0);
		else
			System.out.println(-1);
		br.close();
	}

}
