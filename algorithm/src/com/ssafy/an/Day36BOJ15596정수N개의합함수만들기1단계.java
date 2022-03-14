package com.ssafy.an;

class Test { // 15596 정수N개의 합 함수 만들기 1단계....
	long sum(int[] a) {
		long sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];  
		}
		return sum;
	}
}