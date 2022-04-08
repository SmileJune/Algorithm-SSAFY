package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11004_k번째수 {
	static int[] sortedArr;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		sortedArr = new int[N];
		StringTokenizer str = new StringTokenizer(br.readLine()," ");
		for (int i=0; i < N; i++) {
			arr[i] = Integer.parseInt(str.nextToken()); 
		}
		mergeSort(arr, 0, arr.length-1);
		System.out.println(arr[K-1]);
		
	}
	
	public static void merge(int[] arr, int left, int mid, int right) {
		int L = left; 
		int R = mid + 1; 
		int idx = left; 

		while (L <= mid && R <= right) {
			if (arr[L] <= arr[R]) {
				sortedArr[idx++] = arr[L++];
			} else {
				sortedArr[idx++] = arr[R++];
			}
		}
		if(L <= mid) {
			for(int i = L; i<=mid; i++) {
				sortedArr[idx++] = arr[i];
			}
		}else {
			for(int j = R; j<=right; j++) {
				sortedArr[idx++] = arr[j];
			}
		}
		
		for(int i=left;i<=right;i++) {
            arr[i] = sortedArr[i];
        }
	}

	public static void mergeSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = (left + right) / 2;
			mergeSort(arr, left, mid); 
			mergeSort(arr, mid + 1, right); 
			merge(arr, left, mid, right); 
		}
	}
}
