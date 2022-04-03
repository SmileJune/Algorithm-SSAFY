package com.ssafy.ehoi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Day55_BOJ_G5_7576_BFS {
	static int[][] arr;
	static int n, m;
	static int ans = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken()); // 6
		m = Integer.parseInt(st.nextToken()); // 4
		arr = new int[m][n]; // 4 *6

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

//		System.out.println(Arrays.deepToString(arr));

		bfs();

		System.out.println(ans);

	}

	static class T {
		int x;
		int y;

		public T(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void bfs() {
		// 큐부터 만들자
		// 금요일에도 이것 때문에 고생했는데 내가 필요한 정보는 토마토가 익고 익지 않고의 정보가 아니라
		// 해당 인덱스의 정보가 큐에 들어가야 해
		// 그래서 그 때 Queue<Integer, Integer> 같은 짓을 했는데 이건 안되는 거야
		// 그래서 나는 클래스를 따로 만들었고
		// 아 클래스로 만들려다가 인티저 배열로 만들었다
		// 오늘은 클래스로 만들어야지
		Queue<T> q = new LinkedList<>();

		// 익은 토마토 1을 찾아서 큐에 넣는다
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					q.add(new T(i, j));
				}
			}
		}
		// 큐가 비어있지 않을 동안
		while (!q.isEmpty()) {
			// 맨 앞에 있는 토마토 하나 꺼내고
			T t = q.poll();
			for (int d = 0; d < 4; d++) {
				// 위치도 꺼내요
				int new_x = t.x + dx[d];
				int new_y = t.y + dy[d];

				// 사방에 있는 토마토를 익게 할거야
				// 근데 범위를 벗어난 자리면
				if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n)
					continue;
				// 그리고 안 익은 토마토(0)이 아니면 컨티뉴
				if (arr[new_x][new_y] != 0)
					continue;
				// 여기까지 오면 0이다 이전 토마토의 값에서 +1 해서 저장 -> 추후에 맥스값에서 1빼기
				arr[new_x][new_y] = arr[t.x][t.y] + 1;
				// 익은 토마토 다시 큐에 넣기
				q.add(new T(new_x, new_y));
			}
		}
		// 큐가 다 비었다는 건 다 익게 했다는 뜻

		// 이제 전체를 탐색하면서 안 익은 토마토가 나오면 -1을 출력하고
		// 최댓값도 동시에 찾자
		int max = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 0) {
					ans = -1;
					// 더 볼것도 없이 리턴
					return;
				}
				max = Math.max(max, arr[i][j]);
			}
		}
		ans = max - 1;
		return;
	}
}

// bfs
// 1을 찾는다 큐에 넣는다 방문 처리를 한다(근데 1이면 방문처리가 되었다고 걍 보면 될 거 같은데)
// 근데 1이 한 개가 아니라 여러 개일 수도 있어
// 큐가 비어있지 않을 동안
// 큐에서 맨 앞에 꺼를 꺼낸다 
// 4방 탐색을 돈다
// 범위체크를 한다 
// -1이거나(없거나) 1이거나(익었거나) : continue
// 0이면(익지 않았으면) 익게 한다 (1로 바꾸는  게 아니라, 며칠에 익었는지를 기록)
// 그리고 걔를 다시 큐에 추가한다

// 그럼 이제 큐가 빌 때가 오겠지 그러면 다 익게 한 건데
// 그 때 전체를 탐색해보다가 0이 나온다 그러면 -1을 출력하고
// 처음부터 다 익어있으면 0을 출력해야해 : 최댓값이 1이면 아 어차피 -1로 출력하기로 했으니까 오케이
// 그게 아니면 (다 익었으면) 최소 일수를 출력
