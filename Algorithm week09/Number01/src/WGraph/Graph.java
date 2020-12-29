package WGraph;

import java.util.*;

public class Graph {					// ���� ����Ʈ�� ��Ÿ�� �׷����� ����Ű�� Vertex_graph Ŭ����
	private Node[] header;					// ��������Ʈ�� ����Ű�� header
	private int size;
	
	public Graph(int size) {			// ������
		this.header = new Node[size];		// size��ŭ �迭�� ���̸� �ʱ�ȭ
		this.size = size;					// size�� �Ű����� size�� �ʱ�ȭ
		
		for(int i = 0; i < size; i++) {		// �ݺ����� ���� 
			this.header[i] = null;			// �迭�� �ʱ�ȭ �����ش�
		}
	}
	
	public void add(int i, int k) {			// �׷����� ������ �߰��ϴ� add �޼ҵ�
		Node temp = header[i];				// ���� ���� i���� ������ ����
		
		while(true) {						// �ݺ����� ���� ���� �߰�
			if(header[i] == null) {			// �ش� ������ �ƹ��͵� �������� ���� ���¶��
				header[i] = new Node(k);	// ù��°�� ����Ǵ� k�� ���� ����(Node) �߰�
				break;						// �ݺ��� Ż��
			}
			
			if(temp.getLink() == null) {	// ���� ������ ����Ű�� link�� null�̶��
				temp.setLink(new Node(k));	// ����(Node) �߰�
				break;						// �ݺ��� Ż��
			}
			temp = temp.getLink();			// ���� �� ���ǿ� ���� �������� ������ ���� link�� �ʱ�ȭ�Ͽ� Ž��
		}

		temp = header[k];					// ������ �׷����̹Ƿ� k�� ���ؼ��� ������ ����
		while(true) {
			if(header[k] == null) {			// ���������� ���� k�� �ƹ��͵� ������� �ʾҴٸ�
				header[k] = new Node(i);	// i�� ù��°�� ��������ְ�
				break;						// �ݺ��� Ż��
			}
			
			if(temp.getLink() == null) {	// ���� ������ ����Ű�� link�� null�̸�
				temp.setLink(new Node(i));	// i�� ���ؼ� ����(Node) �߰�
				break;						// �ݺ��� Ż��
			}
			temp = temp.getLink();			// ���� �� ���ǿ� ���� �������� ������ ���� link�� �ʱ�ȭ�Ͽ� Ž��
		}	
	}
	
	public void delete(int i, int k) {					// ������ �����ϴ� delete �޼ҵ�
		if(header[i] == null || header[k] == null) {	// �Ű����� �߿� �ƹ��͵� ������� ���� �����̶��
			System.out.println("This is fault delete");	// ���� ������ ���� �߻�
			return ;									// �޼ҵ� ����
		}
		
		Node curNode = header[i];						// ���� i�� ���� ��带 ����Ű�� curNode
		Node nextNode = header[i].getLink();			// i�� ���� ��带 ����Ű�� nextNode

		while(curNode != null) {						// ���� ��尡 null�� �ƴ϶�� �ݺ�
			if(curNode.getVertex() == k) {				// ���� ����� ������ k�� ���ٸ�
				curNode.setVertex(nextNode.getVertex());// ������ �����ϱ� ���� k�� ��忡 ���� ���� ����Ʈ �����ϰ�
				curNode.setLink(nextNode.getLink());	// �� ���� ��忡 ���� ���������ν� ���� �Ϸ�
				break;									// �ݺ��� Ż��
			}
			curNode = nextNode;							// ���ǹ��� �ش����� �ʴ´ٸ� ���� ��带 ���� ���� �ʱ�ȭ
			nextNode = nextNode.getLink();				// �������� �� ������忡 ���� �ʱ�ȭ�ϰ� �ݺ�
		}
		
		curNode = header[k];							// ������ �׷��� �̹Ƿ� k�� ���ؼ��� ������ ����
		nextNode = header[k].getLink();					// k�� ���� ���� �� ���� ��带 ���� curNode�� nextNode�� ���� �ʱ�ȭ

		while(curNode != null) {						// ���������� ���� ��尡 null�� �ƴ϶�� �ݺ�
			if(curNode.getVertex() == i) {				// ���� ����� ������ i�� ���ٸ�
				curNode.setVertex(nextNode.getVertex());// ������ �����ϱ� ���� i�� ���� ��带 ���� ����Ʈ���� ����  
				curNode.setLink(nextNode.getLink());	// �� ���� ���� �������־� ���� �Ϸ�
				break;									// �ݺ��� Ż��
			}
			curNode = nextNode;							// ���ǹ��� �ش����� �ʴ´ٸ� ���� ��带 ���� ���� �ʱ�ȭ
			nextNode = nextNode.getLink();				// �������� �� ������忡 ���� �ʱ�ȭ�ϰ� �ݺ�
		}
	}
	
