package com.ssafy.park;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1377_버블소트 {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		A[] arr = new A[n];

		for (int i = 0; i < n; i++) {
			arr[i] = new A();
			arr[i].value = Integer.parseInt(reader.readLine());
			arr[i].index = i;
		}
		Arrays.sort(arr);

		int max = 0;
		for (int i = 0; i < n; i++) {
			if (max < arr[i].index - i)
				max = arr[i].index - i;
		}

		System.out.println(max + 1);
	}
}

class A implements Comparable<A> {
	int value;
	int index;

	@Override
	public int compareTo(A o) {
		return this.value - o.value;
	}
}
