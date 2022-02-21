package com.ssafy.namja;

import java.util.Scanner;

public class IM_Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			/*
			우선 a+2h <= X, b+2h <= Y이고, 최댓값을 구하려고 했을 때 
			a+2h = X, b+2h = Y -> a = X-2h, b = Y-2h로 둘 수 있다.
			이를 바탕으로 abh를 3차 방정식으로 만들었을 때 
			f(h) = 4h^3 -2(X+Y)h^2+XYh를 만들 수 있다.
			이를 미분했을때 0이 나오는 해가 극대값이므로 h로 둘 수 있다.
			즉, f'(h) = 12h^2 - 4(X+Y)h + XY = 0 의 해를 구하면 된다.
			이를 위해  근의 공식을 사용하면
			h = 2(X+Y) ± √(2(X+Y))^2 - 12XY)이다.
			여기서 a의 범위는 0 < a < X이기 때문에 h의 범위는 0 < h < X/2라고 할 수 있다.
			h의 범위에 속하는 해 h를 바탕으로 a와 b를 구해서 계산해주면 될 것이다.
			*/
			
			int a = 12;	// f'(h)의 2차항 계수
			int b = -4*(X+Y);	// f'(h)의 1차항 계수
			int c = X*Y;	// f'(h)의 상수항 계수
			
			// 근의 공식 h1
			double ans1 = (2*(X+Y)+Math.sqrt(Math.pow(2*(X+Y),2) - 12*X*Y))/12;
			// 근의 공식 h2
			double ans2 = (2*(X+Y)-Math.sqrt(Math.pow(2*(X+Y),2) - 12*X*Y))/12;
			
			if (ans1 > 0 && ans1 < X / 2) // h1이 h의 범위에 속한다면
				System.out.printf("%.6f\n",(X-2*ans1)*(Y-2*ans1)*ans1);
			else	// h의 범위에서 벗어난다면
				System.out.printf("%.6f\n",(X-2*ans2)*(Y-2*ans2)*ans2);
		}
	}
}