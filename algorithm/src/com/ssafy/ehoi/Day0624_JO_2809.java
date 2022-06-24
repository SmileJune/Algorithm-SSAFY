package com.ssafy.ehoi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Day0624_JO_2809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Integer> list = new ArrayList<>();

		for (int i = 1; i * i <= N; i++) {
			if (N % i == 0) {
				list.add(i); // 나로 나뉘어지면 약수니까 나도 넣고
				if (N / i != i) {
					list.add(N / i); // 나랑 짝도 넣고 근데 N이 36이라서 내가 6인데 내 짝은 없는데 또 들어가면 안되니까 내가 아닐 때만 들어가게 조건 걸기
				}
			}
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		sc.close();
	}
}
