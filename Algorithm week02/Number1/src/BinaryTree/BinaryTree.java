package BinaryTree;

public class BinaryTree {					// 이진트리 나타내는 BinaryTree
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
	
}
