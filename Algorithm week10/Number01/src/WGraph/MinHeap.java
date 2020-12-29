package WGraph;

public class MinHeap {								// 최소힙을 뜻하는 MinHeap
	private int nNode;								// 현재 노드의 갯수 nNode
	private int maxSize;							// 최대 크기인 maxSize
	private Edge[] heap;							// 힙을 가리키는 Edge 배열 heap
	
	public MinHeap() {								// 디폴트 생성자
		this.nNode = 1;								// nNode는 1로 초기화
		this.maxSize = 6;							// maxSize는 6으로 초기화
		this.heap = new Edge[maxSize];				// heap은 6의 크기로 초기화
	}
	
	public void heapFull() {						// 힙이 가득 찾다면 힙을 늘리는 heapFull 메소드
		maxSize++;									// 먼저 maxSize 증가
		Edge[] temp = new Edge[maxSize];			// 증가된 maxSize의 크기를 가진 temp 생성 및 초기화
		for(int i = 1; i < maxSize - 1; i++) {		// 반복문을 통해
			temp[i] = heap[i];						// 기존 힙의 내용을 복사
		}
		heap = temp;								// heap을 temp로 초기화
	}
	
	public void insert(Edge item) {					// 값을 입력하는 insert 메소드
		int i;										// 반복문에서 정점을 가리키는 i
		
		if(nNode == maxSize) heapFull();			// 만약 최대크기라면 heapHull 호출
		
		for(i = nNode; ; ) {						// 반복문을 통해 값을 추가
			if(i == 1) break;						// i가 루트 노드를 가리키면 break
			if(item.compareTo(heap[i/2]) >= 0) break;	// 부모 노드와 비교해서 값이 더 크거나 같다면 반복문 탈출 
			heap[i] = heap[i/2];					// 위의 두 조건에 해당하지 않으면 부모 노드로 초기화  
			i = i/2;								// i는 i/2로 초기화
		}		
		heap[i] = item;								// 반복문 종료후 i의 위치에 item 저장
		nNode++;									// nNode 증가
	}
	
	public Edge delete() {							// 값을 삭제하는 delete 메소드
		if(nNode == 0) return null;					// nNode가 0이면 null을 반환
		
		Edge item = heap[1];						// item에 루트 노드를 저장
		Edge temp = heap[nNode-1];					// temp는 이동시킬 값을 저장 
		nNode--;
		
		int i = 1;									// 반복문에서 사용할 i,j를 
		int j = 2;									// 각각 1,2로 초기화
		
		while(j <= nNode) {							// 반복문을 통해 삭제
			if(j < nNode) {							// j가 Node 보다 작은 인덱스이면
				if(heap[j + 1].compareTo(heap[j]) < 0 ) j++;	// 오른쪽 자식과 왼쪽 자식을 비교해 더 작은 값으로 j 위치 저장
			}
			if(temp.compareTo(heap[j]) <= 0) break;	// temp보다 j가 큰 값이라면 break;
			
			heap[i] = heap[j];						// 조건문에 해당하지 않으면 i의 값에 j의 값으로 초기화
			i = j;									// i는 j로 초기화
			j = j * 2;								// j는 j의 자식으로 초기화
		}	
		heap[i] = temp;								// 반복문이 끝나면 heap[i]값에 temp저장
		return item;								// item을 리턴 하면서 메소드 종료
	}
	
	public int numberElements() {					// nNode getter의 역할을 하는 numberElements 메소드
		return nNode;								// nNode를 반환한다.
	}
	
}
