package com.ssafy.an;

import java.util.Scanner;

public class Day3MainSolution11399 { // 11399 ATM
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int num = sc.nextInt();
		int[] arr = new int[num];
		for (int i = 0; i < num; i++) {
			arr[i] = sc.nextInt();
		}
		sc.nextLine();

		for (int i = num - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j + 1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		} // bubble, tc가 온화해서 n^2복잡도로도 가능

		int sum = 0;
		for (int i = 0; i < num; i++) {
			sum += (arr[i] * (num - i)); // 가장 시간이 짧은 사람이 여러번 겹쳐져야 한다.
		}
		System.out.println(sum);
		sc.close();
	}
}
