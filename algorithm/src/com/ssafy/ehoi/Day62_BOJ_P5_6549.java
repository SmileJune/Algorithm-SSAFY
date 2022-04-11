package com.ssafy.ehoi;

import java.util.Arrays;
import java.util.Scanner;

public class Day62_BOJ_P5_6549 {
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int N = sc.nextInt();
			if (N == 0)
				break;

			arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(getArea(0, N));
		}
		sc.close();
	}

	/**
	 * 
	 * @param s : 배열의 시작 인덱스
	 * @param e : 배열의 마지막 인덱스 + 1
	 * @return : 해당 배열의 최대 넓이를 구해다 줄거야
	 */
	private static long getArea(int s, int e) {
		// base : 사이즈가 1이라면 그냥 그 높이 반환하면 돼
		if (s + 1 == e) {
			return arr[s];
		}

		// recur
		// 계속 분할하면서 최대 넓이 가져와야지
		int mid = (s + e) / 2;
		long leftArea = getArea(s, mid);
		long rightArea = getArea(mid, e);

		// 그 중에 최대 넓이 반환해야지~
		long res = Math.max(leftArea, rightArea);

		// 본격적으로 로직을 작성해보자
		// mid에 있는 걸 중심으로 양쪽의 하나씩 아이들을 살을 붙여가면서 직사각형 넓이를 구할거야
		int height = arr[mid];
		int left = mid - 1, right = mid + 1;
		int width = 1;

		// 포인터들이 이 범위 안에 각각 있다면
		while (s <= left || right < e) {
			// 그 포인터들이 가리키는 높이 중에 더 큰 높이를 구해서 걔랑 더해볼 건데
			// 그럼 일단 그 높이를 각각 구해보자
			// 근데 그 높이의 조건은 일단 현재 높이랑 비교해서 작은 것이어야 해
			// 그리고 left 포인터는 범위 안에 있어야 해 (그래서 범위 안에 없으면 -1 값을 던져)
			int leftH = s <= left ? Math.min(height, arr[left]) : -1;
			int rightH = right < e ? Math.min(height, arr[right]) : -1;
			
			if(leftH >= rightH) {
				height = leftH;
				left--;
			} else {
				height = rightH;
				right++;
			}
			
			// 이제 여기서 더 큰 높이를 택해야 그나마 더 최대 넓이를 구하겠지?
			width++;
			res = Math.max(res, 1L*height*width);
		}

		return res;
	}
}
