package WGraph;

public class main {
	public static void main(String args[]) {		// main �޼ҵ�
		WGraph graph = new WGraph(4);				// ���� 4���� �׷��� ���� �� �ʱ�ȭ 
		graph.insertEdge(0, 1);						// 0���� 1������ ���� �߰�
		graph.insertEdge(0, 2);						// 0���� 2������ ���� �߰�
		
		graph.insertEdge(1, 2);						// 1���� 2������ ���� �߰�
		graph.insertEdge(1, 3);						// 1���� 3������ ���� �߰�
		
		graph.insertEdge(2, 1);						// 2���� 1������ ���� �߰�
		graph.insertEdge(2, 3);						// 2���� 3������ ���� �߰�
			
		System.out.println("Print Graph");			// �׷��� ���
		graph.print();
		
		System.out.println("Transitive Closure");	// ������ ��⸦ ���� ���
		graph.allShortestPath();
	}
}