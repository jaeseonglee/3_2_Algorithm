/*  �˰��� 4���� ����(�̿�)Ž��Ʈ��
 * 	TreeNode.java, BSTSearchTree.java. BSTMain.java, BSTIntegerMain.java
 *  �ۼ��� : 2020.09.24, 10.02
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : ����Ž��Ʈ�� ������ ���� ������, ���ڿ��� ���� ����
 */

package BST;

public class TreeNode {
	private Object key;				// ����� ������ ������ key
	private TreeNode left;			// ���� �ڽ� ��带 ����Ű�� left
	private TreeNode right;			// ������ �ڽ� ��带 ����Ű�� right
	
	// Default Constructor	
	public TreeNode() {				// �Ű������� ���� �⺻ ������ 
		this.key = null;			// ��� ������ null�� �ʱ�ȭ
		this.left = null;
		this.right = null;
	}

	// Constructor
	public TreeNode(Object key) {	// key �Ű������� �־��� ������
		this.left = null;			// �ٸ� ������ null�� �ʱ�ȭ
		this.key = key;				// key�� �Ű����� key���� �ʱ�ȭ�ϰ�
		this.right = null;
	}
	
	public TreeNode(TreeNode left, Object key, TreeNode right)	{	// ��� �Ű������� �־��� ������
		this.left = left;			// ������ �����鿡
		this.key = key;				// �Ű������� ���� ����� �ʱ�ȭ
		this.right = right;
	}
	
	// getter setter
	public Object getKey() {		// key getter
		return key;					// key�� ��ȯ�Ѵ�.
	}

	public void setKey(Object key) {// key setter
		this.key = key;				// �Ű�����  key�� �ʱ�ȭ���ش�
	}

	public TreeNode getLeft() {		// left getter
		return left;				// left�� ��ȯ�Ѵ�.
	}

	public void setLeft(TreeNode left) {	// left setter
		this.left = left;					// �Ű������� ���� ��� left�� �ʱ�ȭ���ش�.
	}	

	public TreeNode getRight() {	// right getter
		return right;				// right�� ��ȯ�Ѵ�.
	}

	public void setRight(TreeNode right) {	// right setter
		this.right = right;					// �Ű������� ���� ��� right�� �ʱ�ȭ���ش�.
	}
	
}
