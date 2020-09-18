/*  �˰��� 3���� ����Ʈ�� ��ȸ, ����, ���ϼ� ��
 * 	TreeNode.java, BinaryTree.java, BinaryTreeTest2.java 
 *  �ۼ��� : 2020.09.16 ~ 18
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : ���� Ʈ�� ���� 
 */

package BinaryTree;

public class TreeNode {			// ����Ʈ���� ��� ������ ������ BinaryNode Ŭ����
	private Object item;		// ����� ������ ������ item
	private TreeNode left;		// ���� �ڽ� ��带 ����Ű�� left
	private TreeNode right;		// ������ �ڽ� ��带 ����Ű�� right
	
	// Default Constructor		
	public TreeNode() {			// �Ű������� ���� �⺻ ������ 
		this.item = null;		// ��� ������ null�� �ʱ�ȭ
		this.left = null;
		this.right = null;
	}
	
	// Constructor
	public TreeNode(Object item) {	// item �Ű������� �־��� ������
		this.item = item;			// item�� �Ű����� item���� �ʱ�ȭ�ϰ�
		this.left = null;			// �ٸ� ������ null�� �ʱ�ȭ
		this.right = null;
	}
	
	public TreeNode(TreeNode left, Object item, TreeNode right) {	// ��� �Ű������� �־��� ������
		this.item = item;			// ������ �����鿡
		this.left = left;			// �Ű������� ���� ����� �ʱ�ȭ
		this.right = right;
	}

	// getter setter
	public Object getItem() {		// item getter
		return item;				// item�� ��ȯ�Ѵ�.
	}
	
	public void setItem(Object item) {	// item setter
		this.item = item;				// �Ű����� item���� �ʱ�ȭ���ش�.
	}
	
	public TreeNode getLeft() {		// left getter
		return left;				// left�� ��ȯ�Ѵ�.
	}							
	
	public void setLeft(TreeNode left) {	// left setter
		this.left = left;					// �Ű������� ���� ��� left�� �ʱ�ȭ���ش�.
	}
	
	public TreeNode getRight() { 	// right getter
		return right;				// right�� ��ȯ�Ѵ�.
	}
	
	public void setRight(TreeNode right) {	// right setter
		this.right = right;					// �Ű������� ���� ��� right�� �ʱ�ȭ���ش�.
	}
	
}
