package BinaryTree;

public class BinaryTree {
	private TreeNode root = new TreeNode();	// ���� root�� �Ǵ� ��� root�� ���� �� �ʱ�ȭ ���ش�.
	
	public BinaryTree() {					// ������
		this.root = null;					// ���� Ʈ���� �����ϸ� root���� null�� �ʱ�ȭ���ش�.
	}
	
	public BinaryTree(BinaryTree left, Object item, BinaryTree right) {	// �Ű������� �ִ� ������
		this.root.setItem(item);			// root ����� item�� �Ű����� item���� setter�� ���� �ʱ�ȭ
		this.root.setLeft(left.root);		// root ����� ���� �ڽ� ��带 ����Ʈ���� left�� root ���� �ʱ�ȭ
		this.root.setRight(right.root);		// root ����� ������ �ڽ� ��带 ����Ʈ�� right�� root ���� �ʱ�ȭ
	}
	
	public boolean isEmpty() {				// ����Ʈ���� ��� �ִ��� Ȯ���ϴ� isEmpty �޼ҵ�
		if(this.root == null)				// root�� null�̶��
			return true;					// ture ��ȯ
		else 
			return false;					// �ƴ϶�� false ��ȯ
	}
	
	/*// 2�������� ����ߴ� �ڵ� 3�������� ���� �޼ҵ���� ȣ������ �ʾ� �ּ�ó��(200918)
	public Object rootData() {				// root ��忡 ����� item���� ��ȯ�ϴ� rootData �޼ҵ�
		if(this.isEmpty()) {				// ����Ʈ���� ����ִٸ� 
			System.out.println("Tree is Empty!!");	// Ʈ���� ����ִٰ� ����ϰ�
			return null;					// null���� ��ȯ
		} else 
			return root.getItem();			// ���� ������ �ƴ϶�� root�� item���� ��ȯ
	}
	
	public BinaryTree leftSubTree() {		// ���� ����Ʈ���� ��ȯ�ϴ� leftSubTree �޼ҵ�
		if(this.root.getLeft() == null)		// ���� ����Ʈ���� ����ִٸ� 
			return null;					// null���� ��ȯ
		else {									// ���� ����Ʈ���� �ִٸ�
			BinaryTree left = new BinaryTree();	// ��ȯ������ left ���� ���� �� �ʱ�ȭ
			left.root = this.root.getLeft();	// left�� root�� ���� root�� ���� ����� ������ �ʱ�ȭ 
			return left;						// left�� ��ȯ�ϸ� ����
		}
	}
	
	public BinaryTree rightSubTree() {		// ������ ����Ʈ���� ��ȯ�ϴ� rightSubTree �޼ҵ�
		if(this.root.getRight() == null)	// ������ ����Ʈ���� ����ִٸ�
			return null;					// null���� ��ȯ
		else {									// ������ ����Ʈ���� �ִٸ� 
			BinaryTree right = new BinaryTree();// ��ȯ������ right ���� ���� �� �ʱ�ȭ
			right.root = this.root.getRight();	// right�� root�� ���� root�� ������ ����� ������ �ʱ�ȭ
			return right;						// right�� ��ȯ�ϸ� ����
		}
	}

	public void show() {						// ���� Ʈ���� ��Ʈ, ����, ������ ��带 ����ϴ� show �޼ҵ� 
		BinaryTree right = this.rightSubTree();	// ����,������ ����Ʈ���� ����ϱ� ���� ���� left, rught ����Ʈ�� ���� ��
		BinaryTree left = this.leftSubTree();	// leftSubTree, rightSubTree �޼ҵ带 ���� ���� root�� ���� Ʈ���� �ʱ�ȭ
		
		System.out.println("root item : " + this.rootData());		// Ʈ���� ������ ���
		System.out.println("left item : " + left.root.getItem());	// this.leftSubTree().root.getItem() 
		System.out.println("right item : " + right.root.getItem()); // this.rightSubTree().root.getItem() -> 52,53��° �ڵ� ��� �����
	}
	*/
	
	
	// pre-order(����) root-left-right
	public void preOrder_recursion() {  		// ����Ʈ���� ������ȸ�� �湮�ϴ� preOrder_recursion �޼ҵ�
		preOrder_recursion_method(this.root);	// preOrder_recursion_method �޼ҵ� ȣ��� ���� ��ȸ
	}
	
	private void preOrder_recursion_method(TreeNode T) {	// ��͸� ���� ������ȸ�� �ϴ� preOrder_recursion_method �޼ҵ�
		if(T != null) {									// ���� ��尡 null�� �ƴ϶��
			System.out.print(T.getItem() + " ");		// ���� ���� ����� ��Ʈ ��带 ����ϰ�
			preOrder_recursion_method(T.getLeft());		// ���� ����Ʈ���� ���� ���� ��ȸ�� ȣ�� 
			preOrder_recursion_method(T.getRight()); 	// ������ ���� Ʈ���� ���� ���� ��ȸ�� ȣ��
		}
	}
	
	// in-order(����) left-root-right
	public void inOrder_recursion() {			// ����Ʈ���� ������ȸ�� �湮�ϴ� inOrder_recursion �޼ҵ�
		inOrder_recursion_method(this.root);	// inOrder_recursion_method �޼ҵ� ȣ��� ���� ��ȸ
	}
	
