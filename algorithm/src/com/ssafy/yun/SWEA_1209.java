package com.ssafy.yun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1209 {

	public static int[][] arr;
	public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		for (int tc = 1; tc <= 10; tc++) {
			System.out.printf("#%d %d%n", tc, solution());
		}

	}

	public static int solution() throws IOException {
		br.readLine();
		int max = 0;
		arr = new int[100][100];
		for (int i = 0; i < arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//가로 합
		for(int i=0; i<arr.length; i++) {
			max = Math.max(max, rowSum(i));
		}
		//세로 합
		for(int i=0; i<arr[0].length; i++) {
			max = Math.max(max, columnSum(i));
		}
		
		//대각합
		int sum=0;
		for(int i=0, j=0; i<arr.length ; i++) {
			sum+=arr[i][j];
		}
		max = Math.max(max, sum);
		sum=0;
		
		for(int i=arr.length-1, j=0; i>=0; i--, j++) {
			sum+=arr[i][j];
		}
		max = Math.max(max, sum);

		return max;
	}

	public static int rowSum(int i) {
		int sum = 0;
		for (int j = 0; j < arr[0].length; j++) {
			sum += arr[i][j];
		}
		return sum;
	}

	public static int columnSum(int i) {
		int sum = 0;
		for (int j = 0; j < arr[0].length; j++) {
			sum += arr[j][i];
		}
		return sum;
	}

}
