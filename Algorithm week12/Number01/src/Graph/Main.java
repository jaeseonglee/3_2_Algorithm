package Graph;

public class Main {
	public static void main(String args[]) {	// main �޼ҵ�
		Graph AOV = new Graph(6);				// AOV ���� �� ���� 6���� �ʱ�ȭ
		
		AOV.insertEdge(0, 1);					// 0 1 ���� �߰�
		AOV.insertEdge(0, 2);					// 0 2 ���� �߰�
		
		AOV.insertEdge(1, 3);					// 1 3 ���� �߰�
		AOV.insertEdge(1, 4);					// 1 4 ���� �߰�
		
		AOV.insertEdge(2, 3);					// 2 3 ���� �߰�
		AOV.insertEdge(2, 4);					// 2 4 ���� �߰�
		
		AOV.insertEdge(3, 5);					// 3 5 ���� �߰�
		
		AOV.insertEdge(4, 5);					// 4 5 ���� �߰�
		
		AOV.topologicalSort();					// topologicalSort ȣ��� ���� ���� ����
	}
}
