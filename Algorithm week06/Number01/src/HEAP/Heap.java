/*  알고리즘 6주차 힙 (해당 코드는 최대힙(MAX HEAP)만을 다룬다) 
 * 	Heap.java, heapMain.java
 *  작성일 : 2020.10.07~09, 14~16
 *  	- 1014~16 작성: makeTreeHeap 메소드를 7주차에 따로 추가하는 것보다 6주차 기한 내에 다시 파일을 수정
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 최대 힙에 대해 배우고 응용하는 코드 추가적으로 이진트리를 힙으로 만드는 makeTreeHeap 메소드가 있다.
 *  현재 HEAP.java는 인덱스 0번 부터 사용하는 구조이다.
 *  i의 부모는 (i-1)/2 
 *     자식은 (i*2)+1 을 통해 가리킨다.
 *  
 *  맨 아래 주석부터 이진트리를 배열로 나타낼 때 인덱스 0번을 사용하지 않는 구조를 사용하는 코드 작성(1009)
 */

package HEAP;

public class Heap {					// 최대힙을 나타내는 Heap 클래스 
	private int nNode;				// 현재 힙의 노드 갯수
	private int maxSize;			// 힙을 나타낼 배열의 최대 크기
	private int heap[];				// 힙을 나타낼 배열
	
	public Heap() {					// 디폴트 생성자
		nNode = 0;					// 노드 개수 0개
		maxSize = 0;				// 최대 크기도 0으로 초기화
		heap = new int[maxSize];	// maxSize의 크기로 초기화
	}
	
	public Heap(int []tree) {		// 매개변수가 있는 생성자
		nNode = tree.length;		// 트리의 노드갯수로 초기화
		maxSize = tree.length;		// 매개변수 배열의 길이로 초기화한다
		heap = tree;				// 매개변수 배열을 복사
	}
	
	private void heapFull() {		// 힙이 최대크기일 때 (배열의 크기를 늘려야 할 때) 크기를 늘려주는 heapFull 메소드 
		maxSize++;					// 먼저 최대크기를 늘려주고 
		int tempHeap[] = new int[maxSize];		// 그 늘려준 maxSize 값으로 초기화해준다
		
		for(int i = 0; i < maxSize - 1; i++) {	// 반복문을 통해서
			tempHeap[i] = heap[i];				// 기존 배열을 복사
		}
		heap = tempHeap;						// 크기가 늘어난 배열로 초기화
	}
	
	public void insert(int item) {				// 힙에 값을 삽입하는 insert 메소드
		if(nNode == maxSize) heapFull();		// nNode와 maxSize와 같을 때, 즉 이진트리 배열이 다 찾다면 heapFull 호출 
		
		int i;									// 반복문 및 인덱스를 가리키기 위해 i 선언
		
		for(i = nNode; ; ) {					// 반복문을 통해 값을 삽입
			if(i == 0) {						// i가 루트 노드를 가리킨다면
				heap[0] = item;					// 루트에 삽입
				break;							// break로 반복문 탈출
			}
			
			if(item > heap[(i-1)/2]) {			// 삽입 하려는 노드 위치의 부모의 값보다 크다면 
				heap[i] = heap[(i-1)/2];		// 자식 노드에 부모 노드의 값을 저장하고
				i = (i-1)/2;					// i가 가리키는 위치를 부모로 바꿔주고
				heap[i] = item;					// 부모노드를 가리키는 위치에 item을 삽입
				continue;						// 반복문 반복
			}
			
			heap[i] = item;						// 조건문을 통해 부모 노드보다 값이 작으면	
			break;								// 그대로 값 삽입후 반복문 종료
		}
		// heap[i] = item;						// 반복문을 끝내고 여기서 삽입해도 된다.
		nNode++;								// 반복문을 통해 값이 추가되었다면 nNode 값 증가	
	}

