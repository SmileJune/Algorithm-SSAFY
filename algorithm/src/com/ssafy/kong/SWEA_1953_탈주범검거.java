package www.ssafy.SWEA_SW모의;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {
	static class Tunnel {
		int num;
		int r, c;
		int[] dir = new int[4];

		public Tunnel(int num, int up, int down, int left, int right) {
			this.num = num;
			this.dir[0] = up;
			this.dir[1] = down;
			this.dir[2] = left;
			this.dir[3] = right; // 얘가 상, 하, 좌, 우
		}

	}

	static int[] dr = { 1, -1, 0, 0 }; // 하, 상, 우, 좌
	static int[] dc = { 0, 0, 1, -1 };

	static class Loc {
		int r, c;
		int time;

		public Loc(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}

	}

	static int N, M, R, C, L;
	static int[][] map;
	static boolean[][] visited;
	static Tunnel[][] tunnel;
	static Queue<Loc> loc;
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; ++t) {
			ans = 1;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			visited = new boolean[N][M];
			tunnel = new Tunnel[N][M];
			loc = new LinkedList<>();
			loc.add(new Loc(R, C, 1));
			visited[R][C] = true;
			for (int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] >= 1) {
						inputTunnel(i, j, map[i][j]);
					}
				}
			} // input 끝!

			BFS();
			System.out.println("#" + t + " " + ans);

		} // tc
	} // main

	private static void BFS() {
		while (!loc.isEmpty()) {
			Loc now = loc.remove();
			for (int i = 0; i < 4; ++i) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];
				if (now.time == L) {
					return;
				}
				int nowDir[] = new int[4];
				// 상, 하, 좌, 우 순으로 했는데, dr, dc를 하, 상, 우, 좌 순으로 했으니..
				// 내 방향도 하, 상, 우, 좌순으로 배열에 저장해주자.
				nowDir[0] = tunnel[now.r][now.c].dir[1];
				nowDir[1] = tunnel[now.r][now.c].dir[0];
				nowDir[2] = tunnel[now.r][now.c].dir[3];
				nowDir[3] = tunnel[now.r][now.c].dir[2];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == 0) {
					continue;
				}
				if (!visited[nr][nc] && tunnel[nr][nc].dir[i] == 1 && nowDir[i] == 1) {
					// 아래를 보고 있을 때 위를 향하는 터널이 있느냐?
					// 오른쪽을 보고 있을 때 왼쪽과 이어진 터널이 있느냐?
					loc.add(new Loc(nr, nc, now.time + 1));
					visited[nr][nc] = true;
					ans++;
				}

			}
		}

	}

	private static void inputTunnel(int r, int c, int tunn) {
		switch (tunn) {
		case 1:
			tunnel[r][c] = new Tunnel(1, 1, 1, 1, 1);
			// 상, 하, 좌, 우
			break;
		case 2:
			tunnel[r][c] = new Tunnel(2, 1, 1, 0, 0);
			// 상, 하
			break;
		case 3:
			tunnel[r][c] = new Tunnel(3, 0, 0, 1, 1);
			// 좌, 우
			break;
		case 4:
			tunnel[r][c] = new Tunnel(4, 1, 0, 0, 1);
			// 상, 우
			break;
		case 5:
			tunnel[r][c] = new Tunnel(5, 0, 1, 0, 1);
			// 하, 우
			break;
		case 6:
			tunnel[r][c] = new Tunnel(6, 0, 1, 1, 0);
			// 하, 좌
			break;
		case 7:
			tunnel[r][c] = new Tunnel(7, 1, 0, 1, 0);
			// 상, 좌
			break;
		}

	}
}
