package sort;

public class SortMain {
	public static void main(String args[]) {		// main 메소드
		int[] a = {5,2,8,3,1};						// int 형 배열 a 선언 및 초기화
		Sort s = new Sort();						// Sort 객체 a 생성 및 초기화
		int i;										// 반복문에서 사용할 변수 i
		System.out.println("정렬 전 배열 원소");			// 배열 출력
		
		for(i = 0; i < a.length; i++) {				// 반복문을 통해 배열을 출력
			System.out.print(a[i] +" ");
		}
		System.out.println();
		System.out.println("================================");
		
		int[] b = s.selectionSort(a);				// 배열을 선택 정렬
		System.out.println("선택정렬 원소");
		
		for(i = 0; i < b.length; i++) {				// 반복문을 통해 선택 정렬된 배열 출력
			System.out.print(b[i] + " ");
		}
		System.out.println();
		System.out.println("================================");

		int[] c = s.bubbleSort(a);					// 배열을 버블 정렬
		System.out.println("버블정렬 원소");
		
		for(i = 0; i < c.length; i++) {				// 반복문을 통해 버블 정렬된 배열 출력
			System.out.print(c[i] + " ");
		}
		System.out.println();
		System.out.println("================================");
		
		int[] d = s.insertionSort(a);				// 배열을 삽입 정렬 
		System.out.println("삽입정렬 원소");
		
		for(i = 0; i < d.length; i++) {				// 반복문을 통해 삽입 정렬된 배열 출력
			System.out.print(d[i] + " ");
		}
		System.out.println();
		System.out.println("================================");
	}
}
