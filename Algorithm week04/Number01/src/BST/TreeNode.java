/*  알고리즘 4주차 이진(이원)탐색트리
 * 	TreeNode.java, BSTSearchTree.java. BSTMain.java, BSTIntegerMain.java
 *  작성일 : 2020.09.24, 10.02
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 이진탐색트리 정수에 대한 예제와, 문자열에 대한 예제
 */

package BST;

public class TreeNode {
	private Object key;				// 노드의 정보를 저장할 key
	private TreeNode left;			// 왼쪽 자식 노드를 가리키는 left
	private TreeNode right;			// 오른쪽 자식 노드를 가리키는 right
	
	// Default Constructor	
	public TreeNode() {				// 매개변수가 없는 기본 생성자 
		this.key = null;			// 모든 변수를 null로 초기화
		this.left = null;
		this.right = null;
	}

	// Constructor
	public TreeNode(Object key) {	// key 매개변수가 주어진 생성자
		this.left = null;			// 다른 변수는 null로 초기화
		this.key = key;				// key을 매개변수 key으로 초기화하고
		this.right = null;
	}
	
	public TreeNode(TreeNode left, Object key, TreeNode right)	{	// 모든 매개변수가 주어진 생성자
		this.left = left;			// 각각의 변수들에
		this.key = key;				// 매개변수로 들어온 값들로 초기화
		this.right = right;
	}
	
	// getter setter
	public Object getKey() {		// key getter
		return key;					// key를 반환한다.
	}

	public void setKey(Object key) {// key setter
		this.key = key;				// 매개변수  key로 초기화해준다
	}

	public TreeNode getLeft() {		// left getter
		return left;				// left을 반환한다.
	}

	public void setLeft(TreeNode left) {	// left setter
		this.left = left;					// 매개변수로 들어온 노드 left로 초기화해준다.
	}	

	public TreeNode getRight() {	// right getter
		return right;				// right를 반환한다.
	}

	public void setRight(TreeNode right) {	// right setter
		this.right = right;					// 매개변수로 들어온 노드 right로 초기화해준다.
	}
	
}
