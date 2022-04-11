package com.ssafy.an;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Day63SW2383점심식사DFS {
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M, ans;
	static int[] sel;
	static int[][] map;
	static List<Pos> ppl;
	static Pos[] sta;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 9876543;
			map = new int[N][N]; // chk 인원수를 알아야 초기화가능
			ppl = new ArrayList<>(); // 사람 배열
			sta = new Pos[2]; // 두개의 계단
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if (map[i][j] == 1)
						ppl.add(new Pos(i, j));
					else if (map[i][j] > 1 && sta[0] == null)
						sta[0] = new Pos(i, j);
					else if (map[i][j] > 1 && sta[0] != null)
						sta[1] = new Pos(i, j);
				}
			}
			sel = new int[M = ppl.size()];

			dfs(0);

			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
		br.close();
	}

	private static void dfs(int idx) {
		if (idx == M) {
			cal(); // 모두 선택 완료
			return;
		}
		for (int s = 0; s < 2; s++) {
			sel[idx] = s;
			dfs(idx + 1);
		}
	}

	private static void cal() {
		int tmp = 0;
		for (int t = 0; t < 2; t++) {
			Pos s = sta[t];
			int[] pq = new int[2 * N + 2];
			int[] pq2 = new int[2 * N + N * N];
			int pe = Integer.MAX_VALUE;
			for (int p = 0; p < M; p++) {
				if (sel[p] == t) {
					int te = dit(p, t) + 1;
					pe = Math.min(pe, te);
					pq[te]++;
				}
			}
			if (pe == Integer.MAX_VALUE)
				continue;
			int ntm = pe;
			int stm = map[s.r][s.c];
			for (int i = 1; i < 2 * N + 2; i++) {
				while (pq[i] > 0) {
					pq[i]--;
					int rtm = stm;
					for (int j = i; j < pq2.length; j++) {
						if (pq2[j] < 3) {
							pq2[j]++;
							rtm--;
						}
						if (rtm == 0) {
							ntm = Math.max(ntm, j + 1);
							break;
						}
					}
				}
			}
			tmp = Math.max(tmp, ntm); // 두계단 중 최대 시간
		}
		ans = Math.min(tmp, ans);
	}

	private static int dit(int p, int s) {
		return Math.abs(sta[s].r - ppl.get(p).r) + Math.abs(sta[s].c - ppl.get(p).c);
	}

}
