import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj18185 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = 0;
		int[] v = {0,3,5,7};
		
		for(int i=0; i<N; i++) {
			if(arr[i] == 0)continue;
			
			int min = arr[i];
			if(arr[i+1] > arr[i+2]) {
				min = Math.min(min, arr[i+1] - arr[i+2]);
				ans += min * v[2];
				arr[i] -= min; arr[i+1] -= min;
				
				min = Math.min(Math.min(arr[i], arr[i+1]), arr[i+2]);
				ans += min * v[3];
				arr[i] -= min; arr[i+1] -= min; arr[i+2] -= min;
			}
			else {
				min = Math.min(Math.min(arr[i], arr[i+1]), arr[i+2]);
				ans += min * v[3];
				arr[i] -= min; arr[i+1] -= min; arr[i+2] -= min;
				
				min = Math.min(arr[i],  arr[i+1]);
				ans += min * v[2];
				arr[i] -= min; arr[i+1] -= min;
			}
			ans += arr[i] * v[1];
			arr[i] = 0;
		}
		System.out.println(ans);
	}  
}
