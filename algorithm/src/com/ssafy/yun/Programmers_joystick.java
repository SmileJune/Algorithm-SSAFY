package com.ssafy.yun;

public class Programmers_joystick {
	boolean[] visited;
	char[] arr;
	int sum = 0;

	public int solution(String name) {
		visited = new boolean[name.length()];
		arr = name.toCharArray();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'A') {
				visited[i] = true;
			}
		}

		if (visited[0] == false) {
			sum += check(arr[0]);
		}
		int pivot = 0;

		outer: while (true) {
			int cnt = 0;
			int left = pivot;
			int right = pivot;
			while (true) {
				left -= 1;
				right += 1;
				cnt++;

				if (cnt >= arr.length)
					break outer;

				if (left < 0) {
					left += arr.length;
				}
				if (right >= arr.length) {
					right -= arr.length;
				}

				if (visited[left] == false) {
					sum += cnt;
					cnt = 0;
					sum += check(arr[left]);

					visited[left] = true;
					pivot = left;
					break;
				}
				if (visited[right] == false) {
					sum += cnt;
					cnt = 0;
					sum += check(arr[right]);

					visited[right] = true;
					pivot = right;
					break;
				}
			}

		}

		return sum;
	}

	int check(char ch) {
		if (ch <= 'A' + 12) {
			return ch - 'A';
		}
		return 1 + ('Z' - ch);
	}

}
