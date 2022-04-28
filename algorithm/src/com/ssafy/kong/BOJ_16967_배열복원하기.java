package com.ssafy.BOJ_SB;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.StringTokenizer;

	public class BOJ_16967_배열복원하기 {

		public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			
			int[][] A = new int[H][W];
			int[][] B = new int[H+X][W+Y];
			int[][] check = new int[H+W][W+Y];
			
			for(int i=0;i<H+X;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W+Y;j++) {
					B[i][j] = Integer.parseInt(st.nextToken());

				}
			}
			
			// A배열의 범위만 보기!
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
						if(i-X>=0&&j-Y>=0) { //현재 위치가 이동 위치와 겹친다면
							A[i][j] = B[i][j]-A[i-X][j-Y]; //B배열의 값과 이동 전의 값의 차를 구함
						}else {
							A[i][j] = B[i][j];
						}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			for(int i=0;i<H;i++) {			
				for(int j=0;j<W;j++)
					sb.append(A[i][j]+" ");
				sb.append("\n");
			}
			
			System.out.println(sb.toString());
		}

	}
}
