/*  알고리즘 10주차 
 * 	WGraph.java main.java   
 *  작성일 : 2020.11.5~6, 12~13
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : Dijkstra 알고리즘을 확인하는 프로그램
 */
package WGraph;

public class WGraph {										// WGraph 클래스
	private int vertex_size;								// 정점의 개수
	private int [][] weights;								// 가중치 그래프를 나타내는 인접행렬인 2차원 배열 weights
			
	public WGraph(int vertex_size) {						// 정점의 개수를 매개변수로 하는 생성자
		this.weights = new int[vertex_size][vertex_size];	// 2차원 배열 weights를 초기화
		this.vertex_size = vertex_size;						// 매개변수 값을 vertex_size로 초기화
		
		for(int i = 0; i < this.vertex_size; i++) {			// 중첩 반복문을 통해 2차원 배열 초기화 
			for(int j = 0; j < this.vertex_size; j++) {		
				if(i == j) weights[i][j] = 0;				// 정점 자기 자신을 가리키면 0을 저장
				else weights[i][j] = 999;					// 그게 아니라면 999를 저장
			}
		}
	}
	
	public void insertEdge(int i, int k, int w) {			// 가중치 그래프에 간선을 추가하는 insertEdge 메소드
		if(weights[i][k] == 999) {							// 간선이 없다면 
			weights[i][k] = w;								// 매개변수로 들어온 w(가중치)로 초기화
		}
	}
	
	public void print() {									// 가중치 그래프를 출력하는 print 메소드
		for(int i = 0; i < vertex_size; i++) {				// 중첩 반복문을 통해 출력
			for(int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);
			}
			System.out.println();
		}
	}
	
	public void shorttestPath(int v) {						// Dijkstra 알고리즘을 통해 가장 짧은 가중치의 경로를 구하는 shorttestPath 메소드
		boolean[] s = new boolean[vertex_size];				// 정점의 방문을 확인하는 boolean 배열 s 생성 
		int[] dist = new int[vertex_size];					// 가중치 값을 저장할 dist배열 생성  
		
		for(int i = 0; i < vertex_size; i++) {				// 반복문을 통해 각각의 배열 값을 초기화
			s[i] = false;
			dist[i] = weights[v][i];						// 매개변수 정점 v와 연결된 간선의 가중치만큼 초기화
		}
		
		s[v] = true;										// v에서 시작하므로 v는 방문한것이나 다름없으니 s[v] = true
		dist[v] = 0;										// 마찬가지로 v에서 v로 가지 않기 때문에 0으로 저장
		
		for(int i = 0 ; i < vertex_size - 2; i++) {			// 반복문을 통해 알고리즘 구현
			int u = -1;										// 정점 값을 저장할 u
			int min = 999;									// 최솟값을 저장할 min
			
			for(int j = 0; j < vertex_size; j++) {			// 반복문을 통해 어느 정점을 사용할지 선택
				if(s[j] == false &&  dist[j] < min) { 		// j 정점을 방문하지 않았고 min보다 작은 값의 가중치를 갖고 있으면
					u = j;									// 그 정점을 선택
					min = dist[j];							// 가중치 값도 (초기화)선택해준다.
				}
			}
			s[u] = true;									// 반복문을 통해 정점을 선택했으니 그 정점을 방문하므로 true
			
			for(int w = 0; w < vertex_size; w++) {			// 반복문을 통해 더 짧은 가중치의 합이 있는지 확인한다.
				if(s[w] == false) {							// 다른 정점을 통해 방문했을 때,
					if(dist[w] > dist[u] + weights[u][w]) {	// 그 정점에 가는 가중치보다 다른 정점을 통해 가는 가중치의 합이 작다면
						dist[w] = dist[u] + weights[u][w];	// 그 가중치의 합으로 초기화
					}
				}
			}
			System.out.printf("===== STAGE %d =====", (i+1));// 알고리즈 동작 횟수
			System.out.println("\nselect vertex : " + u);	
			
			for(int k = 0; k < vertex_size; k++) {			// 알고리즘을 통해 확인한 dist 출력
				System.out.print(dist[k] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
