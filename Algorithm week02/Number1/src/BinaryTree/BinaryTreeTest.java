package BinaryTree;

public class BinaryTreeTest {					// 이진트리 테스트 클래스
	public static void main(String[] args) {	// main 메소드
		BinaryTree root;						// BinaryTree root 생성
		BinaryTree LeftTemp;					// BinaryTree LeftTemp 생성
		BinaryTree RightTemp;					// BinaryTree rightTemp 생성
		
		BinaryTree LeftSubroot;					// 왼쪽 서브 루트 노드를 가리키는 LeftSubroot 생성
		BinaryTree RightSubroot;				// 오른쪽 서브 루트 노드를 가리키는 RightSubroot 생성
		
		BinaryTree empty = new BinaryTree();	// 비어있는 이진트리 empty 생성 및 초기화 
		
		LeftTemp = new BinaryTree(empty, 'A', empty);			// 루트가 A인 이진트리 생성
		RightTemp = new BinaryTree(empty, 'B', empty);			// 루트가 B인 이진트리 생성
		
		LeftSubroot = new BinaryTree(LeftTemp, '+', RightTemp);	// 루트가 +이고 두 이진 트리를 서브 트리로 갖는 이진트리 LeftSubroot 생성
		
		LeftTemp = new BinaryTree(empty, 'C', empty);			// 루트가 C인 이진트리 생성
		RightTemp = new BinaryTree(empty, 'D', empty);			// 루트가 D인 이진트리 생성
			
		RightSubroot = new BinaryTree(LeftTemp, '/', RightTemp); // 루트가 /이고 두 이진 트리를 서브 트리로 갖는 이진트리 RightSubroot 생성
		
		root = new BinaryTree(LeftSubroot, '*', RightSubroot);	// LeftSubroot와 RightSubroot를 서브 트리로 갖는 이진트리 root 생성 
		
		System.out.println("=====root=====");					// root 이진트리의 루트와 두 서브 트리의 루트 노드 출력
		root.show();											 
		
		System.out.println("=====root's right subTree=====");	// root의 오른쪽 서브 트리의 루트 노드와 두 서브 트리의 루트 노드 출력 
		root.rightSubTree().show();								
			
		System.out.println("=====root's left subTree=====");	// root의 왼쪽 서브 트리의 루트 노드와 두 서브 트리의 루트 노드 출력 
		root.leftSubTree().show();								
		
	}
	
}
