
package Sort;

public class sortMain {
	public static void main(String args[]) {		// ���� �޼ҵ�
		Sort s = new Sort();						// Sort ��ü ���� �� �ʱ�ȭ
		
		int[] a2 = {8, 1, 23, 15, 31, 2, 26, 12 };	// �պ����Ŀ� ����� �迭 ����
		
		int[] merge = s.mergeSort(a2);				// mergeSort ȣ��� �պ�����
		
		System.out.print("Merge sort : ");			// ���ĵ� �迭�� �ݺ����� ���� ���
		for(int i = 0; i < merge.length; i++) { 
			System.out.print(merge[i] + " ");
		}
		System.out.println();
		
		int[] a3 = {3, 1, 5, 4, 9, 7, 8};			// �� ���Ŀ��� ����� �迭 ����
		int[] quick = s.quickSort(a3);				// quickSort ȣ��� �� ����
		
		System.out.print("Quick sort : ");			// ���ĵ� �迭�� �ݺ����� ���� ���
		for(int i = 0; i < quick.length; i++) {
			System.out.print(quick[i] + " ");
		}
		System.out.println();
		
	}
}
