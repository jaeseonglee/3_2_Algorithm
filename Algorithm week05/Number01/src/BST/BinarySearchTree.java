package BST;

public class BinarySearchTree {		// ���� Ž�� Ʈ��
	private TreeNode rootNode;		// ��Ʈ ��Ʈ ����
	
	public void BSTinsert(Object k)	// ����Ž��Ʈ���� ���� �����ϴ� BSTinsert�޼ҵ�
	{
		TreeNode p = rootNode;		// ���� ��带 ����Ű�� p ���� �� rootNode�� �ʱ�ȭ
		TreeNode q = p;				// �θ� ��带 ����Ű�� q ���� �� p�� �ʱ�ȭ
		
		while(p != null)			// ���� ��� p�� null�϶� ���� �ݺ�
		{
			if(k instanceof String)	// �����Ϸ��� k�� String�� �� 
			{
				int temp = ((String)p.getKey()).compareTo((String)k); // compareTo �޼ҵ带 ���� ���� ����� key ���� k�� ������ Ȯ�� 
				if ( temp > 0) {			// temp ���� 0���� ũ�ٸ� k���� ū ���� ���� �����Ƿ�
					q = p;					// q�� p�� �ʱ�ȭ
					p = p.getLeft();		// p�� p�� ���� �ڽ� ���� �ʱ�ȭ
				}
				else if(temp < 0) {			// 0���� �۴ٸ� k���� ���� ���� ���� �����Ƿ�
					q = p;					// q�� p�� �ʱ�ȭ
					p = p.getRight();		// p�� p�� ������ �ڽ� ���� �ʱ�ȭ
				}
				else if(temp == 0) {		// temp�� 0�̶�� k�� ���� ���̹Ƿ� 
					System.out.println(k + "��(��) �����մϴ�.");	// ���� �ִٰ� ���
					return ;	// �޼ҵ� ����
				}	
			}
			else if(k instanceof Integer)	// �����Ϸ���  k�� Integer�� ��
			{			
				if( (int)p.getKey() > (int)k) {	// ���� ����� Ű������ k�� ũ�ٸ�
					q = p;						// q�� p�� �ʱ�ȭ
					p = p.getLeft();			// p�� p�� ���� �ڽ� ���� �ʱ�ȭ
				}
				else if((int)p.getKey() < (int)k ) {	// ���� ����� Ű������ k�� �۴ٸ�
					q = p;						// q�� p�� �ʱ�ȭ
					p = p.getRight();			// p�� p�� ������ �ڽ� ���� �ʱ�ȭ
				} else {
					System.out.println(k+"(��)�� �����մϴ�.");	// ���� ���� �����ϴ� ��� ���� �ִٰ� ���
					return ;					// �޼ҵ� ����
				}
			}
			else								// �׿��� �ٸ� Ÿ�Կ� ���ؼ��� ó������ ���� 
			{
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");	// ó������ �ʴ´ٰ� ���
				return;							// �޼ҵ� ����
			}
		}
		
		TreeNode newNode = new TreeNode(k);		// ���ο� ��� ������ ���� newNode �߰�
		
		if(rootNode == null)					// ���� rootNode(����Ʈ��)�� ������
			rootNode = newNode;					// ���ο� rootNode ����
		else
		{	
			if(k instanceof String)				// k�� String�� ��
			{
				if( ((String)q.getKey()).compareTo((String)k) > 0) {	// �������� �θ� ��� q�� key������ k�� �۴ٸ�
					p = newNode;				// ��� �߰�
					q.setLeft(p);				// �θ� ��� q�� ���� �ڽ� ���� ����
				}
				else {
					p = newNode;				// �θ����� key���� k�� ũ�ٸ�
					q.setRight(p);				// �θ� ��� q�� ������ �ڽ� ���� ����
				}
			}
			else if(k instanceof Integer)		// k�� Integer�� ��
			{
				if( (int)q.getKey() > (int)k) {	// �θ� ����� key ������ �۴ٸ�
					p = newNode;				// ��� �߰�
					q.setLeft(p);				// �θ� ��� q�� ���� �ڽ� ���� ����
				}
				else if((int)q.getKey() < (int)k ) {	// �θ����� key���� k�� ũ�ٸ�
					p = newNode;
					q.setRight(p);				// �θ� ��� q�� ������ �ڽ� ���� ����
				}
			}
			else 			// ���� ��尡 null�϶��� 11���� while ���� �ݺ����� ���ϹǷ�
			{
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");// �ٸ� �ڷ����� ó������ �ʴ´ٰ� ���
				return;		// �޼ҵ� ����
			}
		}
	}
	
