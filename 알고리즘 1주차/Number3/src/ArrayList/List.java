/*	List.java, ListTest.java
 *  작성일 : 2020.09.02
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : ArrayList 예제
 */
package ArrayList;

public class List {								// List 클래스
	private Object ArrayList[] = new Object[100]; // Object형의 배열 ArrayList 선언 및 크기 100으로 초기화 
	private int size = 0;						// 현재 크기를 저장할 size 선언 및 0으로 초기화
	
	public void addLast(Object data) {			// 값을 마지막에 추가하는	addLast 메소드
	// List 마지막에 새로운 값 추가 (마지막에 추가되기 때문에 추가적인 index를 변경해주는 작업이 필요없다.
		ArrayList[size] = data;					// ArrayList 배열의 현재 위치에 data 추가
		size++;									// size증가
	}
	
	public void add(int index, Object data) {	// 값을 입력된 index위치에 추가하는 add 메소드
	/* index 위치에 새로운 값을 추가하는 메소드
	 * 따라서 입력 index 이후의 인덱스의 값들의 위치를 재조정이 필요함(ArrayList의 단점)
	 */
		if(index > size) {						// 현재 크기보다 큰 수가 입력되면 
			System.out.println("List보다 큰 인덱스를 입력하여 추가할 수 없습니다.");	// 추가할 수 없다고 출력
			return;								// 메소드 종료
		}
		
		for(int i = size-1; i >= index-1; i--) {// 반복문을 통해 
			ArrayList[i+1] = ArrayList[i];		// ArrayList 배열의 index부터 size까지의 인덱스를 1씩 증가시킨다.
		}
		ArrayList[index] = data;				// 비워진 index 자리에 data 저장
		size++;									// size 증가
	}
	
	public void delete(int index) {				// index위치의 값을 제거하는 delete 메소드
	// 입력 인덱스의 값을 제거하는 메소드
		if(index > size-1 || index < 0) { 		//ArrayList 크기보다 큰 경우 (삭제 불가) 또는 음수가 입력되었을 경우
			System.out.println("잘못된 인덱스가 입력되었습니다."); 
			return;
		}
		
		for(int i = index + 1; i < size; i++) {	// 반복문을 통해 
			ArrayList[i-1] = ArrayList[i];		// ArrayList 배열의 index부터 size까지의 인덱스를 1씩 감소시킨다.
		}
		ArrayList[size-1] = null;				// 자동으로 삭제되는 index자리가 있으므로 마지막 위치에 있었던 값을 지워준다. 
		size--;									// size 감소
	}
	
	public void showList() {					// 현재 ArrayList를 출력하는 showList 메소드
	// 리스트의 모든 값을 출력하는 메소드
		int i;									// 반복문을 위해 사용할 변수 i
		for(i = 0; i < 20; i++) {				
			System.out.print("=");
		}
		System.out.println();
		
		for(i = 0; i < size; i++) {				// 각 인덱스의 값을 출력하며 반복
			System.out.println("Array List [" + i + "] : " + ArrayList[i]);
		}
		
		for(i = 0; i < 20; i++) {
			System.out.print("=");
		}
		System.out.println();
	}

}
