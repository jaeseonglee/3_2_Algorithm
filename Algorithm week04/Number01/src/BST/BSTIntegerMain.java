package BST;

public class BSTIntegerMain {	// Integer 타입으로 이진트리를 구성하는 BSTIntegerMain 클래스
	public static void main(String args[])	{ // 메인 메소드
		BinarySearchTree t = new BinarySearchTree(); 	// 공백 이진트리 생성
		t.BSTinsert(10);			// 각각의 값 삽입
		t.BSTinsert(5);
		t.BSTinsert(9);
		t.BSTinsert(11);
		t.BSTinsert(15);
		t.BSTinsert(14);
		t.BSTinsert(7);
		t.BSTinsert(3);
		t.BSTinsert(20);
		t.BSTinsert(22);
		t.BSTinsert(1);
		
		t.print();				 	// 이진트리 출력
		
		System.out.println("=======================1=====================");
		TreeNode n = t.BSTsearch(1);			// 1을 탐색해서 n에 결과를 저장 
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(1);							// 1 제거
		
		n = t.BSTsearch(1);						// 다시 1을 탐색한 결과를 저장
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// 1이 제거된 현재 이진트리 출력
		
		System.out.println("=======================11=====================");
		n = t.BSTsearch(11);					// 11 탐색
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(11);						// 11 제거

		n = t.BSTsearch(11);					// 다시 11을 탐색한 결과를 저장
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// 현재 이진트리 출력
		
		System.out.println("=======================15=====================");
		n = t.BSTsearch(15);					// 15 탐색
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}
		
		t.BSTdelete(15);						// 15 제거
		
		n = t.BSTsearch(15);					// 다시 15을 탐색한 결과를 저장
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// 현재 이진트리 출력
		
		System.out.println("=======================9=====================");
		
		n = t.BSTsearch(9);						// 9 탐색
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(9);							// 9 제거

		n = t.BSTsearch(9);						// 다시 9을 탐색한 결과를 저장
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// 현재 이진트리 출력
		
		System.out.println("=======================20=====================");
		
		n = t.BSTsearch(20);						// 20 탐색
		if (n == null) {							// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(20);							// 20 제거

		n = t.BSTsearch(20);						// 다시 20을 탐색한 결과를 저장
		if (n == null) {							// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();									// 현재 이진트리 출력

		System.out.println("============================================");
	}
}
