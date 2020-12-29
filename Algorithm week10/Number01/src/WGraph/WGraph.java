package WGraph;

public class WGraph {
	private int vertex_size;							// 정점의 수를 나타내는 vertex_size	
	private int e;										// 현재 간선 갯수 e
	private int[][] weights;							// 가중치들을 저장할 2차원 배열 weights
	
	public WGraph(int vertex_size) {					// WGraph 생성자
		this.weights = new int[vertex_size][vertex_size];	// 매개변수만큼 2차원 배열을 초기화
		this.vertex_size = vertex_size;					// 매개변수 값으로 vertex_size 초기화
		e = 0;											// 현재 간선갯수 0 
		for(int i = 0; i < this.vertex_size; i++) {		// 반복문을 통해 2차원 배열 초기화
			for(int j = 0; j < this.vertex_size; j++) {
				if(i == j) weights[i][j] = 0;			// 같은 정점을 가리키지 않으니 0으로 지정
				else weights[i][j] = -1;				// 다른 정점을 가리키면 -1로 초기화
			}
		}
	}
	
	public void insertEdge(int i, int k, int w) {		// 간선을 추가하는 insertEdge 메소드
		if(weights[i][k] == -1 && weights[k][i] == -1) {// 간선이 연결되어 있지 않으면
			weights[i][k] = w;							// 가중치 w값으로 간선을 추가한다.
			weights[k][i] = w;		
			e++;										// 현재 간선 갯수 증가
		}
	}
		
	public void print() {								// 가중치 그래프를 출력하는 print 메소드
		for(int i = 0; i < vertex_size; i++) {			// 중첩 반복문을 통해 출력
			for(int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);
			}
			System.out.println();
		}
	}
	
	public Edge[] kruskal() {							// kruscal 알고리즘을 통해 최소 비용 간선 선택하는 kruscal 메소드
		Edge[] T = new Edge[vertex_size - 1];			// Edge 배열 T 선언 및 초기화
		MinHeap edgeList = new MinHeap();				// 최소 힙을 가리키는 edgeList 선언 및 초기화
		
		for(int i = 0; i < vertex_size; i++) {			// 중첩 반복문을 통해 최소힙 구성
			for(int j = i + 1; j < vertex_size; j++) {
				if(weights[i][j] != -1) {				// 가중치가 있는 간선이 확인되면
					Edge item = new Edge(i, j, weights[i][j]);	// 그 간선에 대한 Edge를
					edgeList.insert(item);				// 최소힙에 추가한다.
				}
			}
		}
		
		UnionFind u = new UnionFind(vertex_size);		// Unionfind 선언 및 vertex_size만큼 초기화
		int p = -1;										// p에 -1을 저장
		
		while(p < vertex_size -2 && edgeList.numberElements() > 0) {// vertex_size-2 값이 p보다 크고 최소힙이 존재하면 반복 
			Edge e = edgeList.delete();					// 최소힙에서 삭제된 값을 Edge에 저장
			if(!u.find(e.getStart(), e.getEnd())) {		// 간선의 시작과 끝이 다르다면
				p++;									// p 증가
				T[p] = e;								// 간선 e를 T[p]에 저장
				u.union(e.getStart(), e.getEnd());		// 시작과 끝의 정점(해당하는 간선)을 union을 통해 저장한다.
			}
		}
		return T;										// T 반환
	}
	
	////// Prim 알고리즘 (201113 작성 아무리 생각해도 너무 복잡하게 코딩한 것 같아 이후 다시 참고할 것.) 

	public Edge[] prim(int i) {							// Prim 알고리즘을 통해 최소 간선을 찾는 prim 메소드
		Edge[] T = new Edge[vertex_size];				// 반환할 Edge 배열 T생성 및 초기화
		int Tptr = -1;									// T의 인덱스를 가리킬 Tptr 
		
		MinHeap edgeList = new MinHeap();				// 최소힙 edgeList 
		
		UnionFind uf = new UnionFind(vertex_size);		// UnionFind u 선언 및 생성
		
		for(int j = 0; j < vertex_size; j++) {			// 반복문을 통해  매개변수 정점(i)에 대한 간선을 확인한다.
			if(weights[i][j] != -1)						// 간선의 가중치가 있다면
				edgeList.insert(new Edge(i, j, weights[i][j]));	// 최소힙에 추가, 여기서 0 -> 0도 포함되는 것을 유의 
		}
	
		while(Tptr < vertex_size - 2 ) {				// Tptr이 vertex_size-2  보다 작으면 반복
			Edge e = edgeList.delete();					// 최소힙의 delete를 통해 간선 추출
			
			if(!uf.find(e.getStart(), e.getEnd())) {	// 시작 정점과 끝 정점이 다르면
				Tptr++;									// Tptr 증가
				T[Tptr] = e;							// 현재 인덱스에 간선 추가
				uf.union(e.getStart(), e.getEnd());		// 간선 e에 대한 시작 정점과 끝 정점을 union을 통해 저장한다. 
				for(int j = 0; j < vertex_size; j++) {	// 다시 반복문을 통해 최소힙을 구성한다.
					if(weights[e.getEnd()][j] != -1)	// 끝 정점에 연결된 간선을 확인해서
						edgeList.insert(new Edge(e.getEnd(), j, weights[e.getEnd()][j]));	// 그  간선을 최소힙에 추가한다. 
				}
			}
		}
		
		return T;
	}
}
