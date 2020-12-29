package WGraph;

public class main {
	public static void main(String args[]) {		// main 메소드
		WGraph graph = new WGraph(4);				// 정점 4개의 그래프 생성 및 초기화 
		graph.insertEdge(0, 1);						// 0부터 1까지의 간선 추가
		graph.insertEdge(0, 2);						// 0부터 2까지의 간선 추가
		
		graph.insertEdge(1, 2);						// 1부터 2까지의 간선 추가
		graph.insertEdge(1, 3);						// 1부터 3까지의 간선 추가
		
		graph.insertEdge(2, 1);						// 2부터 1까지의 간선 추가
		graph.insertEdge(2, 3);						// 2부터 3까지의 간선 추가
			
		System.out.println("Print Graph");			// 그래프 출력
		graph.print();
		
		System.out.println("Transitive Closure");	// 이행적 폐쇄를 통해 출력
		graph.allShortestPath();
	}
}