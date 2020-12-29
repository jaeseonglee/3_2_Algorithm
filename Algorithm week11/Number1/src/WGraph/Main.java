package WGraph;

public class Main {									
	public static void main(String args[]) {	// main �޼ҵ�
		WGraph graph = new WGraph(6);			// 6���� ������ ���� ����ġ �׷��� ����
		
		graph.insertEdge(0, 1, 6);				// 0���� 1���� ����ġ 6�� ���� �߰�
		graph.insertEdge(0, 2, 5);				// 0���� 2���� ����ġ 5�� ���� �߰�
		graph.insertEdge(0, 3, 5);				// 0���� 3���� ����ġ 5�� ���� �߰�
		
		graph.insertEdge(1, 4, -1);				// 1���� 4���� ����ġ -1�� ���� �߰�
		
		graph.insertEdge(2, 1, -2);				// 2���� 1���� ����ġ -2�� ���� �߰�
		graph.insertEdge(2, 4, 1);				// 2���� 4���� ����ġ 1�� ���� �߰�
		
		graph.insertEdge(3, 2, -3);				// 3���� 2���� ����ġ -3�� ���� �߰�
		graph.insertEdge(3, 5, -1);				// 3���� 5���� ����ġ -1�� ���� �߰�
		
		graph.insertEdge(4, 5, 3);				// 4���� 5���� ����ġ 3�� ���� �߰�
		
		graph.print();							// ����ġ �׷��� ���
		
		graph.BellmanFord(0);					// bellmanFord �˰����� ���� ���� 0������ �ִ� ��� ���
		
		System.out.println("=====================\n\n");
		graph = new WGraph(4);					// graph�� ���� 4���� �� ����ġ �׷����� �ʱ�ȭ
		graph.insertEdge(0, 1, 2);				// 0���� 1���� ����ġ 2�� ���� �߰�			
		graph.insertEdge(0, 2, 9);				// 0���� 2���� ����ġ 9�� ���� �߰�
		
		graph.insertEdge(1, 2, 4);				// 1���� 2���� ����ġ 4�� ���� �߰�
		graph.insertEdge(1, 3, 3);				// 1���� 3���� ����ġ 3�� ���� �߰�
		
		graph.insertEdge(2, 0, -1);				// 2���� 0���� ����ġ -1�� ���� �߰�
		graph.insertEdge(2, 3, 4);				// 2���� 3���� ����ġ 4�� ���� �߰�
		
		graph.insertEdge(3, 1, 1);				// 3���� 1���� ����ġ 1�� ���� �߰�
		graph.insertEdge(3, 2, 7);				// 3���� 2���� ����ġ 7�� ���� �߰�
		
		graph.print();							// ����ġ �׷��� ���
		graph.allShortestPath();				// ��� ���� ���� �ִ� ��� ���
	}
}
