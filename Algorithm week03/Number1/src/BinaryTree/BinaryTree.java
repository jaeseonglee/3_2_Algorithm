package BinaryTree;

public class BinaryTree {
	private TreeNode root = new TreeNode();	// 먼저 root가 되는 노드 root를 생성 및 초기화 해준다.
	
	public BinaryTree() {					// 생성자
		this.root = null;					// 이진 트리를 생성하면 root값을 null로 초기화해준다.
	}
	
	public BinaryTree(BinaryTree left, Object item, BinaryTree right) {	// 매개변수가 있는 생성자
		this.root.setItem(item);			// root 노드의 item을 매개변수 item으로 setter를 통해 초기화
		this.root.setLeft(left.root);		// root 노드의 왼쪽 자식 노드를 이진트리의 left의 root 노드로 초기화
		this.root.setRight(right.root);		// root 노드의 오른쪽 자식 노드를 이진트리 right의 root 노드로 초기화
	}
	
	public boolean isEmpty() {				// 이진트리가 비어 있는지 확인하는 isEmpty 메소드
		if(this.root == null)				// root가 null이라면
			return true;					// ture 반환
		else 
			return false;					// 아니라면 false 반환
	}
	
	/*// 2주차에서 사용했던 코드 3주차에서 이하 메소드들을 호출하지 않아 주석처리(200918)
	public Object rootData() {				// root 노드에 저장된 item값을 반환하는 rootData 메소드
		if(this.isEmpty()) {				// 이진트리가 비어있다면 
			System.out.println("Tree is Empty!!");	// 트리가 비어있다고 출력하고
			return null;					// null값을 반환
		} else 
			return root.getItem();			// 위에 조건이 아니라면 root의 item값을 반환
	}
	
	public BinaryTree leftSubTree() {		// 왼쪽 서브트리를 반환하는 leftSubTree 메소드
		if(this.root.getLeft() == null)		// 왼쪽 서브트리가 비어있다면 
			return null;					// null값을 반환
		else {									// 왼쪽 서브트리가 있다면
			BinaryTree left = new BinaryTree();	// 반환값으로 left 변수 생성 및 초기화
			left.root = this.root.getLeft();	// left의 root를 현재 root의 왼쪽 노드의 값으로 초기화 
			return left;						// left를 반환하며 종료
		}
	}
	
	public BinaryTree rightSubTree() {		// 오른쪽 서브트리를 반환하는 rightSubTree 메소드
		if(this.root.getRight() == null)	// 오른쪽 서브트리가 비어있다면
			return null;					// null값을 반환
		else {									// 오른쪽 서브트리가 있다면 
			BinaryTree right = new BinaryTree();// 반환값으로 right 변수 생성 및 초기화
			right.root = this.root.getRight();	// right의 root를 현재 root의 오른족 노드의 값으로 초기화
			return right;						// right를 반환하며 종료
		}
	}

	public void show() {						// 이진 트리의 루트, 왼쪽, 오른쪽 노드를 출력하는 show 메소드 
		BinaryTree right = this.rightSubTree();	// 왼쪽,오른쪽 서브트리를 출력하기 위해 각각 left, rught 이진트리 생성 및
		BinaryTree left = this.leftSubTree();	// leftSubTree, rightSubTree 메소드를 통해 현재 root의 서브 트리로 초기화
		
		System.out.println("root item : " + this.rootData());		// 트리의 정보를 출력
		System.out.println("left item : " + left.root.getItem());	// this.leftSubTree().root.getItem() 
		System.out.println("right item : " + right.root.getItem()); // this.rightSubTree().root.getItem() -> 52,53번째 코드 대신 사용사능
	}
	*/
	
	
	// pre-order(전위) root-left-right
	public void preOrder_recursion() {  		// 이진트리를 전위순회로 방문하는 preOrder_recursion 메소드
		preOrder_recursion_method(this.root);	// preOrder_recursion_method 메소드 호출로 전위 순회
	}
	
	private void preOrder_recursion_method(TreeNode T) {	// 재귀를 통해 전위순회를 하는 preOrder_recursion_method 메소드
		if(T != null) {									// 현재 노드가 null이 아니라면
			System.out.print(T.getItem() + " ");		// 먼저 현재 노드의 루트 노드를 출력하고
			preOrder_recursion_method(T.getLeft());		// 왼쪽 서브트리에 대해 전위 순회로 호출 
			preOrder_recursion_method(T.getRight()); 	// 오른쪽 서브 트리에 대해 전위 순회로 호출
		}
	}
	
	// in-order(중위) left-root-right
	public void inOrder_recursion() {			// 이진트리를 중위순회로 방문하는 inOrder_recursion 메소드
		inOrder_recursion_method(this.root);	// inOrder_recursion_method 메소드 호출로 중위 순회
	}
	
