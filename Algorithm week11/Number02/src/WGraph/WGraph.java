/*  알고리즘 11주차 이행적 폐쇄 
 * 	WGraph.java main.java   
 *  작성일 : 2020.11.12, 15~16
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 이행적 폐쇄를 확인하는 프로그램
 */
package WGraph;

public class WGraph {									
	private int vertex_size;								// 정점의 개수
	private boolean[][] matrix;								// 그래프를 뜻하는 boolean형 인접 행렬  matrix
	
	public WGraph(int vertex_size) {						// 생성자
		this.matrix = new boolean[vertex_size][vertex_size];// vertex_size 만큼 배열 크기 초기화
		this.vertex_size = vertex_size;						// 매개변수만큼 vertex_size 초기화
		
		for(int i = 0; i < this.vertex_size; i++) {			// 중첩 반복문을 통해 배열 초기화 
			for(int j = 0; j < this.vertex_size; j++) {		
				matrix[i][j] = false;						// 모든 값을 false로 초기화
			}
		}
	}
	
	public void insertEdge(int i, int j) {					// 간선을 추가하는 isnertEdge 메소드
		if(!matrix[i][j])									// i와 j 사이에 간선이 없으면
			matrix[i][j] = true;							// 추가해준다
	}

	public void allShortestPath() {							// 모든 정점 쌍의 최단 경로를 통해 이행적 폐쇄 그래프의 최단 경로를 찾는 allShortestPath 메소드
		boolean[][] dist = new boolean[vertex_size][vertex_size];	// 인접 행렬 dist 생성 및 초기화
		int i, j, k;
		
		for(i = 0; i < vertex_size; i++) {					// 중첩 반복문을 통해
			for(j = 0; j < vertex_size; j++) {
				dist[i][j] = matrix[i][j];					// matrix의 값을 복사
			}
		}
		
		for(k = 0; k < vertex_size; k++) {					// 3중 반복문을 통해			
			for(i = 0; i < vertex_size; i++) { 				// 정점 i에서 j까지 갈 수 있는 경로를 찾는다면
				for(j = 0; j < vertex_size; j++) {			// i에서 j까지 가는 방법이 있으므로
					if(dist[i][k] && dist[k][j])			// dist[i][j]는 true 값으로 초기화
						dist[i][j] = true;
				}
			}
		}
		
		System.out.println("============ D+ ============");	//이행적 폐쇄 행렬, 즉 i에서 j까지 길이가 0보다 큰 경로를 출력
			
		for(i = 0; i < vertex_size; i++) {					// 중첩 반복문을 통해	
			for(j = 0; j < vertex_size; j++) {				// 인접 행렬 출력
				System.out.printf("[ %5b ]", dist[i][j]);	
			}
			System.out.println();
		}
		
		for(k = 0; k < vertex_size; k++) {					// 반사 이행적 폐쇄 행렬을 나타내기 위해 다시 3중 반복
			for(i = 0; i < vertex_size; i++) {
				for(j = 0; j <vertex_size; j++) {			// OR 연산을 통해 자기 자신을 가리키는 경로가 있다면
					if(dist[i][k] || dist[k][j])			// 자기 자신에 대한 간선이 있다는 것으로 취급하여
						dist[i][i] = true;					// 자기 자신을 가리키는 인접 행렬에 대해 true로 초기화
				}
			}
		}
		
		System.out.println("============ D* ============");	// 반사 이행적 폐쇄 행렬, 즉 i i에서 j까지 길이가 0이상인 경로를 출력
		for(i = 0; i < vertex_size; i++) {					// 중첩 반복문을 통해
			for(j = 0; j < vertex_size; j++) {				
				System.out.printf("[ %5b ]", dist[i][j]);	// 인접 행렬 출력
			}
			System.out.println();
		}
	}
	
	public void print() {
		for(int i = 0; i < vertex_size; i++) {
			for(int j = 0; j <vertex_size; j++) {
				System.out.printf("[ %5b ]", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
