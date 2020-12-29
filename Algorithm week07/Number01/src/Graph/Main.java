package Graph;

public class Main {						
	public static void main(String args[]) {	// main 메소드
		Graph graph = new Graph(5);				// 그래프 객체 graph 생성 및 5의 크기로 초기화
		graph.add(0, 1);				// 0과 1 연결
		graph.add(0, 2);				// 0과 2 연결 
		graph.add(1, 2);				// 1과 2 연결 
		graph.add(1, 3);				// 1과 3 연결
		graph.add(2, 3);				// 2과 3 연결
		graph.add(3, 4);				// 3과 4 연결
		
		System.out.println("Graph");
		graph.show();					// 그래프 출력
		
		graph.delete(0, 1);				// 0과 1을 잇는 간선 삭제
		graph.delete(1, 3);				// 1과 3을 잇는 간선 삭제
		
		System.out.println("0-1 / 1-3 Delete");
		graph.show();
	}
}