	private void inOrder_recursion_method(TreeNode T) {		// 재귀를 통해 중위순회를 하는 inOrder_recursion_method 메소드
		if(T != null) {									// 현재 노드가 null이 아니라면
			inOrder_recursion_method(T.getLeft());		// 먼저 왼쪽 서브트리에 대해 중위 순회로 호출
			System.out.print(T.getItem() + " ");		// 그 다음 현재 루트 노드를 출력하고 
			inOrder_recursion_method(T.getRight());		// 마지막으로 오른쪽 서브트리를 중위 순회로 호출한다.
		}
	}
	
	// post-order(후위) left-right-root
	public void postOrder_recursion() {			// 이진트리를 후위순회로 방문하는 postOrder_recursion 메소드	
		postOrder_recursion_method(this.root);	// postOrder_recursion_method 메소드 호출로 후위 순회
	}
	
	private void postOrder_recursion_method(TreeNode T) {	// 재귀를 통해 후위순회를 하는 postOrder_recursion_method 메소드
		if(T != null) {									// 현재 노드가 null이 아니라면
			postOrder_recursion_method(T.getLeft());	// 먼저 왼쪽 서브트리에 대해 후위 순회로 호출하고
			postOrder_recursion_method(T.getRight());	// 오른쪽 서브트리에 대해 후위 순회를 한 다음에
			System.out.print(T.getItem() + " ");		// 양쪽 서브트리를 다 순회하고 나서야 루트 노드를 출력한다.
		}
	}
	
	public BinaryTree copy() {					// 현재 이진트리를 복사하여 반환하는  copy 메소드
		BinaryTree newTree = new BinaryTree();	// 빈 이진트리를 생성 및 초기화한다.
		newTree.root = theCopy(root);			// theCopy 메소드에 현재 루트 값을 인자로 넘겨줌으로써 이진트리를 복사한다.
		return newTree;							// 복사된 newTree를 반환함으로써 복사 완료, 메소드 종료
	}
	
	private TreeNode theCopy(TreeNode t) {		// 재귀를 통해 주어진 매개변수를 루트 노드로 갖는 이진트리를 복사하는 theCopy 메소드
		if(t == null) return null;				// 매개변수가 null값이라면 null을 반환한다.
		else { 									// 다른 값이 있다면
			TreeNode LNode = theCopy(t.getLeft());	// t의 왼쪽 서브트리에 대해 theCopy 메소드 호출 및 그 값을 LNode에 저장
			TreeNode RNode = theCopy(t.getRight());	// t의 오른쪽 서브트리에 대해 theCopy 메소드 호출 및 그 값을 RNode에 저장
			TreeNode newNode = new TreeNode(LNode, t.getItem(), RNode);	// LNode,RNode 그리고 t의 루트 노드 정보를 갖는 newNode 생성 및 초기화
			return newNode;						// 결과적으로 t를 복사한 newNode를 반환, 메소드 종료 
		}
	}
	
	// 	200917, java의 equals('e'quals) 메소드와 혼동 주의
	public boolean Equals(BinaryTree tr) {		// 현재 이진트리와 주어진 매개변수 이진트리가 같은지 확인하는  Equals 메소드 
		return theEqual(this.root, tr.root);	// theEqual 메소드를 호출하면서 그 boolean값을 반환
	}
	
	private boolean theEqual(TreeNode s, TreeNode t) {	// 재귀를 통해 두 TreeNode가 같은 이진트리인지 확인하는 theEqual 메소드
		if (s == null && t == null) {							// 1. 두 매개변수가 다 null이라면
			return true;										// true를 반환	
		} else if (s != null && t != null) {					// 2. 둘 다 null이 아니라면 
			if (s.getItem().equals(t.getItem())) {				// 2_1.각각 두 노드의 루트 노드를 equals 메소드로 비교 
				if( theEqual(s.getLeft(), t.getLeft()))	{ 		// 2_2. 2_1이 true를 반환하면 두 노드의 왼쪽 서브트리를 theEqual호출로 비교 
					return theEqual(s.getRight(), t.getRight());// 2_3. 2_2가 true를 반환하면 두 노드의 오른쪽 서브트리를  theEqual호출로 비교 
				} else {					// 2_2에 대한 else문 
					return false;			// 두 노드의 왼쪽 서브트리 비교 결과가 false기 때문에 false 반환
				}
			} else {						// 2_1에 대한 else문 
				return false;				// 두 노드의 루트가 다르기 때문에 false 반환
			}
		} else {							// 3. 1,2번의 상황이 아니라면 (두 매개 변수에 어떻게든 값은 있으나 값이 다르다면)
			return false;					// false를 반환
		}
	}
	
}
