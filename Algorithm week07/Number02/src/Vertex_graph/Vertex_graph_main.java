package Vertex_graph;

public class Vertex_graph_main {						
	public static void main(String args[]) {			// main �޼ҵ�
		Vertex_graph graph = new Vertex_graph(7);		// ���� ����Ʈ�� �׷��� �� ��Ÿ���� Vertex_graph ��ü ���� �� size�� 7�� �ʱ�ȭ
		
		graph.add(0, 1);				// 0�� 1 ����
		graph.add(0, 2);				// 0�� 2 ����
		graph.add(0, 3);				// 0�� 3 ����
		graph.add(0, 4);				// 0�� 4 ����
		
		graph.add(1, 4);				// 1�� 4 ����
		
		graph.add(2, 4);				// 2�� 4 ����
		graph.add(2, 5);				// 2�� 5 ����
		
		graph.add(3, 5);				// 3�� 5 ����
		
		graph.add(5, 6);				// 5��6 ����
		
		System.out.println("Graph");	// �׷��� ���
		graph.show();
		
		System.out.println("\n0-1 Delete"); // 0�� 1�� ���� ���� ����
		graph.delete(0, 1);				// delete �޼ҵ带 ���� ����
		graph.show();					// �׷��� ���
	}
}
