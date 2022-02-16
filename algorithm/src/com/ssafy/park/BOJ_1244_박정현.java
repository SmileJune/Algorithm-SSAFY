package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244_박정현 {
	static boolean[] bo;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int no = Integer.parseInt(br.readLine());
		bo = new boolean[no+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for (int i = 1; i <= no; i++) {
			if (Integer.parseInt(st.nextToken()) == 1) {
				bo[i] = true;
			}
		}
		int num = Integer.parseInt(br.readLine());
		for (int i = 0; i < num ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			if (Integer.parseInt(st.nextToken()) == 1) {
				man(Integer.parseInt(st.nextToken()));
			} else women(Integer.parseInt(st.nextToken()));
		}
		for (int i = 1; i <= no; i++) {
			if (i > 20 && i % 20 == 1) sb.append("\n");
			if (bo[i] == true) sb.append("1" + " ");
			else sb.append("0" + " ");
		}
		System.out.println(sb);
	}
	
	public static void man(int n) {
		for (int i = n; i <bo.length; i+=n) {
			if (bo[i]) bo[i] = false;
			else bo[i] = true;
		}
	}
	
	public static void women(int n) {
		if (bo[n]) bo[n] = false;
		else bo[n] = true;
		int idx1 = n-1;
		int idx2 = n+1;
		
		while (idx1 >0 && idx2<bo.length) {
			if (bo[idx1] == bo[idx2]) {
				if (bo[idx1]) bo[idx1] = false;
				else bo[idx1] = true;
				bo[idx2] = bo[idx1];
				idx1--;
				idx2++;
			} else break;
		}
	}
}
