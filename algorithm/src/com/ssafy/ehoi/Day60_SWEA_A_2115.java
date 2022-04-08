package day0407;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 50개 테스트 3초(3억번)안에 통과
// 1개 테스트에 6백번 연산 이하...?
public class SWEA_A_2115 {
	static int N, M, C, ans;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input2115.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 입력 끝

			ans = 0;

			// 두 일꾼의 벌통을 완탐해야 함
			for (int i = 0; i < N; i++) {
				for (int j = 0; j + M - 1 < N; j++) {
					// 이 범위 안에서 일꾼 1번의 수익을 얻어오고
					int worker1 = getMoney(i, j, 0, 0, 0);
					// 그럼 일꾼 2번은
					// 1. 1번과 같은 행에서 돌 수도 있고
					// 2. 다음 행에서 돌 수도 있다.
					// 일꾼 1번의 가장 오른쪽 벌통 끝부터
					int worker2 = 0;
					for (int k = j + M; k + M - 1 < N; k++) {
						worker2 = getMoney(i, k, 0, 0, 0);
					}
					// 다음 행이니까
					for (int m = i + 1; m < N; m++) {
						for (int n = 0; n + M - 1 < N; n++) {
							// 둘 중에 더 큰 애가 수익이 되어야겠지
							worker2 = Math.max(worker2, getMoney(m, n, 0, 0, 0));
						}
					}
					ans = Math.max(ans, worker1 + worker2);
				}
			}
			
			System.out.println("#" + tc + " " + ans);

		}
	}

	/**
	 * 파라미터 : 행, 열, M까지 도달했는지 확인하기 위한 변수, 벌꿀양의 합, 벌꿀가격의 합
	 * @return
	 */
	private static int getMoney(int x, int y, int cnt, int honeySum, int priceSum) {
		// 만약 지금까지의 벌꿀양의 합이 C를 넘어섰다? 그러면 수익은 없다!
		if(honeySum > C) return 0; 
		// base : 벌통을 끝까지 다 봤으면 
		if(cnt == M) {
			return priceSum;
		}
		// recursive
		// 벌꿀 통을 들고 왔는데 여기서 해야 할 일이 뭐지?
		// 해당 통의 벌꿀을 채취하느냐 마느냐 둘 중 하나
		// 채취했을 때의 수익과 채취하지 않았을 때의 수익 중 max를 return 하면 돼
		int res = Math.max(
				// 채취하면 해당 벌꿀 양과, 가격을 더하자
				getMoney(x, y + 1, cnt + 1, honeySum + map[x][y], priceSum + map[x][y]*map[x][y]), 
				// 안하면 그냥 횟수만 더하고 치우자
				getMoney(x, y + 1, cnt + 1, honeySum, priceSum));
				
		return res;
		
	}

}
