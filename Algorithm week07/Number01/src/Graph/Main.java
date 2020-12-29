package Graph;

public class Main {						
	public static void main(String args[]) {	// main �޼ҵ�
		Graph graph = new Graph(5);				// �׷��� ��ü graph ���� �� 5�� ũ��� �ʱ�ȭ
		graph.add(0, 1);				// 0�� 1 ����
		graph.add(0, 2);				// 0�� 2 ���� 
		graph.add(1, 2);				// 1�� 2 ���� 
		graph.add(1, 3);				// 1�� 3 ����
		graph.add(2, 3);				// 2�� 3 ����
		graph.add(3, 4);				// 3�� 4 ����
		
		System.out.println("Graph");
		graph.show();					// �׷��� ���
		
		graph.delete(0, 1);				// 0�� 1�� �մ� ���� ����
		graph.delete(1, 3);				// 1�� 3�� �մ� ���� ����
		
		System.out.println("0-1 / 1-3 Delete");
		graph.show();
	}
}
