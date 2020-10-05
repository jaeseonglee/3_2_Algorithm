package BST;

public class BSTIntegerMain {	// Integer Ÿ������ ����Ʈ���� �����ϴ� BSTIntegerMain Ŭ����
	public static void main(String args[])	{ // ���� �޼ҵ�
		BinarySearchTree t = new BinarySearchTree(); 	// ���� ����Ʈ�� ����
		t.BSTinsert(10);			// ������ �� ����
		t.BSTinsert(5);
		t.BSTinsert(9);
		t.BSTinsert(11);
		t.BSTinsert(15);
		t.BSTinsert(14);
		t.BSTinsert(7);
		t.BSTinsert(3);
		t.BSTinsert(20);
		t.BSTinsert(22);
		t.BSTinsert(1);
		
		t.print();				 	// ����Ʈ�� ���
		
		System.out.println("=======================1=====================");
		TreeNode n = t.BSTsearch(1);			// 1�� Ž���ؼ� n�� ����� ���� 
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(1);							// 1 ����
		
		n = t.BSTsearch(1);						// �ٽ� 1�� Ž���� ����� ����
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// 1�� ���ŵ� ���� ����Ʈ�� ���
		
		System.out.println("=======================11=====================");
		n = t.BSTsearch(11);					// 11 Ž��
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(11);						// 11 ����

		n = t.BSTsearch(11);					// �ٽ� 11�� Ž���� ����� ����
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// ���� ����Ʈ�� ���
		
		System.out.println("=======================15=====================");
		n = t.BSTsearch(15);					// 15 Ž��
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}
		
		t.BSTdelete(15);						// 15 ����
		
		n = t.BSTsearch(15);					// �ٽ� 15�� Ž���� ����� ����
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// ���� ����Ʈ�� ���
		
		System.out.println("=======================9=====================");
		
		n = t.BSTsearch(9);						// 9 Ž��
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(9);							// 9 ����

		n = t.BSTsearch(9);						// �ٽ� 9�� Ž���� ����� ����
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// ���� ����Ʈ�� ���
		
		System.out.println("=======================20=====================");
		
		n = t.BSTsearch(20);						// 20 Ž��
		if (n == null) {							// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete(20);							// 20 ����

		n = t.BSTsearch(20);						// �ٽ� 20�� Ž���� ����� ����
		if (n == null) {							// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();									// ���� ����Ʈ�� ���

		System.out.println("============================================");
	}
}
