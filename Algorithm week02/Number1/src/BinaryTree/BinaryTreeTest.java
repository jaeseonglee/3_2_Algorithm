package BinaryTree;

public class BinaryTreeTest {					// ����Ʈ�� �׽�Ʈ Ŭ����
	public static void main(String[] args) {	// main �޼ҵ�
		BinaryTree root;						// BinaryTree root ����
		BinaryTree LeftTemp;					// BinaryTree LeftTemp ����
		BinaryTree RightTemp;					// BinaryTree rightTemp ����
		
		BinaryTree LeftSubroot;					// ���� ���� ��Ʈ ��带 ����Ű�� LeftSubroot ����
		BinaryTree RightSubroot;				// ������ ���� ��Ʈ ��带 ����Ű�� RightSubroot ����
		
		BinaryTree empty = new BinaryTree();	// ����ִ� ����Ʈ�� empty ���� �� �ʱ�ȭ 
		
		LeftTemp = new BinaryTree(empty, 'A', empty);			// ��Ʈ�� A�� ����Ʈ�� ����
		RightTemp = new BinaryTree(empty, 'B', empty);			// ��Ʈ�� B�� ����Ʈ�� ����
		
		LeftSubroot = new BinaryTree(LeftTemp, '+', RightTemp);	// ��Ʈ�� +�̰� �� ���� Ʈ���� ���� Ʈ���� ���� ����Ʈ�� LeftSubroot ����
		
		LeftTemp = new BinaryTree(empty, 'C', empty);			// ��Ʈ�� C�� ����Ʈ�� ����
		RightTemp = new BinaryTree(empty, 'D', empty);			// ��Ʈ�� D�� ����Ʈ�� ����
			
		RightSubroot = new BinaryTree(LeftTemp, '/', RightTemp); // ��Ʈ�� /�̰� �� ���� Ʈ���� ���� Ʈ���� ���� ����Ʈ�� RightSubroot ����
		
		root = new BinaryTree(LeftSubroot, '*', RightSubroot);	// LeftSubroot�� RightSubroot�� ���� Ʈ���� ���� ����Ʈ�� root ���� 
		
		System.out.println("=====root=====");					// root ����Ʈ���� ��Ʈ�� �� ���� Ʈ���� ��Ʈ ��� ���
		root.show();											 
		
		System.out.println("=====root's right subTree=====");	// root�� ������ ���� Ʈ���� ��Ʈ ���� �� ���� Ʈ���� ��Ʈ ��� ��� 
		root.rightSubTree().show();								
			
		System.out.println("=====root's left subTree=====");	// root�� ���� ���� Ʈ���� ��Ʈ ���� �� ���� Ʈ���� ��Ʈ ��� ��� 
		root.leftSubTree().show();								
		
	}
	
}
