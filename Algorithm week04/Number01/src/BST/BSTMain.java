package BST;

public class BSTMain {					// String Ÿ������ ����Ʈ���� �����ϴ� BSTmain Ŭ����
	public static void main(String args[]) {	// ���� �޼ҵ� 
		BinarySearchTree t = new BinarySearchTree();		// ���� ����Ʈ�� ����
		t.BSTinsert("S");		// ������ �� ����
		t.BSTinsert("J");
		t.BSTinsert("B");
		t.BSTinsert("D");
		t.BSTinsert("U");
		t.BSTinsert("M");
		t.BSTinsert("R");
		t.BSTinsert("Q");
		t.BSTinsert("A");
		t.BSTinsert("G");
		t.BSTinsert("E");

		t.print();				// ����Ʈ�� ���

		System.out.println("=======================R=====================");
		TreeNode n = t.BSTsearch("R");			// R�� Ž���ؼ� n�� ����� ���� 
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}
		
		t.BSTdelete("R");						// R ����

		n = t.BSTsearch("R");					// �ٽ� R�� Ž���ؼ� ����� ����
		if (n == null) {						// Ž�� ����� Ȯ��
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// R�� ���ŵ� ����Ʈ�� ���
		
		System.out.println("=======================E=====================");
		n = t.BSTsearch("E");					// E Ž��
		if (n == null) {						// Ž�� ��� ���
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("E");						// E ����

		n = t.BSTsearch("E");					// �ٽ� E�� Ž���� ����� ����
		if (n == null) {						// Ž�� ��� ���
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// ���� ����Ʈ�� ���

		System.out.println("=======================J=====================");

		n = t.BSTsearch("J");					// J Ž��
		if (n == null) {						// Ž�� ��� ���
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("J");						// J Ž��

		n = t.BSTsearch("J");					// �ٽ� J�� Ž���� ����� ����
		if (n == null) {						// Ž�� ��� ���
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// ���� ����Ʈ�� ���

		System.out.println("=======================S=====================");

		n = t.BSTsearch("S");					// S Ž��
		if (n == null) {						// Ž�� ��� ���
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("S");						// S ����

		n = t.BSTsearch("S");					// �ٽ� S�� Ž���� ����� ����
		if (n == null) {						// Ž�� ��� ���
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// ���� ����Ʈ�� ���

		System.out.println("=======================B=====================");

		n = t.BSTsearch("B");					// B Ž��
		if (n == null) {						// Ž�� ��� ���
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.BSTdelete("B");						// B ����

		n = t.BSTsearch("B");					// �ٽ� B�� Ž���� ����� ����
		if (n == null) {						// Ž�� ��� ���
			System.out.println("Not Found");
		} else {
			System.out.println("Found");
		}

		t.print();								// ���� ����Ʈ�� ���
	}
}
