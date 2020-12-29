package WGraph;

public class WGraph {
	private int vertex_size;							// ������ ���� ��Ÿ���� vertex_size	
	private int e;										// ���� ���� ���� e
	private int[][] weights;							// ����ġ���� ������ 2���� �迭 weights
	
	public WGraph(int vertex_size) {					// WGraph ������
		this.weights = new int[vertex_size][vertex_size];	// �Ű�������ŭ 2���� �迭�� �ʱ�ȭ
		this.vertex_size = vertex_size;					// �Ű����� ������ vertex_size �ʱ�ȭ
		e = 0;											// ���� �������� 0 
		for(int i = 0; i < this.vertex_size; i++) {		// �ݺ����� ���� 2���� �迭 �ʱ�ȭ
			for(int j = 0; j < this.vertex_size; j++) {
				if(i == j) weights[i][j] = 0;			// ���� ������ ����Ű�� ������ 0���� ����
				else weights[i][j] = -1;				// �ٸ� ������ ����Ű�� -1�� �ʱ�ȭ
			}
		}
	}
	
	public void insertEdge(int i, int k, int w) {		// ������ �߰��ϴ� insertEdge �޼ҵ�
		if(weights[i][k] == -1 && weights[k][i] == -1) {// ������ ����Ǿ� ���� ������
			weights[i][k] = w;							// ����ġ w������ ������ �߰��Ѵ�.
			weights[k][i] = w;		
			e++;										// ���� ���� ���� ����
		}
	}
		
	public void print() {								// ����ġ �׷����� ����ϴ� print �޼ҵ�
		for(int i = 0; i < vertex_size; i++) {			// ��ø �ݺ����� ���� ���
			for(int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);
			}
			System.out.println();
		}
	}
	
	public Edge[] kruskal() {							// kruscal �˰����� ���� �ּ� ��� ���� �����ϴ� kruscal �޼ҵ�
		Edge[] T = new Edge[vertex_size - 1];			// Edge �迭 T ���� �� �ʱ�ȭ
		MinHeap edgeList = new MinHeap();				// �ּ� ���� ����Ű�� edgeList ���� �� �ʱ�ȭ
		
		for(int i = 0; i < vertex_size; i++) {			// ��ø �ݺ����� ���� �ּ��� ����
			for(int j = i + 1; j < vertex_size; j++) {
				if(weights[i][j] != -1) {				// ����ġ�� �ִ� ������ Ȯ�εǸ�
					Edge item = new Edge(i, j, weights[i][j]);	// �� ������ ���� Edge��
					edgeList.insert(item);				// �ּ����� �߰��Ѵ�.
				}
			}
		}
		
		UnionFind u = new UnionFind(vertex_size);		// Unionfind ���� �� vertex_size��ŭ �ʱ�ȭ
		int p = -1;										// p�� -1�� ����
		
		while(p < vertex_size -2 && edgeList.numberElements() > 0) {// vertex_size-2 ���� p���� ũ�� �ּ����� �����ϸ� �ݺ� 
			Edge e = edgeList.delete();					// �ּ������� ������ ���� Edge�� ����
			if(!u.find(e.getStart(), e.getEnd())) {		// ������ ���۰� ���� �ٸ��ٸ�
				p++;									// p ����
				T[p] = e;								// ���� e�� T[p]�� ����
				u.union(e.getStart(), e.getEnd());		// ���۰� ���� ����(�ش��ϴ� ����)�� union�� ���� �����Ѵ�.
			}
		}
		return T;										// T ��ȯ
	}
	
	////// Prim �˰��� (201113 �ۼ� �ƹ��� �����ص� �ʹ� �����ϰ� �ڵ��� �� ���� ���� �ٽ� ������ ��.) 

	public Edge[] prim(int i) {							// Prim �˰����� ���� �ּ� ������ ã�� prim �޼ҵ�
		Edge[] T = new Edge[vertex_size];				// ��ȯ�� Edge �迭 T���� �� �ʱ�ȭ
		int Tptr = -1;									// T�� �ε����� ����ų Tptr 
		
		MinHeap edgeList = new MinHeap();				// �ּ��� edgeList 
		
		UnionFind uf = new UnionFind(vertex_size);		// UnionFind u ���� �� ����
		
		for(int j = 0; j < vertex_size; j++) {			// �ݺ����� ����  �Ű����� ����(i)�� ���� ������ Ȯ���Ѵ�.
			if(weights[i][j] != -1)						// ������ ����ġ�� �ִٸ�
				edgeList.insert(new Edge(i, j, weights[i][j]));	// �ּ����� �߰�, ���⼭ 0 -> 0�� ���ԵǴ� ���� ���� 
		}
	
		while(Tptr < vertex_size - 2 ) {				// Tptr�� vertex_size-2  ���� ������ �ݺ�
			Edge e = edgeList.delete();					// �ּ����� delete�� ���� ���� ����
			
			if(!uf.find(e.getStart(), e.getEnd())) {	// ���� ������ �� ������ �ٸ���
				Tptr++;									// Tptr ����
				T[Tptr] = e;							// ���� �ε����� ���� �߰�
				uf.union(e.getStart(), e.getEnd());		// ���� e�� ���� ���� ������ �� ������ union�� ���� �����Ѵ�. 
				for(int j = 0; j < vertex_size; j++) {	// �ٽ� �ݺ����� ���� �ּ����� �����Ѵ�.
					if(weights[e.getEnd()][j] != -1)	// �� ������ ����� ������ Ȯ���ؼ�
						edgeList.insert(new Edge(e.getEnd(), j, weights[e.getEnd()][j]));	// ��  ������ �ּ����� �߰��Ѵ�. 
				}
			}
		}
		
		return T;
	}
}
