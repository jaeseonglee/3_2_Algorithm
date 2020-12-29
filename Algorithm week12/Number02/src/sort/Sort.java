/*  알고리즘 12주차  
 * 	Sort.java SortMain.java   
 *  작성일 : 2020.11.19, 21
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 선택 정렬, 버블 정렬, 삽입 정렬을 나타내는 프로그램
 */
package sort;

public class Sort {								// 정렬을 나타내는 클래스 Sort
	public void swap(int[] a, int j, int k) {	// 매개변수 배열의 두 원소를 바꾸는 swap 메소드 
		int temp = a[j];						// a[j] 와 a[k]에 
		a[j] = a[k];							// 대해서 값을 교환
		a[k] = temp;
	}
	
	private int[] copy (int[] arr) {			// 매개변수 배열을 깊은 복사를 통해 반환하는 copy 메소드
		int[] copy = new int[arr.length];		// arr의 길이만큼 배열 생성
		for(int i = 0; i < arr.length; i++) {	// 반복문을 통해 arr의 값까지
			copy[i] = arr[i];					// 복사해준다.
		}
		return copy;							// 복사된 배열을 반환
	}
	
	public int[] bubbleSort(int[] arr) {		// 버블 정렬을 나타내는 bubbleSort 
		int[] a = copy(arr);					// copy 호출로  arr 복사
		for(int i = a.length - 1; i >= 0; i--) {// 중첩 반복문 
			for(int j = 0; j < i; j++) {		// 오름차순		 
				if(a[j] > a[j+1])				// 다음 인덱스의 값보다 크다면
					swap(a, j, j+1);			// 값을 교환
			}
		}		
		return a;								// 정렬된 배열을 반환
	}
	
	public int[] selectionSort(int[] arr) {		// 선택정렬을 나타내는 selectionSort 메소드 	
		int[] a = copy(arr);					// copy 호출로  arr 복사
		int i, j, min;							// 반복문에서 사용할 i, j, min 선언
		// 이 메소드에서는 min을 인덱스에서 사용하는 것을 유의!!
		
		for( i = 0; i < a.length - 1; i++) {	// 중첩 반복문
			for( j = i + 1, min = i; j < a.length; j++) {	// j는 i+1로 , min은 i로 초기화하고 반복한다
				if(a[j] < a[min]) {				// a[min]보다 더 작은 값이 있으면
					min = j;					// min을 j로 초기화
				}
			}
			swap(a,min,i);						// 안쪽의 반복문이 끝나면 현재 인덱스에 가장 작은 값으로 저장
		}										// 즉 오름차순으로 정렬한다.
		
		return a;								// 정렬된 배열을 반환
	}
	
	public int[] insertionSort(int[] arr) {		// 삽입 정렬을 나태내는 insertionSort 메소드
		int[] a = copy(arr);					// copy 호출로  arr 복사
		int i,j,k;								// 반복문에서 사용할 i,j,k		
		boolean move = false;					// boolean형 변수 move 선언 및 false로 초기화
		
		for(i = 1; i < a.length; i++ ) { 		// 중첩 반복문, 두번째 원소부터 반복
			k = a[i];							// a[i]를 k에 (임시) 저장
			j = i;								// j는 i로 초기화
			
			if(a[j - 1] > k)					// 반복문을 통해 a[j - 1]가 k보다 크면
				move = true;					// true로 초기화
			else								// 값이 작다면
				move = false;					// false로 초기화
			
			
			while(move) {						// 안쪽의 반복문
				a[j] = a[j-1];					// a[j]를 a[j - 1]로 초기화
				j--;							// j값 감소
				if(j > 0 && a[j - 1] > k)		// j가 0보다 크고  a[j - 1]가 k보다 크다면
					move = true;				// true
				else
					move = false;				// 두 조건에 맞지 않으면 false
			}
			
			
			/*		// 12주차_1 영상에 있는 삽입정렬 내용중 교수님이 수정한 안쪽의 반복문
			while(j > 0 && a[j - 1] > k) {		// move를 사용하지 않는다.
				a[j] = a[j - 1];		// 68줄과 69 줄의 코드와 같다.
				j--;					
			}
			*/

			
			a[j] =k;							// 안쪽의 반복문이 끝나면 k를 빈자리에 삽입
		}
		return a;								// 정렬된 배열을 반환
	}
}
