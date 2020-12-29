package BST;

public class BinarySearchTree {		// 이진 탐색 트리
	private TreeNode rootNode;		// 루트 노트 생성
	
	public void BSTinsert(Object k)	// 이진탐색트리에 값을 삽입하는 BSTinsert메소드
	{
		TreeNode p = rootNode;		// 현재 노드를 가리키는 p 생성 및 rootNode로 초기화
		TreeNode q = p;				// 부모 노드를 가리키는 q 생성 및 p로 초기화
		
		while(p != null)			// 현재 노드 p가 null일때 까지 반복
		{
			if(k instanceof String)	// 삽입하려는 k가 String일 때 
			{
				int temp = ((String)p.getKey()).compareTo((String)k); // compareTo 메소드를 통해 현재 노드의 key 값과 k가 같은지 확인 
				if ( temp > 0) {			// temp 값이 0보다 크다면 k보다 큰 값을 갖고 있으므로
					q = p;					// q는 p로 초기화
					p = p.getLeft();		// p는 p의 왼쪽 자식 노드로 초기화
				}
				else if(temp < 0) {			// 0보다 작다면 k보다 작은 값을 갖고 있으므로
					q = p;					// q는 p로 초기화
					p = p.getRight();		// p는 p의 오른쪽 자식 노드로 초기화
				}
				else if(temp == 0) {		// temp가 0이라면 k와 같은 값이므로 
					System.out.println(k + "이(가) 존재합니다.");	// 값이 있다고 출력
					return ;	// 메소드 종료
				}	
			}
			else if(k instanceof Integer)	// 삽입하려는  k가 Integer일 때
			{			
				if( (int)p.getKey() > (int)k) {	// 현재 노드의 키값보다 k가 크다면
					q = p;						// q는 p로 초기화
					p = p.getLeft();			// p는 p의 왼쪽 자식 노드로 초기화
				}
				else if((int)p.getKey() < (int)k ) {	// 현재 노드의 키값보다 k가 작다면
					q = p;						// q는 p로 초기화
					p = p.getRight();			// p는 p의 오른쪽 자식 노드로 초기화
				} else {
					System.out.println(k+"(이)가 존재합니다.");	// 값은 값이 존재하는 경우 값이 있다고 출력
					return ;					// 메소드 종료
				}
			}
			else								// 그외의 다른 타입에 대해서는 처리하지 않음 
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");	// 처리하지 않는다고 출력
				return;							// 메소드 종료
			}
		}
		
		TreeNode newNode = new TreeNode(k);		// 새로운 노드 삽입을 위해 newNode 추가
		
