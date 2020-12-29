package WGraph;

public class MinHeap {								// �ּ����� ���ϴ� MinHeap
	private int nNode;								// ���� ����� ���� nNode
	private int maxSize;							// �ִ� ũ���� maxSize
	private Edge[] heap;							// ���� ����Ű�� Edge �迭 heap
	
	public MinHeap() {								// ����Ʈ ������
		this.nNode = 1;								// nNode�� 1�� �ʱ�ȭ
		this.maxSize = 6;							// maxSize�� 6���� �ʱ�ȭ
		this.heap = new Edge[maxSize];				// heap�� 6�� ũ��� �ʱ�ȭ
	}
	
	public void heapFull() {						// ���� ���� ã�ٸ� ���� �ø��� heapFull �޼ҵ�
		maxSize++;									// ���� maxSize ����
		Edge[] temp = new Edge[maxSize];			// ������ maxSize�� ũ�⸦ ���� temp ���� �� �ʱ�ȭ
		for(int i = 1; i < maxSize - 1; i++) {		// �ݺ����� ����
			temp[i] = heap[i];						// ���� ���� ������ ����
		}
		heap = temp;								// heap�� temp�� �ʱ�ȭ
	}
	
	public void insert(Edge item) {					// ���� �Է��ϴ� insert �޼ҵ�
		int i;										// �ݺ������� ������ ����Ű�� i
		
		if(nNode == maxSize) heapFull();			// ���� �ִ�ũ���� heapHull ȣ��
		
		for(i = nNode; ; ) {						// �ݺ����� ���� ���� �߰�
			if(i == 1) break;						// i�� ��Ʈ ��带 ����Ű�� break
			if(item.compareTo(heap[i/2]) >= 0) break;	// �θ� ���� ���ؼ� ���� �� ũ�ų� ���ٸ� �ݺ��� Ż�� 
			heap[i] = heap[i/2];					// ���� �� ���ǿ� �ش����� ������ �θ� ���� �ʱ�ȭ  
			i = i/2;								// i�� i/2�� �ʱ�ȭ
		}		
		heap[i] = item;								// �ݺ��� ������ i�� ��ġ�� item ����
		nNode++;									// nNode ����
	}
	
	public Edge delete() {							// ���� �����ϴ� delete �޼ҵ�
		if(nNode == 0) return null;					// nNode�� 0�̸� null�� ��ȯ
		
		Edge item = heap[1];						// item�� ��Ʈ ��带 ����
		Edge temp = heap[nNode-1];					// temp�� �̵���ų ���� ���� 
		nNode--;
		
		int i = 1;									// �ݺ������� ����� i,j�� 
		int j = 2;									// ���� 1,2�� �ʱ�ȭ
		
		while(j <= nNode) {							// �ݺ����� ���� ����
			if(j < nNode) {							// j�� Node ���� ���� �ε����̸�
				if(heap[j + 1].compareTo(heap[j]) < 0 ) j++;	// ������ �ڽİ� ���� �ڽ��� ���� �� ���� ������ j ��ġ ����
			}
			if(temp.compareTo(heap[j]) <= 0) break;	// temp���� j�� ū ���̶�� break;
			
			heap[i] = heap[j];						// ���ǹ��� �ش����� ������ i�� ���� j�� ������ �ʱ�ȭ
			i = j;									// i�� j�� �ʱ�ȭ
			j = j * 2;								// j�� j�� �ڽ����� �ʱ�ȭ
		}	
		heap[i] = temp;								// �ݺ����� ������ heap[i]���� temp����
		return item;								// item�� ���� �ϸ鼭 �޼ҵ� ����
	}
	
	public int numberElements() {					// nNode getter�� ������ �ϴ� numberElements �޼ҵ�
		return nNode;								// nNode�� ��ȯ�Ѵ�.
	}
	
}
