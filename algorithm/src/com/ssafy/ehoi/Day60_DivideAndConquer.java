package day0408;

import java.util.Arrays;

public class DivideAndConquer {
	static int[] arr = { 63, 1, 42, 6, 14, 25, 33 };

	public static void main(String[] args) {
		int N = arr.length;
		System.out.println(Arrays.toString(arr));
		mergeSort(0, N, N);
		System.out.println(Arrays.toString(arr));
	}

	private static void mergeSort(int s, int e, int size) {
		// base
		if (s + 1 >= e) return;
		
		// recursive
		int mid = (s + e) / 2;
		size /= 2;
		mergeSort(s, mid, size);
		mergeSort(mid, e, size);
		merge(s, mid, e);
	}
	static int[] tmp = new int[arr.length];
	private static void merge(int s, int mid, int e) {
		int l = s, r = mid, idx = s;
		
		while(l < mid && r < e) {
			if(arr[l] < arr[r]) {
				tmp[idx++] = arr[l++];
			} else {
				tmp[idx++] = arr[r++];
			}
		}
		
		// 왼쪽 포인터가 끝까지 이동하지 못했을 때
		while(l < mid) {
			tmp[idx++] = arr[l++];
		}
		// 오른쪽 포인터가 끝까지 이동하지 못했을 때
		while(r < e) {
			tmp[idx++] = arr[r++];
		}
		
		for (int i = s; i < e; i++) 
			arr[i] = tmp[i];
	}
}
