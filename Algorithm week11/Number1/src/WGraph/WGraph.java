/*  �˰��� 11���� Bellman and Ford, ��� ���� ���� �ִ� ��� 
 * 	WGraph.java Main.java   
 *  �ۼ��� : 2020.11.12, 15~16
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : BellmanFord �˰���� ��� ���� ���� �ִ� ��θ� Ȯ���ϴ� ���α׷�
 */
package WGraph;

public class WGraph {										// ����ġ �׷��� WGraph Ŭ����
	private int vertex_size;								// ��������
	private int [][] weights;								// ����ġ�� ��Ÿ���� 2���� �迭 weights
	
	public WGraph(int vertex_size) {						// ������
		this.weights = new int[vertex_size][vertex_size];	// �Ű����� vertex_size�� ũ��� �迭�� ũ�� �ʱ�ȭ
		this.vertex_size = vertex_size;						// �Ű����� ������ vetex_size �ʱ�ȭ
		
		for(int i = 0; i < this.vertex_size; i++) {			// ��ø �ݺ����� ���� 2���� �迭 �ʱ�ȭ
			for(int j = 0; j < this.vertex_size; j++) {	 
				if(i == j) weights[i][j] = 0;				// ���� ������ ����Ű�� ���� ���ؼ��� 0���� ����
				else weights[i][j] = 999;					// �� �� �ٸ� ��� ����ġ�� 999�� ����
			}
		}
	}
	
	public void insertEdge(int i , int j, int w) {			// ������ �߰��ϴ� insertEdge �޼ҵ�
		if(weights[i][j] == 999) {							// i�� j ������ ������ ������ 
			weights[i][j] = w;								// ����ġ w�� �ʱ�ȭ ���ش�.
		}
	}
	
	public void BellmanFord(int v) {						// BellmanFord �˰������� �ִܰ�θ� ã�� �޼ҵ�
		int []dist = new int[vertex_size];					// �������� v������ �ִ� ��� ���̸� ������ �迭 dist 
		
		for(int i = 0; i < vertex_size; i++) {				// �ݺ����� ����
			dist[i] = weights[v][i];						// ���� v�� ������ ����ġ�� dist �迭�� ���� -> dist(1)
		}
		
		for(int k = 2; k < vertex_size; k++) {				// dist(2) ���� ���ϹǷ� k=2 �����Ѵ�.
			for(int u = 0; u < vertex_size; u++ ) {			// ��� ������ ���� 
				if(u != v) {								// ���� ������ �����ϰ�
					for(int i = 0; i < vertex_size; i++) {	
						if(weights[i][u] != 0 || weights[i][u] != 999) {	// i�� u������ ������ �ְ�
							if(dist[u] > dist[i] + weights[i][u]) {			// �� ª�� ��θ� ã���� 
								dist[u] = dist[i] + weights[i][u];			// �� ������ ����ġ ���� ���
							}
						}
					}
				}
					
			}
		}
		System.out.println("\n===== Best PATH =====");		// ��� ���
		for(int i = 0; i < vertex_size; i++) {				// �� ���������� �ִ� ��θ� ����Ѵ�.
			System.out.print(dist[i] + " ");				// 
		}
		System.out.println();
	}
	
	public void allShortestPath() {							// ��� ���� ���� �ִ� ��θ� ã�� allShortestPath �޼ҵ�
		int [][]dist = new int[vertex_size][vertex_size];	// ����ġ ������� dist ���� �� �ʱ�ȭ
		int i, j, k;							
		
		for(i = 0; i < vertex_size; i++) {					// ��ø �ݺ����� ����
			for(j = 0; j <vertex_size; j++) { 				
				dist[i][j] = weights[i][j];					// ����ġ ���� ��� ����
			}
		}
		
		for(k = 0; k < vertex_size; k++) {					// �߰� �������� 0���� ������ �������� ����ϴ� ���
			System.out.printf("Stage : %d\n", k);			// �ݺ� Ƚ���� ���� ��� 
			for(i = 0;  i < vertex_size; i++ ) {			// ��� ������ �������� 
				for(j = 0; j < vertex_size; j++) {			// ��� ������ ������ ���� �ݺ�	 
					if(dist[i][j] > (dist[i][k] + dist[k][j])) {	// �� ª�� ��� �˻�
						dist[i][j] = dist[i][k] + dist[k][j];
					}
					System.out.printf("[ %3d ]", dist[i][j]);	// �� ������ ���� ����ġ ����� ������ �� ���
				} 
				System.out.println();
			}
		}
	}
	
	public void print() {									// ����ġ �׷����� ����ϴ� print �޼ҵ�
		for(int i = 0; i < vertex_size; i++) {				// ��ø �ݺ����� ���� ���
			for(int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);	// �׷��� ���� ��� ���
			}
			System.out.println();
		}
	}
}
