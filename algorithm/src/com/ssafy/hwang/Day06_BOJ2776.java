package com.ssafy.hwang;
/*
 * [BOJ2776 암기왕 S4]
 * 이분탐색문제
 * 
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Day06_BOJ2776 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < T; tc++) {

			int n1 = Integer.parseInt(br.readLine());
			int[] arr1 = new int[n1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n1; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
				
			}
			Arrays.sort(arr1);
			int n2 = Integer.parseInt(br.readLine());
			int[] arr2 = new int[n2];
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for (int i = 0; i < n2; i++) {
				arr2[i] = Integer.parseInt(st1.nextToken());
			}

			for(int i =0;i<n2;i++) {
				bw.write(BSearch(arr1,arr2[i])+"\n");
			}
		}
		bw.close();
	}

	static int BSearch(int arr[], int target) {
		int low = 0;
		int high = arr.length - 1;
		int mid;

		while (low <= high) {
			mid = (low + high) / 2;

			if (arr[mid] == target)
				return 1;
			else if (arr[mid] > target)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return 0;
	}
}
