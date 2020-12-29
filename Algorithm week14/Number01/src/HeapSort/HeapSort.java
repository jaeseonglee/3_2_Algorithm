/*  알고리즘 14주차 힙 정렬  
 * 	HeapSort.java, main.java   
 *  작성일 : 2020.12.02~ 03
 *  작성자 : 20165153 이재성
 * 	프로그램 설명 : 최대 힙으로 힙 정렬하는 프로그램
 *  
 *  현재 프로그램은 배열의 0번째 인덱스를 사용하지 않는 배열을 사용한다.
 */

package HeapSort;

public class HeapSort {					// 힙 정렬 클래스
	public HeapSort() {					// 비어있는 디폴트 생성자
		
	}
	public int[] heapSort(int[] arr) { 	// 힙 정렬을 하는 heapSort 메소드
		int n = arr.length - 1;			// 원소의 개수 만큼 n을 초기화
		int i;							// 반복문에서 사용할 i 선언
		for(i = n/2; i >= 1; i--) {		// 반복문, n/2 부터 시작하는 것은 리프노드(원소 1개)는 그 자체로 힙이기 때문이다.
			heapify(arr, i ,n);			// heapify 메소드를 통해 배열을 최대 힙으로 다시 구성한다. 
		}
		
		for(i = n-1; i >= 1; i--) {		// 인덱스 1에 있는 최대 값을 마지막으로 바꾸면서 오름차순으로 정렬하는 반복문  
			int temp = arr[1];			// 마지막 원소와 인덱스 1의 원소를 교환
			arr[1] = arr[i+1];
			arr[i+1] = temp;
			heapify(arr, 1, i);			// 최대 원소를 제외, 다시 힙구조로 만드는 메소드	
		}
		
		return arr;						// 오름차순으로 정렬된 배열 반환
	}
	
	private void heapify(int[] arr, int h, int  m) {// 주어진 배열을 최대 힙으로 구성하는 heapify 메소드
		int ah = arr[h];							// 루트 h가 최대 힙으로 구성되기 위한 자리를 찾을 때 사용할 값을 ah에 저장 
		int j;										// 반복문에서 사용할 변수
		for(j = 2 * h; j <= m; j *= 2) {			// 반복문을 통해 배열을 힙으로 구성, h의 자식부터 시작한다.
			if(j < m) {								 
				if(arr[j] < arr[j + 1] )			// 왼쪽 자식 보다 오른쪽 자식이 더크면
					j++;							// 오른쪽 자식을 가리키게 함
			}
			if(ah >= arr[j])						// ah 보다 작은 값을 찾으면 반복문 탈출
				break;								// 이 경우로 탈출하면  j의 부모에 ah를 저장해야하므로 j의 값을 그대로 둔다.
			else
				arr[j/2] = arr[j];					// 그게 아니라면 자식 노드의 값을 부모 노드의 값으로 저장
		}
		arr[j/2] = ah;								// 반복문이 끝나면 반복문이 끝나기 직전의 j 자리에 ah에 저장된 값을 저장
	}
}
