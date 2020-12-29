package sort;

public class SortMain {
	public static void main(String args[]) {		// main �޼ҵ�
		int[] a = {5,2,8,3,1};						// int �� �迭 a ���� �� �ʱ�ȭ
		Sort s = new Sort();						// Sort ��ü a ���� �� �ʱ�ȭ
		int i;										// �ݺ������� ����� ���� i
		System.out.println("���� �� �迭 ����");			// �迭 ���
		
		for(i = 0; i < a.length; i++) {				// �ݺ����� ���� �迭�� ���
			System.out.print(a[i] +" ");
		}
		System.out.println();
		System.out.println("================================");
		
		int[] b = s.selectionSort(a);				// �迭�� ���� ����
		System.out.println("�������� ����");
		
		for(i = 0; i < b.length; i++) {				// �ݺ����� ���� ���� ���ĵ� �迭 ���
			System.out.print(b[i] + " ");
		}
		System.out.println();
		System.out.println("================================");

		int[] c = s.bubbleSort(a);					// �迭�� ���� ����
		System.out.println("�������� ����");
		
		for(i = 0; i < c.length; i++) {				// �ݺ����� ���� ���� ���ĵ� �迭 ���
			System.out.print(c[i] + " ");
		}
		System.out.println();
		System.out.println("================================");
		
		int[] d = s.insertionSort(a);				// �迭�� ���� ���� 
		System.out.println("�������� ����");
		
		for(i = 0; i < d.length; i++) {				// �ݺ����� ���� ���� ���ĵ� �迭 ���
			System.out.print(d[i] + " ");
		}
		System.out.println();
		System.out.println("================================");
	}
}
