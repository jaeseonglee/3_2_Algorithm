package WGraph;

public class main {
	public static void main(String args[]) {		// main �޼ҵ�
		WGraph graph = new WGraph(5);				// ����ġ �׷��� 
		
		graph.insertEdge(0, 1, 2);					// ���� 0���� 1�� ���� ����ġ 2�� ����
		graph.insertEdge(0, 2, 5);					// ���� 0���� 2�� ���� ����ġ 5�� ����
		graph.insertEdge(0, 4, 3);					// ���� 0���� 4�� ���� ����ġ 3�� ����
		
		graph.insertEdge(1, 3, 4);					// ���� 1���� 3�� ���� ����ġ 4�� ����
		graph.insertEdge(1, 4, 10);					// ���� 1���� 4�� ���� ����ġ 10�� ����
		
		graph.insertEdge(2, 3, 6);					// ���� 2���� 3�� ���� ����ġ 6�� ����
		graph.insertEdge(2, 4, 2);					// ���� 2���� 4�� ���� ����ġ 2�� ����
		
		graph.insertEdge(4, 2, 1);					// ���� 4���� 2�� ���� ����ġ 1�� ����
		graph.insertEdge(4, 3, 2);					// ���� 4���� 3�� ���� ����ġ 2�� ����
		
		graph.print();								// ����ġ �׷��� ���
				
		graph.shorttestPath(0);						// Dijkstra �˰����� ���� ���

	}
}
