import java.io.IOException;
import java.util.*;

public class SWEA_1961_숫자배열회전{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(), t=0;
		int[][] arr = new int[8][8];
		while(t++<T) {
			int N = sc.nextInt();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)arr[i][j]=sc.nextInt();
			}
			StringBuilder sb = new StringBuilder();
			sb.append('#').append(t).append('\n');
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>=0; j--)sb.append(arr[j][i]);
				sb.append(' ');
				for(int j=N-1; j>=0; j--)sb.append(arr[N-i-1][j]);
				sb.append(' ');
				for(int j=0; j<N; j++)sb.append(arr[j][N-i-1]);
				sb.append('\n');
			}
			System.out.print(sb);
		}
	}
}
