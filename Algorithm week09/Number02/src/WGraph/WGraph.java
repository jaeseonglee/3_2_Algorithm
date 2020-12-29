package WGraph;

public class WGraph {									// 가중치 그래프를 나타내는 WGraph
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

	
}
