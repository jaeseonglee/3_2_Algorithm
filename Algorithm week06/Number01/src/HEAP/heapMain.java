package HEAP;

public class heapMain {
	public static void main(String args[]) {		// main �޼ҵ�
		Heap h = new Heap();						// HEAP ���� �� �ʱ�ȭ
		
		System.out.println("==Insert==");			// ������ �� ����
		h.insert(18);
		h.insert(13);
		h.insert(5);
		h.insert(12);
		h.insert(8);
		h.insert(3);
		h.insert(19);
		h.show();									// ���
		
		
		System.out.println("==Delete===");			// ����
		h.delete();									// ���� ū �� ����
		h.show();									// ���
		h.delete();
		h.show();
		
		System.out.println("===MakeHeap===");		// ���� ������ش�. �̶� ���� ����Ʈ���� 0������ ����ϴ��� �ƴ����� ���� ���� �ٸ� ����� ��Ÿ����.
		int [] tree = {0,20,40,50,70,30,100,80,10,90,60};	
		//int [] tree = {0,0,20,40,50,70,30,100,80,10,90,60};			// �ε����� 0������ ����Ѵٸ� �� �迭�� ���
		
		Heap nh = new Heap(tree);					// ���ο� HEAP�� ������ tree�� �ʱ�ȭ
		
		nh.makeTreeHeap();							// ���� ������ְ�
		nh.show();									// ���
	
	}
}
