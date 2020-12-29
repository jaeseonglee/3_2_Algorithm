package WGraph;

public class Main {
	public static void main(String args[]) {				// main 메소드
		WGraph graph = new WGraph(6);						// 가중치 그래프 graph 선언 및 6만큼 초기화
		
		graph.insertEdge(0, 1, 5);							// 0 과 1을 가중치 5만큼 연결 
		graph.insertEdge(0, 2, 4);							// 0 과 2를 가중치 4만큼 연결
		graph.insertEdge(1, 2, 2);							// 1 과 2를 가중치 2만큼 연결
		graph.insertEdge(1, 3, 7);							// 1과  3을 가중치 7만큼 연결
		graph.insertEdge(2, 3, 6);							// 2 과 3을 가중치 6만큼 연결
		graph.insertEdge(2, 4, 9);							// 2 과 4를 가중치 9만큼 연결
		graph.insertEdge(3, 4, 3);							// 3 과 4를 가중치 3만큼 연결
		graph.insertEdge(3, 5, 8);							// 3 과 5을 가중치 8만큼 연결
		graph.insertEdge(4, 5, 8);							// 4 과 5을 가중치 8만큼 연결
		
		System.out.println("Print Graph");					// 그래프 출력
		graph.print();					
		Edge[] kruskal = graph.kruskal();	
		
		System.out.println("\nPrim (start - weight - end)");
		Edge[] prim = graph.prim(0);
		for(int i = 0; i < kruskal.length; i++) {
			System.out.printf("(%d-%d-%d) ", prim[i].getStart(), prim[i].getWeight(), prim[i].getEnd());
		}
		
		
		
	}
}