	public int delete() {						// 맥스 힙의 원소를 삭제하는 delete 메소드
		if(nNode == 0)							// 공백 힙이면
			return -1;							// 메소드 비정상 종료
		
		int item = heap[0];						// item에 루트 노드의 값을 저장, 반복문 후에 삭제될 값을 가리킨다.
		int temp = heap[nNode-1];				// 마지막 값을 temp에 저장
		nNode--;								// nNode 감소
		
		int i = 0;								// 반복문에서 사용할 i,j 여기서 j는 i의 자식 노드이다.
		int j = 1;								// 루트 노드와 그 자식인 0과 1을 저장 
		
		while(j <= nNode) {						// 반복문을 통해 삭제 
			if(j < nNode)						// j가 최대 크기보다 작은지를 먼저 확인 
				if(heap[j] < heap[j+1])			// 왼쪽 자식 보다 오른쪽 자식이 크면 
					j++;						// 오른쪽 자식을 가리키도록 저장
			
			if(temp > heap[j]) break;			// temp가 힙의 마지막 값보다  큰 값이라면 break
			
			heap[i] = heap[j];					// 조건문에 해당하지 않으면 자식 노드를 부모로 이동
			i = j;								// i를 j로 초기화
			j = (j*2)+1; 						// j는 i의 자식이므로 2배를 해준다.
		}
		
		heap[i] = temp;							// 반복문 종료 후에 가리키는 i의 위치의 값에 현재 힙의 마지막 값인 temp를 저장
		maxSize--;								// maxSize 감소
		return item;							// item 반환으로 값 삭제
	}
	
	// 1014 7주차에서 작성, 다음 코드에 쓰는 것보다 6주차를 수정
	// 입력된 완전 이진트리가 0번 인덱스를 사용하는가 아닌가에 따라 메소드 전체 구조가 달라진다. 
	public void makeTreeHeap() {						// 완전 이진트리를 Heap으로 변환하는 makeTreeHeap 메소드
		int p,temp;										// 인덱스를 가리킬 p와 값 교환을 위해 선언한 temp 선언	
				
		for(int i = (nNode-1)/2; i >= 0; i--) {			// 중첩 반복문을 통해 힙 구조를 만든다.
			p = i;										// p에 i 값을 저장
			
			for(int j = (2*p)+1; j < nNode; j = (j*2)+1) {	// j는 p의 자식을 가리키고 반복할 때 마다 j는 j의 자식을 가리켜 준다.
				if(j < nNode)							// j가 최대 크기보다 작은지를 먼저 확인
					if( heap[j] < heap[j+1])			// 왼쪽 자식보다 오른쪽 자식이 크면
						j++;							// 오른쪽 자식을 가리키도록 저장
				
				if(heap[p] > heap[j]) break;			// 부모 노드의 값보다 자식 노드의 값이 작으면 break
				
				temp = heap[p];							// 그게 아니라면 부모와
				heap[p] = heap[j];						// 자식의 값을
				heap[j] = temp;							// 서로 바꿔주고
				p = j;									// p는 자식을 가리키도록 지정
			}
		}	
	}

	public void show() {						// 힙을 출력하는 show 메소드
		for(int i = 0; i < maxSize; i++) {		// 반복문을 통해 출력
			System.out.print(heap[i] + " | ");	
		}
		System.out.println();					// 모든 출력이 끝나면 줄바꿈
	}
}


