package WGraph;

public class Main {
	public static void main(String args[]) {				// main �޼ҵ�
		WGraph graph = new WGraph(6);						// ����ġ �׷��� graph ���� �� 6��ŭ �ʱ�ȭ
		
		graph.insertEdge(0, 1, 5);							// 0 �� 1�� ����ġ 5��ŭ ���� 
		graph.insertEdge(0, 2, 4);							// 0 �� 2�� ����ġ 4��ŭ ����
		graph.insertEdge(1, 2, 2);							// 1 �� 2�� ����ġ 2��ŭ ����
		graph.insertEdge(1, 3, 7);							// 1��  3�� ����ġ 7��ŭ ����
		graph.insertEdge(2, 3, 6);							// 2 �� 3�� ����ġ 6��ŭ ����
		graph.insertEdge(2, 4, 9);							// 2 �� 4�� ����ġ 9��ŭ ����
		graph.insertEdge(3, 4, 3);							// 3 �� 4�� ����ġ 3��ŭ ����
		graph.insertEdge(3, 5, 8);							// 3 �� 5�� ����ġ 8��ŭ ����
		graph.insertEdge(4, 5, 8);							// 4 �� 5�� ����ġ 8��ŭ ����
		
		System.out.println("Print Graph");					// �׷��� ���
		graph.print();					
		Edge[] kruskal = graph.kruskal();	
		
		System.out.println("\nPrim (start - weight - end)");
		Edge[] prim = graph.prim(0);
		for(int i = 0; i < kruskal.length; i++) {
			System.out.printf("(%d-%d-%d) ", prim[i].getStart(), prim[i].getWeight(), prim[i].getEnd());
		}
		
		
		
	}
}
