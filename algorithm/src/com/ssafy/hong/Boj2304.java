package com.ssafy.hong;
import java.util.*;

public class Boj2304{
	/**
	 * [BOJ: 2304] 창고 다각형
	 * N개의 막대 기둥 일렬로 세워져 있다.
	 * 폭이 1m인 기둥들을 사용하여 창고 제작하려 한다.
	 * 비가 올 때, 물이 고이지 않게 오목한 부분이 없어야 한다.
	 * 
	 * input:	N	기둥 수
	 * 			p h	위치, 높이
	 * 			...
	 * output:	ans	지붕을 만들었을 때 내부 면적
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		List<P> list = new ArrayList<>();
		for(int i=0; i<N; i++) {
			list.add(new P(sc.nextInt(),sc.nextInt()));
		}
		list.sort((p1,p2)->{if(p1.h == p2.h) return p1.p - p2.p; return p2.h - p1.h;});
		
		int h = 0, l = list.get(0).p, r = list.get(0).p, ans = 0;
		for(int i=0; i<N; i++) {
			h = list.get(i).h;
			int j = i, tl = l, tr = r;
			while(j<N && list.get(j).h == h) {
				tl = Math.min(tl, list.get(j).p);
				tr = Math.max(tr, list.get(j).p+1);
				j++;
			}
			i=j-1;
			ans+=(tr-r)*h+(l-tl)*h;
			l=tl; r=tr;
		}
		System.out.println(ans);
	}
	static class P{
		int p, h;
		P(int p, int h){this.p=p; this.h=h;}
	}
}
