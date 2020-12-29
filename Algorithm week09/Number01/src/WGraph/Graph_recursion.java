package WGraph;

public class Graph_recursion {
	public static void main(String args[]) {		// 메인 메소드
		Graph graph = new Graph(7);					// Graph 객체 생성 및 7의 크기로 초기화 (0~6)
		
		graph.add(0, 1);						// 0과 1 연결 
		graph.add(0, 2);						// 0과 2 연결 
		graph.add(0, 3);						// 0과 3 연결 
		graph.add(1, 4);						// 1과 4 연결 
		graph.add(2, 4);						// 2과 4 연결 
		graph.add(2, 5);						// 2과 5 연결 
		graph.add(3, 5);						// 3과 5 연결 
		graph.add(4, 6);						// 4과 6 연결 
		graph.add(5, 6);						// 5과 6 연결 
		
		graph.show();							// 그래프 출력
		System.out.println("DFS");				// DFS를 호출하면 DFS한 결과를 출력하는데
		graph.DFS(0);							// 매개변수를 0출력한 이후 pop한 값이 먼저 나오기 때문에 3부터 나오는 것을 확인할 수 있다.
		
		System.out.println();			
		System.out.println("BFS");				// BFS도 마찬가지로 BFS한 결과를 출력하는데
		graph.BFS(0);							// 매개변수를 0출력한 이후 큐 구조에서 먼저 remove된 순서를(1,2,3...) 나오는 것을 확인할 수 있다.
		
	}
}