/*
public class Heap {					// 최대힙을 나타내는 Heap 클래스 
	private int nNode;				// 현재 힙의 노드 갯수
	private int maxSize;			// 힙을 나타낼 배열의 최대 크기
	private int heap[];				// 힙을 나타낼 배열
	
	public Heap() {					// 디폴트 생성자
		nNode = 0;					// 노드 개수 0개
		maxSize = 1;				// 인덱스 0번을 사용하지 않아 현재 maxSize는 1이다.
		heap = new int[maxSize];	// 1의 크기로 초기화
	}
	
	public Heap(int []tree) {		// 매개변수가 있는 생성자
		nNode = tree.length - 1;	// 트리의 노드갯수로 초기화, 인덱스 0번을 쓰지 않으면  -1해서 저장
		maxSize = tree.length;		// 매개변수 배열의 길이로 초기화한다
		heap = tree;				// 매개변수 배열을 복사
	}
	
	private void heapFull() {		// 힙이 최대크기일 때 (배열의 크기를 늘려야 할 때) 크기를 늘려주는 heapFull 메소드 
		maxSize++;					// 먼저 최대크기를 늘려주고 
		int tempHeap[] = new int[maxSize];		// 그 늘려준 maxSize 값으로 초기화해준다
		
		for(int i = 0; i < maxSize - 1; i++) {	// 반복문을 통해서
			tempHeap[i] = heap[i];				// 기존 배열을 복사
		}
		heap = tempHeap;						// 크기가 늘어난 배열로 초기화
	}
	
	public void insert(int item) {				// 힙에 값을 삽입하는 insert 메소드
		if(nNode + 1 == maxSize) heapFull();	// 노드 + 1이 maxSize와 같을 때, 즉 이진트리 배열이 다 찾다면 heapFull 호출 
		
		int i;		// 반복문 및 인덱스를 가리키기 위해 i 선언
		
		for(i = nNode + 1; ; ) {				// 반복문을 통해 값을 삽입
			if(i == 1) {						// i가 루트 노드를 가리킨다면(인덱스 0번을 비워둠) 
				heap[1] = item;					// 루트에 삽입
				break;							// break로 반복문 탈출
			}
			
			if(item > heap[i/2]) {				// 삽입 하려는 노드 위치의 부모의 값보다 크다면 
				heap[i] = heap[i/2];			// 자식 노드에 부모 노드의 값을 저장하고
				i = i/2;						// i가 가리키는 위치를 부모로 바꿔주고
				heap[i] = item;					// 부모노드를 가리키는 위치에 item을 삽입
				continue;						// 반복문 반복
			}
			
			heap[i] = item;						// 조건문을 통해 부모 노드보다 값이 작으면	
			break;								// 그대로 값 삽입후 반복문 종료
		}
		// heap[i] = item;						// 반복문을 끝내고 여기서 삽입해도 된다.
		nNode++;								// 반복문을 통해 값이 추가되었다면 nNode 값 증가	
	}

	public int delete() {						// 맥스힙의 원소를 삭제하는 delete 메소드
		if(nNode == 0)							// 공백 힙이면
			return -1;							// 메소드 비정상 종료
		
		int item = heap[1];						// item에 루트 노드의 값을 저장, 반복문 후에 삭제될 값을 가리킨다.
		int temp = heap[nNode];					// 마지막 값을 temp에 저장
		nNode--;								// nNode 감소
		
		int i = 1;								// 반복문에서 사용할 i,j 여기서 j는 i의 자식 노드이다.
		int j = 2;								// 0번 인덱스를 사용하지 않기 때문에 1번과 2번을 저장
		
		while(j <= nNode) {						// 반복문을 통해 삭제 
			if(j < nNode)						// j가 최대 크기보다 작은지를 먼저 확인 
				if(heap[j] < heap[j+1])			// 왼쪽 자식 보다 오른쪽 자식이 크면 
					j++;						// 오른쪽 자식을 가리키도록 저장
			
			if(temp > heap[j]) break;			// temp가 힙의 마지막 값보다  큰 값이라면 break
			
			heap[i] = heap[j];					// 조건문에 해당하지 않으면 자식 노드를 부모로 이동
			i = j;								// i를 j로 초기화
			j *= 2; 							// j는 i의 자식이므로 2배를 해준다.
		}
		
		heap[i] = temp;							// 반복문 종료 후에 가리키는 i의 위치의 값에 현재 힙의 마지막 값인 temp를 저장
		maxSize--;								// maxSize 감소
		return item;							// item 반환으로 값 삭제
	}
	
	// 1014 7주차에서 작성, 다음 코드에 쓰는 것보다 6주차를 수정
	// 입력된 완전 이진트리가 0번 인덱스를 사용하는가 아닌가에 따라 메소드 전체 구조가 달라진다. 
	public void makeTreeHeap() {						// 완전 이진트리를 Heap으로 변환하는 makeTreeHeap 메소드
		int p,temp;										// 인덱스를 가리킬 p와 값 교환을 위해 선언한 temp 선언	
				
		for(int i = nNode/2; i >= 1; i--) {				// 중첩 반복문, 인덱스 0번을 쓰지 않아 nNode/2 로 인덱스를 지정, 1번보다 크다면 반복
			p = i;										// p에 i 값을 저장
			
			for(int j = 2 * p; j <= nNode; j *= 2) {	// j는 p의 자식을 가리키고 반복할 때 마다 j는 2배씩 커진다.
				if(j < nNode)							// j가 최대 크기보다 작은지를 먼저 확인
					if( heap[j] < heap[j+1])			// 왼쪽 자식보다 오른쪽 자식이 크면
						j++;							// 오른쪽 자식을 가리키도록 저장
				
				if(heap[p] > heap[j]) break;			// 부모 노드의 값보다 자식 노드의 값이 작으면 break
				
				temp = heap[p];							// 그게 아니라면 부모와
				heap[p] = heap[j];						// 자식의 값을
				heap[j] = temp;							// 서로 바꿔주고
				p = j;									// p는 자식을 가리키도록 지정
			}
		}	
	}

	public void show() {						// 힙을 출력하는 show 메소드
		for(int i = 1; i < maxSize; i++) {		// 반복문을 통해 출력
			System.out.print(heap[i] + " | ");	
		}
		System.out.println();					// 모든 출력이 끝나면 줄바꿈
	}
}
*/