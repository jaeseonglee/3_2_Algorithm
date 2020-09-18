
package BinaryTree;

public class BinaryTreeTest2 {					// ����Ʈ�� �׽�Ʈ Ŭ����
	public static void main(String[] args) { 	// main �޼ҵ�
		BinaryTree root;						// BinaryTree root ����
		BinaryTree copyTree;					// ����Ʈ���� ������ ������ copyTree ����
		BinaryTree LeftTemp;					// BinaryTree LeftTemp ����
		BinaryTree RightTemp;					// BinaryTree rightTemp ����
		
		BinaryTree LeftSubroot;					// ���� ���� ��Ʈ ��带 ����Ű�� LeftSubroot ����
		BinaryTree RightSubroot;				// ������ ���� ��Ʈ ��带 ����Ű�� RightSubroot ����
		
		BinaryTree empty = new BinaryTree();	// ����ִ� ����Ʈ�� empty ���� �� �ʱ�ȭ 
		
		LeftTemp = new BinaryTree(empty, "2", empty);			// ��Ʈ�� 2�� ����Ʈ�� ����
		RightTemp = new BinaryTree(empty, "3", empty);			// ��Ʈ�� 3�� ����Ʈ�� ����
		
		LeftSubroot = new BinaryTree(LeftTemp,"+",RightTemp);	// ��Ʈ�� +�̰� �� ���� Ʈ���� ���� Ʈ���� ���� ����Ʈ�� LeftSubroot ����
		
		LeftTemp = new BinaryTree(empty, "2", empty);			// ��Ʈ�� 2�� ����Ʈ�� ����
		
		RightTemp = new BinaryTree(empty, "1", empty);			// ��Ʈ�� 1�� ����Ʈ�� ����
		
		RightSubroot = new BinaryTree(LeftTemp,"/",RightTemp);  // ��Ʈ��  /�̰� �� ���� Ʈ���� ���� Ʈ���� ���� ����Ʈ�� RightSubroot ����
		
		copyTree = RightSubroot;								// copyTree�� RightSubroot�� �ʱ�ȭ
		
		root = new BinaryTree(LeftSubroot, "*", RightSubroot);  // ��Ʈ�� *�̰� LeftSubroot�� RightSubroot�� ���� Ʈ���� ���� ����Ʈ���� ����, root�� �ʱ�ȭ
		
		System.out.println("=====root ���=====");				// ����Ʈ�� root ���
		System.out.println("=====In Order=====");				// ���� ��ȸ ���
		root.inOrder_recursion();								// inOrder_recursion �޼ҵ� ȣ��
		
		System.out.println("\n=====Pre Order=====");			// ���� ��ȸ ���
		root.preOrder_recursion();								// preOrder_recursion �޼ҵ� ȣ�� 
		
		System.out.println("\n=====Post Order=====");			// ���� ��ȸ ���
		root.postOrder_recursion();								// postOrder_recursion �޼ҵ� ȣ�� 
		
		System.out.println("\n=====copyroot ���=====");			// ����Ʈ�� copyroot ���
		System.out.println("=====In Order=====");				// ���� ��ȸ ���
		copyTree.inOrder_recursion();							// inOrder_recursion �޼ҵ� ȣ��
		
		System.out.println("\n=====Pre Order=====");			// ���� ��ȸ ���
		copyTree.preOrder_recursion();							// preOrder_recursion �޼ҵ� ȣ�� 
		
		System.out.println("\n=====Post Order=====");			// ���� ��ȸ ���
		copyTree.postOrder_recursion();							// postOrder_recursion �޼ҵ� ȣ�� 
		
		
		if (root.Equals(copyTree)) {							// Equals �޼ҵ�� root�� copyTree ��
			System.out.println("\nroot and copy are the same!!!");	 
		} else {
			System.out.println("\nroot and copy are the not same!!!"); 	// �� Ʈ���� �ٸ��� ������ 55�� �� ����
		}
		
		copyTree = root.copy();									// copy �޼ҵ� ȣ��� copyTree�� root�� ����

		if (root.Equals(copyTree)) {							// �ٽ� Equals �޼ҵ�� root�� copyTree ��
			System.out.println("\nroot and copy are the same!!!"); // copyTree�� ����Ǿ� ���� ������ 61�� �� ����
		} else {
		System.out.println("\nroot and copy are the not same!!!");
		}
		
	}
}
