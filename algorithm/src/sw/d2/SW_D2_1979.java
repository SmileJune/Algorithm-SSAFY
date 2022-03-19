package sw.d2;

import java.util.Scanner;

public class SW_D2_1979 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int K = sc.nextInt(); // 단어의 길이 입력

			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			} // 배열 완성

			int ans = 0;
			// 가로 순회
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { // i행인 이 한 줄에서
					if(arr[i][j] == 1) { // 1을 만났따?
						int cnt = 0;
						// 내 오른쪽으로 1이 몇개나 있는지 세어보자
						// 조건문은 꼭 범위체크부터 먼저 하고 세부적인 걸로 넘어가야해 
						while (j < N && arr[i][j] == 1) {
							cnt++;
							j++;
						}
						if (cnt == K) ans++;
					}
				}
			}

			// 세로 순회
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) { // j열인 이 한 줄에서
					if(arr[i][j] == 1) { // 1을 만났따?
						int cnt = 0;
						// 내 밑으로 1이 몇개나 있는지 세어보자
						// 조건문은 꼭 범위체크부터 먼저 하고 세부적인 걸로 넘어가야해 
						while (i < N && arr[i][j] == 1) {
							cnt++;
							i++;
						}
						if (cnt == K) ans++;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, ans);
		}

		sc.close();
	}
}
//내가 0인 건 신경 안써
// 내가 1이 됐다? 자 그러면 내 옆이 1일동안 계속 보는 거야 cnt++ 하면서
// 그리고 난 다음에 cnt가 K와 같다? 그러면 ans++

