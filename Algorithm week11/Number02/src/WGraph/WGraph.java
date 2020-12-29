/*  �˰��� 11���� ������ ��� 
 * 	WGraph.java main.java   
 *  �ۼ��� : 2020.11.12, 15~16
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : ������ ��⸦ Ȯ���ϴ� ���α׷�
 */
package WGraph;

public class WGraph {									
	private int vertex_size;								// ������ ����
	private boolean[][] matrix;								// �׷����� ���ϴ� boolean�� ���� ���  matrix
	
	public WGraph(int vertex_size) {						// ������
		this.matrix = new boolean[vertex_size][vertex_size];// vertex_size ��ŭ �迭 ũ�� �ʱ�ȭ
		this.vertex_size = vertex_size;						// �Ű�������ŭ vertex_size �ʱ�ȭ
		
		for(int i = 0; i < this.vertex_size; i++) {			// ��ø �ݺ����� ���� �迭 �ʱ�ȭ 
			for(int j = 0; j < this.vertex_size; j++) {		
				matrix[i][j] = false;						// ��� ���� false�� �ʱ�ȭ
			}
		}
	}
	
	public void insertEdge(int i, int j) {					// ������ �߰��ϴ� isnertEdge �޼ҵ�
		if(!matrix[i][j])									// i�� j ���̿� ������ ������
			matrix[i][j] = true;							// �߰����ش�
	}

	public void allShortestPath() {							// ��� ���� ���� �ִ� ��θ� ���� ������ ��� �׷����� �ִ� ��θ� ã�� allShortestPath �޼ҵ�
		boolean[][] dist = new boolean[vertex_size][vertex_size];	// ���� ��� dist ���� �� �ʱ�ȭ
		int i, j, k;
		
		for(i = 0; i < vertex_size; i++) {					// ��ø �ݺ����� ����
			for(j = 0; j < vertex_size; j++) {
				dist[i][j] = matrix[i][j];					// matrix�� ���� ����
			}
		}
		
		for(k = 0; k < vertex_size; k++) {					// 3�� �ݺ����� ����			
			for(i = 0; i < vertex_size; i++) { 				// ���� i���� j���� �� �� �ִ� ��θ� ã�´ٸ�
				for(j = 0; j < vertex_size; j++) {			// i���� j���� ���� ����� �����Ƿ�
					if(dist[i][k] && dist[k][j])			// dist[i][j]�� true ������ �ʱ�ȭ
						dist[i][j] = true;
				}
			}
		}
		
		System.out.println("============ D+ ============");	//������ ��� ���, �� i���� j���� ���̰� 0���� ū ��θ� ���
			
		for(i = 0; i < vertex_size; i++) {					// ��ø �ݺ����� ����	
			for(j = 0; j < vertex_size; j++) {				// ���� ��� ���
				System.out.printf("[ %5b ]", dist[i][j]);	
			}
			System.out.println();
		}
		
		for(k = 0; k < vertex_size; k++) {					// �ݻ� ������ ��� ����� ��Ÿ���� ���� �ٽ� 3�� �ݺ�
			for(i = 0; i < vertex_size; i++) {
				for(j = 0; j <vertex_size; j++) {			// OR ������ ���� �ڱ� �ڽ��� ����Ű�� ��ΰ� �ִٸ�
					if(dist[i][k] || dist[k][j])			// �ڱ� �ڽſ� ���� ������ �ִٴ� ������ ����Ͽ�
						dist[i][i] = true;					// �ڱ� �ڽ��� ����Ű�� ���� ��Ŀ� ���� true�� �ʱ�ȭ
				}
			}
		}
		
		System.out.println("============ D* ============");	// �ݻ� ������ ��� ���, �� i i���� j���� ���̰� 0�̻��� ��θ� ���
		for(i = 0; i < vertex_size; i++) {					// ��ø �ݺ����� ����
			for(j = 0; j < vertex_size; j++) {				
				System.out.printf("[ %5b ]", dist[i][j]);	// ���� ��� ���
			}
			System.out.println();
		}
	}
	
	public void print() {
		for(int i = 0; i < vertex_size; i++) {
			for(int j = 0; j <vertex_size; j++) {
				System.out.printf("[ %5b ]", matrix[i][j]);
			}
			System.out.println();
		}
	}
}
