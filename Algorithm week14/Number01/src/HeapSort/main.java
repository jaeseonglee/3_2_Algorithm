package HeapSort;

public class main {
	public static void main(String[] args) {			// ���� �޼ҵ�
		HeapSort s = new HeapSort();					// �� ���� ��ü ����
		int[] a4 = {0, 20, 40, 50, 70, 30, 100, 80, 10, 90, 60};	// 0��° �ε����� ������� �ʴ� �迭�� ����
		
		int[] heap = s.heapSort(a4);					// heapSort�� �迭�� ����
		
		System.out.println("Heap sort : ");				// ���ĵ� �迭 ���
		
		for(int i = 0; i < heap.length; i++) {			// �ݺ����� ���� �迭�� ���� ���
			System.out.print(heap[i] + " ");
		}
		System.out.println();
	}
}
