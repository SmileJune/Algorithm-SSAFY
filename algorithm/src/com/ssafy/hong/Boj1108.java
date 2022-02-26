impot java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main{
	
	static int[] dfsn = new int[2502];
	static int cnt = 0;
	static boolean[] finished = new boolean[2502];
	static List<Integer>[] adj = new ArrayList[2502];
	static Stack<Integer> s = new Stack<>();
	static int sccn=1;
	static int[] scc = new int[2502];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), n=1;
		int[] indegree = new int[2502];
		Map<String, Integer> map = new HashMap<>();
		for(int i=0; i<2502; i++) {
			adj[i]=new ArrayList<>();
		}
		for(int i=0; i<N; i++) {
			String str = sc.next(); 
			int v = sc.nextInt();
			if(!map.containsKey(str))map.put(str, n++);
			while(v-- > 0) {
				String dst = sc.next();
				if(!map.containsKey(dst))map.put(dst, n++);
				adj[map.get(dst)].add(map.get(str));
			}
		}
		for(int i=1; i<n; i++)if(!finished[i])dfs(i);
		for(int i=1; i<n; i++) {
			for(int next : adj[i]) {
				if(scc[next] == scc[i])continue;
				indegree[next]++;
			}
		}
		int[] cost = new int[n];
		for(int i=1; i<n; i++)cost[i]=1;
		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<n; i++) if(indegree[i] == 0) q.add(i);
		
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			
			for(int next : adj[curr]) {
				if(scc[next] == scc[curr]) continue;
				indegree[next]--;
				cost[next]+=cost[curr];
				if(indegree[next] == 0) {
					q.add(next);
				}
			}
		}
		String str = sc.next();
		System.out.println(cost[map.get(str)]);
	}
	
	
	static int dfs(int curr) {
		int res = dfsn[curr] = ++cnt;
		s.add(curr);
		for(int next : adj[curr]) {
			if(dfsn[next] == 0)res=Math.min(res, dfs(next));
			else if(!finished[next]) res = Math.min(res, dfsn[next]);
		}
		if(res == dfsn[curr]) {
			while(true) {
				int temp = s.pop();
				finished[temp]=true;
				scc[temp]=sccn;
				if(temp==curr)break;
			}
			sccn++;
		}
		return res;
	}
	
}