	public TreeNode BSTsearch(Object k)				// �Ű����� k�� Ž���ϴ� BSTsearch �޼ҵ�
	{
		TreeNode t = rootNode;						// ���� ��� t�� rootNode�� �ʱ�ȭ
		while(t != null)							// ���� ��� t�� null�϶����� �ݺ�
		{
			if(k instanceof String)					// k�� String�� ��
			{
				int temp = ((String)t.getKey()).compareTo((String)k);	 // compareTo �޼ҵ带 ���� ���� ����� key ���� k�� ������ Ȯ�� 
				if ( temp == 0) {					// temp���� 0�̶�� ���� ���̹Ƿ� 
					return t;						// t ��ȯ
				}
				else if(temp < 0) {					// 0���� �۴ٸ�
					t = t.getRight();				// t�� ������ �ڽ����� �ʱ�ȭ
				}
				else if(temp > 0) {					// 0���� ũ�ٸ�
					t = t.getLeft();				// t�� ���� �ڽ����� �ʱ�ȭ
				}	
			}
			else if(k instanceof Integer)			// k�� Integer�� �� 
			{
				if ((int)t.getKey() == (int)k ) {	// k�� ���� key ���̶��
					return t;						// t ��ȯ
				}
				else if( (int)t.getKey() < (int)k) {// k���� �۴ٸ�
					t = t.getRight();				// t�� ������ �ڽ����� �ʱ�ȭ
				}
				else if((int)t.getKey() > (int)k ) {// k ���� ũ�ٸ�
					t = t.getLeft();				// t�� ���� �ڽ����� �ʱ�ȭ
				}
			}
			else
			{
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�.");	// �ٸ� �ڷ����� ���ؼ��� ó������ �ʴ´ٰ� ���
				return null;				// �޼ҵ� ����
			}
		}
		return null;						// �ݺ����� ���� Ž������ ���ϸ� null�� ��ȯ
	}
	
	private TreeNode maxNode(TreeNode root)		// �־��� ����Ʈ���� ���� ���� ū ���� ��ȯ�ϴ� maxNode �޼ҵ�
	{
		TreeNode p = root;						// p�� root�� �ʱ�ȭ
		if(p.getRight() == null) 				// ������ �ڽ��� ������ ���� ū���� �ڱ� �ڽ��̹Ƿ�
			return p; 							// p�� ��ȯ
		else 
			return maxNode(p.getRight());		// ������ �ڽ��� �ִٸ� ������ �ڽ� ��带 �Ű������� ��ȸ�Ͽ� ��ȯ		
	}

	public void BSTdelete(Object k)				// �Ű����� k�� ����Ʈ������ �����ϴ� BSTdelete �޼ҵ�
	{
		rootNode = delete(rootNode,k);			// ����Ʈ�� rootNode�� delete �޼ҵ��� ��ȯ������ �ʱ�ȭ
	}
	
