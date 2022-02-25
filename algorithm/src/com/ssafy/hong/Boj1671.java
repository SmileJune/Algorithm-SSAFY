import java.util.*;

public class Boj1671{
	/**
	 * [BOJ: 1671] 상어의 저녁식사
	 * 상어는 서로 먹는다.
	 * A상어의 크기, 속도, 지능이 B상어의 크기, 속도, 지능보다 높거나 같으면
	 * A상어는 B상어를 먹을 수 있다.
	 * 한 상어당 최대 2마리까지만 먹을 수 있을 때,
	 * 살아남는 상어는 최소 몇마리?
	 * 
	 * input:	N		상어 수
	 * 			a b c	크기, 속도, 지능
	 * 			..
	 * output:	ans		살아남은 수
	 * @param args
	 */
	static boolean[] visit;
	static int[] match = new int[51];
	static List<Integer>[] adj = new ArrayList[51];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		List<Shark> list = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			match[i] = -1;
			adj[i] = new ArrayList<>();
			list.add(new Shark(sc.nextInt(), sc.nextInt(), sc.nextInt()));
		}
		
		for(int i=0; i<N; i++) {
			Shark now = list.get(i);
			for(int j=0; j<N; j++) if(i!=j){
				if(now.bigger(list.get(j))) {
					adj[i].add(j);
				}
			}
			for(int j=i+1; j<N; j++) {
				if(now.equal(list.get(j))){
					adj[i].add(i);
				}
			}
		}
		int ans = 0;
		for(int i=0; i<2*N; i++) {
			visit = new boolean[N];
			if(dfs(i/2)) ans++;
		}
		System.out.println(N-ans);
	}
	
	static boolean dfs(int curr) {
		if(visit[curr])return false;
		visit[curr]=true;
		
		for(int next : adj[curr]) {
			if(match[next] == -1 || dfs(match[next])) {
				match[next] = curr;
				return true;
			}
		}
		return false;
	}
	
	static class Shark{
		int size,speed,intel;
		Shark(int size, int speed, int intel){this.size=size; this.speed=speed; this.intel=intel;}
		
		boolean bigger(Shark s) {
			if(this.size > s.size) {
				return this.speed >= s.speed && this.intel >= s.intel;
			}
			if(this.speed > s.speed) {
				return this.size >= s.size && this.intel >= s.intel;
			}
			if(this.intel > s.intel) {
				return this.speed >= s.speed && this.size >= s.size;				
			}
			return false;
		}
		boolean equal(Shark s) {
			return this.size == s.size && this.speed == s.speed && this.intel == s.intel;
		}
	}
}
