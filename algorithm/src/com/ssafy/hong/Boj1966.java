package com.ssafy.hong;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1966 {
		/**
		* [BOJ: 1966] 프린터 큐
		* 앞에서부터 순서대로 출력 하되
	  * 뒤의 문서들 중 중요도가 높은 문서가 존재 한다면 우선으로 출력한다.
		* 이 때, 앞에서 출력하지 않은 문서들은 큐의 맨 뒤로 들어간다.
		* 특정 문서가 몇 번째로 출력되는지 알아내라.
		*
		* input:  T        테스트 케이스 수
		*					N K      문서 수, 찾는 문서
		*         a1,a2..  문서 우선 순위
		* output: n        n번째 출력물
		*/
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), t=0;
        while(t++<T){
            int N = sc.nextInt();
            int K = sc.nextInt();
            List<Integer> p = new ArrayList<>();
            Queue<Pair> queue = new LinkedList<>();
            for(int i=0; i<N; i++){
                int val = sc.nextInt();
                p.add(val);
                queue.add(new Pair(val,i));
            }
            p.sort((o1,o2)->o2-o1);
            for(int i=0; i<N; i++){
                while(queue.peek().val!=p.get(i)){
                    queue.add(queue.poll());
                }
                if(queue.poll().idx==K){
                    System.out.println(i+1);
                    break;
                }
            }
        }
    }
    static class Pair{
        int val,idx;
        Pair(int val, int idx){this.val=val;this.idx=idx;}
    }
}
