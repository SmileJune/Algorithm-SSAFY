import java.io.*;
import java.util.*;

public class BOJ_11724_연결요소의개수 {	
	static ArrayList<Integer>[] adjList;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		adjList = new ArrayList[n+1];
		visited = new boolean[n+1];
		int vertex1,vertex2,answer = 0;
		
		for(int i = 1; i < n+1; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			vertex1 = Integer.parseInt(st.nextToken());
			vertex2 = Integer.parseInt(st.nextToken());
			adjList[vertex1].add(vertex2);
			adjList[vertex2].add(vertex1);
		}
		
		for(int i = 1; i < n+1; i++) {
			if(!visited[i]) {
				dfs(i);
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	static void dfs(int v){
        if(visited[v]) {
            return;
        }
        visited[v]=true;
        for(int i : adjList[v]){
            if(!visited[i]) {
                dfs(i);
            }
        }
    }

}