/*  �˰��� 9���� ����ġ �׷���
 * 	Edge.java, UnionFind.java, MinHeap.java, Node.java, WGraph.java, Main.java   
 *  �ۼ��� : 2020.10.29~30, 11.1, 5~6
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : Kruscal �˰����� Ȯ���ϴ� ���α׷�
 */
package WGraph;

public class UnionFind {						// UnionFind Ŭ����
	int [] parent;								// int�� �迭 parent
	
	public UnionFind(int n) {					// UnionFind ������
		parent = new int[n];					// �Ű����� n��ŭ �ʱ�ȭ
		for(int i = 0; i < n; i++) {			// �ݺ����� ����
			parent[i] = i;						// �� �ε����� �ε����� ������ �ʱ�ȭ
		}
	}
	
	private int root(int i) {					// ������ �ٸ� ������ ����Ǿ� �ִ��� Ȯ���ϴ� root �޼ҵ�
		while(i != parent[i]) {					// parent �迭�� i �ε����� �� �ε����� ���� �ƴϸ�, �� �������� ����Ǿ� ������
			parent[i] = parent[parent[i]];		// �ٽ� �� �ε���(����)�� ������ �ʱ�ȭ
			i = parent[i];						
		}	
		return i;								// i ��ȯ
	}
	
	public boolean find(int p, int q) {			// �Ű����� �� ����(����)�� �������� ����Ǿ� �ִ��� Ȯ���ϴ� find �޼ҵ�
		return root(p) == root(q);
	}
	
	public void union(int p, int q) {			// �� �Ű������� �����ִ� union 
		int i = root(p);						// �� �Ű����� root�� ����  
		int j = root(q);						// ����� i,j�� ����
		parent[i] = j;							// ���� i�� j�� ������ �߰����ش�.
	}	
}