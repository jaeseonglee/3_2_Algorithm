package HeapSort;

public class main {
	public static void main(String[] args) {			// 메인 메소드
		HeapSort s = new HeapSort();					// 힙 정렬 객체 생성
		int[] a4 = {0, 20, 40, 50, 70, 30, 100, 80, 10, 90, 60};	// 0번째 인덱스를 사용하지 않는 배열을 생성
		
		int[] heap = s.heapSort(a4);					// heapSort로 배열을 정렬
		
		System.out.println("Heap sort : ");				// 정렬된 배열 출력
		
		for(int i = 0; i < heap.length; i++) {			// 반복문을 통해 배열의 내용 출력
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
}
