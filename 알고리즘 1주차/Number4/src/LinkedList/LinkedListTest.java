package LinkedList;

public class LinkedListTest {					// 연결리스트 테스트
	public static void main(String arg[]) {		// main 메소드
		LinkedList list = new LinkedList();		// 새로운 연결리스트 list 생성
		ListNode temp = new ListNode();			// 새로운 노드 temp 생성
		
		for(int i = 0; i <= 6; i++ ) {			// 반복문을 통해 리스트에 A ~ G까지 삽입
			list.addLastNode(Character.toString((char)(i + 65)));
		}
		
		list.showList();						// 연결 리스트 출력
		
		temp = list.search("A");				// A의 데이터를 가지고 있는 노드를 찾아 temp에 저장
		list.insert(temp, "D");					// 그 다음 노드에 D라는 데이터를 가진 노드 삽입
		list.showList();						// 연결 리스트 출력
		
		list.delete("A");						// A 삭제
		list.delete("G");						// G 삭제
		list.showList();						// 연결 리스트 출력 
		
		list.deleteLastNode();					// 마지막 노드 삭제
		list.deleteLastNode();
		list.deleteLastNode();
		list.showList();						// 연결 리스트 출력
	}

}
