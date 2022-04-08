package day0408;

import java.util.Arrays;

public class BinarySearch {
	static int[] arr = { 63, 1, 42, 6, 14, 25, 33 };
	static int ans;
	public static void main(String[] args) {
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println("api : " + Arrays.binarySearch(arr, 32));
		System.out.println("직접 구현 : " + binarySearch(32));
		ans = 0;
		recur(0, arr.length, 32);
		System.out.println("재귀로 구현 : " + ans);
	}

	private static int binarySearch(int key) {
		int res = -1;

		int s = 0;
		int e = arr.length;

		while (s < e) {
			int mid = (s + e) / 2;
			if (arr[mid] == key) {
				res = mid;
				break;
			}

			if (arr[mid] > key) {
				e = mid - 1;
			} else if (arr[mid] < key) {
				s = mid + 1;
			}
		}

		return res;
	}

	private static void recur(int s, int e, int key) {
		// base
		if(s >= e) {
			ans = -1;
			return;
		}

		// recursive
		int mid = (s + e) / 2;
		
		if (arr[mid] == key) {
			ans = mid;
			return;
		}
		
		else if (arr[mid] > key)
			recur(s, mid - 1, key);
		else
			recur(mid + 1, e, key);

	}

}
