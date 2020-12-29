package Vertex_graph;

public class Vertex_graph {					// ���� ����Ʈ�� ��Ÿ�� �׷����� ����Ű�� Vertex_graph Ŭ����
	private Node[] header;					// ��������Ʈ�� ����Ű�� header
	private int size;
	
	public Vertex_graph(int size) {			// ������
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
}