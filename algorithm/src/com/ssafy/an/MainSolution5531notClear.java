package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MainSolution5531notClear { // 4년전 문제인데, 자바로 맞은사람이 없는 문제... 1/3이 시간초과...나도...
	public static void main(String[] args) throws Exception{ // 5531 버블 정렬
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine()); 
		}
//		int cnt = bubble_sort(arr, N);
//		System.out.println("정렬된 배열 : " + Arrays.toString(arr) + " 변경된 횟수 : " + cnt);
		System.out.println(minSwapCntArr(arr, N));
		br.close();
	}

	public static int bubble_sort(int[] arr, int n) {
		int i, j;
		int result = 0;
		for (i = 0; i < n - 1; ++i) {
			for (j = 0; j < n - 1; ++j) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					result++;
				}
			}
		}
		return result;
	}

	public static int minSwapCntArr(int[] arr, int n) {
		int[] minArr = arr.clone();
		int minCnt = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
//				System.out.println(Arrays.toString(minArr));
				int temp = minArr[j];
				minArr[j] = minArr[i];
				minArr[i] = temp;
				int cNum = bubble_sort(minArr, n);
//				System.out.println(j + "번 " + cNum + " " + minCnt);
				if (minCnt > cNum) {
					minCnt = cNum;
				}
//				System.out.println(Arrays.toString(minArr));
				minArr = arr.clone();
			}
		}
		return minCnt;
	}
}