	private void inOrder_recursion_method(TreeNode T) {		// ��͸� ���� ������ȸ�� �ϴ� inOrder_recursion_method �޼ҵ�
		if(T != null) {									// ���� ��尡 null�� �ƴ϶��
			inOrder_recursion_method(T.getLeft());		// ���� ���� ����Ʈ���� ���� ���� ��ȸ�� ȣ��
			System.out.print(T.getItem() + " ");		// �� ���� ���� ��Ʈ ��带 ����ϰ� 
			inOrder_recursion_method(T.getRight());		// ���������� ������ ����Ʈ���� ���� ��ȸ�� ȣ���Ѵ�.
		}
	}
	
	// post-order(����) left-right-root
	public void postOrder_recursion() {			// ����Ʈ���� ������ȸ�� �湮�ϴ� postOrder_recursion �޼ҵ�	
		postOrder_recursion_method(this.root);	// postOrder_recursion_method �޼ҵ� ȣ��� ���� ��ȸ
	}
	
	private void postOrder_recursion_method(TreeNode T) {	// ��͸� ���� ������ȸ�� �ϴ� postOrder_recursion_method �޼ҵ�
		if(T != null) {									// ���� ��尡 null�� �ƴ϶��
			postOrder_recursion_method(T.getLeft());	// ���� ���� ����Ʈ���� ���� ���� ��ȸ�� ȣ���ϰ�
			postOrder_recursion_method(T.getRight());	// ������ ����Ʈ���� ���� ���� ��ȸ�� �� ������
			System.out.print(T.getItem() + " ");		// ���� ����Ʈ���� �� ��ȸ�ϰ� ������ ��Ʈ ��带 ����Ѵ�.
		}
	}
	
	public BinaryTree copy() {					// ���� ����Ʈ���� �����Ͽ� ��ȯ�ϴ�  copy �޼ҵ�
		BinaryTree newTree = new BinaryTree();	// �� ����Ʈ���� ���� �� �ʱ�ȭ�Ѵ�.
		newTree.root = theCopy(root);			// theCopy �޼ҵ忡 ���� ��Ʈ ���� ���ڷ� �Ѱ������ν� ����Ʈ���� �����Ѵ�.
		return newTree;							// ����� newTree�� ��ȯ�����ν� ���� �Ϸ�, �޼ҵ� ����
	}
	
	private TreeNode theCopy(TreeNode t) {		// ��͸� ���� �־��� �Ű������� ��Ʈ ���� ���� ����Ʈ���� �����ϴ� theCopy �޼ҵ�
		if(t == null) return null;				// �Ű������� null���̶�� null�� ��ȯ�Ѵ�.
		else { 									// �ٸ� ���� �ִٸ�
			TreeNode LNode = theCopy(t.getLeft());	// t�� ���� ����Ʈ���� ���� theCopy �޼ҵ� ȣ�� �� �� ���� LNode�� ����
			TreeNode RNode = theCopy(t.getRight());	// t�� ������ ����Ʈ���� ���� theCopy �޼ҵ� ȣ�� �� �� ���� RNode�� ����
			TreeNode newNode = new TreeNode(LNode, t.getItem(), RNode);	// LNode,RNode �׸��� t�� ��Ʈ ��� ������ ���� newNode ���� �� �ʱ�ȭ
			return newNode;						// ��������� t�� ������ newNode�� ��ȯ, �޼ҵ� ���� 
		}
	}
	
	// 	200917, java�� equals('e'quals) �޼ҵ�� ȥ�� ����
	public boolean Equals(BinaryTree tr) {		// ���� ����Ʈ���� �־��� �Ű����� ����Ʈ���� ������ Ȯ���ϴ�  Equals �޼ҵ� 
		return theEqual(this.root, tr.root);	// theEqual �޼ҵ带 ȣ���ϸ鼭 �� boolean���� ��ȯ
	}
	
	private boolean theEqual(TreeNode s, TreeNode t) {	// ��͸� ���� �� TreeNode�� ���� ����Ʈ������ Ȯ���ϴ� theEqual �޼ҵ�
		if (s == null && t == null) {							// 1. �� �Ű������� �� null�̶��
			return true;										// true�� ��ȯ	
		} else if (s != null && t != null) {					// 2. �� �� null�� �ƴ϶�� 
			if (s.getItem().equals(t.getItem())) {				// 2_1.���� �� ����� ��Ʈ ��带 equals �޼ҵ�� �� 
				if( theEqual(s.getLeft(), t.getLeft()))	{ 		// 2_2. 2_1�� true�� ��ȯ�ϸ� �� ����� ���� ����Ʈ���� theEqualȣ��� �� 
					return theEqual(s.getRight(), t.getRight());// 2_3. 2_2�� true�� ��ȯ�ϸ� �� ����� ������ ����Ʈ����  theEqualȣ��� �� 
				} else {					// 2_2�� ���� else�� 
					return false;			// �� ����� ���� ����Ʈ�� �� ����� false�� ������ false ��ȯ
				}
			} else {						// 2_1�� ���� else�� 
				return false;				// �� ����� ��Ʈ�� �ٸ��� ������ false ��ȯ
			}
		} else {							// 3. 1,2���� ��Ȳ�� �ƴ϶�� (�� �Ű� ������ ��Ե� ���� ������ ���� �ٸ��ٸ�)
			return false;					// false�� ��ȯ
		}
	}
	
}