	private TreeNode delete(TreeNode root, Object k)		// �Ű����� k�� �Ű����� root���������ϴ� BSTdelete �޼ҵ�
	{
		TreeNode p = root;						// ���� ��带 ����Ű�� p ���� �� root�� �ʱ�ȭ
		TreeNode q = p;							// �θ� ��带 ����Ű�� q ���� �� p�� �ʱ�ȭ
		while(p != null)						// ���� ��带 ��Ű�� p�� null�϶����� �ݺ�
		{
			if(k instanceof String)				// k��  String�� �� 
			{
				int temp = ((String)p.getKey()).compareTo((String)k); 	// compareTo �޼ҵ带 ���� ���� ����� key ���� k�� ������ Ȯ�� 
				if ( temp > 0) {			// temp ���� 0���� ũ�ٸ� k���� ū ���� ���� �����Ƿ�
					q = p;					// q�� p�� �ʱ�ȭ
					p = p.getLeft();		// p�� p�� ���� �ڽ� ���� �ʱ�ȭ
				}
				else if(temp < 0) {			// 0���� �۴ٸ� k���� ���� ���� ���� �����Ƿ�
					q = p;					// q�� p�� �ʱ�ȭ
					p = p.getRight();		// p�� p�� ������ �ڽ� ���� �ʱ�ȭ
				}
				else if(temp == 0) {		// temp�� 0�̶�� k�� ���� ���̹Ƿ� 
					break;					// ������ key�� ���� p�� ã�����Ƿ� �ݺ��� Ż�� 
				} 				
			}
			else if(k instanceof Integer)	// k�� Integer�� ��
			{
				if( (int)p.getKey() > (int)k) {	// ���� ����� Ű������ k�� ũ�ٸ�
					q = p;						// q�� p�� �ʱ�ȭ
					p = p.getLeft();			// p�� p�� ���� �ڽ� ���� �ʱ�ȭ
				}
				else if((int)p.getKey() < (int)k ) { // ���� ����� Ű������ k�� �۴ٸ�
					q = p;						// q�� p�� �ʱ�ȭ
					p = p.getRight();			// p�� p�� ������ �ڽ� ���� �ʱ�ȭ
				} else {
					break;						// ������ key�� ���� p�� ã�����Ƿ� �ݺ��� Ż�� 
				}
			}			
			else
			{
				System.out.println("�ش� �ڷ����� ���� ó���� �߰����� �ʾҽ��ϴ�."); // �ٸ� �ڷ����� ó������ �ʴ´ٰ� ���
				return null;	// �޼ҵ� ����
			}
		}
		
		
		if(p == null) 			// �ƹ��͵� �� �� ���� ���
		{
			System.out.println(k + "��  �������� �ʽ��ϴ�.");
		}
		if((p.getLeft() == null) && (p.getRight() == null))		// ���� ���p�� �ڽ� ��尡 ���� ���
		{
			if(p == root) {						// p�� ��Ʈ �����
				return null;					// null�� ��ȯ, ����Ʈ�� ����
			}
			else if(q.getLeft() == p) {			// p�� �θ� ���q�� ���� �ڽ��̶��
				q.setLeft(null);				// q�� ���� �ڽĳ�带 null�� �ʱ�ȭ
			}
			else {								// ������ �ڽ��̶��
				q.setRight(null);				// q�� ������ �ڽĳ�带 null�� �ʱ�ȭ
			}
		}
		else if((p.getLeft() == null )|| (p.getRight() == null))	// ���� ���p�� �ڽ� ��尡 �ϳ��� �ִ� ���
		{
			if(p == root) {						// p�� ��Ʈ �����
				if(p.getLeft() != null)			// p�� ���� �ڽ��� ������
					q = p.getLeft();			// ���� �ڽ����� �ʱ�ȭ	
				else							// ������ �ڽ��� ������
					q = p.getRight();			// ������ �ڽ����� �ʱ�ȭ
			}
			else if(q.getLeft() == p) {			// p�� �θ� ���q�� ���� �ڽ��̶��
				if(p.getLeft() != null)			// p�� ���� �ڽ��� ������
					q.setLeft(p.getLeft());		// q�� ���� �ڽĳ�带 p�� ���� �ڽĳ��� �ʱ�ȭ	
				else							// ������ �ڽ��� ������
					q.setLeft(p.getRight()); 	// q�� ���� �ڽĳ�带 p�� ������ �ڽĳ��� �ʱ�ȭ
			}
			else {								// p�� �θ� ���q�� ������ �ڽ��̶��
				if(p.getLeft() != null)			// p�� ���� �ڽ��� ������
					q.setRight(p.getLeft());	// q�� ������ �ڽĳ�带 p�� ���� �ڽĳ��� �ʱ�ȭ	
				else							// ������ �ڽ��� ������
					q.setRight(p.getRight());	// q�� ������ �ڽĳ�带 p�� ������ �ڽĳ��� �ʱ�ȭ	
			}
		}
		else									// ���� ���p�� �ڽ� ��尡 �� �� �ִ� ���
		{
			p.setKey(maxNode(p.getLeft()).getKey());			// maxNode ȣ���� ���� p�� ���� �ڽ� ����� ���� ū ���� Ȯ���ϰ� �� ���� p�� key�� �ʱ�ȭ �Ѵ�.
			p.setLeft(delete(p.getLeft(), p.getKey()));			// �׸��� p�� �����ڽ� ����� ���� ū key���� delete�� ���� ���������ν� ������ ������. 
		}
		return root;							// ������ ���� ����Ʈ�� root�� ��ȯ
	}
	
