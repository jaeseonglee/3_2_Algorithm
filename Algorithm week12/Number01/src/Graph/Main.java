package Graph;

public class Main {
	public static void main(String args[]) {	// main 메소드
		Graph AOV = new Graph(6);				// AOV 생성 및 정점 6개로 초기화
		
		AOV.insertEdge(0, 1);					// 0 1 간선 추가
		AOV.insertEdge(0, 2);					// 0 2 간선 추가
		
		AOV.insertEdge(1, 3);					// 1 3 간선 추가
		AOV.insertEdge(1, 4);					// 1 4 간선 추가
		
		AOV.insertEdge(2, 3);					// 2 3 간선 추가
		AOV.insertEdge(2, 4);					// 2 4 간선 추가
		
		AOV.insertEdge(3, 5);					// 3 5 간선 추가
		
		AOV.insertEdge(4, 5);					// 4 5 간선 추가
		
		AOV.topologicalSort();					// topologicalSort 호출로 위상 정렬 실행
	}
}
