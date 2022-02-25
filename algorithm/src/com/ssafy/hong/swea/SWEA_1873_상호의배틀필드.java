import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SWEA_1873_상호의배틀필드{
	static int N, M, y, x;
	static char[][] map;
	static int[] dy = {0,1,-1,0,0};
	static int[] dx = {0,0,0,1,-1};
	static Map<Character, Integer> hm = new HashMap<>();
	static Map<Character, Integer> hm2 = new HashMap<>();
	static Map<Character, Character> mh = new HashMap<>();
	static {
		hm.put('S', 0); 
		hm.put('D', 1); mh.put('D','v');  hm2.put('v',1);
		hm.put('U', 2); mh.put('U','^');  hm2.put('^',2);
		hm.put('R', 3); mh.put('R','>');  hm2.put('>',3);
		hm.put('L', 4); mh.put('L','<');  hm2.put('<',4);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine()), t=0;
		while(t++<T) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][];
			for(int i=0; i<N; i++) {
				map[i]=sc.nextLine().toCharArray();
				for(int j=0; j<M; j++) {
					if(map[i][j]=='<' || map[i][j]=='>' || map[i][j]=='^' || map[i][j]=='v') {
						y=i; x=j;
					}
				}
			}
			int n = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();
			for(int i=0; i<n; i++) {
				action(str.charAt(i));
			}
			System.out.printf("#%d ",t);
			print();
		}
	}
	static void action(char command) {
		int dir = hm.get(command);
		int ty = y+dy[dir];
		int tx = x+dx[dir];
		
		if(command == 'S') {
			dir = hm2.get(map[y][x]);
			while(ty+dy[dir]>=0 && tx+dx[dir]>=0 && ty+dy[dir]<N && tx+dx[dir]<M) {
				ty+=dy[dir]; tx+=dx[dir];
				if(map[ty][tx]=='*') {
					map[ty][tx]='.';
					break;
				}
				else if(map[ty][tx]=='#')break;
			}
		}
		else if(ty>=0 && tx>=0 && ty<N && tx<M && map[ty][tx]=='.'){
			map[y][x]='.';
			map[ty][tx]=mh.get(command);
			y=ty; x=tx;
		}
		else {
			map[y][x]=mh.get(command);
		}
	}
	
	static void print() {
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)sb.append(map[i][j]);
			if(i<N-1)sb.append('\n');
		}
		System.out.println(sb);
	}
}
