package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_14696_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int no = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= no; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int[] arra = new int[a];
			for (int i = 0; i < a; i++) {
				arra[i] = Integer.parseInt(st.nextToken());
			}
			arra = sort(arra);
			st = new StringTokenizer(br.readLine()," ");
			int b = Integer.parseInt(st.nextToken());
			int[] arrb = new int[b];
			for ( int i = 0; i < b; i++) {
				arrb[i] = Integer.parseInt(st.nextToken());
			}
			arrb = sort(arrb);
			int min = Math.min(arra.length, arrb.length);
			boolean bo = false;
			for (int i = 0; i < min; i++) {
				if ( arra[i] > arrb[i]) {
					sb.append("A"+"\n");
					bo = true;
					break;
				}
				else if ( arra[i] < arrb[i]) {
					sb.append("B" + "\n");
					bo = true;
					break;
				}
			}
			if (!bo) {
				if (arra.length > arrb.length) sb.append("A" + "\n");
				else if ( arra.length < arrb.length) sb.append("B" + "\n");
				else sb.append("D" + "\n");
			}
		}
		System.out.println(sb);
	}
	public static int[] sort(int[] arr) {
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = i+1; j < arr.length; j++) {
				if ( arr[j] > arr[i]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}
}
