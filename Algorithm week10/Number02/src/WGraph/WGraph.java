/*  �˰��� 10���� 
 * 	WGraph.java main.java   
 *  �ۼ��� : 2020.11.5~6, 12~13
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : Dijkstra �˰����� Ȯ���ϴ� ���α׷�
 */
package WGraph;

public class WGraph {										// WGraph Ŭ����
	private int vertex_size;								// ������ ����
	private int [][] weights;								// ����ġ �׷����� ��Ÿ���� ��������� 2���� �迭 weights
			
	public WGraph(int vertex_size) {						// ������ ������ �Ű������� �ϴ� ������
		this.weights = new int[vertex_size][vertex_size];	// 2���� �迭 weights�� �ʱ�ȭ
		this.vertex_size = vertex_size;						// �Ű����� ���� vertex_size�� �ʱ�ȭ
		
		for(int i = 0; i < this.vertex_size; i++) {			// ��ø �ݺ����� ���� 2���� �迭 �ʱ�ȭ 
			for(int j = 0; j < this.vertex_size; j++) {		
				if(i == j) weights[i][j] = 0;				// ���� �ڱ� �ڽ��� ����Ű�� 0�� ����
				else weights[i][j] = 999;					// �װ� �ƴ϶�� 999�� ����
			}
		}
	}
	
	public void insertEdge(int i, int k, int w) {			// ����ġ �׷����� ������ �߰��ϴ� insertEdge �޼ҵ�
		if(weights[i][k] == 999) {							// ������ ���ٸ� 
			weights[i][k] = w;								// �Ű������� ���� w(����ġ)�� �ʱ�ȭ
		}
	}
	
	public void print() {									// ����ġ �׷����� ����ϴ� print �޼ҵ�
		for(int i = 0; i < vertex_size; i++) {				// ��ø �ݺ����� ���� ���
			for(int j = 0; j < vertex_size; j++) {
				System.out.printf("[ %3d ]", weights[i][j]);
			}
			System.out.println();
		}
	}
	
	public void shorttestPath(int v) {						// Dijkstra �˰����� ���� ���� ª�� ����ġ�� ��θ� ���ϴ� shorttestPath �޼ҵ�
		boolean[] s = new boolean[vertex_size];				// ������ �湮�� Ȯ���ϴ� boolean �迭 s ���� 
		int[] dist = new int[vertex_size];					// ����ġ ���� ������ dist�迭 ����  
		
		for(int i = 0; i < vertex_size; i++) {				// �ݺ����� ���� ������ �迭 ���� �ʱ�ȭ
			s[i] = false;
			dist[i] = weights[v][i];						// �Ű����� ���� v�� ����� ������ ����ġ��ŭ �ʱ�ȭ
		}
		
		s[v] = true;										// v���� �����ϹǷ� v�� �湮�Ѱ��̳� �ٸ������� s[v] = true
		dist[v] = 0;										// ���������� v���� v�� ���� �ʱ� ������ 0���� ����
		
		for(int i = 0 ; i < vertex_size - 2; i++) {			// �ݺ����� ���� �˰��� ����
			int u = -1;										// ���� ���� ������ u
			int min = 999;									// �ּڰ��� ������ min
			
			for(int j = 0; j < vertex_size; j++) {			// �ݺ����� ���� ��� ������ ������� ����
				if(s[j] == false &&  dist[j] < min) { 		// j ������ �湮���� �ʾҰ� min���� ���� ���� ����ġ�� ���� ������
					u = j;									// �� ������ ����
					min = dist[j];							// ����ġ ���� (�ʱ�ȭ)�������ش�.
				}
			}
			s[u] = true;									// �ݺ����� ���� ������ ���������� �� ������ �湮�ϹǷ� true
			
			for(int w = 0; w < vertex_size; w++) {			// �ݺ����� ���� �� ª�� ����ġ�� ���� �ִ��� Ȯ���Ѵ�.
				if(s[w] == false) {							// �ٸ� ������ ���� �湮���� ��,
					if(dist[w] > dist[u] + weights[u][w]) {	// �� ������ ���� ����ġ���� �ٸ� ������ ���� ���� ����ġ�� ���� �۴ٸ�
						dist[w] = dist[u] + weights[u][w];	// �� ����ġ�� ������ �ʱ�ȭ
					}
				}
			}
			System.out.printf("===== STAGE %d =====", (i+1));// �˰��� ���� Ƚ��
			System.out.println("\nselect vertex : " + u);	
			
			for(int k = 0; k < vertex_size; k++) {			// �˰����� ���� Ȯ���� dist ���
				System.out.print(dist[k] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
