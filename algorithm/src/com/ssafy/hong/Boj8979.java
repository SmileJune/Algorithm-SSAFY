import java.util.Arrays;
import java.util.Scanner;

public class Boj8979 {
	/**
	 *	[BOJ: 8979] 올림픽
	 *	정렬하기.
	 *	1. 금메달 수 많은 나라
	 *	2. 은메달 수 많은 나라
	 *	3. 동메달 수 많은 나라
	 *	순으로 정렬 하였을 때, k국가 몇등인지 출력
	 *	input:	N K		나라 수, k번째 국가
	 *			n g s c	번호, 금, 은, 동메달 수
	 *			...
	 *	output:	ans		등 수
	 */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Info[] infos = new Info[N];
        for(int i=0; i<N; i++){
            infos[i]=new Info(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(infos, (n1,n2)->{
            if(n1.g - n2.g != 0) return n2.g - n1.g;
            if(n1.s - n2.s != 0) return n2.s - n1.s;
            return n2.c - n1.c;
        });
        int ans=1;
        boolean flag=false;
        for(int idx=0,temp=1; idx<N;){
            int j=idx;
            while(j<N && infos[idx].equals(infos[j])){
                if(infos[j++].n==K){ans=temp;flag=true;}
            }
            temp+=j-idx;
            idx+=j-idx;
        }
        System.out.println(flag?ans:N);
    }
    static class Info{
        int n,g,s,c;
        public Info(int n, int g, int s, int c){
            this.g=g;
            this.c=c;
            this.n=n;
            this.s=s;
        }
        public String toString(){
            return n + " "+ g+" "+s+" "+c;
        }
        public boolean equals(Info info){
            return this.g == info.g && this.s == info.s && this.c == info.c;
        }
    }
}
