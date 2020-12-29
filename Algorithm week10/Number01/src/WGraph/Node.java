package WGraph;

public class Node {						// Node Ŭ����
	private int vertex;					// ������ ����Ű�� vertex
	private Node link;					// ���� Node�� ����Ű�� link
	
	public Node(int vertex) {			// vertex�� �ִ� ������
		this.vertex = vertex;			// �Ű����� vertex�� �ʱ�ȭ
		this.link = null;				// link�� null�� �ʱ�ȭ
	}
	
	public Node(int vertex, Node link) {// �Ű������� �� �� �ִ� �����ڴ�
		this.vertex = vertex;			// ������ �Ű����� ������ �ʱ�ȭ
		this.link = link;
	}
	
	public int getVertex() {			// vertex getter
		return vertex;					// vertex�� ��ȯ
	}	
	
	public void setVertex(int vertex) {	// vertex setter
		this.vertex = vertex;			// �Ű����� vertex�� �ʱ�ȭ
	}
	
	public Node getLink() {				// link getter
		return link;					// link�� ��ȯ
	}
	
	public void setLink(Node link) {	// link setter
		this.link = link;				// �Ű����� link�� �ʱ�ȭ
	}
}
