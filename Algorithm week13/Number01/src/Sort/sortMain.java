
package Sort;

public class sortMain {
	public static void main(String args[]) {		// 메인 메소드
		Sort s = new Sort();						// Sort 객체 생성 및 초기화
		
		int[] a2 = {8, 1, 23, 15, 31, 2, 26, 12 };	// 합병정렬에 사용할 배열 생성
		
		int[] merge = s.mergeSort(a2);				// mergeSort 호출로 합병정렬
		
		System.out.print("Merge sort : ");			// 정렬된 배열을 반복문을 통해 출력
		for(int i = 0; i < merge.length; i++) { 
			System.out.print(merge[i] + " ");
		}
		System.out.println();
		
		int[] a3 = {3, 1, 5, 4, 9, 7, 8};			// 퀵 정렬에서 사용할 배열 생성
		int[] quick = s.quickSort(a3);				// quickSort 호출로 퀵 정렬
		
		System.out.print("Quick sort : ");			// 정렬된 배열을 반복문을 통해 출력
		for(int i = 0; i < quick.length; i++) {
			System.out.print(quick[i] + " ");
		}
		System.out.println();
		
	}
}
