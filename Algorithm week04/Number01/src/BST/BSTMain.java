package BST;

public class BSTMain {					// String 타입으로 이진트리를 구성하는 BSTmain 클래스
	public static void main(String args[]) {	// 메인 메소드 
		BinarySearchTree t = new BinarySearchTree();		// 공백 이진트리 생성
		t.BSTinsert("S");		// 각각의 값 삽입
		t.BSTinsert("J");
		t.BSTinsert("B");
		t.BSTinsert("D");
		t.BSTinsert("U");
		t.BSTinsert("M");
		t.BSTinsert("R");
		t.BSTinsert("Q");
		t.BSTinsert("A");
		t.BSTinsert("G");
		t.BSTinsert("E");

		t.print();				// 이진트리 출력

		System.out.println("=======================R=====================");
		TreeNode n = t.BSTsearch("R");			// R을 탐색해서 n에 결과를 저장 
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}
		
		t.BSTdelete("R");						// R 제거

		n = t.BSTsearch("R");					// 다시 R을 탐색해서 결과를 저장
		if (n == null) {						// 탐색 결과를 확인
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// R이 제거된 이진트리 출력
		
		System.out.println("=======================E=====================");
		n = t.BSTsearch("E");					// E 탐색
		if (n == null) {						// 탐색 결과 출력
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("E");						// E 제거

		n = t.BSTsearch("E");					// 다시 E를 탐색한 결과를 저장
		if (n == null) {						// 탐색 결과 출력
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// 현재 이진트리 출력

		System.out.println("=======================J=====================");

		n = t.BSTsearch("J");					// J 탐색
		if (n == null) {						// 탐색 결과 출력
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("J");						// J 탐색

		n = t.BSTsearch("J");					// 다시 J를 탐색한 결과를 저장
		if (n == null) {						// 탐색 결과 출력
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// 현재 이진트리 출력

		System.out.println("=======================S=====================");

		n = t.BSTsearch("S");					// S 탐색
		if (n == null) {						// 탐색 결과 출력
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("S");						// S 삭제

		n = t.BSTsearch("S");					// 다시 S를 탐색한 결과를 저장
		if (n == null) {						// 탐색 결과 출력
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// 현재 이진트리 출력

		System.out.println("=======================B=====================");

		n = t.BSTsearch("B");					// B 탐색
		if (n == null) {						// 탐색 결과 출력
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("B");						// B 삭제

		n = t.BSTsearch("B");					// 다시 B를 탐색한 결과를 저장
		if (n == null) {						// 탐색 결과 출력
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// 현재 이진트리 출력
	}
}
