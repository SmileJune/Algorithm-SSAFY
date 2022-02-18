package com.ssafy.park;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2567_박정현 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		boolean[][] bo = new boolean[101][101];
		int no = Integer.parseInt(br.readLine());
		for (int n = 0; n < no; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++)
					bo[j][k] = true;
			}
		}

		int cnt = 0;

		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, 1, -1 };

		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= 100; j++) {
				if (bo[i][j]) {
					for (int k = 0; k < 4; k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];

						if (nx >= 1 && nx <= 100 && ny >= 1 && ny <= 100 && bo[nx][ny] == false)
							cnt++;
						else if (nx < 1 || nx > 100 || ny < 1 || ny > 100)
							cnt++;
					}
				}
			}
		}
		sb.append(cnt);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}
