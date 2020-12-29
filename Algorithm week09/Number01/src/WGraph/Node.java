/*  알고리즘 9주차  DFS, BFS
 * 	Node.java,Graph.java, Graph_recursion.java   
 *  작성일 : 2020.10.29~30, 11.1, 5~6
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : DFS, BFS를 추가한 프로그램
 */

package WGraph;

public class Node {				// 인접 리스트에서 사용할 Node 클래스
	private int vertex;			// 정점
	private Node link;			// 다음 정점을 가리키는 link
	
	public Node(int vertex) {	// 정점만 있는 생성자
		this.vertex = vertex;	// 매개변수로 초기화하고
		this.link = null;		// link는 null로 초기화한다.
	}
	
	public Node(int vertex, Node link) {	// 정점과 link가 있는 생성자
		this.vertex = vertex;				// vertex에 매개변수 vertex로 초기화
		this.link = link;					// link를 매개변수 link로 초기화
	}
	
	public int getVertex() {				// 정점에 대한 getter
		return vertex;
	}
	
	public void setVertex(int vertex) { 	// 정점에 대한 setter
		this.vertex = vertex;
	}
	
	public Node getLink() {					// link에 대한 getter
		return link;
	}
	
	public void setLink(Node link) {		// link에 대한 setter
		this.link = link;
	}
}