	public void print()							// ����Ʈ���� ������ ����ϴ� print �޼ҵ�
	{
		printNode(rootNode);					// printNode�޼ҵ带 ���� ��� 
		System.out.println();					// ����� ������ �ٹٲ�
	}

	private void printNode(TreeNode n)			// ����Ʈ���� ������ ��͸� ���� ����ϴ� printNode �޼ҵ�, ���� ��ȸ�� ����.
	{
		if(n != null)							// �Ű����� ��尡 null�� �ƴҶ����� �ݺ�
		{
			System.out.print("(");
			printNode(n.getLeft());				// ���� �ڽ� ���
			System.out.print(" " + n.getKey() + " "); // ����� key ���
			printNode(n.getRight());			// ������ �ڽ� ���
			System.out.print(")");
		}
	}
	
	
	public void setRootNode(TreeNode root) {
		this.rootNode = root;
	}
	
	public boolean split(BinarySearchTree bBST, BinarySearchTree cBST, Object x) { // x ���� �������� ����Ʈ���� �����ϴ� split �޼ҵ�
		TreeNode Small = new TreeNode();	// x�� ���� ���� ����� ������ų Small ���� Ʈ�� ���� �� �ʱ�ȭ
		TreeNode Large = new TreeNode();	// x�� ���� ū ����� ������ų Large ���� Ʈ�� ���� �� �ʱ�ȭ
		TreeNode S = Small;					// Small�� Large�� ������Ű�� ��ġ�� �����ϴ� ��� S, L�� ���� 
		TreeNode L = Large;					// ���� Small�� Large�� ����Ű�� �ʱ�ȭ 
		TreeNode p = this.rootNode;			// ����Ʈ���� ���� ��带 ����Ű�� p ���� �� ������ rootNode�� �ʱ�ȭ
		
		while(p != null) {					// �ݺ����� ���� ����Ʈ���� �����ϰ� x���� ���� ���� ã���� true�� ��ȯ�ϸ� �޼ҵ� ����
			if(x instanceof Integer) {		// Integer���� ���� ����Ѵ�.
				if( x == p.getKey()) {		// x���� ���� ���� Ʈ�� ������ ã����
					S.setRight(p.getLeft());				// S�� ������ �ڽ��� p�� ���� �ڽ����� �ʱ�ȭ
					L.setLeft(p.getRight());				// L�� ���� �ڽ��� p�� ������ �ڽ����� �ʱ�ȭ
					
					bBST.setRootNode(Small.getRight()); 	// �ݺ����� ���� ������� Small�� ������ �ڽ� ��带 bBST�� ����
					cBST.setRootNode(Large.getLeft());		// �ݺ����� ���� ������� Large�� ���� �ڽ� ��带 cBST�� ����
					
					return true;							// true�� ��ȯ�ϸ� �޼ҵ� ����
				}
				else if( (int)x < (int)(p.getKey()) ) {		// x���� ���� ����� Ű ������ �۴ٸ�
					L.setLeft(p);			// ���� p ��带 L�� ���� �ڽ����� ����Ű��
					L = p;					// L�� p�� ��ġ�� �ʱ�ȭ
					p = p.getLeft();
				}
				else {						// x ���� ���� ����� Ű ���� �۴ٸ�
					S.setRight(p);			// ���� p ��带 S�� ������ �ڽ����� ����Ű��
					S = p;					// S�� p�� ��ġ�� �ʱ�ȭ
					p = p.getRight();		// p�� ����Ʈ���� ������ �ڽ����� �ʱ�ȭ���ش�. 
				}
			}
		}
		
		// �ݺ����� �����ٴ� ���� x�� ���� Ʈ�� ���� ���ٴ� ���� �ǹ��Ѵ�.
		
		S.setRight(null);					// �ݺ����� ���� �����״� ��ġ�� ������ �ڽ� ��带 null�� ����
		L.setLeft(null);					// ���������� �����״� ��ġ�� ���� �ڽ� ��带 null�� ����
		bBST.setRootNode(Small.getRight());	// �ݺ����� ���� ������� Small�� ������ �ڽ� ��带 bBST�� ����
		cBST.setRootNode(Large.getLeft());	// �ݺ����� ���� ������� Large�� ���� �ڽ� ��带 cBST�� ����
		return false;						// false�� ��ȯ�ϸ� �޼ҵ� ����
	}

}