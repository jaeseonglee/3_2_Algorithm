package WGraph;

public class Node {						// Node 클래스
	private int vertex;					// 정점을 가리키는 vertex
	private Node link;					// 다음 Node를 가리키는 link
	
	public Node(int vertex) {			// vertex만 있는 생성자
		this.vertex = vertex;			// 매개변수 vertex로 초기화
		this.link = null;				// link는 null로 초기화
	}
	
	public Node(int vertex, Node link) {// 매개변수가 둘 다 있는 생성자는
		this.vertex = vertex;			// 각각의 매개변수 값으로 초기화
		this.link = link;
	}
	
	public int getVertex() {			// vertex getter
		return vertex;					// vertex를 반환
	}	
	
	public void setVertex(int vertex) {	// vertex setter
		this.vertex = vertex;			// 매개변수 vertex로 초기화
	}
	
	public Node getLink() {				// link getter
		return link;					// link를 반환
	}
	
	public void setLink(Node link) {	// link setter
		this.link = link;				// 매개변수 link로 초기화
	}
}
