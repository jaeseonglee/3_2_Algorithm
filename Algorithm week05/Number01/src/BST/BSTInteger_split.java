package BST;

public class BSTInteger_split {
	public static void main(String args[])	// main 메소드
	{
		BinarySearchTree aBST = new BinarySearchTree();		// 공백 이진트리 aBST 생성 및 초기화
		
		System.out.println("[INFO] Insert ");				// 정수값들로 삽입 
		
		aBST.BSTinsert(11);
		aBST.BSTinsert(9);
		aBST.BSTinsert(14);
		aBST.BSTinsert(22);
		aBST.BSTinsert(18);
		aBST.BSTinsert(16);
		aBST.BSTinsert(17);
		aBST.BSTinsert(15);
		
		System.out.println("===aBST print===");
		aBST.print();
		
		BinarySearchTree bBST = new BinarySearchTree();		// 공백 이진트리 bBST,
		BinarySearchTree cBST = new BinarySearchTree();		// 공백 이진트 cBST 생성 및 초기화
		
		System.out.println("[INFO] Split 16");
		aBST.split(bBST,cBST,16);

		System.out.println("Left Tree");
		bBST.print();
		
		System.out.println("Right Tree");
		cBST.print();		
		
		bBST = new BinarySearchTree();
		cBST = new BinarySearchTree();
		
		aBST = new BinarySearchTree();
		
		System.out.println("===aBST print===");
		
		aBST.BSTinsert(11);
		aBST.BSTinsert(9);
		aBST.BSTinsert(14);
		aBST.BSTinsert(22);
		aBST.BSTinsert(18);
		aBST.BSTinsert(16);
		aBST.BSTinsert(17);
		aBST.BSTinsert(15);
		
		aBST.print();
		
		System.out.println("[INFO] Split 19");
		aBST.split(bBST,cBST,19);
		
		System.out.println("Left Tree");
		bBST.print();
		
		System.out.println("Right Tree");
		cBST.print();
	}
}
