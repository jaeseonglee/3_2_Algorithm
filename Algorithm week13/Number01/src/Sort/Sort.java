/*  �˰��� 13���� �պ�����, ������  
 * 	sort.java sortMain.java   
 *  �ۼ��� : 2020.11.27~28
 *  �ۼ��� : 20165153 ���缺
 * 	���α׷� ���� : �պ�����(merge), ��������  ��Ÿ���� ���α׷�
 */
package Sort;

public class Sort {
	// �պ� ����
	public int[] mergeSort(int[] arr) {						// �ܺο��� ȣ���ϴ� �պ� ���� mergeSort �޼ҵ�  
		int[] temp = new int[arr.length];					// �Ű����� �迭���� ���� ��ŭ temp �迭 ���� 
		internalMergeSortSort(arr, temp, 0, arr.length-1);	// Ŭ���� ���ο��� �����ϴ� internalMergeSortSort ȣ���� ���� ���� 
		
		return arr;											// ���ĵ� arr ��ȯ
	}

	private void internalMergeSortSort(int[] arr, int[] temp, int m, int n) {	// ���ȣ���� ���� �պ������� �����ϴ� internalMergeSortSort �޼ҵ� 
		if(m < n) {											// ������ ���Ұ� 2�� �̻��� ��� ����, �� �� ��ȯ���� �����ؾ� �� ���Ұ� 1������ ���ǿ� �ش����� �ʴ´�. 
			int middle = (m+n)/ 2;							// �迭�� �̵���ϱ� ���� middle ���� �� �ʱ�ȭ 
			internalMergeSortSort(arr, temp, m, middle);	// m���� middle������ ���� ���ȣ��
			internalMergeSortSort(arr, temp, middle + 1, n);// middle + 1���� n ������ ���� ���ȣ��
			merge(arr, temp, m, middle, middle+1, n);		// merge ȣ��� �������� �迭�� �պ�����
		}
	}
	
	private void merge(int[] arr, int[] temp, int m, int p, int q, int n) {		// �������� �� �迭�� ��ġ�� ���� �޼ҵ� merge
		int t = m;											// �迭 ���� �ε����� ����Ű�� t�� m���� �ʱ�ȭ 
		int numElements = n - m + 1;						// ���� ��ĥ ���Ұ� �� ������ ���
		while(m <= p && q <= n) {							// m�� p���� ũ�ų� q�� n���� ũ�ų�, �� ��� ������ �迭�� �ε����� �Ѿ ������ �ݺ�
			if(arr[m] < arr[q])								// �ε��� m�� ���� �� ������
				temp[t++] = arr[m++];						// temp�� ���ҷ� ����
			else
				temp[t++] = arr[q++];						// q�� �� ������ �� ������ ����
		}
															// 30���� while���� ������ ���Ŀ���
		while(m <= p)										// ���� �κ� �迭�� ���Ұ� ���� �ִ� ���
			temp[t++] = arr[m++];							// ���� ������ temp�� �߰����ش�.
		while(q <= n)										// ���������� ������ �κ� �迭�� ���Ұ� ���� �ִ� ���
			temp[t++] = arr[q++];							// ���� ���鵵 �߰����ش�.
		for(int i = 0; i < numElements; i++, n--)			// �迭 temp[]�� a[]�� ����
			arr[n] = temp[n];								// ���� �ϳ��ϳ� �������ش�.
	}
	
	// �� ����
	public int[] quickSort(int[] arr) {						// �ܺο��� ȣ���ϴ� ������ quickSort �޼ҵ�
		internalQuickSort(arr, 0 , arr.length-1);			// Ŭ���� ���ο��� �����ϴ� internalQuickSort�� ȣ���Ͽ� ����
		return arr;											// ���ĵ� arr ��ȯ
	}
	
	private void internalQuickSort(int[] arr, int m, int n) {	// ���ȣ��� �������� �����ϴ� internalQuickSort �޼ҵ�
		if(m >= n)											// ���� ���Ұ� ���ų� �ϳ���� ������ �ʿ䰡 �����Ƿ�
			return ;										// �ٷ� ����
		int p = partition(arr, m, n);						// partition ȣ���� ���� �� ���Ŀ��� ����� pivot�� �ε����� ��´�.
		internalQuickSort(arr, m , p-1);					// pivot ���� �������� �ε����� ���� ��� ȣ��
		internalQuickSort(arr, p+1, n);						// pivot ���� ū ���� �ε����鿡 ���� ���ȣ��
	}
	
	private int partition(int[] arr, int m ,int n) {		// pivot�� ã�� �������� �����ϴ� partition �޼ҵ�
		int temp;											// ����ȯ�� ����� temp
		int middle = (m+n)/2;								// �̵���� �߾� �ε��� ���� ã�� ���� 
		int pivot = arr[middle];							// pivot�� middle�� ������ ����
		arr[middle] = arr[m];								// middle�ε����� ���� arr[m]���� �ʱ�ȭ�ϰ�
		arr[m] = pivot;										// arr[m]�� pivot���� �ʱ�ȭ���ش�
		int p = m;											// p�� �� ��Ƽ���� ��踦 �����ϴ� �ε���
		
		for(int k = m + 1; k <= n; k++ ) {					// �ݺ����� ���� ���� ��ȯ, �ٲ� ��ġ ���� ������ Ȯ���ϹǷ� m+1
			if(arr[k] < pivot) {							// pivot���� ���� ���� ������
				p = p + 1;									// p�� ��ġ ����
				temp = arr[p];								// arr[k] �� arr[p]�� ��ȯ�Ѵ�.
				arr[p] = arr[k];
				arr[k] = temp;
			}
		}
		
		temp = arr[m];										// a[p]�� a[m]�� ��ȯ�Ѵ�.
		arr[m] = arr[p];
		arr[p] = temp;
		return p;											// ������ ������ pivot�� �ε��� p�� ��ȯ�ϸ� ����
	}
}
