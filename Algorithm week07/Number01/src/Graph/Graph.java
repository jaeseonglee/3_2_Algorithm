/*  �˰��� 7���� �׷��� (�ش� �ڵ�� ������ �׷������� �ٷ��) 
 * 	Graph.java, Main.java, Node.java, Vertex_graph.java, Vertex_graph_main.java 
 *  �ۼ��� : 2020.10.15~16
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : �׷����� ������İ� ���� ����Ʈ�� ���� ��Ÿ�� ���α׷�
 */

package Graph;

public class Graph {						// ������ �׷����� ��Ÿ���� ������� Ŭ����
	private int[][] matrix;					// ��������� ������ 2���� �迭matrix 
	private int size;						// �迭�� ũ�� size
	
	public Graph(int size) {				// Graph ������
		this.matrix = new int[size][size];	// �Ű����� size�� �迭�� �ʱ�ȭ
		this.size = size;					// size�� �Ű����� size�� �ʱ�ȭ
	}
	
	public void add(int i, int k ) {		// ���� i, k�� ���� ������ �߰��ϴ� add �޼ҵ�
		matrix[i][k] = 1;					// i�� ���� k�� �̾��ְ�
		matrix[k][i] = 1;					// k�� ���� i�� �̾��ش�.
	}
	
	public void delete(int i, int k) {		// ���� i, k�� ���� ������ �����ϴ� delete �޼ҵ�
		matrix[i][k] = 0;					// i�� ���� k�� �����ϰ�
		matrix[k][i] = 0;					// k�� ���� i�� �������ش�.
	}
	
	public void show() {					// ���� ��� �׷����� ����ϴ� show �޼ҵ� 
		if(this.size == 0) {				// �׷����� ũ�Ⱑ 0�̶�� 
			System.out.println("No Matrix");// �޼ҵ� ����
			return ;
		}
		
		for(int i = 0; i < size; i++) {		// ��ø �ݺ����� ���� ���
			String temp = "";
			for(int j = 0; j < size; j++) {	
				if(this.matrix[i][j] == 1) {// �ش� �ε����� ���� 1�̶�� ���� �Ǿ��ֱ� ������
					temp += j + " ";		// temp�� �ش� �ε����� �߰��Ѵ�
				}
			}
			if(!temp.equals("")) {			// temp�� ������ �ݺ����� ���� �ٸ� ���� �ִٸ�
				System.out.println(i + " : " + temp);	// ����� ���� ���
			}
		}
	}
}
