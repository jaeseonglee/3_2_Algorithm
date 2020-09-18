/*  알고리즘 3주차 이진트리 순회, 복사, 동일성 비교
 * 	TreeNode.java, BinaryTree.java, BinaryTreeTest2.java 
 *  작성일 : 2020.09.16 ~ 18
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 이진 트리 예제 
 */

package BinaryTree;

public class TreeNode {			// 이진트리의 노드 정보를 가지는 BinaryNode 클래스
	private Object item;		// 노드의 정보를 저장할 item
	private TreeNode left;		// 왼쪽 자식 노드를 가리키는 left
	private TreeNode right;		// 오른쪽 자식 노드를 가리키는 right
	
	// Default Constructor		
	public TreeNode() {			// 매개변수가 없는 기본 생성자 
		this.item = null;		// 모든 변수를 null로 초기화
		this.left = null;
		this.right = null;
	}
	
	// Constructor
	public TreeNode(Object item) {	// item 매개변수가 주어진 생성자
		this.item = item;			// item을 매개변수 item으로 초기화하고
		this.left = null;			// 다른 변수는 null로 초기화
		this.right = null;
	}
	
	public TreeNode(TreeNode left, Object item, TreeNode right) {	// 모든 매개변수가 주어진 생성자
		this.item = item;			// 각각의 변수들에
		this.left = left;			// 매개변수로 들어온 값들로 초기화
		this.right = right;
	}

	// getter setter
	public Object getItem() {		// item getter
		return item;				// item을 반환한다.
	}
	
	public void setItem(Object item) {	// item setter
		this.item = item;				// 매개변수 item으로 초기화해준다.
	}
	
	public TreeNode getLeft() {		// left getter
		return left;				// left을 반환한다.
	}							
	
	public void setLeft(TreeNode left) {	// left setter
		this.left = left;					// 매개변수로 들어온 노드 left로 초기화해준다.
	}
	
	public TreeNode getRight() { 	// right getter
		return right;				// right를 반환한다.
	}
	
	public void setRight(TreeNode right) {	// right setter
		this.right = right;					// 매개변수로 들어온 노드 right로 초기화해준다.
	}
	
}
