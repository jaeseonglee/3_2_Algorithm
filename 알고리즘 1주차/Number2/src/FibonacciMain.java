/*	Fibonacci.java
 *  작성일 : 2020.09.02
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : Fibonacci 실습 예제, 팩토리얼과 마찬가지로 int형의 범위를 넘어서지 않게 유의!
 */

import java.util.Scanner;							// Scanner 사용을 위해 import

public class FibonacciMain {
	public static void main(String args[]) {		// main 메소드
		int i, num;									// 반복문에서 사용할 i 선언, 값을 입력받은 num 선언
		Scanner input = new Scanner(System.in);		// Scanner input 생성
		
		System.out.print("input : ");				// 값을 입력해달라고 출력
		num = input.nextInt();						// 입력받은 값을 num에 저장
		
		System.out.println("Recursion Method!");	// 순환을 통해 피보나치 수열 계산
		for(i = 0; i <= num; i++) {					// 반복문을 통해 각 피보나치 항을 출력
			System.out.println("fibo(" + i + ") : " +  Fibonacci_recursion(i));
		}
		
		System.out.println("Loop!");				// 반복을 통해 피보나치 수열 계산
		for(i = 0 ; i <= num; i++) {				// 반복문을 통해 각 피보나치 항을 출력 
			System.out.println("fibo(" + i + ") : " + Fibonacci_loop(i));
		}
	}

	private static int Fibonacci_recursion(int n) { // 순환(재귀함수)을 통해 피보나치 수열을 계산하는  Fibonacci_recursion 메소드
		if (n < 0) {								// n이 0보다 작다면
			return 0;								// 0을 반환
		} else if ( n == 1) {						// n이 1이라면
			return 1;								// 1을 반환
		} else {									// 그 이외의 경우는 자기자신을 호출하며 각각 n-1 , n-2을 전달
			return Fibonacci_recursion(n-1) + Fibonacci_recursion(n-2);	
		}
	}
	
	private static int Fibonacci_loop(int n) {		// 반복을 통해 피보나치 수열을 계산하는 Fibonacci_loop 메소드
		int sum = 0;								// 결과를 반환할 sum을 0으로 초기화
		int fibo1 = 0;								// 피보나치 수열 계산을 위해 fibo1, fibo2을 0으로 초기화
		int fibo2 = 0;
		
		for (int i = 0; i <= n; i++) {				// 반복문을 통해 피보나치 수열 계산
			if(i == 0) {							// i가 0이라면 
				fibo2 = 0;							// fibo2을 0으로 초기화
				sum += fibo2;						// sum에 fibo2를 더해준다.
			}
			else if(i == 1) {						// i가 1이라면 
				fibo1 = 1;							// fibo1을 1로 초기화
				sum += fibo1;						// sum에 fibo1을 더해준다.
			}
			else {									// 그외에는 
				sum = fibo1 + fibo2;				// fibo1과 fibo2을 더한 값을 sum에 저장
				fibo2 = fibo1;						// fibo2를 fibo1로 초기화
				fibo1 = sum;						// fibo1을 sum으로 초기화
			}
		}
		return sum;									// 반복문이 끝나면 sum을 반환한다.
	}
	
}
