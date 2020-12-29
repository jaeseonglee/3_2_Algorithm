/*  알고리즘 7주차 그래프 (해당 코드는 무방향 그래프만을 다룬다) 
 * 	Graph.java, Main.java, Node.java, Vertex_graph.java, Vertex_graph_main.java 
 *  작성일 : 2020.10.15~16
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 그래프를 인접행렬과 인접 리스트를 통해 나타낸 프로그램
 */

package Graph;

public class Graph {						// 무방향 그래프를 나타내는 인접행렬 클래스
	private int[][] matrix;					// 인접행렬을 저장할 2차원 배열matrix 
	private int size;						// 배열의 크기 size
	
	public Graph(int size) {				// Graph 생성자
		this.matrix = new int[size][size];	// 매개변수 size로 배열을 초기화
		this.size = size;					// size에 매개변수 size로 초기화
	}
	
	public void add(int i, int k ) {		// 정점 i, k에 대해 간선을 추가하는 add 메소드
		matrix[i][k] = 1;					// i에 대해 k를 이어주고
		matrix[k][i] = 1;					// k에 대해 i를 이어준다.
	}
	
	public void delete(int i, int k) {		// 정점 i, k에 대해 간선을 제거하는 delete 메소드
		matrix[i][k] = 0;					// i에 대해 k를 삭제하고
		matrix[k][i] = 0;					// k에 대해 i를 삭제해준다.
	}
	
	public void show() {					// 인접 행렬 그래프를 출력하는 show 메소드 
		if(this.size == 0) {				// 그래프의 크기가 0이라면 
			System.out.println("No Matrix");// 메소드 종료
			return ;
		}
		
		for(int i = 0; i < size; i++) {		// 중첩 반복문을 통해 출력
			String temp = "";
			for(int j = 0; j < size; j++) {	
				if(this.matrix[i][j] == 1) {// 해당 인덱스의 값이 1이라면 연결 되어있기 때문에
					temp += j + " ";		// temp에 해당 인덱스를 추가한다
				}
			}
			if(!temp.equals("")) {			// temp가 안쪽의 반복문을 통해 다른 값이 있다면
				System.out.println(i + " : " + temp);	// 연결된 정점 출력
			}
		}
	}
}
