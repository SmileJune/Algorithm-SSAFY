package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW1493IM {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {

		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			System.out.printf("#%d %d\n", i, solution());
		}
	}

	static int solution() throws NumberFormatException, IOException {

		int[][] map = new int[300][300];

		int cnt = 0;
		int n = 1;
		int y = 0, x = 0;

		while (n <= 90000) {

			while (x <= cnt && x < 300) {
				map[y][x] = n++;
				y--;
				x++;
			}
			cnt++;
			if (cnt < 300) {
				y = cnt;
				x = 0;
			} else {
				y = 299;
				x = cnt - 299;
			}
		}

		st = new StringTokenizer(br.readLine());
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());

		int[] p1 = new int[2];
		int[] p2 = new int[2];
		boolean trig1 = false, trig2 = false;
		outer: for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++) {
				if (map[i][j] == n1) {
					p1[0] = i;
					p1[1] = j;
					trig1 = true;
				}
				if (map[i][j] == n2) {
					p2[0] = i;
					p2[1] = j;
					trig2 = true;
				}
				if (trig1 && trig2) {
					break outer;
				}
			}
		}
		p1[0] += p2[0] + 1;
		p1[1] += p2[1] + 1;
		return map[p1[0]][p1[1]];

	}
}
