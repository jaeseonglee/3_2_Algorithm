package WGraph;

public class Graph_recursion {
	public static void main(String args[]) {		// ���� �޼ҵ�
		Graph graph = new Graph(7);					// Graph ��ü ���� �� 7�� ũ��� �ʱ�ȭ (0~6)
		
		graph.add(0, 1);						// 0�� 1 ���� 
		graph.add(0, 2);						// 0�� 2 ���� 
		graph.add(0, 3);						// 0�� 3 ���� 
		graph.add(1, 4);						// 1�� 4 ���� 
		graph.add(2, 4);						// 2�� 4 ���� 
		graph.add(2, 5);						// 2�� 5 ���� 
		graph.add(3, 5);						// 3�� 5 ���� 
		graph.add(4, 6);						// 4�� 6 ���� 
		graph.add(5, 6);						// 5�� 6 ���� 
		
		graph.show();							// �׷��� ���
		System.out.println("DFS");				// DFS�� ȣ���ϸ� DFS�� ����� ����ϴµ�
		graph.DFS(0);							// �Ű������� 0����� ���� pop�� ���� ���� ������ ������ 3���� ������ ���� Ȯ���� �� �ִ�.
		
		System.out.println();			
		System.out.println("BFS");				// BFS�� ���������� BFS�� ����� ����ϴµ�
		graph.BFS(0);							// �Ű������� 0����� ���� ť �������� ���� remove�� ������(1,2,3...) ������ ���� Ȯ���� �� �ִ�.
		
	}
}
