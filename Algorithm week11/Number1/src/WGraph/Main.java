package WGraph;

public class Main {									
	public static void main(String args[]) {	// main 메소드
		WGraph graph = new WGraph(6);			// 6개의 정점을 가진 가중치 그래프 생성
		
		graph.insertEdge(0, 1, 6);				// 0에서 1까지 가중치 6의 간선 추가
		graph.insertEdge(0, 2, 5);				// 0에서 2까지 가중치 5의 간선 추가
		graph.insertEdge(0, 3, 5);				// 0에서 3까지 가중치 5의 간선 추가
		
		graph.insertEdge(1, 4, -1);				// 1에서 4까지 가중치 -1의 간선 추가
		
		graph.insertEdge(2, 1, -2);				// 2에서 1까지 가중치 -2의 간선 추가
		graph.insertEdge(2, 4, 1);				// 2에서 4까지 가중치 1의 간선 추가
		
		graph.insertEdge(3, 2, -3);				// 3에서 2까지 가중치 -3의 간선 추가
		graph.insertEdge(3, 5, -1);				// 3에서 5까지 가중치 -1의 간선 추가
		
		graph.insertEdge(4, 5, 3);				// 4에서 5까지 가중치 3의 간선 추가
		
		graph.print();							// 가중치 그래프 출력
		
		graph.BellmanFord(0);					// bellmanFord 알고리즘을 통해 정점 0에서의 최단 경로 출력
		
		System.out.println("=====================\n\n");
		graph = new WGraph(4);					// graph에 정점 4개의 새 가중치 그래프로 초기화
		graph.insertEdge(0, 1, 2);				// 0에서 1까지 가중치 2의 간선 추가			
		graph.insertEdge(0, 2, 9);				// 0에서 2까지 가중치 9의 간선 추가
		
		graph.insertEdge(1, 2, 4);				// 1에서 2까지 가중치 4의 간선 추가
		graph.insertEdge(1, 3, 3);				// 1에서 3까지 가중치 3의 간선 추가
		
		graph.insertEdge(2, 0, -1);				// 2에서 0까지 가중치 -1의 간선 추가
		graph.insertEdge(2, 3, 4);				// 2에서 3까지 가중치 4의 간선 추가
		
		graph.insertEdge(3, 1, 1);				// 3에서 1까지 가중치 1의 간선 추가
		graph.insertEdge(3, 2, 7);				// 3에서 2까지 가중치 7의 간선 추가
		
		graph.print();							// 가중치 그래프 출력
		graph.allShortestPath();				// 모든 정점 쌍의 최단 경로 출력
	}
}