		if(rootNode == null)					// 현재 rootNode(이진트리)가 없으면
			rootNode = newNode;					// 새로운 rootNode 생성
		else
		{	
			if(k instanceof String)				// k가 String일 때
			{
				if( ((String)q.getKey()).compareTo((String)k) > 0) {	// 현재노드의 부모 노드 q의 key값보다 k가 작다면
					p = newNode;				// 노드 추가
					q.setLeft(p);				// 부모 노드 q의 왼쪽 자식 노드로 삽입
				}
				else {
					p = newNode;				// 부모노드의 key보다 k가 크다면
					q.setRight(p);				// 부모 노드 q의 오른쪽 자식 노드로 삽입
				}
			}
			else if(k instanceof Integer)		// k가 Integer일 때
			{
				if( (int)q.getKey() > (int)k) {	// 부모 노드의 key 값보다 작다면
					p = newNode;				// 노드 추가
					q.setLeft(p);				// 부모 노드 q의 왼쪽 자식 노드로 삽입
				}
				else if((int)q.getKey() < (int)k ) {	// 부모노드의 key보다 k가 크다면
					p = newNode;
					q.setRight(p);				// 부모 노드 q의 오른쪽 자식 노드로 삽입
				}
			}
			else 			// 현재 노드가 null일때는 11줄의 while 문이 반복하지 못하므로
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");// 다른 자료형을 처리하지 않는다고 출력
				return;		// 메소드 종료
			}
		}
	}
	
	public TreeNode BSTsearch(Object k)				// 매개변수 k를 탐색하는 BSTsearch 메소드
	{
		TreeNode t = rootNode;						// 현재 노드 t를 rootNode로 초기화
		while(t != null)							// 현재 노드 t가 null일때까지 반복
		{
			if(k instanceof String)					// k가 String일 땐
			{
				int temp = ((String)t.getKey()).compareTo((String)k);	 // compareTo 메소드를 통해 현재 노드의 key 값과 k가 같은지 확인 
				if ( temp == 0) {					// temp값이 0이라면 값은 값이므로 
					return t;						// t 반환
				}
				else if(temp < 0) {					// 0보다 작다면
					t = t.getRight();				// t의 오른쪽 자식으로 초기화
				}
				else if(temp > 0) {					// 0보다 크다면
					t = t.getLeft();				// t의 왼쪽 자식으로 초기화
				}	
			}
			else if(k instanceof Integer)			// k가 Integer일 때 
			{
				if ((int)t.getKey() == (int)k ) {	// k와 같은 key 값이라면
					return t;						// t 반환
				}
				else if( (int)t.getKey() < (int)k) {// k보다 작다면
					t = t.getRight();				// t의 오른쪽 자식으로 초기화
				}
				else if((int)t.getKey() > (int)k ) {// k 보다 크다면
					t = t.getLeft();				// t의 왼쪽 자식으로 초기화
				}
			}
			else
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다.");	// 다른 자료형에 대해서는 처리하지 않는다고 출력
				return null;				// 메소드 종료
			}
		}
		return null;						// 반복문을 통해 탐색하지 못하면 null을 반환
	}
	
	private TreeNode maxNode(TreeNode root)		// 주어진 이진트리에 대해 가장 큰 값을 반환하는 maxNode 메소드
	{
		TreeNode p = root;						// p를 root로 초기화
		if(p.getRight() == null) 				// 오른쪽 자식이 없으면 제일 큰값은 자기 자신이므로
			return p; 							// p를 반환
		else 
			return maxNode(p.getRight());		// 오른쪽 자식이 있다면 오른쪽 자식 노드를 매개변수로 순회하여 반환		
	}

	public void BSTdelete(Object k)				// 매개변수 k를 이진트리에서 삭제하는 BSTdelete 메소드
	{
		rootNode = delete(rootNode,k);			// 이진트리 rootNode를 delete 메소드의 반환값으로 초기화
	}
	
	private TreeNode delete(TreeNode root, Object k)		// 매개변수 k를 매개변수 root에서삭제하는 BSTdelete 메소드
	{
		TreeNode p = root;						// 현재 노드를 가리키는 p 생성 및 root로 초기화
		TreeNode q = p;							// 부모 노드를 가리키는 q 생성 및 p로 초기화
		while(p != null)						// 현재 노드를 가키는 p가 null일때까지 반복
		{
			if(k instanceof String)				// k가  String일 때 
			{
				int temp = ((String)p.getKey()).compareTo((String)k); 	// compareTo 메소드를 통해 현재 노드의 key 값과 k가 같은지 확인 
				if ( temp > 0) {			// temp 값이 0보다 크다면 k보다 큰 값을 갖고 있으므로
					q = p;					// q는 p로 초기화
					p = p.getLeft();		// p는 p의 왼쪽 자식 노드로 초기화
				}
				else if(temp < 0) {			// 0보다 작다면 k보다 작은 값을 갖고 있으므로
					q = p;					// q는 p로 초기화
					p = p.getRight();		// p는 p의 오른쪽 자식 노드로 초기화
				}
				else if(temp == 0) {		// temp가 0이라면 k와 같은 값이므로 
					break;					// 삭제할 key을 가진 p를 찾았으므로 반복문 탈출 
				} 				
			}
			else if(k instanceof Integer)	// k가 Integer일 때
			{
				if( (int)p.getKey() > (int)k) {	// 현재 노드의 키값보다 k가 크다면
					q = p;						// q는 p로 초기화
					p = p.getLeft();			// p는 p의 왼쪽 자식 노드로 초기화
				}
				else if((int)p.getKey() < (int)k ) { // 현재 노드의 키값보다 k가 작다면
					q = p;						// q는 p로 초기화
					p = p.getRight();			// p는 p의 오른쪽 자식 노드로 초기화
				} else {
					break;						// 삭제할 key을 가진 p를 찾았으므로 반복문 탈출 
				}
			}			
			else
			{
				System.out.println("해당 자료형에 대한 처리를 추가하지 않았습니다."); // 다른 자료형을 처리하지 않는다고 출력
				return null;	// 메소드 종료
			}
		}
		
		
		if(p == null) 			// 아무것도 할 수 없는 경우
		{
			System.out.println(k + "가  존재하지 않습니다.");
		}
		if((p.getLeft() == null) && (p.getRight() == null))		// 현재 노드p의 자식 노드가 없는 경우
		{
			if(p == root) {						// p가 루트 노드라면
				return null;					// null을 반환, 이진트리 삭제
			}
			else if(q.getLeft() == p) {			// p가 부모 노드q의 왼쪽 자식이라면
				q.setLeft(null);				// q의 왼쪽 자식노드를 null로 초기화
			}
			else {								// 오른쪽 자식이라면
				q.setRight(null);				// q의 오른쪽 자식노드를 null로 초기화
			}
		}
		else if((p.getLeft() == null )|| (p.getRight() == null))	// 현재 노드p의 자식 노드가 하나라도 있는 경우
		{
			if(p == root) {						// p가 루트 노드라면
				if(p.getLeft() != null)			// p가 왼쪽 자식이 있으면
					q = p.getLeft();			// 왼쪽 자식으로 초기화	
				else							// 오른쪽 자식이 있으면
					q = p.getRight();			// 오른쪽 자식으로 초기화
			}
			else if(q.getLeft() == p) {			// p가 부모 노드q의 왼쪽 자식이라면
				if(p.getLeft() != null)			// p가 왼쪽 자식이 있으면
					q.setLeft(p.getLeft());		// q의 왼쪽 자식노드를 p의 왼쪽 자식노드로 초기화	
				else							// 오른쪽 자식이 있으면
					q.setLeft(p.getRight()); 	// q의 왼쪽 자식노드를 p의 오른쪽 자식노드로 초기화
			}
			else {								// p가 부모 노드q의 오른쪽 자식이라면
				if(p.getLeft() != null)			// p가 왼쪽 자식이 있으면
					q.setRight(p.getLeft());	// q의 오른쪽 자식노드를 p의 왼쪽 자식노드로 초기화	
				else							// 오른쪽 자식이 있으면
					q.setRight(p.getRight());	// q의 오른쪽 자식노드를 p의 오른쪽 자식노드로 초기화	
			}
		}
		else									// 현재 노드p의 자식 노드가 둘 다 있는 경우
		{
			p.setKey(maxNode(p.getLeft()).getKey());			// maxNode 호출을 통해 p의 왼쪽 자식 노드의 가장 큰 값을 확인하고 그 값을 p의 key로 초기화 한다.
			p.setLeft(delete(p.getLeft(), p.getKey()));			// 그리고 p의 왼쪽자식 노드의 가장 큰 key값을 delete를 통해 삭제함으로써 삭제를 끝낸다. 
		}
		return root;							// 삭제가 끝난 이진트리 root를 반환
	}
	
	public void print()							// 이진트리의 내용을 출력하는 print 메소드
	{
		printNode(rootNode);					// printNode메소드를 통해 출력 
		System.out.println();					// 출력이 끝나면 줄바꿈
	}

	private void printNode(TreeNode n)			// 이진트리의 내용을 재귀를 통해 출력하는 printNode 메소드, 중위 순회와 같다.
	{
		if(n != null)							// 매개변수 노드가 null일 아닐때까지 반복
		{
			System.out.print("(");
			printNode(n.getLeft());				// 왼쪽 자식 출력
			System.out.print(" " + n.getKey() + " "); // 노드의 key 출력
			printNode(n.getRight());			// 오른쪽 자식 출력
			System.out.print(")");
		}
	}
	
	
	public void setRootNode(TreeNode root) {
		this.rootNode = root;
	}
	
	public boolean split(BinarySearchTree bBST, BinarySearchTree cBST, Object x) { // x 값을 기준으로 이진트리를 분할하는 split 메소드
		TreeNode Small = new TreeNode();	// x값 보다 작은 값들로 구성시킬 Small 이진 트리 생성 및 초기화
		TreeNode Large = new TreeNode();	// x값 보다 큰 값들로 구성시킬 Large 이진 트리 생성 및 초기화
		TreeNode S = Small;					// Small과 Large를 구성시키며 위치를 변경하는 노드 S, L을 생성 
		TreeNode L = Large;					// 각각 Small과 Large를 가리키며 초기화 
		TreeNode p = this.rootNode;			// 이진트리의 현재 노드를 가리키는 p 생성 및 현재의 rootNode로 초기화
		
		while(p != null) {					// 반복문을 통해 이진트리를 분할하고 x값과 같은 값을 찾으면 true를 반환하며 메소드 종료
			if(x instanceof Integer) {		// Integer형일 때만 고려한다.
				if( x == p.getKey()) {		// x값과 같은 값을 트리 내에서 찾으면
					S.setRight(p.getLeft());				// S의 오른쪽 자식을 p의 왼쪽 자식으로 초기화
					L.setLeft(p.getRight());				// L의 왼쪽 자식을 p의 오른쪽 자식으로 초기화
					
					bBST.setRootNode(Small.getRight()); 	// 반복문을 통해 만들어진 Small의 오른쪽 자식 노드를 bBST로 저장
					cBST.setRootNode(Large.getLeft());		// 반복문을 통해 만들어진 Large의 왼쪽 자식 노드를 cBST로 저장
					
					return true;							// true를 반환하며 메소드 종료
				}
				else if( (int)x < (int)(p.getKey()) ) {		// x값이 현재 노드의 키 값보다 작다면
					L.setLeft(p);			// 현재 p 노드를 L의 왼쪽 자식으로 가리키고
					L = p;					// L을 p의 위치로 초기화
					p = p.getLeft();
				}
				else {						// x 보다 현재 노드의 키 값이 작다면
					S.setRight(p);			// 현재 p 노드를 S의 오른쪽 자식으로 가리키고
					S = p;					// S를 p의 위치로 초기화
					p = p.getRight();		// p를 이진트리의 오른쪽 자식으로 초기화해준다. 
				}
			}
		}
		
		// 반복문이 끝난다는 것은 x가 이진 트리 내에 없다는 것을 의미한다.
		
		S.setRight(null);					// 반복문을 통해 가리켰던 위치의 오른쪽 자식 노드를 null로 지정
		L.setLeft(null);					// 마찬가지로 가리켰던 위치의 왼쪽 자식 노드를 null로 지정
		bBST.setRootNode(Small.getRight());	// 반복문을 통해 만들어진 Small의 오른쪽 자식 노드를 bBST로 저장
		cBST.setRootNode(Large.getLeft());	// 반복문을 통해 만들어진 Large의 왼쪽 자식 노드를 cBST로 저장
		return false;						// false를 반환하며 메소드 종료
	}

}