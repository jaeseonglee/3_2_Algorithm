package WGraph;

public class main {
	public static void main(String args[]) {		// main 메소드
		WGraph graph = new WGraph(5);				// 가중치 그래프 
		
		graph.insertEdge(0, 1, 2);					// 정점 0에서 1로 가는 가중치 2의 간선
		graph.insertEdge(0, 2, 5);					// 정점 0에서 2로 가는 가중치 5의 간선
		graph.insertEdge(0, 4, 3);					// 정점 0에서 4로 가는 가중치 3의 간선
		
		graph.insertEdge(1, 3, 4);					// 정점 1에서 3로 가는 가중치 4의 간선
		graph.insertEdge(1, 4, 10);					// 정점 1에서 4로 가는 가중치 10의 간선
		
		graph.insertEdge(2, 3, 6);					// 정점 2에서 3로 가는 가중치 6의 간선
		graph.insertEdge(2, 4, 2);					// 정점 2에서 4로 가는 가중치 2의 간선
		
		graph.insertEdge(4, 2, 1);					// 정점 4에서 2로 가는 가중치 1의 간선
		graph.insertEdge(4, 3, 2);					// 정점 4에서 3로 가는 가중치 2의 간선
		
		graph.print();								// 가중치 그래프 출력
				
		graph.shorttestPath(0);						// Dijkstra 알고리즘을 통한 출력

	}
}
