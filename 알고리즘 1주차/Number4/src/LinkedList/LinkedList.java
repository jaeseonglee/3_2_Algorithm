package LinkedList;

public class LinkedList {		// 연결리스트인 LinkedList 클래스
	private ListNode head;		// 첫번째 노드를 가리키는 ListNode 객체 head 생성
	
	public void addLastNode(Object data) { 	// (1) 입력받은 data를 가지는 노드를 마지막에 추가하는 addLastNode 메소드
		ListNode newNode = new ListNode();	// 새로운 노드를 추가하기 위해 newNode 생성  
		
		newNode.setData(data);				// newNode의 정보를 Setter를 통해 초기화 
		newNode.setLink(null); 				// 7번째 줄에서 data를 생성자의 매개변수를 전달해도 같은 결과이다.
											// ListNode newNode = new ListNode(data);
		if(head == null) {		// 첫번째 노드가 null이라면 
			head = newNode;		// newNode가 첫번째 노드 이므로 head가 된다.
			return;				// 메소드 종료
		}
		
		ListNode temp = head;				// head가 null이 아니면 head의 정보를 temp에 저장
		while(temp.getLink() != null) {		// 반복문을 통해 마지막 노드까지 탐색
			temp = temp.getLink();			// 다음 노드가 있다면 그 노드를 temp에 저장
		}
		temp.setLink(newNode);				// 반복문을 통해 현재 마지막노드의 link를 newNode로 저장한다.
	}
	
	public void deleteLastNode() {			// (2) 마지막 노드를 제거하는 deleteLastNode 메소드 
		ListNode preNode, curNode;		
		
		if(head == null) {					// head가 없다면 연결 리스트가 비어있으므로
			System.out.println("LinkedList가 비어있습니다."); // 연결 리스트가 비어있다고 출력
			return;							// 메소드 종료
		}
		
		if(head.getLink() == null) {		// head의 link가 없다면 연결 리스트에 head밖에 없으므로
			head = null;					// head를 제거한다.
			return;							// 메소드 종료
		}
		
		preNode = head;						// preNode에 head를 저장
		curNode = head.getLink();			// curNode에 head의 다음 노드를 저장
		
		while(curNode.getLink() != null) {	// 반복문을 통해 현재 마지막 노드를 탐색
			preNode = curNode;
			curNode = curNode.getLink();
		}
		preNode.setLink(null);				// 마지막 노드의 이전 노드의 link를 null로 지정함으로써 마지막 노드 제거
	}
	
	public void delete(Object data) { 		// (3) 입력받은 데이터를 제거하는 delete 메소드
		ListNode preNode, curNode;
		
		if(head == null) {					// head가 없다면 연결 리스트가 비어있으므로
			System.out.println("LinkedList가 비어있습니다."); // 연결 리스트가 비어있다고 출력
			return;							// 메소드 종료
		}
		
		if(head.getLink() == null) { 		// head의 link가 없다면 연결 리스트에 head밖에 없으므로
			head = null;					// head를 제거한다.
			return;							// 메소드 종료
		}
			
		preNode = head;						// preNode에 head를 저장
		curNode = head.getLink();			// curNode에 head의 다음 노드를 저장
		
		if(data.equals(preNode.getData())) {// 만약 매개변수 data와 head(preNode)의 data가 같다면  
			head = curNode;					// head를 head의 다음 노드로 초기화 해주므로써 head 삭제
			preNode.setLink(null);			
			return;							// 메소드 종료
		}
		
		while(curNode != null) {			// 반복문을 통해 연결 리스트 끝까지 탐색
			if(data.equals(curNode.getData())) {	// 매개변수 data와 같은 data를 가진 노드를 찾으면
				if(curNode.getLink() == null) {		// 그 노드가 마지막 노드라면
					preNode.setLink(null);			// 마지막 노드의 이전 노드의 link를 null해주어 마지막 노드 삭제 
				}
				else {						// 마지막 노드가 아니라면 해당 노드의 이전 노드와 다음 노드를 연결시키기 위해
					preNode.setLink(curNode.getLink());	// 이전 노드의 link는 그 다음 노드로 연결해주고 
					curNode.setLink(null);				// 해당 노드의 link는 null로 해줌으로써 노드 삭제
				}
				return;								// 조건문에 만족하는 순간 data를 찾은 것이므로 메소드 종료
			}
			preNode = curNode;						// 조건문을 만족하지 못하면 다음 노드 탐색을 위해 
			curNode = curNode.getLink();			// preNode는 curNode로, curNode는 그 다음 노드로 초기화
		}
		System.out.println("삭제할 노드가 존재하지 않습니다.");	// 반복문이 연결 리스트 전체를 탐색하고도 메소드 종료가 안되면
	}													// 삭제할 노드가 존재하지 않는다고 출력
		
	public ListNode search(Object data) { 	// (4) 입력받은 data를 찾는 search 메소드
		ListNode temp = head;
		
		while(temp != null) {				// 반복문을 통해 연결 리스트 탐색
			if(data.equals(temp.getData())) {	// 매개변수 data와 같은 data를 가진 노드를 찾으면  
				return temp;					// 그 노드를 반환
			}
			temp = temp.getLink();				// 다음 노드로 초기화해주어 탐색 진행
		}
		
		System.out.println("해당 data가 List에 존재하지 않습니다.");	// 반복문을 빠져나오면 해당 data가 없다고 출력
		return null;						// null 반환
	}
	
	public void insert(ListNode preNode, Object data) { // (5) 입력받은 노드뒤에 data를 삽입하는 insert 메소드
		ListNode newNode = new ListNode(data);			// 새로운 노드를 삽입하기 위해 새 ListNode 생성
		
		if(head == null) {								// 연결 리스트가 없다면 
			System.out.println("List가 비어있습니다.");		// 비어있다고 출력
			return;										// 삽입 실패, 메소드 종료
		}
		else if(preNode == null) {						// 매개변수 preNode가 null 값이라면
			System.out.println("삽입하기 전 노드의 값을 확인할 수 없습니다.");	// 알 수 없다고 출력 
			return;										// 삽입 실패, 메소드 종료
		}
		
		newNode.setLink(preNode.getLink());				// 새로운 노드의 link는 preNode의 link로 초기화
		preNode.setLink(newNode);						// preNode의 link는 새로운 노드를 가리키며 메소드 종료
	}
	
	public void showList() {						// 연결 리스트를 출력하는 showList 메소드
		int i = 0;									// 반복문에서 사용할 변수 i
		if(head == null) {							// head가 없으면 연결 리스트가 없으므로
			System.out.println("List가 비어있습니다.");	// 연결 리스트가 비어있다고 출력
			return;									// 메소드 출력
		}
		ListNode temp = head;						// temp에 head를 저장
		
		System.out.println("List show 시작");		// 출력 시작 
		
		while(temp != null) {					// 반복문을 통해 출력
			System.out.println("List [" + (i++) + "] : " + temp.getData());	// 노드의 data 출력
			temp = temp.getLink();				// 다음 노드로 초기화해주며 연결 리스트 출력 
		}
		
		System.out.println("List show 종료");		// 출력 종료하며 메소드 종료
	}
}
