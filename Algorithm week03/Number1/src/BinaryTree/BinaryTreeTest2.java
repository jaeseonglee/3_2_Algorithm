
package BinaryTree;

public class BinaryTreeTest2 {					// 이진트리 테스트 클래스
	public static void main(String[] args) { 	// main 메소드
		BinaryTree root;						// BinaryTree root 생성
		BinaryTree copyTree;					// 이진트리를 복사해 저장할 copyTree 생성
		BinaryTree LeftTemp;					// BinaryTree LeftTemp 생성
		BinaryTree RightTemp;					// BinaryTree rightTemp 생성
		
		BinaryTree LeftSubroot;					// 왼쪽 서브 루트 노드를 가리키는 LeftSubroot 생성
		BinaryTree RightSubroot;				// 오른쪽 서브 루트 노드를 가리키는 RightSubroot 생성
		
		BinaryTree empty = new BinaryTree();	// 비어있는 이진트리 empty 생성 및 초기화 
		
		LeftTemp = new BinaryTree(empty, "2", empty);			// 루트가 2인 이진트리 생성
		RightTemp = new BinaryTree(empty, "3", empty);			// 루트가 3인 이진트리 생성
		
		LeftSubroot = new BinaryTree(LeftTemp,"+",RightTemp);	// 루트가 +이고 두 이진 트리를 서브 트리로 갖는 이진트리 LeftSubroot 생성
		
		LeftTemp = new BinaryTree(empty, "2", empty);			// 루트가 2인 이진트리 생성
		
		RightTemp = new BinaryTree(empty, "1", empty);			// 루트가 1인 이진트리 생성
		
		RightSubroot = new BinaryTree(LeftTemp,"/",RightTemp);  // 루트가  /이고 두 이진 트리를 서브 트리로 갖는 이진트리 RightSubroot 생성
		
		copyTree = RightSubroot;								// copyTree를 RightSubroot로 초기화
		
		root = new BinaryTree(LeftSubroot, "*", RightSubroot);  // 루트가 *이고 LeftSubroot와 RightSubroot를 서브 트리로 갖는 이진트리를 생성, root에 초기화
		
		System.out.println("=====root 출력=====");				// 이진트리 root 출력
		System.out.println("=====In Order=====");				// 중위 순회 출력
		root.inOrder_recursion();								// inOrder_recursion 메소드 호출
		
		System.out.println("\n=====Pre Order=====");			// 전위 순회 출력
		root.preOrder_recursion();								// preOrder_recursion 메소드 호출 
		
		System.out.println("\n=====Post Order=====");			// 후위 순회 출력
		root.postOrder_recursion();								// postOrder_recursion 메소드 호출 
		
		System.out.println("\n=====copyroot 출력=====");			// 이진트리 copyroot 출력
		System.out.println("=====In Order=====");				// 중위 순회 출력
		copyTree.inOrder_recursion();							// inOrder_recursion 메소드 호출
		
		System.out.println("\n=====Pre Order=====");			// 전위 순회 출력
		copyTree.preOrder_recursion();							// preOrder_recursion 메소드 호출 
		
		System.out.println("\n=====Post Order=====");			// 후위 순회 출력
		copyTree.postOrder_recursion();							// postOrder_recursion 메소드 호출 
		
		
		if (root.Equals(copyTree)) {							// Equals 메소드로 root와 copyTree 비교
			System.out.println("\nroot and copy are the same!!!");	 
		} else {
			System.out.println("\nroot and copy are the not same!!!"); 	// 두 트리가 다르기 때문에 55번 줄 수행
		}
		
		copyTree = root.copy();									// copy 메소드 호출로 copyTree에 root를 복사

		if (root.Equals(copyTree)) {							// 다시 Equals 메소드로 root와 copyTree 비교
			System.out.println("\nroot and copy are the same!!!"); // copyTree가 복사되어 같기 때문에 61번 줄 수행
		} else {
		System.out.println("\nroot and copy are the not same!!!");
		}
		
	}
}
