package Vertex_graph;

public class Vertex_graph_main {						
	public static void main(String args[]) {			// main 메소드
		Vertex_graph graph = new Vertex_graph(7);		// 연결 리스트로 그래프 를 나타내는 Vertex_graph 객체 생성 및 size를 7로 초기화
		
		graph.add(0, 1);				// 0과 1 연결
		graph.add(0, 2);				// 0과 2 연결
		graph.add(0, 3);				// 0과 3 연결
		graph.add(0, 4);				// 0과 4 연결
		
		graph.add(1, 4);				// 1과 4 연결
		
		graph.add(2, 4);				// 2과 4 연결
		graph.add(2, 5);				// 2과 5 연결
		
		graph.add(3, 5);				// 3과 5 연결
		
		graph.add(5, 6);				// 5과6 연결
		
		System.out.println("Graph");	// 그래프 출력
		graph.show();
		
		System.out.println("\n0-1 Delete"); // 0과 1에 대한 간선 삭제
		graph.delete(0, 1);				// delete 메소드를 통해 삭제
		graph.show();					// 그래프 출력
	}
}
