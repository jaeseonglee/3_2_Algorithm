/*  알고리즘 1주차
 * 	Factorial.java
 *  작성일 : 2020.09.02
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : Factorial 실습 예제, 너무 큰 정수를 입력하면 결과가 int의 범위(21억)를 넘어가므로 유의!! 
 */

import java.util.Scanner;						// Scanner 사용을 위해 import

public class FactorialMain {
	public static void main(String args[]) {	// main 메소드
		int num;								// 입력받을 변수 num 선언
		
		Scanner input = new Scanner(System.in);	// Scanner input 생성 
		
		System.out.print("input : ");			// 정수를 입력해달라고 출력
		num = input.nextInt();					// 입력받은 정수를 num에 저장
		
		System.out.println("loop Factorial(" + num + ") : " + Factorial_loop(num));		// 반복을 통한 팩토리얼 출력
		System.out.println("Recursion Factorial(" + num + ") : " + Factorial_recursion(num));	// 순환(재귀함수)을 통한 팩토리얼 출력
	}
	
	private static int Factorial_loop(int n) {	// 반복을 통해 팩토리얼을 계산하는 Factorial_loop 메소드
		int sum = 1;							// 결과를 반환할 변수 sum을 1로 초기화
		for(int i = 1; i <= n; i++) {			// 반복을 통해 매개변수 n으로 팩토리얼 계산
			sum *= i;
		}
		return sum;								// sum 반환
	}
	
	private static int Factorial_recursion(int n) {	// 순환(재귀함수)을 통해 팩토리얼을 계산하는 Factorial_recursion 메소드
		if(n <= 1) {							// 매개변수 1보다 작거나 같다면
			return 1;							// 1을 반환
		} else {
			return n * Factorial_recursion(n-1);	// 그게 아니라면 자기자신을 호출하며 n-1을 전달
		}
	}
	
}
