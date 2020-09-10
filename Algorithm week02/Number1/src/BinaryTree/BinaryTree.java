package BinaryTree;

public class BinaryTree {					// ����Ʈ�� ��Ÿ���� BinaryTree
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
	
}
