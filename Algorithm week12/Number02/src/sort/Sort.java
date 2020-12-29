/*  �˰��� 12����  
 * 	Sort.java SortMain.java   
 *  �ۼ��� : 2020.11.19, 21
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : ���� ����, ���� ����, ���� ������ ��Ÿ���� ���α׷�
 */
package sort;

public class Sort {								// ������ ��Ÿ���� Ŭ���� Sort
	public void swap(int[] a, int j, int k) {	// �Ű����� �迭�� �� ���Ҹ� �ٲٴ� swap �޼ҵ� 
		int temp = a[j];						// a[j] �� a[k]�� 
		a[j] = a[k];							// ���ؼ� ���� ��ȯ
		a[k] = temp;
	}
	
	private int[] copy (int[] arr) {			// �Ű����� �迭�� ���� ���縦 ���� ��ȯ�ϴ� copy �޼ҵ�
		int[] copy = new int[arr.length];		// arr�� ���̸�ŭ �迭 ����
		for(int i = 0; i < arr.length; i++) {	// �ݺ����� ���� arr�� ������
			copy[i] = arr[i];					// �������ش�.
		}
		return copy;							// ����� �迭�� ��ȯ
	}
	
	public int[] bubbleSort(int[] arr) {		// ���� ������ ��Ÿ���� bubbleSort 
		int[] a = copy(arr);					// copy ȣ���  arr ����
		for(int i = a.length - 1; i >= 0; i--) {// ��ø �ݺ��� 
			for(int j = 0; j < i; j++) {		// ��������		 
				if(a[j] > a[j+1])				// ���� �ε����� ������ ũ�ٸ�
					swap(a, j, j+1);			// ���� ��ȯ
			}
		}		
		return a;								// ���ĵ� �迭�� ��ȯ
	}
	
	public int[] selectionSort(int[] arr) {		// ���������� ��Ÿ���� selectionSort �޼ҵ� 	
		int[] a = copy(arr);					// copy ȣ���  arr ����
		int i, j, min;							// �ݺ������� ����� i, j, min ����
		// �� �޼ҵ忡���� min�� �ε������� ����ϴ� ���� ����!!
		
		for( i = 0; i < a.length - 1; i++) {	// ��ø �ݺ���
			for( j = i + 1, min = i; j < a.length; j++) {	// j�� i+1�� , min�� i�� �ʱ�ȭ�ϰ� �ݺ��Ѵ�
				if(a[j] < a[min]) {				// a[min]���� �� ���� ���� ������
					min = j;					// min�� j�� �ʱ�ȭ
				}
			}
			swap(a,min,i);						// ������ �ݺ����� ������ ���� �ε����� ���� ���� ������ ����
		}										// �� ������������ �����Ѵ�.
		
		return a;								// ���ĵ� �迭�� ��ȯ
	}
	
	public int[] insertionSort(int[] arr) {		// ���� ������ ���³��� insertionSort �޼ҵ�
		int[] a = copy(arr);					// copy ȣ���  arr ����
		int i,j,k;								// �ݺ������� ����� i,j,k		
		boolean move = false;					// boolean�� ���� move ���� �� false�� �ʱ�ȭ
		
		for(i = 1; i < a.length; i++ ) { 		// ��ø �ݺ���, �ι�° ���Һ��� �ݺ�
			k = a[i];							// a[i]�� k�� (�ӽ�) ����
			j = i;								// j�� i�� �ʱ�ȭ
			
			if(a[j - 1] > k)					// �ݺ����� ���� a[j - 1]�� k���� ũ��
				move = true;					// true�� �ʱ�ȭ
			else								// ���� �۴ٸ�
				move = false;					// false�� �ʱ�ȭ
			
			
			while(move) {						// ������ �ݺ���
				a[j] = a[j-1];					// a[j]�� a[j - 1]�� �ʱ�ȭ
				j--;							// j�� ����
				if(j > 0 && a[j - 1] > k)		// j�� 0���� ũ��  a[j - 1]�� k���� ũ�ٸ�
					move = true;				// true
				else
					move = false;				// �� ���ǿ� ���� ������ false
			}
			
			
			/*		// 12����_1 ���� �ִ� �������� ������ �������� ������ ������ �ݺ���
			while(j > 0 && a[j - 1] > k) {		// move�� ������� �ʴ´�.
				a[j] = a[j - 1];		// 68�ٰ� 69 ���� �ڵ�� ����.
				j--;					
			}
			*/

			
			a[j] =k;							// ������ �ݺ����� ������ k�� ���ڸ��� ����
		}
		return a;								// ���ĵ� �迭�� ��ȯ
	}
}
