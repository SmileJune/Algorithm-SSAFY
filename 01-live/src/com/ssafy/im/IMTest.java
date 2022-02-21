package com.ssafy.im;

import java.util.Scanner;

public class IMTest { // 기지국 문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스 2

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 지도 크기 9
			char[][] map = new char[N][N]; // 지도 생성 9

			for (int i = 0; i < N; i++) { // 
				String str = sc.next(); // 한 행에 대한 문자열을 받고
				for (int j = 0; j < N; j++) { // 열 단위로 끊어서
					map[i][j] = str.charAt(j); // 해당 자리에 있는 문자를 넣는다
				}
			} // 한 테케에 대한 지도 입력 완료

			// 상 하 좌 우
			int[] di = { -1, 1, 0, 0 }; // 행 이동
			int[] dj = { 0, 0, -1, 1 }; // 열 이동

			// 기지국 카바하러 간다 시작
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int reach = 0; // 일단 도달 길이는 0으로 초기화를 해두고
					switch (map[i][j]) { // 해당 구역의 값이
					case 'A':
						reach = 1;
						break;
					case 'B':
						reach = 2;
						break;
					case 'C':
						reach = 3;
						break;
//					default:
//						continue; // 근데 이 문장 필요없지 않나?
					}

					// 이제 4방 탐색 시작
					for (int d = 0; d < 4; d++) { // 상하좌우 돌 동안
						for (int r = 1; r <= reach; r++) { // 한 방향으로 갈 때 그 도달 길이만큼 갈 수 있게 세팅을 해두고
							int ni = i + di[d] * r;
							int nj = j + dj[d] * r;
//							int ni = i + di[d] * reach; // 이래서 값이 달라졌어
//							int nj = j + dj[d] * reach;

							if (ni < 0 || ni >= N || nj < 0 || nj >= N) // 범위체크
								continue;

							if (map[ni][nj] == 'H') { // home 인 곳을
								map[ni][nj] = 'T'; // true의 T로 바꿔준다
							}
						}
					}
				}
			}
			
			// 지도 싹다 돌고 나왔는데 이제 그냥 H인 애들은 기지국이 커버못하는 애들일 테니까
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'H') cnt++; // 기지국이 카바못해서 H로 안바뀐 친구들은 다 세서
				}
			}

			System.out.printf("#%d %d", tc, cnt);
		}
		sc.close();
	}
}
