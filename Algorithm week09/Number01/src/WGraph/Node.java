/*  �˰��� 9����  DFS, BFS
 * 	Node.java,Graph.java, Graph_recursion.java   
 *  �ۼ��� : 2020.10.29~30, 11.1, 5~6
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : DFS, BFS�� �߰��� ���α׷�
 */

package WGraph;

public class Node {				// ���� ����Ʈ���� ����� Node Ŭ����
	private int vertex;			// ����
	private Node link;			// ���� ������ ����Ű�� link
	
	public Node(int vertex) {	// ������ �ִ� ������
		this.vertex = vertex;	// �Ű������� �ʱ�ȭ�ϰ�
		this.link = null;		// link�� null�� �ʱ�ȭ�Ѵ�.
	}
	
	public Node(int vertex, Node link) {	// ������ link�� �ִ� ������
		this.vertex = vertex;				// vertex�� �Ű����� vertex�� �ʱ�ȭ
		this.link = link;					// link�� �Ű����� link�� �ʱ�ȭ
	}
	
	public int getVertex() {				// ������ ���� getter
		return vertex;
	}
	
	public void setVertex(int vertex) { 	// ������ ���� setter
		this.vertex = vertex;
	}
	
	public Node getLink() {					// link�� ���� getter
		return link;
	}
	
	public void setLink(Node link) {		// link�� ���� setter
		this.link = link;
	}
}
