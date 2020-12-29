/*  알고리즘 11주차 Bellman and Ford, 모든 정점 쌍의 최단 경로 
 * 	WGraph.java Main.java   
 *  작성일 : 2020.11.12, 15~16
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : BellmanFord 알고리즘과 모든 정점 쌍의 최단 경로를 확인하는 프로그램
 */
package WGraph;

public class WGraph {										// 가중치 그래프 WGraph 클래스
	private int vertex_size;								// 정점개수
	private int [][] weights;								// 가중치를 나타내는 2차원 배열 weights
	
	public WGraph(int vertex_size) {						// 생성자
		this.weights = new int[vertex_size][vertex_size];	// 매개변수 vertex_size의 크기로 배열의 크기 초기화
		this.vertex_size = vertex_size;						// 매개변수 값으로 vetex_size 초기화
		
		for(int i = 0; i < this.vertex_size; i++) {			// 중첩 반복문을 통해 2차원 배열 초기화
			for(int j = 0; j < this.vertex_size; j++) {	 
				if(i == j) weights[i][j] = 0;				// 같은 정점을 가리키는 값에 대해서는 0으로 지정
				else weights[i][j] = 999;					// 그 외 다른 모든 가중치는 999로 지정
			}
		}
	}
	
	public void insertEdge(int i , int j, int w) {			// 간선을 추가하는 insertEdge 메소드
		if(weights[i][j] == 999) {							// i와 j 사이의 간선이 없으면 
			weights[i][j] = w;								// 가중치 w로 초기화 해준다.
		}
	}
	
	public void BellmanFord(int v) {						// BellmanFord 알고리즘으로 최단경로를 찾는 메소드
		int []dist = new int[vertex_size];					// 시작정점 v에서의 최단 경로 길이를 저장할 배열 dist 
		
		for(int i = 0; i < vertex_size; i++) {				// 반복문을 통해
			dist[i] = weights[v][i];						// 정점 v의 간선의 가중치를 dist 배열에 저장 -> dist(1)
		}
		
		for(int k = 2; k < vertex_size; k++) {				// dist(2) 부터 구하므로 k=2 시작한다.
			for(int u = 0; u < vertex_size; u++ ) {			// 모든 정점에 대해 
				if(u != v) {								// 같은 정점을 제외하고
					for(int i = 0; i < vertex_size; i++) {	
						if(weights[i][u] != 0 || weights[i][u] != 999) {	// i와 u사이의 간선이 있고
							if(dist[u] > dist[i] + weights[i][u]) {			// 더 짧은 경로를 찾으면 
								dist[u] = dist[i] + weights[i][u];			// 그 값으로 가중치 합을 계산
							}
						}
					}
				}
					
			}
		}
		System.out.println("\n===== Best PATH =====");		// 결과 출력
		for(int i = 0; i < vertex_size; i++) {				// 각 정점까지의 최단 경로를 출력한다.
			System.out.print(dist[i] + " ");				// 
		}
		System.out.println();
	}
	
	public void allShortestPath() {							// 모든 정점 쌍의 최단 경로를 찾는 allShortestPath 메소드
		int [][]dist = new int[vertex_size][vertex_size];	// 가중치 인접행렬 dist 생성 및 초기화
		int i, j, k;							
		
		for(i = 0; i < vertex_size; i++) {					// 중첩 반복문을 통해
			for(j = 0; j <vertex_size; j++) { 				
				dist[i][j] = weights[i][j];					// 가중치 인접 행렬 복사
			}
		}
		
		for(k = 0; k < vertex_size; k++) {					// 중간 정점으로 0에서 정점의 개수까지 사용하는 경로
			System.out.printf("Stage : %d\n", k);			// 반복 횟수에 대한 출력 
			for(i = 0;  i < vertex_size; i++ ) {			// 모든 가능한 시작점과 
				for(j = 0; j < vertex_size; j++) {			// 모든 가능한 종점에 대해 반복	 
					if(dist[i][j] > (dist[i][k] + dist[k][j])) {	// 더 짧은 경로 검사
						dist[i][j] = dist[i][k] + dist[k][j];
					}
					System.out.printf("[ %3d ]", dist[i][j]);	// 각 정점에 대한 가중치 계산이 끝나면 값 출력
				} 
				System.out.println();
			}
		}
	}
	
	public void print() {									// 가중치 그래프를 출력하는 print 메소드
		for(int i = 0; i < vertex_size; i++) {				// 중첩 반복문을 통해 출력
			for(int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);	// 그래프 인접 행렬 출력
			}
			System.out.println();
		}
	}
}
