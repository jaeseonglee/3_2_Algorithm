/*	ListNode.java, LinkedList.java, LinkedListTest.java 
 *  작성일 : 2020.09.02 ~ 03
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 연결리스트 예제
 */
package LinkedList;

public class ListNode {			// Node의 정보를 가지는 ListNode 클래스
	public Object data;			// Object 타입의 변수 data
	private ListNode link;		// 다음 노드를 가리키는 LinkNode타입의 link
	
	public ListNode() {			// Default 생성자, 아무 정보도 없는 Node 생성
		this.data = null;		// data를 null로 초기화
		this.link = null;		// link를 null로 초기화
	}
	
	public ListNode(Object data) {	// 매개변수가 1개인 생성자, data만 가지고 있는 노드
		this.data = data;		// 노드의 data를 매개변수 data로 초기화
		this.link = null;		// link를 null로 초기화
	}
	
	public ListNode(Object data, ListNode link) {	// 매개변수가 2개인 생성자
		this.data = data;		// 노드의 data를 매개변수 data로 초기화
		this.link = link;		// 노드의 link를 매개변수 link로 초기화
	}
	
	public Object getData() {	// data Getter
		return this.data;		// 노드의 data를 반환
	}
	
	public void setData(Object data) {	// data Setter
		this.data = data;		// 노드의 data를 매개변수 data로 초기화
	}
	
	public ListNode getLink() {	// link Getter
		return this.link;		// 노드의 link를 반환
	}
	
	public void setLink(ListNode link) {	// link Setter
		this.link = link;		// 노드의 link를 매개변수 link로 초기화
	}
}
