/*  알고리즘 13주차 합병정렬, 퀵정렬  
 * 	sort.java sortMain.java   
 *  작성일 : 2020.11.27~28
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 합병정렬(merge), 퀵정렬을  나타내는 프로그램
 */
package Sort;

public class Sort {
	// 합병 정렬
	public int[] mergeSort(int[] arr) {						// 외부에서 호출하는 합병 정렬 mergeSort 메소드  
		int[] temp = new int[arr.length];					// 매개변수 배열을의 길이 만큼 temp 배열 생성 
		internalMergeSortSort(arr, temp, 0, arr.length-1);	// 클래스 내부에서 동작하는 internalMergeSortSort 호출을 통해 정렬 
		
		return arr;											// 정렬된 arr 반환
	}

	private void internalMergeSortSort(int[] arr, int[] temp, int m, int n) {	// 재귀호출을 통해 합병정렬을 보조하는 internalMergeSortSort 메소드 
		if(m < n) {											// 정렬할 원소가 2개 이상인 경우 동작, 즉 매 순환마다 정렬해야 할 원소가 1개여야 조건에 해당하지 않는다. 
			int middle = (m+n)/ 2;							// 배열을 이등분하기 위해 middle 선언 및 초기화 
			internalMergeSortSort(arr, temp, m, middle);	// m부터 middle까지에 대해 재귀호출
			internalMergeSortSort(arr, temp, middle + 1, n);// middle + 1부터 n 까지에 대해 재귀호출
			merge(arr, temp, m, middle, middle+1, n);		// merge 호출로 나누어진 배열을 합병정렬
		}
	}
	
	private void merge(int[] arr, int[] temp, int m, int p, int q, int n) {		// 나누어진 두 배열을 합치는 보조 메소드 merge
		int t = m;											// 배열 현재 인덱스를 가리키는 t에 m으로 초기화 
		int numElements = n - m + 1;						// 현재 합칠 원소가 몇 개인지 계산
		while(m <= p && q <= n) {							// m이 p보다 크거나 q가 n보다 크거나, 즉 어느 한쪽의 배열의 인덱스를 넘어갈 때까지 반복
			if(arr[m] < arr[q])								// 인덱스 m의 값이 더 작으면
				temp[t++] = arr[m++];						// temp의 원소로 저장
			else
				temp[t++] = arr[q++];						// q가 더 작으면 그 값으로 저장
		}
															// 30줄의 while문이 끝나고 난후에도
		while(m <= p)										// 왼쪽 부분 배열에 원소가 남아 있는 경우
			temp[t++] = arr[m++];							// 남은 값들을 temp에 추가해준다.
		while(q <= n)										// 마찬가지로 오른쪽 부분 배열에 원소가 남아 있는 경우
			temp[t++] = arr[q++];							// 남은 값들도 추가해준다.
		for(int i = 0; i < numElements; i++, n--)			// 배열 temp[]를 a[]로 복사
			arr[n] = temp[n];								// 값을 하나하나 복사해준다.
	}
	
	// 퀵 정렬
	public int[] quickSort(int[] arr) {						// 외부에서 호출하는 퀵정렬 quickSort 메소드
		internalQuickSort(arr, 0 , arr.length-1);			// 클래스 내부에서 동작하는 internalQuickSort를 호출하여 정렬
		return arr;											// 정렬된 arr 반환
	}
	
	private void internalQuickSort(int[] arr, int m, int n) {	// 재귀호출로 퀵정렬을 보조하는 internalQuickSort 메소드
		if(m >= n)											// 먼저 원소가 없거나 하나라면 정렬할 필요가 없으므로
			return ;										// 바로 종료
		int p = partition(arr, m, n);						// partition 호출을 통해 퀵 정렬에서 사용할 pivot의 인덱스를 얻는다.
		internalQuickSort(arr, m , p-1);					// pivot 보다 작은쪽의 인덱스에 대해 재귀 호출
		internalQuickSort(arr, p+1, n);						// pivot 보다 큰 쪽의 인덱스들에 대해 재귀호출
	}
	
	private int partition(int[] arr, int m ,int n) {		// pivot을 찾아 퀵정렬을 보조하는 partition 메소드
		int temp;											// 값교환에 사용할 temp
		int middle = (m+n)/2;								// 이등분할 중앙 인덱스 값을 찾아 저장 
		int pivot = arr[middle];							// pivot을 middle의 값으로 저장
		arr[middle] = arr[m];								// middle인덱스의 값을 arr[m]으로 초기화하고
		arr[m] = pivot;										// arr[m]은 pivot으로 초기화해준다
		int p = m;											// p는 두 파티션의 경계를 지시하는 인덱스
		
		for(int k = m + 1; k <= n; k++ ) {					// 반복문을 통해 값을 교환, 바뀐 위치 다음 값부터 확인하므로 m+1
			if(arr[k] < pivot) {							// pivot보다 작은 값이 있으면
				p = p + 1;									// p의 위치 증가
				temp = arr[p];								// arr[k] 와 arr[p]를 교환한다.
				arr[p] = arr[k];
				arr[k] = temp;
			}
		}
		
		temp = arr[m];										// a[p]와 a[m]을 교환한다.
		arr[m] = arr[p];
		arr[p] = temp;
		return p;											// 분할을 끝내면 pivot의 인덱스 p를 반환하며 종료
	}
}
