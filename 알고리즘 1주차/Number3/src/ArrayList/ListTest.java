package ArrayList;

public class ListTest {					// ListTest 클래스
	public static void main(String args[]) {	// main 메소드
		List ArrayList = new List();	// 새로운 List 객체 ArrayList 생성
		int i;							// 반복문에서 사용할 i 생성
		
		for(i = 1; i <= 6; i++) 		// 반복문을 통해 값을 추가해준다.
			ArrayList.addLast(i * 10);
		
		ArrayList.showList();			// 출력
			
		ArrayList.add(3, 11);			// 인덱스 3의 위치에 11 삽입
		
		ArrayList.showList();
		
		ArrayList.delete(5);			// 인덱스 5의 위치의 값 삭제

		ArrayList.showList();
	}
}
