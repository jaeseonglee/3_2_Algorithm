package HEAP;

public class heapMain {
	public static void main(String args[]) {		// main 메소드
		Heap h = new Heap();						// HEAP 생성 및 초기화
		
		System.out.println("==Insert==");			// 각각의 값 삽입
		h.insert(18);
		h.insert(13);
		h.insert(5);
		h.insert(12);
		h.insert(8);
		h.insert(3);
		h.insert(19);
		h.show();									// 출력
		
		
		System.out.println("==Delete===");			// 삭제
		h.delete();									// 가장 큰 값 삭제
		h.show();									// 출력
		h.delete();
		h.show();
		
		System.out.println("===MakeHeap===");		// 힙을 만들어준다. 이때 완전 이진트리가 0번부터 사용하는지 아닌지에 따라 전혀 다른 결과를 나타낸다.
		int [] tree = {0,20,40,50,70,30,100,80,10,90,60};	
		//int [] tree = {0,0,20,40,50,70,30,100,80,10,90,60};			// 인덱스를 0번부터 사용한다면 이 배열을 사용
		
		Heap nh = new Heap(tree);					// 새로운 HEAP을 생성및 tree로 초기화
		
		nh.makeTreeHeap();							// 힙을 만들어주고
		nh.show();									// 출력
	
	}
}