	public void show() {								// �׷����� ������ ����ϴ� show �޼ҵ�
		if(size == 0) {									// size�� 0�̸� 
			System.out.println("No Vertex");			// �ƹ� �׷����� �׷����� �ʾ����� No Vertex ���
		}
		
		for(int i = 0; i < size; i++) {					// ��ø �ݺ����� ���� �׷��� ���. size�� 0�̸� �ڵ����� �ݺ����� ����
			Node temp = header[i];						// temp�� �� ������ ���� �迭���� �����ϰ�
			
			System.out.print(i + " : ");				// �� ������ ���� ���				
			while(temp != null) {						// �ݺ����� ���� ���� ����Ʈ�� ���� ���
				System.out.print(temp.getVertex() + " ");	// ���� ������ ����ϰ�
				temp = temp.getLink();					// ���� link�� �ʱ�ȭ�ϰ� �ݺ�
			}
			System.out.println();						// �� ������ ���� ���� ����� ������ �ٹٲ�
		}
	}
	
	
	// 9���� DFS, BFS 
	public void DFS(int i) {							// ���� �켱 Ž��(DFS) �޼ҵ�, ������ �̿��Ͽ� Ž���Ѵ�.
		boolean[] visit = new boolean[header.length];	// �湮�� Ȯ���ϴ� visit
		int j;											// �ݺ������� ������ ����ų ���� j
		
		for(j = 0; j < header.length; j++) {			// �ݺ����� ����
			visit[j] = false;							// visit �迭�� false�� �ʱ�ȭ
		}
		
		Stack<Integer> stack = new Stack<Integer>();	// Integer�� ������ ���� �� �ʱ�ȭ
		stack.push(i);									// ���ÿ� �Ű����� i�� push���ش�.
		
		while(!stack.isEmpty()) {						// ������ ������ �� ���� �ݺ�
			j = stack.pop();							// ���ÿ��� pop�� ���� j�� ���� 
			Node node = header[j];						// j������ ��������Ʈ�� node�� ����
			
			if(visit[j] == false) {						// ���� j�� ������ �湮���� �ʾҴٸ�
				System.out.print(j + " ");				// j ���
				visit[j] = true;						// j�� �湮�����Ƿ� true
				while(node != null) {					// �ٽ� �ݺ����� ���� ������ ����Ѵ�. 
					if(visit[node.getVertex()] == false)// �湮���� ���� ������ ������
						stack.push(node.getVertex());	// ���ÿ� �� ������ push
					node = node.getLink();				// node ������ ����Ű�� Node�� node�� ����
				}
			}
		}
	}
		
	public void BFS(int i) {							// ť�� ����ϴ� �ʺ� �켱 Ž��(BFS) �޼ҵ�
		boolean[] visit = new boolean[header.length];	// �湮�� Ȯ���ϴ� visit 
		int idx;										
		
		for(int j = 0; j < header.length; j++) {		//�ݺ����� ����
			visit[j] = false;							// visit �迭�� false�� �ʱ�ȭ
		}
		
		Queue<Integer> queue = new LinkedList<Integer>();	// Integer�� ť ���� �� �ʱ�ȭ
		queue.add(i);									// ť�� �Ű����� i�� �߰����ش� 
		
		while(!queue.isEmpty()) {						// ť�� ������ ������ �ݺ�
			idx = queue.remove();						// ť���� remove ���� ���� idx�� ����
			Node node = header[idx];					// j������ ��������Ʈ�� node�� ����
			
			if(visit[idx] == false) {					// ���� idx�� ������ �湮���� �ʾҴٸ�
				System.out.print(idx + " ");			// idx ���
				visit[idx] = true;						// idx�� �湮 �����Ƿ� true
			}
			
			while( node != null) {						// �ݺ����� ���� ť�� ����Ѵ�.
				if(visit[node.getVertex()] == false) 	// �湮���� ���� ������ ������
					queue.add(node.getVertex());		// ť�� �� ������ �߰����ش�
				node = node.getLink();					// node ������ ����Ű�� Node�� node�� ����
			}
		}
	}

}