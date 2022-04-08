package day0408;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_A_1949 {
	static int N, K, maxH, ans;
	static int[][] map;
	static boolean[][] visit;
	static List<Top> topList;

	static class Top {
		int x, y;

		public Top(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.setIn(new FileInputStream("data/input1949.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도 길이
			K = Integer.parseInt(st.nextToken()); // 공사 가능한 최대 깊이 1 <= K <= 5

			map = new int[N][N];
			visit = new boolean[N][N];
			maxH = 0;
			ans = 0; 
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxH = Math.max(maxH, map[i][j]); // 최대 봉우리 찾고
				}
			}
			
	
				/**
				 * 봉우리 배열이 있을 필요가 딱히 없었넹
			topList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxH) {
						topList.add(new Top(i, j)); // 최대 봉우리들 리스트에 넣기
					}
				}
			}

			// 최대 봉우리들마다 깊이우선탐색을 하면 되려나
			for (int i = 0; i < topList.size(); i++) {
				// 봉우리의 x, y좌표, 등산로 길이, 공사 여부
				dfs(topList.get(i).x, topList.get(i).y, 1, 1);
			}
				 */
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == maxH) {
						dfs(i, j, 1, 1);
					}
				}
			}
			
			System.out.println("#" + tc + " "  +ans);

		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	private static void dfs(int x, int y, int len, int done) {
		// base
		if(len > ans) {
			ans = len;
		}

		// recursive
		visit[x][y] = true; // 나 방문처리
		for (int d = 0; d < 4; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			// 범위체크
			if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
			if (visit[nx][ny]) continue;
			// 이동하려는 높이가 현재 내 높이보다 낮다면 등산로 가능!
			if (map[nx][ny] < map[x][y]) {
				dfs(nx, ny, len+1, done);
			} 
			// 크다면
			// 공사를 아직 한적이 없고 + 공사를 하면 나보다 높이가 작아질 수 있다면
			else if (done == 1 && map[nx][ny] - K < map[x][y]){
				int tmp = map[nx][ny]; // 임시로 공사해볼거니까 tmp에 기록
				map[nx][ny] = map[x][y] - 1;
				dfs(nx, ny, len+1, 0);
				map[nx][ny] = tmp; // 원상복구
			}
		}
		visit[x][y] = false; // 다음 방문을 위해서 방문 처리 회수

	}
}

/**
 * 라이브
 * 1. 가장 높은 봉우리 찾기
 * 2. 등산로 조성하기
 * 	1) 현 위치보다 낮을 때
 * 	2) 현 위치와 높이가 같거나 높을 때 
 * 		(1) 공사를 이미 진행했을 때
 * 		(2) 공사를 진행하지 않았을 때
 * 			공사를 해야하는데 k의 범위만큼 전부다 파 봐야 하나?
 * 			아니지 내 값보다 하나 작게만 파면 돼
 * 3. 등산로 길이 갱신	
 */
