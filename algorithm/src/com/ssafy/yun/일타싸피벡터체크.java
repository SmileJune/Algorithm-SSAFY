package com.ssafy.yun;

public class 일타싸피벡터체크 {

	static double ballSize = 5.27;

	static double[] getUnitVector(double[] A) {
		double length = Math.sqrt(Math.pow(A[0], 2) + Math.pow(A[1], 2));
		double[] ans = { A[0] / length, A[1] / length };
		return ans;
	}

	static double[] AtoB(double[] A, double[] B) {
		double[] ans = { B[0] - A[0], B[1] - A[1] };
		return ans;
	}

	static double[] getReverseVector(double[] A) {
		double[] arr = getUnitVector(A);
		double[] ans = { arr[0] * (-ballSize), arr[1] * (-ballSize) };
		return ans;
	}

	static double[] sum(double[] A, double[] B) {
		return new double[] { A[0] + B[0], A[1] + B[1] };
	}

	static double dot(double[] A, double[] B) {
		return A[0] * B[0] + A[1] * B[1];
	}

	public static void main(String[] args) {
		double[] hole = { 254, 127 };
		double[] targetBall = { hole[0]/2, hole[1]/2 };
		double[] whiteBall = { 0, hole[1]/4 };

		double[] targetToHole = AtoB(targetBall,hole);
		double[] whiteToTarget = AtoB(whiteBall,targetBall);
		double[] reversedVector = getReverseVector(targetToHole);
		double[] realTarget = sum(whiteToTarget,reversedVector);
		
		
		double radian = Math.atan2(realTarget[1], realTarget[0]);
		System.out.println(radian);
		double degree = Math.toDegrees(radian);
		System.out.println(degree);
	
	}

}
